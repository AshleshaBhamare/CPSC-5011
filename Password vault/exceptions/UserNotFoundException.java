package abhamare_hw2.exceptions;

/**
 * Thrown when user is not added to the system .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class UserNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;
    /**
     * Construct UserNotFoundException with the specified detail message .
     * @param message error message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

}
