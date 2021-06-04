package abhamare_hw2.exceptions;

/**
 * Thrown when site name not found for user .
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class SiteNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Construct SiteNotFoundException with the specified detail message .
     * @param message error message
     */
    public SiteNotFoundException(String message) {
        super(message);
    }
}
