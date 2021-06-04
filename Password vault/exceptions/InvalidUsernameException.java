package abhamare_hw2.exceptions;
/**
 * Thrown when Invalid user name entered by the user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class InvalidUsernameException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct InvalidUsernameException with the specified detail message .
     * @param message error message
     */
    public InvalidUsernameException(String message) {
        super(message);
    }
}
