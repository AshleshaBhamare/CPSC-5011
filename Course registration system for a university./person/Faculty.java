package abhamare_hw4.person;

import abhamare_hw4.enums.Building;
import abhamare_hw4.enums.FacultyType;
import abhamare_hw4.enums.PersonStatus;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 *
 * @author Ashlesha Bhamare
 */
public class Faculty extends Person
{
    private Building building;
    private int room;
    private FacultyType facultyType;

    /**
     * Constructor
     *
     * @param firstName The first name of the faculty
     * @param lastName The last name of the faculty
     * @param suID The school identification number
     * @param status The status of the facility
     * @param facultyType The type of faculty
     * @param building The building and the room number
     * @param email The school email address
     */
    public Faculty(String firstName, String lastName, int suID, PersonStatus status,
                    FacultyType facultyType, Building building, int room, String email)
    {
        super(firstName, lastName, suID, status, email);
        this.building = building;
        this.room = room;
        this.facultyType = facultyType;
    }
    /**
     * Constructor
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    @Override
    public String toString()
    {
        return "Faulty: Name="+ firstName + " " + lastName + ", SUID=" + suID
                + ", Email=" + email + ", Status=" + personStatus + ", Type="  +
                facultyType + ", Office=" + building + " " + room;
    }

    public Building getBuilding()
    {
        return building;
    }

    public int getRoom()
    {
        return room;
    }

    public FacultyType getFacultyType()
    {
        return facultyType;
    }


}
