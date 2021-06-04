package abhamare_hw2.exceptions;

/**
 * Thrown when Invalid site name entered by the user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class InvalidSiteException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct InvalidSiteException with the specified detail message .
     * @param message error message
     */
    public InvalidSiteException(String message) {
        super(message);
    }

}
