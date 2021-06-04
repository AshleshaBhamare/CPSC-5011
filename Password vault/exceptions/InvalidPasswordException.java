package abhamare_hw2.exceptions;

/**
 * Thrown when Invalid password entered by the user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class InvalidPasswordException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct InvalidPasswordException with the specified detail message .
     * @param message error message
     */
    public InvalidPasswordException(String message) {
        super(message);
    }
}
