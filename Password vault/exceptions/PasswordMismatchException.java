package abhamare_hw2.exceptions;
/**
 * Thrown when user attempt to login with incorrect credentials .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class PasswordMismatchException extends Exception
{
    private static final long serialVersionUID = 1L;
    /**
     * Construct PasswordMismatchException with the specified detail message .
     * @param message error message
     */
    public PasswordMismatchException(String message) {
        super(message);
    }
}
