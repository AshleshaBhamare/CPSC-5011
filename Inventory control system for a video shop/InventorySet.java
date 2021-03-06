package abhamare_hw5;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

/**
 * An Inventory implemented using a <code>HashMap&lt;Video, Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * <p><b>Class Type:</b> Mutable Collection of Records</p>
 * <p><b>Object Invariant:</b></p>
 *   Every key and value in the map is non-<code>null</code>.
 * <p><b>Object Invariant:</b></p>
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
public class InventorySet {
    /** <p><b>Invariant:</b> <code>_data != null</code> </p>*/
    private final Map<VideoObj, Record> data = new HashMap<VideoObj, Record>();

    /**
     * Default constructor.
     */
    InventorySet() { }

    /**
     * This function returns the number of Records.
     *
     * @return int number of records
     *
     */
    public int size()
    {
        return data.size();
    }

    /**
     *  This function returns a copy of the record for a given Video; if not present,
     *  return <code>null</code>.
     *
     * @param v videoObj
     * @return a copy of the record for a given Video
     */
    public Record get(VideoObj v)
    {
        if (data.containsKey(v))
        {
            Record rec = data.get(v);
            Record record = new Record(rec.video, rec.numOwned, rec.numOut,
                                                             rec.numRentals);
            return record;
        }
        return null;
    }

    /**
     * Return a copy of the records as a collection.
     * Neither the underlying collection, nor the actual records are returned.
     *
     * @return a copy of the records as a collection
     */
    public Collection<Record> toCollection()
    {
        // Recall that an ArrayList is a Collection.
        ArrayList<Record> list = new ArrayList<Record>(data.values());
        ArrayList<Record> recordList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            Record record = list.get(i);
            recordList.add(new Record(record.video, record.numOwned,
                                          record.numOut, record.numRentals));
        }
        return recordList;
    }

    /**
     * Add or remove copies of a video from the inventory.
     * If a video record is not already present (and change is
     * positive), a record is created.
     * If a record is already present, <code>numOwned</code> is
     * modified using <code>change</code>.
     * If <code>change</code> brings the number of copies to be zero,
     * the record is removed from the inventory.
     *
     * @param video the video to be added.
     * @param change the number of copies to add (or remove if negative).
     *
     * @throws IllegalArgumentException if video null, change is zero,
     *  if attempting to remove more copies than are owned, or if
     *  attempting to remove copies that are checked out.
     * <p><b>Postcondition:</b> changes the record for the video</p>
     */
    public void addNumOwned(VideoObj video, int change) throws IllegalArgumentException
    {
        Record record = null;
        if (video == null || change == 0)
        {
            throw new IllegalArgumentException();
        }
        if (data.containsKey(video))
        {
            record = data.get(video);

            if (record.numOwned < change && change < 0)
            {
                throw new IllegalArgumentException();
            }
            record.numOwned = record.numOwned + change;

            if (record.numOwned == 0)
            {
                 data.remove(video);
                return;
            }
        }
            else {
                if (change > 0)
                {
                    record = new Record(video, change, 0,0);
                }
                else {
                    throw new IllegalArgumentException();
                }

            }
            data.put(video, record);
        }

    /**
     * Check out a video.
     *
     * @param video the video to be checked out.
     *
     * @throws IllegalArgumentException if video has no record or numOut
     * equals numOwned.
     * <p><b>Postcondition:</b> changes the record for the video</p>
     */
    public void checkOut(VideoObj video) throws IllegalArgumentException
    {
        if (!data.containsKey(video))
        {
            throw new IllegalArgumentException();
        }
        Record record = data.get(video);
        if (record.numOut == record.numOwned)
        {
            throw new IllegalArgumentException();
        }

        record.numRentals = record.numRentals + 1;
        record.numOut = record.numOut + 1;

        data.put(video, record);
    }

    /**
     * Check in a video.
     *
     * @param video the video to be checked in.
     *
     * @throws IllegalArgumentException if video has no record or numOut
     * non-positive.
     * <p><b>Postcondition:</b> changes the record for the video</p>
     */
    public void checkIn(VideoObj video) throws IllegalArgumentException
    {
        if (!data.containsKey(video))
        {
            throw new IllegalArgumentException();
        }
        Record record = data.get(video);
        if (record.numOut <= 0)
        {
            throw new IllegalArgumentException();
        }

        record.numOwned++;
        data.put(video, record);
    }

    /**
     * Remove all records from the inventory.
     * <p><b>Postcondition:</b> <code>size() == 0</code></p>
     *
     */
    public void clear()
    {
        data.clear();
    }

    /**
     * This function returns the contents of the inventory as a string.
     *
     * @return String
     */
    @Override
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Database:\n");
        for (Record r : data.values()) {
            buffer.append("  ");
            buffer.append(r);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
