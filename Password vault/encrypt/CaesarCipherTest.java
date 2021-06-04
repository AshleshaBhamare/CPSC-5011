package abhamare_hw2.encrypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class implement encryption and decryption unit tests
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
class CaesarCipherTest
{

    @Test
    void testCaesarCipher() {
        CaesarCipher cc = new CaesarCipher();
        assertNotNull(cc);
    }

    @Test
    void testCaesarCipherInt() {
        CaesarCipher cc = new CaesarCipher(4);
        assertNotNull(cc);
        assertEquals(4, cc.getShift());
    }

    @Test
    void encrypt()
    {
        CaesarCipher cc = new CaesarCipher();
        String text = "mypass123";
        String encryptedText = cc.encrypt(text);
        assertNotSame("text", "encrptedText");
    }

    @Test
    void decrypt()
    {
        CaesarCipher cc = new CaesarCipher();
        String encrpyted = "qcteww567";
        String text = "mypass123";
        String decrypted = cc.decrypt(encrpyted);
        assertEquals(text, decrypted);
    }
}