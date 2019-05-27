public class Variable implements ISentence
{
    String variable;

    public Variable (String variable)
    {
        this.variable = variable;
    }


    @Override
    public java.lang.String toString() {
        return variable;
    }
}
