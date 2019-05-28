public class Main {

    public static void main(String[] args)
    {
        /*
        ISentence sentence1 = new Expression(new Expression(new Variable("A", false), Operator.OR, new Variable("B", false), false), Operator.AND, new Variable("C", false), true);

        ISentence sentence2 = new Expression(new Variable("C", false), Operator.OR, new Variable("D", false), true);

        ISentence sentence3 = new Expression(new Variable("E", false), Operator.IMPLICATION, new Variable("F", true), false);

        ISentence sentence4 = new Expression(new Variable("G", true), Operator.DOUBLEIMPLICATION, new Variable("H", false), true);

        System.out.println("Printint out sentence 1");
        System.out.println(sentence1);

        System.out.println("Printint out sentence 2");
        System.out.println(sentence2);

        System.out.println("Printint out sentence 3");
        System.out.println(sentence3);

        System.out.println("Printint out sentence 4");
        System.out.println(sentence4);


        BeliefBase beliefBase = new BeliefBase();
        beliefBase.addSentence(sentence1);
        beliefBase.addSentence(sentence2);
        beliefBase.addSentence(sentence3);
        beliefBase.addSentence(sentence4);

        System.out.println("Printint out the belief base consisting of sentence 1 to 4");
        System.out.println(beliefBase);


        beliefBase.removeSentence(0);

        beliefBase.removeSentence(sentence1);


        System.out.println(beliefBase);
        */

        BeliefBase beliefBase = new BeliefBase();
        ISentence TestSentence = new Expression(new Variable("A", false), Operator.IMPLICATION, new Variable("B", false),false);

       System.out.println(TestSentence);
       TestSentence.convertToCNF();
       //System.out.println();
        System.out.println(TestSentence);
    }
}
