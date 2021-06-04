package abhamare_hw5;

/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * <p><b>Class Type:</b> Immutable Data Class</p>
 * <p><b>Object Invariant:</b></p>
 *   Title is non-null, no leading or final spaces, not empty string.
 * <p><b>Object Invariant:</b></p>
 *   Year is greater than 1800, less than 5000.
 * <p><b>Object Invariant:</b></p>
 *   Director is non-null, no leading or final spaces, not empty string.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
public class VideoObj implements Comparable<VideoObj> {
    /** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
    private final String title;

    /** <p><b>Invariant:</b> greater than 1800, less than 5000 </p>*/
    private final int year;

    /** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
    private final String director;

    /**
     * Initialize all object attributes.
     * Title and director are "trimmed" to remove leading and final space.
     *
     * @param title title of a video
     * @param year year of a video
     * @param director director of a video
     * @throws IllegalArgumentException if any object invariant is violated.
     */
    public VideoObj (String title, int year, String director)
                                              throws IllegalArgumentException
    {

        if (title == null || title.trim().length() == 0 || year < 1801 ||
                year > 4999 || director == null || director.trim().length() == 0)
        {
            throw new IllegalArgumentException();
        }

        this.year = year;
        this.title = title.trim();
        this.director = director.trim();
    }

    /**
     * This function return the the value of director attribute.
     *
     * @return String a value of director
     */
    public String director()
    {
        return this.director;
    }

    /**
     * This function return the the value of title attribute.
     *
     * @return String value of title
     */
    public String title()
    {
        return this.title;
    }

    /**
     * This function return the the value of year attribute.
     *
     * @return int value of the year
     */
    public int year()
    {
        return this.year;
    }

    /**
     * Compare the attributes of this object with those of thatObject.
     *
     * @param thatObject the Object to be compared.
     * @return deep equality test between this and thatObject.
     *
     */
    @Override
    public boolean equals(Object thatObject)
    {
        if (this == thatObject)
        {
            return true;
        }
        if (thatObject == null)
            return false;
        if (getClass() != thatObject.getClass())
            return false;

        VideoObj obj = (VideoObj) thatObject;
        if (director == null)
        {
            if (obj.director != null)
                return false;
        }
        else if (!director.equals(obj.director))
        {
            return false;
        }
        if (title == null) {
            if (obj.title != null)
                return false;
        }
        else if (!title.equals(obj.title))
        {
            return false;
        }
        if (year != obj.year)
            return false;

        return true;
    }

    /**
     * Return a hash code value for this object using the algorithm from Bloch:
     * fields are added in the following order: title, year, director.
     *
     * @return int a hash code value for this object
     */
    @Override
    public int hashCode()
    {
        final int number = 31;
        int result = 1;

        result = number * result + ((director == null) ? 0 : director.hashCode());
        result = number * result + ((title == null) ? 0 : title.hashCode());
        result = number * result + year;
        return  result;
    }

    /**
     * Compares the attributes of this object with those of thatObject, in
     * the following order: title, year, director.
     *
     * @param thatObject the VideoObj to be compared.
     *
     * @return a negative integer, zero, or a positive integer as this
     *  object is less than, equal to, or greater than that object.
     *
     */
    @Override
    public int compareTo(VideoObj thatObject)
    {
        VideoObj videoObj = (VideoObj) thatObject;

        if(this.title.compareTo(videoObj.title) < 0)
        {
            return 1;
        }
        else if (this.title.compareTo(videoObj.title()) > 0)
        {
            return -1;
        }

        int compareYear = Integer.compare(this.year, videoObj.year);

        if (compareYear == 0)
        {
            return (this.director.compareTo(videoObj.director));
        }
        return compareYear;
    }

    /**
     * Return a string representation of the object in the following format:
     * <code>"title (year) : director"</code>.
     *
     * @return String a string representation of the object
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(title);
        builder.append(" (" + year + ") : ");
        builder.append(director);
        return builder.toString();
    }
}
