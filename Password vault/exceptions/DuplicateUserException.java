package abhamare_hw2.exceptions;

/**
 * Thrown when duplicate user name entered by the user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class DuplicateUserException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct DuplicateUserException with the specified detail message .
     * @param message error message
     */
    public DuplicateUserException(String message) {
        super(message);
    }

}
