package abhamare_hw4.person;

import abhamare_hw4.enums.PersonStatus;

/**
 * This class is used to hold Person Information
 *
 * @author Ashlesha Bhamare
 */

public class Person
{
    protected String firstName;
    protected String lastName;
    protected int suID;
    protected PersonStatus personStatus;
    protected String email;

    /**
     * Constructor
     *
     * @param firstName The first name of the faculty
     * @param lastName The last name of the faculty
     * @param suID The school identification number
     * @param personStatus The status of the faculty
     * @param email The school email address
     */
    public Person(String firstName, String lastName, int suID,
                  PersonStatus personStatus,String email )
    {
        this(firstName, lastName);
        this.suID = suID;
        this.email = email;
        this.personStatus = personStatus;

    }
    /**
     * Constructor
     *
     * @param firstName The first name of the faculty
     * @param lastName The last name of the faculty
     */
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getSuID()
    {
        return suID;
    }

    public String getEmail()
    {
        return email;
    }

    public PersonStatus getPersonStatus()
    {
        return personStatus;
    }

    @Override
    public int hashCode(){
        final int number = 31;
        int result = 1;
        result = number * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = number * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Person otherPerson = (Person) o;
        if (firstName == null){
            if (otherPerson.firstName != null)
            {
                return false;
            }
        }
        else if (!firstName.equals(otherPerson.firstName))
        {
            return false;
        }
        if (lastName == null)
        {
            if (otherPerson.lastName == null)
                return false;
        }
        else if (!lastName.equals(otherPerson.lastName))
        {
            return false;
        }
        return true;
    }
}
