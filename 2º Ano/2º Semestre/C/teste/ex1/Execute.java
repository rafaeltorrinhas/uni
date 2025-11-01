import java.util.*;

@SuppressWarnings("CheckReturnValue")
public class Execute extends StrLangBaseVisitor<String> {

   private final HashMap<String, String> variables = new HashMap<>();
   private final Scanner sc = new Scanner(System.in);

   @Override
   public String visitProgram(StrLangParser.ProgramContext ctx) {
      for (StrLangParser.LineContext line : ctx.line()) {
         visit(line);
      }

      return "";
   }

   @Override
   public String visitLine(StrLangParser.LineContext ctx) {
      if (ctx.stat() != null) {
         visit(ctx.stat());
      }
      return "";
   }

   @Override
   public String visitAssignStat(StrLangParser.AssignStatContext ctx) {
      String var = ctx.ID().getText();
      String value = visit(ctx.expr());
      variables.put(var, value);

      return "";
   }

   @Override
   public String visitPrintStat(StrLangParser.PrintStatContext ctx) {
      System.out.println(visit(ctx.expr()));
      return "";
   }

   @Override
   public String visitExprId(StrLangParser.ExprIdContext ctx) {
      String var = ctx.ID().getText();
      if (!variables.containsKey(var)) {

         System.out.println("Variable not declared");
         System.exit(1);
      }
      return variables.get(var);
   }

   @Override
   public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String value = ctx.STRING().getText();

      return value.substring(1, value.length() - 1);
   }

   @Override
   public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      System.out.print(visit(ctx.expr()));
      return sc.nextLine();
   }

   @Override
   public String visitExprSum(StrLangParser.ExprSumContext ctx) {
      String e1 = visit(ctx.e1);
      String e2 = visit(ctx.e2);
      return e1 + e2;
   }

   @Override
   public String visitExprSubtract(StrLangParser.ExprSubtractContext ctx) {
      String e1 = visit(ctx.e1);
      String e2 = visit(ctx.e2);
      return e1.replace(e2, "");

   }

   @Override
   public String visitExprSubstitute(StrLangParser.ExprSubstituteContext ctx) {
      String e1 = visit(ctx.e1);
      String e2 = visit(ctx.e2);
      String e3 = visit(ctx.e3);
      return e1.replace(e2, e3);
   }

   @Override
   public String visitExprParenthesis(StrLangParser.ExprParenthesisContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      return visit(ctx.expr()).trim();
   }
}
