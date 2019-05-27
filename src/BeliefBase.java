import java.util.ArrayList;
import java.util.List;

public class BeliefBase
{
    List<ISentence> Sentences = new ArrayList<>();


    public void CheckLogicalEntailment()
    {

    }

    public String toString()
    {
        String beliefBase = "";
        for (int i = 0; i < Sentences.size(); i++)
        {
            beliefBase += Sentences.get(i).toString() + "\n";
        }
        return beliefBase;
    }

    public void addSentence(ISentence sentence)
    {
        sentence.convertToCNF();
        Sentences.add(sentence);
    }
    public void removeSentence(int index)
    {
        Sentences.remove(index);
    }
    public void removeSentence(ISentence sentence)
    {
        Sentences.remove(sentence);
    }


}
