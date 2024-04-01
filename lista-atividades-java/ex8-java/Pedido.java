import java.util.*;

public class Pedido {
    private List<Pizza> pizzas;
    private double total;

    public Pedido() {
        this.pizzas = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        total += pizza.getValor();
    }

    public void cancelarPedido() {
        pizzas.clear();
        total = 0.0;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getTotal() {
        return total;
    }
}
