public interface ISentence
{
    public String toString();

    public ISentence convertToCNF();

    public ISentence Negate();
}
