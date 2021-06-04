package abhamare_hw2.vault;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements the validation for password and sitename.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class ValidatePasswordSitenameUsername
{
    private static final Set<Character> specialCharacterSet = new HashSet<>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&'));
    private static final String regex = "[a-z]+";

    /**
     * This function checks whether password satisfies the given conditions
     * @param password site password
     * @return true if password is valid
     */
    public static boolean isValidPassword(String password)
    {
        if (password.length() < 6 || password.length() > 15) {
            return false;
        }

        if (!containsOneDigitOneLetter(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }
        return true;
    }

    /**
     * This function checks whether username satisfies the given conditions
     * @param username site username
     * @return true if username is valid
     */
    public static boolean isValidUsername(String username) {
        return isValidName(username);
    }

    /**
     * This function checks username, siteName requirements
     * @param name of site or username
     * @return true if a username or sitename is valid
     */
    private static boolean isValidName(String name) {
        if (name.length() < 6 || name.length() > 12) {
            return false;
        }

        return name.matches(regex);
    }

    /**
     * This function checks whether sitename satisfies the given constraints
     * @param siteName sitename
     * @return true if sitename is valid.
     */
    public static boolean isValidSitename(String siteName) {
        return isValidName(siteName);
    }

    /**
     * This function checks if the password contains at least one digit one letter
     * @param password of the user
     * @return true if password has at least one digit
     */
    private static boolean containsOneDigitOneLetter(String password)
    {
        boolean foundDigit = false;
        boolean foundLetter = false;

        for (int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                foundDigit = true;
            } else if (Character.isLetter(c)) {
                foundLetter = true;
            }
        }
        return foundDigit && foundLetter;
    }

    /**
     * This function checks if password contains at least one special character
     * @param password of the user
     * @return true if password has at least one special character
     */
    private static boolean containsSpecialCharacter(String password) {
        boolean containsSpecialCharacter = false;
        for (int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (specialCharacterSet.contains(c)) {
                containsSpecialCharacter = true;
                break;
            }
        }
        return containsSpecialCharacter;
    }
}
