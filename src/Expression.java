public class Expression implements ISentence
{
    private ISentence sentence1;
    private ISentence sentence2;
    private Operator operator;
    public Expression( ISentence sentence1 , Operator operator, ISentence sentence2)
    {
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return sentence1.toString() + " " + operator.toString() + " " + sentence2.toString();
    }
}
