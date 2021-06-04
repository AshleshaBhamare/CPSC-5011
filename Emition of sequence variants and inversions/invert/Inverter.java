package abhamare_hw7EC.invert;

import abhamare_hw7EC.sequence.Sequence;

import java.util.Random;

import static abhamare_hw7EC.sequence.State.ACTIVE;

public class Inverter
{

    private int index;
    private static boolean isSeeded = false;

    Sequence sequence = new Sequence();

    public Inverter()
    {
        this.index = 0;
    }

    public Inverter(Sequence sequence)
    {
        this.sequence = sequence;
        this.index = generateRandomNumber(sequence.getWord().length() - 1);
    }

    public String invertElements()
    {

        Random rand = new Random();
        int index = 0;

        if (sequence.getState() == ACTIVE)
        {
            index = rand.nextInt(sequence.getWord().length() - 1);
            if (index < (sequence.getWord().length()-1))
                return swapChars(sequence.getWord(), index,  index+1);
            else
                return swapChars(sequence.getWord(), index, index-1);
        }

        return sequence.getWord();
    }

    private boolean checkWordSizeValidity(int index, String word)
    {
        int size;
        size = word.length();
        if (index < 0 || index >= size - 1) {
            return false;
        }
        return true;
    }

    private int generateRandomNumber(int maxRange)
    {
        Random random = new Random();
        if (!isSeeded) {
            random.ints();
            isSeeded = true;
        }

        int randomNumber;
        randomNumber = random.nextInt() % maxRange;
        return randomNumber;
    }

    private String convertIntoString(char[] array, int size)
    {
        String word = "";
        for (int i = 0; i < size; i++) {
            word = word + array[i];
        }
        return word;
    }

    private String swapChars(String str, int lIdx, int rIdx)
    {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }
}
