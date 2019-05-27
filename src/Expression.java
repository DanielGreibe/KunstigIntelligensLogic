public class Expression implements ISentence
{
    private ISentence sentence1;
    private ISentence sentence2;
    private Operator operator;
    private boolean negation;
    public Expression( ISentence sentence1 , Operator operator, ISentence sentence2, boolean negation)
    {
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
        this.operator = operator;
        this.negation = negation;
    }

    @Override
    public String toString() {
        if (negation)
        {
            return "NOT(" + sentence1.toString() + " " + operator.toString() + " " + sentence2.toString() + ")";
        }
        else
        {
            return "(" + sentence1.toString() + " " + operator.toString() + " " + sentence2.toString() + ")";
        }
    }
}
