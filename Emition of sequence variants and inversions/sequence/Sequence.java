package abhamare_hw7EC.sequence;

import java.util.Random;

import static abhamare_hw7EC.sequence.State.ACTIVE;

public class Sequence
{
    private State state;
    private String word;

    public String emitWord()
    {
        Random rand = new Random();
        int index;
        if(this.state==ACTIVE)
        {
            index = rand.nextInt(word.length()-1);
            return word.concat(word.charAt(index)+"");
        }
        return this.word;
    }

    public Sequence() {
        this.word = "";
        this.state = ACTIVE;
    }

    public Sequence(String word, State state)
    {
        this.word = word;
        this.state = state;
    }

    public boolean validateTheWord(String word)
    {
        return word.length() >= 3;
    }

    public void setWord(String word)
    {
        if (validateTheWord(word))
        {
            this.word = word;
        }
    }

    public String getWord()
    {
        return this.word;
    }

    public State getState()
    {
        return state;
    }
}
