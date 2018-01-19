package usa.edu.mum.asd.lectures.lec4.factorymethod;

import usa.edu.mum.asd.lectures.lec4.factorymethod.Product.*;

public class SimplePizzaFactory implements PizzaFactory {
    //This factory should often times be a Singleton
    private static PizzaFactory factory = new SimplePizzaFactory();

    private SimplePizzaFactory() {
    }

    public static PizzaFactory getFactory() {
        return factory;
    }

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
