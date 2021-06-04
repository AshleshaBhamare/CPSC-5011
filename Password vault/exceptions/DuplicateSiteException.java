package abhamare_hw2.exceptions;

/**
 * Thrown when duplicate site name entered by the user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class DuplicateSiteException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct DuplicateSiteException with the specified detail message .
     * @param message error message
     */
    public DuplicateSiteException(String message) {
        super(message);
    }

}
