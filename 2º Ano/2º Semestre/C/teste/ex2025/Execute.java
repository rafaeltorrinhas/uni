
import java.util.*;

@SuppressWarnings("CheckReturnValue")
public class Execute extends TupleNumBaseVisitor<Tuple> {

   HashMap<String, Tuple> variables = new HashMap<>();

   @Override
   public Tuple visitProgram(TupleNumParser.ProgramContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitLine(TupleNumParser.LineContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitPrintStat(TupleNumParser.PrintStatContext ctx) {
      ArrayList<Tuple> tuples = visit(ctx.expr());
      int objAmount = tuples.size();
      if (objAmount > 1) {
         for (int i = 0; i < objAmount; i++) {
            System.out.print(tuples.get(i));
         }
      }
      Tuple tup = visit(ctx.expr());
      System.out.println(tup);
      return null;
   }

   @Override
   public Tuple visitAssignStat(TupleNumParser.AssignStatContext ctx) {
      Tuple res = visit(ctx.expr());
      if (res != null) {
         variables.put(ctx.ID().getText(), res);
      }
      return null;
      // return res;
   }

   @Override
   public Tuple visitExprRead(TupleNumParser.ExprReadContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprTuple(TupleNumParser.ExprTupleContext ctx) {
      int size = ctx.NUMBER().size();
      ArrayList<Double> numbers = new ArrayList<>();

      for (int i = 0; i < size; i++) {
         numbers.add(Double.parseDouble(ctx.NUMBER(i).getText()));
      }

      return new Tuple(numbers);
   }

   @Override
   public Tuple visitExprComma(TupleNumParser.ExprCommaContext ctx) {
      ArrayList<Tuple> tuples = new ArrayList<>();
      for (TupleNumParser.ExprContext exprCtx : ctx.expr()) {
          ArrayList<Tuple> newtuples = visit(exprCtx);
          for (Double d: newtuples.)
         tuples.add(visit(exprCtx));
      }
      
      return new Tuple(tuples);
   }


   @Override
   public Tuple visitExprOperation(TupleNumParser.ExprOperationContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprSlice(TupleNumParser.ExprSliceContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprEmpty(TupleNumParser.ExprEmptyContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprUnary(TupleNumParser.ExprUnaryContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprNumber(TupleNumParser.ExprNumberContext ctx) {
      return new Tuple(Double.parseDouble(ctx.NUMBER().getText()));
      // return res;
   }

   @Override
   public Tuple visitExprParenthesis(TupleNumParser.ExprParenthesisContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Tuple visitExprSignal(TupleNumParser.ExprSignalContext ctx) {
      Tuple res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Tuple visitExprID(TupleNumParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if (!variables.containsKey(id)) {
         System.out.println("Variable not declared");
         return null;
      }
      return variables.get(id);
      // return res;
   }
}
