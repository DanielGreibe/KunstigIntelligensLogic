public class Variable implements ISentence {
    String name;
    boolean negated;

    public Variable(String name, boolean negated) {
        this.name = name;
        this.negated = negated;
    }


    @Override
    public java.lang.String toString() {
        if (negated) {
            return "NOT " + name;
        } else {
            return name;
        }
    }

    @Override
    public ISentence convertToCNF() {
        return this;
    }

    @Override
    public ISentence Negate() {
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

    public String getName() {
        return name;
    }

    @Override
    public boolean getNegated() {
        return negated;
    }
}