public class Variable implements ISentence
{
    String variable;
    boolean negated;

    public Variable (String variable, boolean negated)
    {
        this.variable = variable;
        this.negated = negated;
    }


    @Override
    public java.lang.String toString() {
        if (negated)
        {
            return "NOT " + variable;
        }
        else
        {
            return variable;
        }
    }
}
