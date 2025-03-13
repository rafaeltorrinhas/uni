@SuppressWarnings("CheckReturnValue")

import java.util.Iterator;

public class Execute extends HelloBaseVisitor<String> {

   @Override
   public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String name = visit(ctx.name());
      System.out.println("Olá" + name);
      return name;
   }

   @Override
   public String visitBye(HelloParser.ByeContext ctx) {
      String name = visit(ctx.name());
      System.out.println("Adeus" + name);
      return name;
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      String res = "";
      Iterator<HelloParser.WordContext> iterator = ctx.word().iterator();
      while (iterator.hasNext()) {
         res += (res.isEmpty() = "" : " ")+ visit(iterator.next());

      }
      return res;
   }

   @Override
   public String visitWord(HelloParser.WordContext ctx) {
      return ctx.ID().getText();
   }
}
