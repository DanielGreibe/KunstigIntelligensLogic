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
        Expression CopyExpression = new Expression(this.getSentence1(), this.getOperator(), this.getSentence2(), this.getNegated());
        CopyExpression = ConvertBiimplication(CopyExpression);
        CopyExpression = ConvertImplication(CopyExpression);
        CopyExpression.sentence1 = CopyExpression.sentence1.convertToCNF();
        CopyExpression.sentence2 = CopyExpression.sentence2.convertToCNF();

        return CopyExpression;

    }

    private Expression ConvertBiimplication (Expression expression)
    {
        if (expression.getOperator() == Operator.DOUBLEIMPLICATION)
        {
            expression.sentence1 = new Expression(expression.getSentence1(), Operator.IMPLICATION, expression.getSentence2(), expression.getNegated());
            expression.sentence2 = new Expression(expression.getSentence2(), Operator.IMPLICATION, expression.getSentence1(), expression.getNegated());
            expression.operator = Operator.AND;
        }
        return this;
    }

    private Expression ConvertImplication (Expression expression)
    {
        if(operator == Operator.IMPLICATION)
        {
            Expression CopyExpression = new Expression(expression.getSentence1(), expression.getOperator(), expression.getSentence2(), expression.getNegated());
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
