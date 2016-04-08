public class NonVegPizzaDecorator extends PizzaDecorator
{

  public NonVegPizzaDecorator( Pizza pizza )
  {
    super(pizza);
  }

  public String makePizza()
  {
    return pizza.makePizza() + addMushroomAndCheese();

  }

  private String addMushroomAndCheese()
  {
    return ",Mushroom and Cheese added";
  }
}