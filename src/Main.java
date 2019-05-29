public class Main {

    public static void main(String[] args)
    {
        Expression ExpressionOne = new Expression(new Variable("A", false), Operator.OR, new Variable("B", false), false);
        Expression ExpressionTwo = new Expression(new Variable("A", false), Operator.OR, new Expression(new Variable("B", false), Operator.OR, new Variable("C", false), false), false);
        Expression ExpressionThree = new Expression(new Variable("A", true), Operator.IMPLICATION, new Variable("B", false), false);
        Expression ExpressionFour = new Expression(new Variable("A", false), Operator.AND, new Variable("B", false), true);
        Expression ExpressionFive = new Expression(new Variable("A", true), Operator.AND, new Variable("B", false), true);
        Expression ExpressionSix = new Expression(new Variable("A", false), Operator.AND, new Variable("B", true), true  );
        Expression ExpressionSeven = new Expression(new Variable("A", true), Operator.OR, new Variable("B", false), true);
        Expression ExpressionEight = new Expression(new Variable("A", false), Operator.OR, new Variable("B", true), true);
        Expression ExpressionNine = new Expression(new Variable("A", true), Operator.OR, new Variable("A", false), false);
        Expression ExpressionTen = new Expression(new Variable("A", false), Operator.IMPLICATION, new Variable("B", false), false);
        Variable ExpressionElleven = new Variable("A", false);
        Variable ExpressionTwelve = new Variable("A", true);



        BeliefBase beliefBase = new BeliefBase();
        beliefBase.addSentence(ExpressionOne);
        beliefBase.addSentence(ExpressionTwo);

       // System.out.println(beliefBase);
        System.out.println(ExpressionOne);
        System.out.println(ExpressionTwo);

        beliefBase.generateVariables(ExpressionOne);
        beliefBase.generateVariables(ExpressionTwo);
        beliefBase.FillVariablesList();
        beliefBase.generateExpressionTruthTable();
        System.out.println(beliefBase.getVariables());
        System.out.println(beliefBase.getVariableTruthTable());
        System.out.println(beliefBase.getExpressionTruthTable());
        System.out.println("Is the BeliefBase Consistent:  " + beliefBase.isConsistent());
    }
}
