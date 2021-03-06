package abhamare_hw4.exception;

/**
 * <p>The class <strong>DuplicateCourseException</strong> and its subclasses are a form of Throwable
 * that indicates conditions that a reasonable application might want to catch.
 * This exception is thrown when attempting to add a duplicate course.</p>
 *
 *
 */
@SuppressWarnings("serial")
public class DuplicateCourseException extends Exception
{
    public DuplicateCourseException(String msg) {
        super(msg);
    }

    public DuplicateCourseException() {
        this("Course has already been added.");
    }
}
