public interface ISentence
{
    String toString();

    ISentence convertToCNF();

    ISentence Negate();

    boolean getNegated();

}
