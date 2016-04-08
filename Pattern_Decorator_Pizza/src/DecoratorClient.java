public class DecoratorClient
{

  public static void main( String args[] )
  {
    PlainPizza plainPizzaObj = new PlainPizza();
    String plainPizza = plainPizzaObj.makePizza();
    System.out.println(plainPizza);

    String nonvegPizza = new NonVegPizzaDecorator(plainPizzaObj).makePizza();
    System.out.println("\n'" + nonvegPizza + "' using NonVegPizzaDecorator");

    String vegPizza = new VegPizzaDecorator(plainPizzaObj).makePizza();
    System.out.println("\n'" + vegPizza + "' using VegPizzaDecorator");

  }

}