public class Main {

    public static void main(String[] args)
    {
        ISentence sentence1 = new Expression(new Expression(new Variable("A", false), Operator.OR, new Variable("B", false), false), Operator.AND, new Variable("C", false), true);

        ISentence sentence2 = new Expression(new Variable("C", false), Operator.OR, new Variable("D", false), true);

        ISentence sentence3 = new Expression(new Variable("E", false), Operator.IMPLICATION, new Variable("F", true), false);

        ISentence sentence4 = new Expression(new Variable("G", true), Operator.DOUBLEIMPLICATION, new Variable("H", false), true);

        System.out.println(sentence1);

        System.out.println(sentence2);

        System.out.println(sentence3);

        System.out.println(sentence4);

    }
}
