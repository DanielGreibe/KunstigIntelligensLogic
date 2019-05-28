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

    public Expression( Expression expression)
    {
        this(expression.getSentence1(), expression.getOperator(), expression.getSentence2(), expression.getNegated());
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
        ConvertBiimplication();
        ConvertImplication();
        ConvertNotExpression();
        ConvertDoubleNot();
        sentence1.convertToCNF();
        sentence2.convertToCNF();
        return this;

    }

    private Expression ConvertBiimplication ()
    {
        if (operator == Operator.DOUBLEIMPLICATION)
        {
            Expression NewSentence1 = new Expression(this);//new Expression(sentence1, Operator.IMPLICATION, sentence2, negated);
            Expression NewSentence2 = new Expression(this);//new Expression(sentence2, Operator.IMPLICATION, sentence1, negated);


            sentence1 = NewSentence1;
            operator = Operator.AND;
            sentence2 = NewSentence2;
        }
        return this;
    }

    private Expression ConvertImplication ()
    {
        if(operator == Operator.IMPLICATION)
        {
            sentence1.Negate();
            operator = Operator.OR;

        }
        return this;
    }

    private Expression ConvertNotExpression ()
    {
        return this;
    }

    private Expression ConvertDoubleNot ()
    {
        return this;
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

    public ISentence getSentence1()
    {
        return sentence1;
    }
    public ISentence getSentence2() {
        return sentence2;
    }
    public boolean getNegated()
    {
        return negated;
    }
    public Operator getOperator() {
        return operator;
    }

    public void setSentence1(ISentence sentence1) {
        this.sentence1 = sentence1;
    }

    public void setSentence2(ISentence sentence2) {
        this.sentence2 = sentence2;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }
}
