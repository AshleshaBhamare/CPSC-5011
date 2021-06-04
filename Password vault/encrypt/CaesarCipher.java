package abhamare_hw2.encrypt;

/**
 * This program implement encryption and decryption of password
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class CaesarCipher implements Encryptor
{

    private static final int DEFAULT_SHIFT = 4;

    private int shift;

    /**
     * Default Constructor
     */
    public CaesarCipher() {
        shift = DEFAULT_SHIFT;
    }

    /**
     * Constructor with parameters
     *
     * @param shift is used to decide the shifting of a character by how
     * many places
     */
    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public int getShift()
    {
        return shift;
    }

    @Override
    public String encrypt(String s) {

        return encrypt(s, shift);
    }

    @Override
    public String decrypt(String s) {

        return decrypt(s, shift);
    }

    /**
     * This function encrypts text using shift
     *
     * @param text  to be encrypted
     * @param shift to shift the character
     * @return encrypted string
     */
    private static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++)
        {
            char character = text.charAt(i);
            if (Character.isUpperCase(character))
            {
                character = (char) (((int) text.charAt(i) + shift - 65)
                                                                  % 26 + 65);
            } else if (Character.isLowerCase(character))
            {
                character = (char) (((int) text.charAt(i) + shift - 97)
                                                                   % 26 + 97);
            } else if (Character.isDigit(character))
            {
                character = (char) (((int) text.charAt(i) + shift - 48)
                                                                   % 10 + 48);
            }
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     * This function decrypts text using a shift
     *
     * @param text To be decrypted
     * @param dec    Shift to be subtracted
     * @return decrypted string
     */
    private static String decrypt(String text, int dec)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++)
        {
            char character = text.charAt(i);

            int shift = 0;
            if (Character.isUpperCase(character))
            {
                shift = 26 - dec;
                character = (char) (((int) text.charAt(i) + shift - 65)
                                                                   % 26 + 65);
            } else if (Character.isLowerCase(character))
            {
                shift = 26 - dec;
                character = (char) (((int) text.charAt(i) + shift - 97)
                                                                  % 26 + 97);
            } else if (Character.isDigit(character))
            {
                shift = 10 - dec;
                character = (char) (((int) text.charAt(i) + shift - 48)
                                                                  % 10 + 48);
            }
            sb.append(character);
        }
        return sb.toString();
    }
}
