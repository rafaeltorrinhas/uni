public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override
   public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      // Each line (statement) contains an expression.
      Double res = visit(ctx.expr());
      System.out.println(res);
      return res;
   }

   @Override
   public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {

      return Double.valueOf(ctx.Number().getText());

   }

   @Override
   public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {

      Double left = visit(ctx.expr(0));
      Double right = visit(ctx.expr(1));
      String op = ctx.op.getText();

      switch (op) {
         case "+":
            return left + right;
         case "-":
            return left - right;
         case "*":
            return left * right;
         case "/":
            return left / right;
         default:
            throw new RuntimeException("Operação desconhecida: " + op);
      }
   }
}
