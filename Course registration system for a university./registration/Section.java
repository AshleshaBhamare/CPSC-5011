package abhamare_hw4.registration;

import abhamare_hw4.enums.Building;
import abhamare_hw4.enums.Quarter;
import abhamare_hw4.person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 *
 * @author Ashlesha Bhamare
 */
public class Section
{
    private Course course;
    private int section;
    private Faculty instructor;
    private Quarter quarter;
    private int year;
    private int cap;
    private Building bldg;
    private int room;
    /**
     *
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter,
                   int year, int cap, Building bldg, int room)
    {
        this.course = course;
        this.section = section;
        this.instructor = instructor;
        this.quarter = quarter;
        this.year = year;
        this.cap = cap;
        this.bldg = bldg;
        this.room = room;

    }

    @Override
    public int hashCode()
    {
        final int number = 31;
        int result = 1;
        result = number * result + ((course == null) ? 0 : course.hashCode());
        result = number * result + section;
        return result;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Section otherSection = (Section) o;

        if (course == null){
            if (otherSection.course != null)
            {
                return false;
            }
        }
        else if (!course.equals(otherSection.course))
        {
            return false;
        }
        if (section != otherSection.section)
            return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "Section: Course=" + course.getCode() + "-" + course.getCourseNum()
                + "-0" + section + ": " + course.getName() + ", Faculty=" +
                instructor.getFirstName() + " " + instructor.getLastName() +
                ", Term=" + quarter + " " + year + ", Capacity=" + cap + ", Room="
                + bldg + " " + room;
    }

}
