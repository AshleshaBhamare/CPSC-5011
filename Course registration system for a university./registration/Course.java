package abhamare_hw4.registration;

import abhamare_hw4.enums.SubjectCode;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 *
 * @author Ashlesha Bhamare
 */
public class Course
{
    private SubjectCode code;
    private int courseNum;
    private String name;
    private int creditNum;

    private Set<Course> prerequisite = new HashSet<>();

    /**
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     *
     */
    public Course(SubjectCode code, int courseNum){
        this.code = code;
        this.courseNum = courseNum;
    }

    /**
     *
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
    public Course(SubjectCode code, int courseNum, String name,
                  int creditNum)
    {
        this(code, courseNum);
        this.name = name;
        this.creditNum = creditNum;
    }

    @Override
    public int hashCode()
    {
        final int number = 31;
        int result = 1;
        result = number * result + ((code == null) ? 0 : code.hashCode());
        result = number * result + courseNum;
        return result;
    }
    @Override
    public boolean equals(Object o){

        if (this == o)
        {
            return true;
        }
        if (o == null)
        {
            return false;
        }
        if (getClass() != o.getClass())
            return false;

        Course otherCourse = (Course) o;

        if (code != otherCourse.code)
            return false;
        if (courseNum != otherCourse.courseNum)
            return false;
        return true;
    }

    /**
     * This function adds Prerequisites
     *
     * @param prereqs the prerequisites
     */
    public void addPrerequisites(Course prereqs)
    {
        prerequisite.add(prereqs);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

       for(Course c: prerequisite)
       {
           stringBuilder.append("Name=" + c.getCode() + "-" + c.getCourseNum()
           + ": " + c.getName() );
       }
       return "Course: Name=" + code + "-" + courseNum + ": " + name + ", Credits="
               + creditNum + ", Prerequisite=[" + stringBuilder + "]";
    }

    public SubjectCode getCode()
    {
        return code;
    }

    public int getCourseNum()
    {
        return courseNum;
    }

    public String getName()
    {
        return name;
    }

    public int getCreditNum()
    {
        return creditNum;
    }

    public Set<Course> getPrerequisite(){
        return prerequisite;
    }

}

