package abhamare_hw2.vault;

import java.security.SecureRandom;

/**
 * Used to generate password as per requirement.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */

public class GeneratePassword
{
    private static SecureRandom random = new SecureRandom();


    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&";
    private static final String NUMERIC = "0123456789";

    /**
     * This method is use to generate random string of passwod based on the
     * given parameters
     *
     * @param length length of the random string
     * @return the random password string
     */
    public static String generateNewPassword(int length)
    {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < length) {

            if (i < length) {
                int smallLetters = random.nextInt(LOWER_CASE.length());
                sb.append(LOWER_CASE.charAt(smallLetters));
                i++;
            }
            if (i < length) {
                int capsLetters = random.nextInt(UPPER_CASE.length());
                sb.append(UPPER_CASE.charAt(capsLetters));
                i++;
            }
            if (i < length) {
                int specialChar = random.nextInt(SPECIAL_CHARACTERS.length());
                sb.append(SPECIAL_CHARACTERS.charAt(specialChar));
                i++;
            }
            if (i < length) {
                int numbers = random.nextInt(NUMERIC.length());
                sb.append(NUMERIC.charAt(numbers));
                i++;
            }
        }
        return shuffleTheStringOfPassword(sb.toString());
    }

    /**
     * This function is used to shuffle the string.
     *
     * @param password String to be shuffled
     * @return Shuffled String
     */
    private static String shuffleTheStringOfPassword(String password)
    {
        char[] arrayOfPassword = password.toCharArray();
        for (int i = 0; i < arrayOfPassword.length; i++)
        {
            int randomNumber = random.nextInt(arrayOfPassword.length);

            char tmp = arrayOfPassword[i];

            arrayOfPassword[i] = arrayOfPassword[randomNumber];
            arrayOfPassword[randomNumber] = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayOfPassword.length; i++) {
            sb.append(arrayOfPassword[i]);
        }
        return sb.toString();
    }
}
