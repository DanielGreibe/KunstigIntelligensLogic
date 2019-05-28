public class Expression implements ISentence
{
    private ISentence sentence1;
    private ISentence sentence2;
    private Operator operator;
    private boolean negated;
    public Expression( ISentence sentence1 , Operator operator, ISentence sentence2, boolean negated)
    {
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
        this.operator = operator;
        this.negated = negated;
    }

    @Override
    public String toString() {
        if (negated)
        {
            return "NOT(" + sentence1.toString() + " " + operator.toString() + " " + sentence2.toString() + ")";
        }
        else
        {
            return "(" + sentence1.toString() + " " + operator.toString() + " " + sentence2.toString() + ")";
        }
    }

    @Override
    public Expression convertToCNF()
    {
        this.ConvertBiimplication(this);
        this.ConvertImplication(this);
        this.ConvertNotExpression(this);
        this.ConvertDoubleNot(this);
        this.sentence1 = sentence1.convertToCNF();
        this.sentence2 = sentence2.convertToCNF();
        return this;

    }

    private Expression ConvertBiimplication (Expression sentence)
    {
        if (sentence.operator == Operator.DOUBLEIMPLICATION)
        {
            Expression NewSentence1 = new Expression(sentence.sentence1, Operator.IMPLICATION, sentence.sentence2, sentence.negated);
            Expression NewSentence2 = new Expression(sentence.sentence2, Operator.IMPLICATION, sentence.sentence1, sentence.negated);

            sentence.sentence1 = NewSentence1;
            sentence.operator = Operator.AND;
            sentence.sentence2 = NewSentence2;
        }

        return sentence;
    }

    private Expression ConvertImplication (Expression sentence)
    {
        if(sentence.operator == Operator.IMPLICATION)
        {
            sentence.sentence1.Negate();
            sentence.operator = Operator.OR;

        }
        return sentence;
    }

    private Expression ConvertNotExpression (Expression sentence)
    {
        return sentence;
    }

    private Expression ConvertDoubleNot (Expression sentence)
    {
        return sentence;
    }

    @Override
    public ISentence Negate()
    {
        if (this.negated == true)
        {
            this.negated = false;
        }
        else
        {
            this.negated = true;
        }
        return this;
    }
}
