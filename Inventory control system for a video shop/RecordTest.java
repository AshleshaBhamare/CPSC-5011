package abhamare_hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class implement RecordTest unit tests
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
class RecordTest {

    @Test
    public void testCopy() {

        // be sure to test that copy returns a NEW reference!
        VideoObj video = new VideoObj( "A", 2000, "B" );
        Record r1 = new Record( video, 20, 10, 300 );
        Record r2 = r1.copy();
        assertTrue( r1 != r2 );
        assertTrue( r1.toString().equals(r2.toString()) );
    }
}