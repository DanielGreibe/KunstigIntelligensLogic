import java.util.ArrayList;
import java.util.List;

public class BeliefBase
{
    List<ISentence> Sentences = new ArrayList<>();

    List<Variable> Variables = new ArrayList<>();

    List<List<Boolean>> VariableTruthTable = new ArrayList<>();

    List<List<Boolean>> ExpressionTruthTable = new ArrayList<>();




    public void generateVariables(ISentence sentence)
    {
        boolean alreadyExist = false;
        if (sentence instanceof Variable)
        {
            for(Variable i: Variables)
            {
                if (i.getName().equals(((Variable) sentence).getName()))
                {
                    alreadyExist = true;
                    break;
                }
            }
            if (!alreadyExist)
            {
                Variables.add(new Variable(((Variable) sentence).getName(), false));
            }

        }
        else
        {
            generateVariables(((Expression) sentence).getSentence1());
            generateVariables(((Expression) sentence).getSentence2());
        }
    }

    public void generateExpressionTruthTable()
    {
        for(int i = 0; i < Sentences.size(); i++)
        {
            ExpressionTruthTable.add(new ArrayList<>());
            for(int j = 0; j < Math.pow(2, Variables.size()); j++)
            {
                ExpressionTruthTable.get(i).add(EvaluateSentence(Sentences.get(i),j));
            }

        }
    }

    public boolean EvaluateSentence(ISentence sentence, int row)
    {
        boolean returnvalue = true;
        if(sentence instanceof Variable)
        {
            for(int i = 0; i < Variables.size(); i++)
            {
                if (Variables.get(i).getName().equals(((Variable) sentence).getName()))
                {
                    returnvalue = VariableTruthTable.get(i).get(row);
                }
            }

        }
        if (sentence instanceof Expression)
        {
            if(((Expression) sentence).getOperator() == Operator.OR)
            {
                if (EvaluateSentence(((Expression) sentence).getSentence1(), row) || EvaluateSentence(((Expression) sentence).getSentence2(), row))
                {
                    returnvalue =  true;
                }
                else
                {
                    returnvalue = false;
                }
            }

            if (((Expression) sentence).getOperator() == Operator.AND)
            {
                if (EvaluateSentence(((Expression) sentence).getSentence1(), row) && EvaluateSentence(((Expression) sentence).getSentence2(), row))
                {
                    returnvalue = true;
                }
                else
                {
                    returnvalue = false;
                }
            }

            if (((Expression) sentence).getOperator() == Operator.DOUBLEIMPLICATION)
            {
                if (EvaluateSentence(((Expression) sentence).getSentence1(), row) == EvaluateSentence(((Expression) sentence).getSentence2(), row))
                {
                    returnvalue = true;
                }
                else
                {
                    returnvalue = false;
                }
            }
        }
        if (sentence.getNegated())
        {
            return !returnvalue;
        }
        else
        {
            return returnvalue;
        }
    }

    public void FillVariablesList()
    {
        int frequency = 1;
        double NumberOfRows = Math.pow(2, Variables.size());
        for(Variable v: Variables)
        {
            int counter = frequency;
            boolean isValue0 = true;
            List<Boolean> TruthTableRow = new ArrayList<>();
            for(int i = 0; i < NumberOfRows; i++)
            {
                if (isValue0)
                {
                    TruthTableRow.add(false);
                    counter--;
                    if (counter == 0)
                    {
                        counter = frequency;
                        isValue0 = false;
                    }
                }
                else
                {
                    TruthTableRow.add(true);
                    counter--;
                    if (counter == 0)
                    {
                        counter = frequency;
                        isValue0 = true;
                    }
                }
            }

            VariableTruthTable.add(TruthTableRow);
            frequency = frequency * 2;
        }
    }

    public boolean isConsistent(){
        int Kolonne = 0;
        int Række = 0;
        int counter = 0;

        for(Række = 0; Række < ExpressionTruthTable.get(Kolonne).size(); Række++){
            Kolonne = 0;
            counter = 0;
            for(Kolonne = 0; Kolonne < ExpressionTruthTable.size(); Kolonne++){
                if (ExpressionTruthTable.get(Kolonne).get(Række)) {
                    counter++;
                    if (counter == ExpressionTruthTable.size()) {
                        return true;
                    }
                }
                if (Kolonne == ExpressionTruthTable.size()-1){
                    break;
                }
            }
        }
        return false;
    }

    public void CheckLogicalEntailment(ISentence sentence)
    {
        //Check if the Belief Base entails the new sentence.
        //Essentially check if what is added is just redundant data.
        //If it's just redundant data we don't add it.
        //If it isn't redundant data we add it to the Belief Base
        //And then we check if something else is entailed by the new sentence.


        /*boolean EntailedByBeliefBase = false;
        for(int i = 0; i < Sentences.size(); i++)
        {
            if (Sentences.get(i).Entails(sentence) == true)
            {
                EntailedByBeliefBase = true;
            }
        }
        if (!EntailedByBeliefBase)
        {
            addSentence(sentence);
            for(int i = 0; i < Sentences.size(); i++)
            {
                if (sentence.Entails(Sentences.get(i)))
                {
                    removeSentence(i);
                }
            }
        }*/
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


    public List<Variable> getVariables() {
        return Variables;
    }

    public List<List<Boolean>> getVariableTruthTable() {
        return VariableTruthTable;
    }

    public List<List<Boolean>> getExpressionTruthTable() {
        return ExpressionTruthTable;
    }
}
