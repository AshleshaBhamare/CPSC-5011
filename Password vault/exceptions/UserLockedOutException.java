package abhamare_hw2.exceptions;
/**
 * Thrown when user enter incorrect credentials 3 times.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class UserLockedOutException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct UserLockedOutException with the specified detail message .
     * @param message error message
     */
    public UserLockedOutException(String message) {
        super(message);
    }
}
