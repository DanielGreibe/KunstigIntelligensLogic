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
        //ConvertBiimplication
        ConvertImplication(this);
        ConvertNotExpression();
        sentence1.convertToCNF();
        sentence2.convertToCNF();

        return this;

    }

    private Expression ConvertBiimplication (Expression expression)
    {
        if (operator == Operator.DOUBLEIMPLICATION)
        {
            //Change Sentence1 and Sentence2 so that
            //Sentence 1 = Sentence1 AND Sentence2
            //Sentence 2 = Sentence2 AND Sentence1

            //We faced the problem that the left hand side in Sentence1 and right hand side in Sentence 2 is the same reference
            //So when we changed either side, it changed both and not just the one of them.
        }
        return expression;
    }

    private Expression ConvertImplication (Expression expression)
    {
        if(operator == Operator.IMPLICATION)
        {
            sentence1.Negate();
            operator = Operator.OR;
        }
        return this;
    }

    private Expression ConvertNotExpression (){
        if(negated){
            Negate();
            sentence1.Negate();
            sentence2.Negate();

            if(operator == Operator.OR){
                this.operator = Operator.AND;
            } else{
                this.operator = Operator.OR;
            }
        }
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

    public ISentence getSentence2() {
        return sentence2;
    }

    public ISentence getSentence1() {
        return sentence1;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public boolean getNegated() {
        return negated;
    }
}
