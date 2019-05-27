public class Main {

    public static void main(String[] args)
    {
        ISentence sentence1 = new Expression(new Variable("A"), Operator.AND, new Variable("B"));

        ISentence sentence2 = new Expression(new Variable("C"), Operator.OR, new Variable("D"));

        ISentence sentence3 = new Expression(new Variable("E"), Operator.IMPLICATION, new Variable("F"));

        ISentence sentence4 = new Expression(new Variable("G"), Operator.DOUBLEIMPLICATION, new Variable("G"));

        System.out.println(sentence1);

        System.out.println(sentence2);

        System.out.println(sentence3);

        System.out.println(sentence4);

    }
}
