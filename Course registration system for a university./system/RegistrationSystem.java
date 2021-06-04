package abhamare_hw4.system;

import abhamare_hw4.enums.*;
import abhamare_hw4.exception.*;
import abhamare_hw4.person.Faculty;
import abhamare_hw4.person.PersonDetails;
import abhamare_hw4.person.Student;
import abhamare_hw4.registration.Course;
import abhamare_hw4.registration.Section;

import java.util.*;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about
 * the school, including the ability to add students, add faculty, add courses,
 * and add prerequisite(s).</p>
 *
 * @author Ashlesha Bhamare
 */
public class RegistrationSystem
{
    private Set<Faculty> faculties;
    private Set<Student> students;
    private Set<Section> sections;
    private List<Course> courses;
    private Map<SubjectCode, String> subjects;
    private List<Faculty> facultyList;

    /**
     * Default Constructor
     */
    public RegistrationSystem() {

        faculties = new HashSet<>();
        students = new HashSet<>();
        sections = new HashSet<>();
        courses = new ArrayList<>();
        subjects = new HashMap<>();
        facultyList= new ArrayList<>();

    }

    /**
     * Add a student to the student list collection.
     *
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName,
                           StudentType type, StudentProgram program,
                           Quarter quarter, int year)
            throws DuplicatePersonException
    {

        if(facultyList.isEmpty())
        {
            for(Faculty faculty:faculties)
                facultyList.add(faculty);
        }
        int suID = PersonDetails.getNextSuid();
        String email = PersonDetails.generateEmail(firstName, lastName);

        StudentYear studentYear = null;
        int yearDifference = 0;

        if(type == StudentType.UNDERGRAD) {
            yearDifference = PersonDetails.getYearDifference(year);
            /*if (yearDifference > 3)
            {
                yearDifference = 3;
                studentYear = StudentYear.values()[yearDifference] ;
            }*/
            studentYear = StudentYear.values()[yearDifference - 1] ;

        }
        Random rnd = new Random();

        Student student = new Student(firstName, lastName, suID, PersonStatus.ACTIVE,
                                type, program, studentYear, quarter, year,
                facultyList.get(rnd.nextInt(faculties.size()-1)) , email);

        if(students.contains(student))
        {
            throw new DuplicatePersonException();
        }
        students.add(student);
    }



    /**
     * Add a faculty to the faculty list collection.
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                           FacultyType type, Building bldg, int room, String email)
            throws DuplicatePersonException
    {

        int suId = PersonDetails.getNextSuid();

        Faculty faculty = new Faculty(firstName, lastName, suId, PersonStatus.ACTIVE,
                type, bldg, room, email);

        if (this.faculties.contains(faculty)){
            throw new DuplicatePersonException();
        }
        this.faculties.add(faculty);
    }

    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     *
     * @param code    The subject code
     * @param desc    The subject description
     *
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc)
            throws DuplicateSubjectException {


        if (subjects.containsKey(code)){
            throw new DuplicateSubjectException();
        }

        subjects.put(code, desc);

    }

    /**
     * Adds a course to the course list collection.
     *
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system
     */
    public void addCourse(SubjectCode code, int num, String name,
                          int creditNum) throws DuplicateCourseException
    {

        Course course = new Course(code, num, name, creditNum);

        if (courses.contains(course))
        {
            throw new DuplicateCourseException();
        }
        courses.add(course);
    }

    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     *
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num,
                                SubjectCode prereqCode, int prereqNum)
            throws CourseNotFoundException {

            Course existingCourse = getCourse(code, num);
            if (existingCourse == null)
            {
                throw new CourseNotFoundException();
            }

            Course prerequisiteCourse = getCourse(prereqCode, prereqNum);
            if (prerequisiteCourse == null)
            {
                throw new CourseNotFoundException();
            }

            existingCourse.addPrerequisites(prerequisiteCourse);
    }

    /**
     * Adds a section to the section list collection.
     *
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                           String firstName, String lastName, Quarter quarter,
                           int year, int cap, Building bldg, int room)
            throws CourseNotFoundException, PersonNotFoundException,
                                                       DuplicateSectionException
    {

        Course course = getCourse(code, courseNum);
        if (course == null){
            throw new CourseNotFoundException();
        }

        Faculty faculty = new Faculty(firstName, lastName);

        if (!this.faculties.contains(faculty)){
            throw new PersonNotFoundException();
        }

        Section section = new Section(course, sectionNum, faculty, quarter, year,
                cap, bldg, room);

        if (sections.contains(section)){
            throw new DuplicateSectionException();
        }

        sections.add(section);

    }

    private Course getCourse(SubjectCode code, int num)
    {
        for (Course c: courses)
        {
            if (c.getCourseNum()==num && c.getCode()==code){
                return c;
            }
        }
        return null;
    }

    public Set<Faculty> getFaculties()
    {
        return faculties;
    }

    public Set<Student> getStudents()
    {
        return students;
    }

    public Set<Section> getSections()
    {
        return sections;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public Map<SubjectCode, String> getSubjects()
    {
        return subjects;
    }

}
