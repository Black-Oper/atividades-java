import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int op;

        Pedido pedido = new Pedido();

        do {
            System.out.println("[ 1 ] - Novo Pedido");
            System.out.println("[ 2 ] - Consultar Pedido");
            System.out.println("[ 3 ] - Atualizar Pedido");
            System.out.println("[ 4 ] - Remover Pedido");
            System.out.println("[ 0 ] - Sair do Programa");

            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Adicione pizzas ao pedido. Digite '0' para finalizar.");

                    while (true) {
                        System.out.print("Nome da pizza: ");
                        String nome = leitor.nextLine();
                        if (nome.equals("0")) break;
                        System.out.print("Valor da pizza: ");
                        double valor = leitor.nextDouble();
                        leitor.nextLine();
                        System.out.print("Número de ingredientes: ");
                        int numIngredientes = leitor.nextInt();
                        leitor.nextLine();
                        String[] ingredientes = new String[numIngredientes];
                        System.out.println("Digite os ingredientes:");
                        for (int i = 0; i < numIngredientes; i++) {
                            ingredientes[i] = leitor.nextLine();
                        }
                        Pizza pizza = new Pizza(nome, valor, ingredientes);
                        pedido.adicionarPizza(pizza);
                    }
                    System.out.println("Pedido criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Consultando o pedido...");
                    List<Pizza> pizzas = pedido.getPizzas();
                    if (pizzas.isEmpty()) {
                        System.out.println("O pedido está vazio.");
                    } else {
                        System.out.println("Pizzas no pedido:");
                        for (Pizza pizza : pizzas) {
                            System.out.println("Nome: " + pizza.getNome() + ", Valor: " + pizza.getValor());
                        }
                        System.out.println("Total do pedido: " + pedido.getTotal());
                    }
                    break;
                case 3:
                    System.out.println("Atualizando o pedido... (não implementado)");
                    break;
                case 4:
                    System.out.println("Removendo o pedido...");
                    pedido.cancelarPedido();
                    System.out.println("Pedido removido com sucesso!");
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);

        leitor.close();
    }
}
