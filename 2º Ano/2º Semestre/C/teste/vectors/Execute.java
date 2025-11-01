import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends VectorLangBaseVisitor<Variable> {

   private final HashMap<String, Variable> variables = new HashMap<>();

   @Override
   public Variable visitProgram(VectorLangParser.ProgramContext ctx) {
      visitChildren(ctx);
      return null;
   }

   @Override
   public Variable visitStatShow(VectorLangParser.StatShowContext ctx) {
      Variable res = visit(ctx.expr());
      if (res != null) {
         System.out.println(res);
      }
      ;
      return null;
   }

   @Override
   public Variable visitStatAssign(VectorLangParser.StatAssignContext ctx) {
      Variable res = visit(ctx.expr());
      if (res != null) {
         variables.put(ctx.ID().getText(), res);
      }
      ;
      return null;
   }

   @Override
   public Variable visitExprVector(VectorLangParser.ExprVectorContext ctx) {
      Variable v = visit(ctx.vector());
      return v;
   }

   @Override
   public Variable visitExprMult(VectorLangParser.ExprMultContext ctx) {
      Variable v1 = visit(ctx.e1);
      Variable v2 = visit(ctx.e2);
      if (v1 == null)
         return null;
      if (v2 == null)
         return null;
      return v1.mult(v2);
   }

   @Override
   public Variable visitExprSum(VectorLangParser.ExprSumContext ctx) {
      Variable v1 = visit(ctx.e1);
      Variable v2 = visit(ctx.e2);
      Variable res;
      if (v1 == null)
         return null;
      if (v2 == null)
         return null;
      String op = ctx.OP.getText();
      if (op.equals("+")) {
         res = v1.sum(v2);
      } else if (op.equals("-")) {
         res = v1.sub(v2);
      } else {
         System.out.println("Wrong op");
         return null;
      }
      if (res != null)
         return res;

      return null;
   }

   @Override
   public Variable visitExprValue(VectorLangParser.ExprValueContext ctx) {
      Variable v1 = visit(ctx.expr());
      String signal = ctx.SIGNAL.getText();
      if (signal == "+") {
         return v1;
      }
      if (signal == "-") {
         return v1.minus();

      } else {
         return null;
      }

   }

   @Override
   public Variable visitExprIntern(VectorLangParser.ExprInternContext ctx) {
      Variable v1 = visit(ctx.e1);
      Variable v2 = visit(ctx.e2);

      return v1.product(v2);
   }

   @Override
   public Variable visitExprNumber(VectorLangParser.ExprNumberContext ctx) {
      return new Num(Double.parseDouble(ctx.NUMBER().getText()));

   }

   @Override
   public Variable visitExprParenthesis(VectorLangParser.ExprParenthesisContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Variable visitExprID(VectorLangParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if (!variables.containsKey(id)) {
         System.out.printf("Variable %s not declared.\n", id);
         return null;
      }
      return variables.get(id);
   }

   @Override
   public Variable visitVector(VectorLangParser.VectorContext ctx) {
      int size = ctx.NUMBER().size();
      double[] vector = new double[size];
      for (int i = 0; i < size; i++) {
         vector[i] = Double.parseDouble(ctx.NUMBER(i).getText());
      }
      return new Vector(vector);

   }
}
