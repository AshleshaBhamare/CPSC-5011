package abhamare_hw2.Menu;

import abhamare_hw2.vault.PasswordVault;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This program implements a menu-driven console app that uses the vault.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class MenuDriver
{
    private final PasswordVault pv = new PasswordVault();

    private HashMap<String, Boolean> loginMap = new HashMap<>();

    public static void main(String[] args) {
        char choice;
        String userName = "arpita";
        String password;
        String site;

        int option;
        Scanner input = new Scanner(System.in);
        MenuDriver driver = new MenuDriver();
        do
        {
            try
            {
                System.out.println("\n================  MENU ==================\n");
                System.out.println("\t** 1. Add New User **");
                System.out.println("\t** 2. Log In: **");
                System.out.println("\t** 3. Log Out: **");
                System.out.println("\t** 4. Add Site **");
                System.out.println("\t** 5. Request New Password for Site **");
                System.out.println("\t** 6. User retrieves existing password " +
                                                                "for site **");

                System.out.print("\nPlease enter a menu option: ");
                option = input.nextInt();
                switch (option)
                {
                    case 1:
                        System.out.print("Please Enter the user name: ");
                        userName = input.next();
                        System.out.print("Please Enter the password: ");
                        password = input.next();
                        driver.addNewUser(userName, password);
                        break;
                    case 2:
                        System.out.print("Please Enter the user name: ");
                        userName = input.next();
                        System.out.print("Please Enter the password: ");
                        password = input.next();
                        driver.login(userName, password);
                        break;
                    case 3:
                        System.out.print("Please Enter the user name: ");
                        userName = input.next();
                        driver.logout(userName);
                        break;
                    case 4:
                        if (driver.isUserLoggedIn(userName)) {
                            System.out.print("Please Enter the user name: ");
                            userName = input.next();
                            System.out.print("Please Enter the password: ");
                            password = input.next();
                            System.out.print("Please Enter the site name: ");
                            site = input.next();
                            driver.addNewSite(userName, password, site);
                        } else {
                            System.out.println("Please login first ");
                        }
                        break;
                    case 5:
                        if (driver.isUserLoggedIn(userName)) {
                            System.out.print("Please Enter the user name: ");
                            userName = input.next();
                            System.out.print("Please Enter the password: ");
                            password = input.next();
                            System.out.print("Please Enter the site name: ");
                            site = input.next();
                            driver.addNewSite(userName, password, site);
                            System.out.print("Please generate new " +
                                                         "password for site: ");
                            driver.testUpdateSitePassword(userName, password, site);
                        }else {
                            System.out.println("Please login first ");
                        }
                        break;
                    case 6:
                        if (driver.isUserLoggedIn(userName)){
                            System.out.print("Please Enter the user name: ");
                            userName = input.next();
                            System.out.print("Please Enter the password: ");
                            password = input.next();
                            System.out.print("Please Enter the site name: ");
                            site = input.next();
                            //driver.addNewSite(userName, password, site);
                            System.out.print("Please retrieves existing " +
                                                        "password for site: ");
                            driver.testRetrievePassword(userName, password,site);
                        }else {
                            System.out.println("Please login first ");
                        }
                        break;
                    default:
                        System.out.println("Invalid option selected:");
                }
            } catch (Exception e) {
                System.out.println("Exception:" + e.getMessage());
                System.out.print("Would you like to continue:(Y/N): ");
                choice = input.next().charAt(0);
            }
            System.out.print("\nWould you like to continue?(Y/N): ");
            choice = input.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

        System.out.println("Thank you!");

    }


    public void addNewUser(String name, String password) {
        try {
            System.out.println();
            System.out.println("Attempting to add user '" + name +
                                       "' and password '" + password + "'");
            pv.addNewUser(name, password);
            System.out.println("Added user '" + name + "'");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * This function is used to check login functionality.
     *
     * @param name of the user
     * @param password of the user
     */
    public void login(String name, String password) {
        try {
            System.out.println();
            System.out.println("Authenticating user login for user '"
                                                               + name + "'");

            if (loginMap.get(name) != null) {
                if (loginMap.get(name) == true) {
                    System.out.println("You are already logged in");
                }
            } else {
                if (pv.isLoginAuthenticationValid(name, password)) {
                    System.out.println("Login authenticated.. Logged in");
                    loginMap.put(name, true);
                } else {
                    System.out.println("Invalid login credentials. Please retry");
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This function checks is user logged in.
     *
     * @param name of the user
     * @return false is user not logged in
     */
    public boolean isUserLoggedIn(String name) {
        if (loginMap.get(name) != null) {
            return loginMap.get(name);
        }
        return false;
    }

    /**
     * This function creates logout functionality.
     *
     * @param name of the user
     */
    public void logout(String name) {
        try {
            System.out.println();
            if (loginMap.get(name) != null) {
                System.out.println("Logging off user '" + name + "'");
                loginMap.put(name, false);
            }
            System.out.println("User successfully logged out!");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This function adds new site for user
     *
     * @param username of the user
     * @param password of the user
     * @param site name of the site
     */
    public void addNewSite(String username, String password, String site) {
        try {
            System.out.println("\nAttempting to add site '" + site +
                    "' for user '" + username + "'");

            String sitePassword;
            sitePassword = pv.addNewSite(username, password, site);

            System.out.println("Added site '" + site + "' for user '" + username +
                    "' => generated site password: " + sitePassword);


        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * This function retrieves site password for user
     *
     * @param name of the user
     * @param password of the user
     * @param site name of the site
     */
    public void testRetrievePassword(String name, String password, String site)
    {
        try
        {
            System.out.println("\nAttempting to retrieve '" + site +
                                  "' site password for user '" + name + "'");

            String retrievePassword;
            retrievePassword = pv.retrieveSitePassword(name, password, site);

            System.out.println("\nRetrieved site '" + site + "' for user '"
                    + name + "' => retrieved password: " + retrievePassword);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * This function updates new site password for user
     *
     * @param username of the user
     * @param password of the user
     * @param site mane of the site
     */
    public void testUpdateSitePassword(String username, String password,
                                                                String site)
    {
        try
        {
            System.out.println("\nAttempting to update '" + site +
                    "' site password for user '" + username + "'");

            String updatedPassword;
            updatedPassword = pv.updateSitePassword(username, password, site);

            System.out.println("\nUpdated site '" + site + "' for user '"
                    + username + "' => updated password: " + updatedPassword);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
