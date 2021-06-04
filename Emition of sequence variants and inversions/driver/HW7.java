package abhamare_hw7EC.driver;

import abhamare_hw7EC.invert.Inverter;
import abhamare_hw7EC.sequence.Extractor;
import abhamare_hw7EC.sequence.Repeater;
import abhamare_hw7EC.sequence.Sequence;
import abhamare_hw7EC.sequence.Variator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


import static abhamare_hw7EC.sequence.State.ACTIVE;

public class HW7
{
    static Random random = new Random();
    static Scanner keyboard = new Scanner(System.in);
    static int totalWords = 0;

    public static void main(String[] args)
    {
        String line = "";
        int SIZE = 9;
        Sequence[] sequence = new Sequence[SIZE];
        String[] words;
        String answer;
        String input;
        char repeat = 'y';

        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nWelcome to the Sequence tester!");
        words = readFile();

        int count = 3;
        for (int k = 0; k < count; k++)
        {
            int index = random.nextInt(totalWords - 1);
            System.out.println("\n----------");

            System.out.println("\nTesting word " + (k + 1) + ":");

            Repeater repeater = new Repeater(words[index], ACTIVE);

            for(int l = 0; l < 3; l++)
            {
                sequence[l] = repeater;
                String subSequence = words[index].substring(0, words[index].length() / 2);
                Extractor extractor = new Extractor(words[index], subSequence, ACTIVE);

                sequence[l + 1] = extractor;
                Variator variator = new Variator(words[index], ACTIVE);
                sequence[l + 2] = variator;
                System.out.println("\nemit: " + sequence[l].emitWord().trim());
                Inverter inverter = new Inverter(sequence[l]);
                System.out.println("invert: " + inverter.invertElements().trim());

            }

            while(repeat == 'y' || repeat == 'Y')
            {
                System.out.print("\nWhat is your guess? ");
                answer = keyboard.nextLine();

                if (answer.trim().equals(words[index]))
                {
                    System.out.println("That's correct!");
                    break;
                }
                else
                {
                    System.out.println("That is not correct.");
                    System.out.print("Guess again (y/n)? ");
                    input = keyboard.next();   // Read a line.
                    keyboard.nextLine();
                    repeat = input.charAt(0);
                }
            }
        }

        System.out.println("\n----------");

        testAdditionalFunctionality(words, line);

        System.out.println("\n----------");
        System.out.println("\nThanks for using the Sequence tester! \n");

    }

    public static String[] readFile()
    {
        BufferedReader fileReader;
        int numberOfLines = 0;
        String[] lines = new String[50];
        try {

            fileReader = new BufferedReader(new FileReader
                    ("/Users/rishi/Desktop/CPSC5011/abhamare__hw7EC/data/words.dat"));
            while (fileReader.readLine() != null)
            {
                lines[numberOfLines] = fileReader.readLine();
                numberOfLines++;
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        totalWords = numberOfLines;
        return lines;
    }


public static void testAdditionalFunctionality(String[] words, String line)
    {
        String input;
        char repeat = 'y';

        System.out.println("Testing word 4 (additional functionality): \n");
        do
        {

            int index = random.nextInt(totalWords - 1);

            Repeater repeater = new Repeater(words[index], ACTIVE);

            if (repeater.getWord().isEmpty())
            {
                System.out.println("A Word " + line + " length is less than 3 characters long ");

                repeat = 'y';
                continue;
            }

            Inverter inverter = new Inverter(repeater);
            System.out.println("Invert: " + inverter.invertElements().trim());

            do
            {
                //int endIndex = random.nextInt() % (line.length() - 2) + 1;
                int endIndex = random.nextInt(50) % (words[index].length() / 2) + 1;
                //String subSequence = words[index].substring(0, (words[index].length() / 2) + 1);
                String subSequence = words[index].substring(0, endIndex);

                System.out.println("\nprovide a subsequence: " + subSequence);

                Extractor extractor = new Extractor(words[index], subSequence, ACTIVE);

                System.out.println("emit: " + extractor.emitWord().trim());

                System.out.print("\nProvide another subsequence (y/n)? ");
                input = keyboard.next();  // Read a line.
                repeat = input.charAt(0);

            } while (repeat == 'y' || repeat == 'Y');

            do {
                String response;
                System.out.print("\nWhat is your guess? ");
                response = keyboard.next();

                if (response.trim().equals(words[index]))
                {
                    System.out.println("That's correct!");
                    break;
                }
                else
                {
                    System.out.println("That is not correct.");
                    System.out.print("Guess again (y/n)? ");
                    input = keyboard.next();  // Read a line.
                    repeat = input.charAt(0);

                }
            } while (repeat == 'y' || repeat == 'Y');

            System.out.print("\nWould you like to test another word (y/n)? ");
            input = keyboard.next();  // Read a line.
            repeat = input.charAt(0);

        } while (repeat == 'y' || repeat == 'Y');

    }
}
