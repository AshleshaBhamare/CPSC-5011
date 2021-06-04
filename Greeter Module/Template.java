package abhamare_hw1;

import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Template
{
    /**
     * Constructor used to spilt the String separated by space
     *
     * @param s String
     * @throws FileNotFoundException
     */
    public Template(String s) throws FileNotFoundException{
        words = s.split("\\s");
        zippyList = populateZippyList();
        currentLineIndex = 0;
    }

    /**
     * This function checks if the word is same as the some conditions.
     *
     * @param args Hash map
     * @param isRandom Boolean flag
     * @return String to be printed
     * @throws Exception
     */
    public String instantiate(Map<String, String> args, boolean isRandom)
                                                           throws Exception {
        String [] translatedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isVariable(words[i])) {
                if (words[i].equals("$newline"))
                {
                    translatedWords[i] = "\n";
                }
               else if (words[i].equals("$zippy"))
                {
                    if (isRandom){
                        translatedWords[i] = getRandomZippyQuotes();
                    }
                    else{
                        translatedWords[i] = getSequentialZippyQuotes();
                        currentLineIndex++;
                    }
                }
                else if (words[i].equals("$daypart")){
                    translatedWords[i] = (new DayPart()).toString();
                }
                else if (args.containsKey(words[i]))
                {
                    translatedWords[i] = args.get(words[i]);
                }

            else if (words[i].equals("$name") || words[i].startsWith("$name.")) {
                    String userName = System.getProperty("user.name");
                    if (userName != null || userName.length() != 0) {
                        translatedWords[i] = userName.substring(0, 1).toUpperCase()
                                + userName.substring(1);
                    } else {
                        translatedWords[i] = unnamedPerson;
                    }
                } else

                    throw new Exception("Variable not matched: " + words[i]);
            }
            else {
                translatedWords[i] = words[i];
            }
        }
        return String.join(" ", translatedWords);
    }

    /** This function Checks if the start of the word is with $
     *
     * @param s String
     * @return true if is $, otherwise return false
     */
    private boolean isVariable(String s)
    {
        if(s.charAt(0) == '$')
        {
            if (checkIsNumeric(Character.toString(s.charAt(1)))) {
                return false;
            }
           return true;
        }
        return false;
    }

    private boolean checkIsNumeric(String string){
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *  This function is used to get a random number and get the zippy quote from
     *  the array list
     *
     * @return zippy quote which is generated from random number.
     * @throws FileNotFoundException
     */
    private String getRandomZippyQuotes()
    {
        Random randomNumber = new Random();

        int randomNumberIndex = randomNumber.nextInt(noOfLines);

        return zippyList.get(randomNumberIndex);
    }

    /**
     * This function returns Sequential zippy quote
     *
     * @return sequential zippy quote
     */
    private String getSequentialZippyQuotes()
    {
        if(currentLineIndex < noOfLines)
        {
            return zippyList.get(currentLineIndex);
        }
      else
         {
          currentLineIndex = 0;
          return zippyList.get(currentLineIndex);
        }
    }
    /**
     * This function is used to populate the Arraylist with zippy quotes.
     *
     * @return populated zippy quote
     * @throws FileNotFoundException
     */
    private List<String> populateZippyList () throws FileNotFoundException {
        File file = new File("yow.lines");

        List<String> zippyList = new ArrayList<>();

        Scanner keyBoard = new Scanner(file);
        noOfLines = 0;
        while (keyBoard.hasNextLine())
        {
            String zippyQuote = keyBoard.nextLine();
            if(zippyQuote.length() != 0){
                zippyList.add(zippyQuote);
                noOfLines++;
            }
        }
        return zippyList;
    }

    private String [] words;
    private static int currentLineIndex;
    private static int noOfLines;
    private List<String> zippyList;
    private final static String unnamedPerson = "Unnamed Person";

}
