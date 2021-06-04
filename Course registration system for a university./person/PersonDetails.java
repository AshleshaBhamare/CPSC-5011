package abhamare_hw4.person;

import java.util.Calendar;

/**
 * This class is used to get Person Details
 *
 * @author Ashlesha Bhamare
 */
public class PersonDetails {

    private static int suID = 100001;

    private static final String email = "@seattleu.edu";

    /**
     * This function generates new suID
     *
     * @return generated suID
     */
    public static int getNextSuid()
    {
        return suID++;
    }

    /**
     * This function calculates year difference
     *
     * @param startingYear starting year of student
     * @return calculated year difference
     */
    public static int getYearDifference(int startingYear)
    {

        return Calendar.getInstance().get(Calendar.YEAR) - startingYear;
    }

    /**
     * This function generates the email
     *
     * @param firstName firstname of person
     * @param lastName lastname of person
     * @return generated email address
     */
    public static String generateEmail(String firstName, String lastName)
    {
        return (firstName + lastName + email).toLowerCase();

    }
}
