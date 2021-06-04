package abhamare_hw1;

import java.util.HashMap;
import java.util.Map;

public class Driver
{
    public static void main(String[] args) throws Exception {
        String template = "Good $daypart $name - that's a nice $color shirt. " +
                "$newline Zippy quote: " + "$zippy";

        Map<String, String> templateVars = new HashMap<String, String>();

        templateVars.put("$name", "Ashlesha");
        templateVars.put("$color", "green");

        boolean isRandom = true;

            Greeter g = new Greeter(template);
            String greeting = g.getGreeting(templateVars, isRandom);
            System.out.println(greeting);

        extraCreditFunctionality();

    }
    /**
     * This function demonstrate extra credit functionality
     *
     * @throws Exception
     */
    public static void extraCreditFunctionality() throws Exception
    {
        System.out.println();
        String template = "Good $daypart $name. I owe you $1.25. $newline Zippy quote: " +
                "$zippy";

        Map<String, String> templateVars = new HashMap<String, String>();
        templateVars.put("$color", "green");


        boolean isRandom = false;
            Greeter g = new Greeter(template);
            String greeting = g.getGreeting(templateVars, isRandom);
            System.out.println(greeting);

    }
}
