package abhamare_hw2.vault;

import abhamare_hw2.exceptions.DuplicateUserException;
import abhamare_hw2.exceptions.InvalidPasswordException;
import abhamare_hw2.exceptions.InvalidUsernameException;
import abhamare_hw2.exceptions.DuplicateSiteException;
import abhamare_hw2.exceptions.UserNotFoundException;
import abhamare_hw2.exceptions.UserLockedOutException;
import abhamare_hw2.exceptions.PasswordMismatchException;
import abhamare_hw2.exceptions.InvalidSiteException;
import abhamare_hw2.exceptions.SiteNotFoundException;

import abhamare_hw2.encrypt.CaesarCipher;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * This program implements the functionality for adding a new user, adding new
 * site, retrieving site password and to update the site password
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class PasswordVault implements Vault
{
    private static final int minimumPasswordLength = 6;
    private static final int maximumPasswordLength = 15;
    private static SecureRandom random = new SecureRandom();

    // CeaserCipher object
    private CaesarCipher cipher;

    //  To Store username as a key and password,site details as value
    private static Map<String, CreateSiteMapping> map;

    /**
     * Default Constructor
     */
    public PasswordVault() {
        map = new HashMap<>();
        cipher = new CaesarCipher();
    }


    /**
     * This function adds a new user to the vault
     *
     * @param username username for the user
     * @param password for the user
     */
    @Override
    public void addNewUser(String username, String password)
            throws InvalidUsernameException, InvalidPasswordException,
            DuplicateUserException {
        if (ValidatePasswordSitenameUsername.isValidUsername(username)) {
            if (ValidatePasswordSitenameUsername.isValidPassword(password)) {
                if (!map.containsKey(username)) {
                    map.put(username, new CreateSiteMapping(cipher.encrypt
                            (password), null));
                } else {
                    throw new DuplicateUserException( " "+ username + ", Username " +
                            "already exists.");
                }
            } else {
                throw new InvalidPasswordException(" The password is invalid; " +
                        "enter 6-15 characters and at least\n" + "one letter, " +
                        "one number, and one special character (!@#$%^&). ");
            }
        } else {
            throw new InvalidUsernameException(" The username " + username + " is invalid; " +
                    "enter 6-12 lower-case letters. ");
        }

    }

    /**
     * This function adds a new site to the vault system
     *
     * @param username  username for the user
     * @param password for the user
     * @param  sitename name of the website
     * @return password for the site
     */
    @Override
    public String addNewSite(String username, String password, String sitename)
            throws DuplicateSiteException, UserNotFoundException,
            UserLockedOutException, PasswordMismatchException,
            InvalidSiteException {
        String sitePassword = null;

        if (map.containsKey(username)) {
            if (!checkIsLockedUser(username)) {
                if (cipher.decrypt(map.get(username).getUserPassword())
                        .equals(password)) {

                    // To Validate site name
                    if (ValidatePasswordSitenameUsername
                            .isValidSitename(sitename)) {

                        CreateSiteMapping mapping = map.get(username);

                        Map<String, String> siteMap = mapping.getSiteMap();
                        if (siteMap != null) {
                            if (siteMap.containsKey(sitename)) {
                                throw new DuplicateSiteException
                                        (" The site name already exists for this user.");
                            }
                        } else {
                            siteMap = new HashMap<>();

                        }

                        sitePassword = generateRandomSitePassword();

                        String encryptedPassword = cipher.encrypt(sitePassword);
                        siteMap.put(sitename, encryptedPassword);
                        mapping.setSiteMap(siteMap);
                    } else {
                        throw new InvalidSiteException(" The site name " +
                                "is invalid; enter 6-12 lower-case letters.");
                    }
                } else {
                    updateRetryCount(username);
                    throw new PasswordMismatchException(" Attempted " +
                            "to login with incorrect credentials.");
                }
            } else {
                throw new UserLockedOutException(" Attempted " +
                        "to login with incorrect credentials 3 times\n" +
                        "user is locked out of the system.");
            }
        } else {
            throw new UserNotFoundException(" Username '"
                    + username + "' does not exist.");
        }
        return sitePassword;
    }
    /**
     * This function generates random string password for the site
     *
     * @return random generated password
     */
    private String generateRandomSitePassword() {
        int passwordLength = random.nextInt(maximumPasswordLength -
                minimumPasswordLength + 1) + minimumPasswordLength;
        return GeneratePassword.generateNewPassword(passwordLength);
    }

    /**
     * This function is used to update the site password
     *
     * @param username username for the user
     * @param password for the user
     * @param  sitename name of the site
     * @return updated password for the site
     */
    @Override
    public String updateSitePassword(String username, String password, String sitename)
            throws SiteNotFoundException, UserNotFoundException,
            UserLockedOutException, PasswordMismatchException
    {
        String updatedSitePassword = null;
        if (map.containsKey(username)) {

            String psw = cipher.decrypt(map.get(username).getUserPassword());
            if (cipher.decrypt(map.get(username).getUserPassword()).equals(password))
            {

                CreateSiteMapping mapping = map.get(username);

                Map<String, String> siteMap = mapping.getSiteMap();
                if (siteMap != null) {
                    if (siteMap.containsKey(sitename)) {
                        updatedSitePassword = generateRandomSitePassword();
                    } else {
                        throw new SiteNotFoundException(" Site " +
                                "name does not exist for this user.");
                    }
                } else {
                    throw new SiteNotFoundException(" Site name " +
                            "does not exist for this user.");
                }

                // Encrypt and store the site password
                String encryptedPassword = cipher.encrypt(updatedSitePassword);
                siteMap.put(sitename, encryptedPassword);
                mapping.setSiteMap(siteMap);
            } else {
                updateRetryCount(username);
                throw new PasswordMismatchException("Attempted " +
                        "to login with incorrect credentials.");
            }
        } else {

            throw new UserNotFoundException(" Username "
                    + username + " does not exist.");
        }
        return updatedSitePassword;
    }

    /**
     * This function gets the site decrypted password
     *
     * @param username username for the user
     * @param password for the user
     * @param  sitename of the website
     * @return password for the site
     */
    @Override
    public String retrieveSitePassword(String username, String password, String sitename)
            throws SiteNotFoundException, UserNotFoundException
    {

        String sitePassword = null;

        if (map.containsKey(username)) {

            if (cipher.decrypt(map.get(username).getUserPassword()).equals(password))
            {

                CreateSiteMapping mapping = map.get(username);

                Map<String, String> siteMap = mapping.getSiteMap();
                if (siteMap != null) {
                    if (siteMap.containsKey(sitename)) {
                        sitePassword = cipher.decrypt(siteMap.get(sitename));
                    } else {
                        throw new SiteNotFoundException(" Site " +
                                "name does not exist for this user.");
                    }
                } else {
                    throw new SiteNotFoundException(" Site name " +
                            "does not exist for this user.");
                }
            }
        } else {
            throw new UserNotFoundException(" Username "
                    + username + " does not exist");
        }
        return sitePassword;

    }

    /**
     * This function used to create mapping between siteName and sitepassword
     */
    private static class CreateSiteMapping {
        private String userPassword;
        private int retryCount;
        private Map<String, String> siteMap;

        public CreateSiteMapping(String userPassword, Map<String, String> siteMap)
        {
            this.userPassword = userPassword;
            this.siteMap = siteMap;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public Map<String, String> getSiteMap() {
            return siteMap;
        }

        public void setSiteMap(Map<String, String> siteMap) {
            this.siteMap = siteMap;
        }

        public void setRetryCount(int retryCount) {
            this.retryCount = retryCount;
        }
    }

    /**
     * This function increments the count of retry for a user with wrong
     * password attempt
     *
     * @param userName name of the user
     * @throws UserLockedOutException throws
     */
    private void updateRetryCount(String userName) throws UserLockedOutException
    {
        CreateSiteMapping mapping = map.get(userName);
        mapping.setRetryCount(++mapping.retryCount);

        map.put(userName, mapping);

        if (mapping.retryCount == 4) {
            throw new UserLockedOutException("Attempted to " +
                    "login with incorrect credentials 3 times\n" +
                    "user is locked out of the system.");
        }

    }

    /**
     * This function checks whether a user is locked out
     *
     * @param userName name of the user
     * @return true if user is locked otherwise return false
     */
    private static boolean checkIsLockedUser(String userName) {

        CreateSiteMapping mapping = map.get(userName);
        if (mapping.retryCount < 3) {
            return false;
        }
        return true;
    }
    /**
     * This function checks Authentication of login
     *
     * @param userName name of the user
     * @param password for the user
     * @return status true if user authentication is valid otherwise return false
     */
    public boolean isLoginAuthenticationValid(String userName, String password)
    {
        boolean status= false;

        String psw = cipher.decrypt(map.get(userName).getUserPassword());
        if(psw.equals(password))
            status=true;
        else
            status=false;
        return status;
    }
}
