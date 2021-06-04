package abhamare_hw2.main;

import abhamare_hw2.vault.PasswordVault;

import java.util.Scanner;
/**
 * This program implements and test all password vault functionality.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class Driver
{
    private final PasswordVault pv = new PasswordVault();
   // private final Scanner keyBoard = new Scanner(System.in);

    public static void main(String[] args)
    {
        char choice = 'N';
        String name = "ashlesha";
        String password = "mypass123!";
        String site = "amazon";
        String invalidPassword = "test";
        Scanner input = new Scanner(System.in);
        Driver driver = new Driver();
        try
        {
            System.out.println("\n** 1. Testing success case: **\n");
            driver.testingSuccessCase(name, password, site);

            System.out.println("\n** 2. Testing exceptions for addNewUser: **");
            driver.testAddNewUser("bob", password);

            driver.testAddNewUser("bobismyname", "mypass123");
            driver.testAddNewUser(name, password);

            System.out.println("\n** 3. Testing exceptions for addNewSite: **");
            driver.testAddNewSite(name, password, site);

            driver.testAddNewSite("maryismyname", password, site);
            driver.testAddNewSite(name, password, "amazon1.com");

            System.out.println("\n** 4. Testing exceptions for " +
                                                   "retrieveSitePassword : **");
            driver.testRetrievePassword(name, password, "amazon.com");

            System.out.println("\n** 5. Testing exceptions for " +
                                                   "updateSitePassword : **");
            driver.testUpdateSitePassword(name, password, "amazon.com");
            driver.testUpdateSitePassword(name, invalidPassword, "amazon");
            driver.testUpdateSitePassword(name, invalidPassword, "amazon");
            driver.testUpdateSitePassword(name, invalidPassword, "amazon");
            driver.testUpdateSitePassword(name, invalidPassword, "amazon");


        } catch (Exception e)
        {
            System.out.println("Exception:" + e.getMessage());
            System.out.print("Would you like to continue:(Y/N)\n");
            choice = input.next().charAt(0);
        }
    }
    /**
     * This function test all success cases like addaNewUser, addNewSite,
     * retrievePassword, updatePassword.
     *
     * @param name of the user
     * @param password of the user
     * @param site name of the site
     */
    public void testingSuccessCase(String name, String password, String site) {
        try
        {
            System.out.println("Attempting to add user '" + name + "' and" +
                                               " password '" + password + "'");
            pv.addNewUser(name, password);
            System.out.println("Added user '" + name + "'");

            System.out.println("\nAttempting to add site '" + site + "' " +
                                                    "for user '" + name + "'");

            String sitePassword;
            sitePassword = pv.addNewSite(name, password, site);
            System.out.println("Added site '" + site + "' for user '" + name +
                    "' => generated site password: " + sitePassword);

            System.out.println("\nAttempting to retrieve '" + site + "' " +
                                     "site password for user '" + name + "'");

            String retrievePassword;
            retrievePassword = pv.retrieveSitePassword(name, password, site);

            System.out.println("Retrieved site '" + site + "' for user '" + name +
                    "' => retrieved password: " + retrievePassword);

            System.out.println();

            System.out.println("Attempting to update '" + site + "' " +
                                          "password for user '" + name + "'");

            String updatedPassword;
            updatedPassword = pv.updateSitePassword(name, password, site);

            System.out.println("Updated site '" + site + "' for user '" + name +
                    "' => updated password: " + updatedPassword);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }
    /**
     * This function test all exceptions for addNewUser.
     *
     * @param name of the user
     * @param password of the user
     */
    public void testAddNewUser(String name, String password) {
        try
        {
            System.out.println();
            System.out.println("Attempting to add user '" + name + "' " +
                                           "and password '" + password + "'");
            pv.addNewUser(name, password);
            System.out.println("Added user '" + name + "'");

        } catch (Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * This function test all exceptions for addNewSite.
     *
     * @param username of the user
     * @param password of the user
     * @param site name of the site
     */
    public void testAddNewSite(String username, String password, String site) {
        try
        {
            System.out.println("\nAttempting to add site '" + site + "' " +
                                                      "for user " + username);

            String sitePassword;
            sitePassword = pv.addNewSite(username, password, site);
            System.out.println("Added site '" + site + "' for user '" + username +
                    "' => generated site password: " + sitePassword);


        } catch (Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }
    /**
     * This function test all exceptions for retrievePassword.
     *
     * @param name of the user
     * @param password of the user
     * @param site name of the site
     */
    public void testRetrievePassword(String name, String password, String site) {
        try
        {
            System.out.println("\nAttempting to retrieve '" + site + "' " +
                                    "site password for user '" + name + "'");

            String retrievePassword;
            retrievePassword = pv.retrieveSitePassword(name, password, site);

            System.out.println("Retrieved site '" + site + "' for user '" + name +
                    "' => retrieved password: " + retrievePassword);
        } catch (Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This function test all exceptions for updatePassword.
     *
     * @param username of the user
     * @param password of the user
     * @param site name of the site
     */
    public void testUpdateSitePassword(String username, String password,
                                                              String site) {
        try
        {
            System.out.println("\nAttempting to update '" + site + "' " +
                                         "site password for user '" + username + "'");
            String updatedPassword;
            updatedPassword = pv.updateSitePassword(username, password, site);

            System.out.println("Updated site '" + site + "' for user '" + username +
                    "' => updated password: " + updatedPassword);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}


