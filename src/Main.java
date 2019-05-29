public class Main {

    public static void main(String[] args)
    {
        Expression ExpressionOne = new Expression(new Variable("A", false), Operator.OR, new Variable("B", false), false);
        Expression ExpressionTwo = new Expression(new Variable("A", false), Operator.OR, new Expression(new Variable("B", false), Operator.OR, new Variable("C", false), false), false);
        Expression ExpressionThree = new Expression(new Variable("A", true), Operator.DOUBLEIMPLICATION, new Variable("B", false), false);
        Expression ExpressionFour = new Expression(new Variable("A", false), Operator.AND, new Variable("B", false), true);
        Expression ExpressionFive = new Expression(new Variable("A", true), Operator.AND, new Variable("B", false), true);
        Expression ExpressionSix = new Expression(new Variable("A", false), Operator.AND, new Variable("B", true), true  );
        Expression ExpressionSeven = new Expression(new Variable("A", true), Operator.OR, new Variable("B", false), true);
        Expression ExpressionEight = new Expression(new Variable("A", false), Operator.OR, new Variable("B", true), true);
        Expression ExpressionNine = new Expression(new Variable("A", true), Operator.OR, new Variable("A", false), false);
        Expression ExpressionTen = new Expression(new Variable("A", false), Operator.IMPLICATION, new Variable("B", false), false);
        Variable ExpressionElleven = new Variable("A", false);


        /*System.out.println("Expression One:  " + ExpressionOne);
        ExpressionOne = ExpressionOne.convertToCNF();
        System.out.println("Expression One Converted: " + ExpressionOne);
        System.out.println();
        System.out.println();

        System.out.println("Expression Two:  " + ExpressionTwo);
        ExpressionTwo = ExpressionTwo.convertToCNF();
        System.out.println("Expression Two Converted: " + ExpressionTwo);
        System.out.println();
        System.out.println();

        System.out.println("Expression Three:  " + ExpressionThree);
        ExpressionThree = ExpressionThree.convertToCNF();
        System.out.println("Expression Three Converted: " + ExpressionThree);
        System.out.println();
        System.out.println();

        System.out.println("Expression Four:  " + ExpressionFour);
        ExpressionFour = ExpressionFour.convertToCNF();
        System.out.println("Expression Four Converted: " + ExpressionFour);
        System.out.println();
        System.out.println();

        System.out.println("Expression Five:  " + ExpressionFive);
        ExpressionFive = ExpressionFive.convertToCNF();
        System.out.println("Expression Five Converted: " + ExpressionFive);
        System.out.println();
        System.out.println();

        System.out.println("Expression Six:  " + ExpressionSix);
        ExpressionSix = ExpressionSix.convertToCNF();
        System.out.println("Expression Six Converted: " + ExpressionSix);
        System.out.println();
        System.out.println();

        System.out.println("Expression Seven:  " + ExpressionSeven);
        ExpressionSeven = ExpressionSeven.convertToCNF();
        System.out.println("Expression Seven Converted: " + ExpressionSeven);
        System.out.println();
        System.out.println();

        System.out.println("Expression Eight:  " + ExpressionEight);
        ExpressionEight = ExpressionEight.convertToCNF();
        System.out.println("Expression Eight Converted: " + ExpressionEight);
        System.out.println();
        System.out.println();

        System.out.println("Expression Nine:  " + ExpressionNine);
        ExpressionNine = ExpressionNine.convertToCNF();
        System.out.println("Expression Nine Converted: " + ExpressionNine);
        System.out.println();
        System.out.println();

        System.out.println("Expression Ten:  " + ExpressionTen);
        ExpressionTen = ExpressionTen.convertToCNF();
        System.out.println("Expression Ten Converted: " + ExpressionTen);
        System.out.println();
        System.out.println();*/

        BeliefBase beliefBase = new BeliefBase();
       /* beliefBase.addSentence(ExpressionOne);
        beliefBase.addSentence(ExpressionTwo);
        beliefBase.addSentence(ExpressionThree);
        beliefBase.addSentence(ExpressionFour);
        beliefBase.addSentence(ExpressionFive);
        beliefBase.addSentence(ExpressionSix);
        beliefBase.addSentence(ExpressionSeven);
        beliefBase.addSentence(ExpressionEight);
        beliefBase.addSentence(ExpressionNine);
        beliefBase.addSentence(ExpressionTen);
        beliefBase.addSentence(ExpressionElleven);*/

       beliefBase.addSentence(ExpressionTwo);

       // System.out.println(beliefBase);
        System.out.println(ExpressionTwo);
        beliefBase.generateVariables(ExpressionTwo);
        beliefBase.FillVariablesList();
        beliefBase.generateExpressionTruthTable();
        System.out.println(beliefBase.getVariables());
        System.out.println(beliefBase.getVariableTruthTable());
        System.out.println(beliefBase.getExpressionTruthTable());

    }
}
