package abhamare_hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class implement VideoObjTest unit tests
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
class VideoObjTest {

    @Test
    public void testConstructorAndAttributes() {
        String title1 = "XX";
        String director1 = "XY";
        String title2 = " XX ";
        String director2 = " XY ";
        int year = 2002;

        VideoObj v1 = new VideoObj(title1, year, director1);
        assertSame(title1, v1.title());
        assertEquals(year, v1.year());
        assertSame(director1, v1.director());

        VideoObj v2 = new VideoObj(title2, year, director2);
        assertEquals(title1, v2.title());
        assertEquals(director1, v2.director());
    }

    @Test
    public void testConstructorExceptionYear() {
        try {
            new VideoObj("X", 1800, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("X", 5000, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("X", 1801, "Y");
            new VideoObj("X", 4999, "Y");
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
    @Test
    public void testConstructorExceptionTitle() {
        try {
            new VideoObj(null, 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj(" ", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void testConstructorExceptionDirector()
    {
        Assertions.assertThrows(IllegalArgumentException.class,()->
        {
            VideoObj obj = new VideoObj("", 700, "");
            assertEquals(new VideoObj("Frozen", 2015, "Adam"),
                    new VideoObj("Frozen", 2015, "Adam"));
        });
    }

    @Test
    public void testHashCode() {
        assertEquals
                (1331973446, new VideoObj("None", 2009,
                                                 "Zebra").hashCode());
        assertEquals
                (-2015297039, new VideoObj("Blah", 1954,
                                               "Cante").hashCode());
    }

    @Test
    public void testEquals()
    {
        VideoObj obj1 = new VideoObj("Martian", 2022, "sammy");
        VideoObj obj2 = new VideoObj("Martian", 2022, "sammy");

        assertTrue(obj1.equals(obj2));

        VideoObj obj3 = new VideoObj("Titanic", 2001, "John");
        VideoObj obj4 = new VideoObj("Titanic", 2010, "John");

        assertFalse(obj3.equals(obj4));
    }

    @Test
    public void testCompareTo()
    {
        VideoObj obj1 = new VideoObj("Martian", 2022, "sammy");
        VideoObj obj2 = new VideoObj("Martian", 2022, "sammy");

        obj1.compareTo(obj2);

        VideoObj obj3 = new VideoObj("Martian", 2022, "sammy");
        VideoObj obj4 = new VideoObj("Martian", 2022, "sammy");
        obj3.compareTo(obj4);
    }

    @Test
    public void testToString() {
        String s = new VideoObj("A", 2000, "B").toString();
        assertEquals( "A (2000) : B", s );
        s = new VideoObj(" A ", 2000, " B ").toString();
        assertEquals( "A (2000) : B", s );
    }

}