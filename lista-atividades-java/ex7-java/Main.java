import java.util.*;

public class Main {
    static Scanner leitor = new Scanner(System.in);
    static ArrayList<Produto> estoque = new ArrayList<>();

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("[ 1 ] - Adicionar produto");
            System.out.println("[ 2 ] - Atualizar produto");
            System.out.println("[ 3 ] - Remover produto");
            System.out.println("[ 4 ] - Visualizar relatório de estoque");
            System.out.println("[ 0 ] - Sair");

            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    visualizarRelatorio();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (op != 0);
    }

    private static void adicionarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = leitor.nextLine();

        System.out.println("Digite o código do produto:");
        int codigo = leitor.nextInt();

        System.out.println("Digite o preço do produto:");
        double preco = leitor.nextDouble();

        System.out.println("Digite a quantidade em estoque:");
        int quantidade = leitor.nextInt();
        leitor.nextLine();

        Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
        estoque.add(novoProduto);

        System.out.println("Produto adicionado com sucesso.");
    }

    private static void atualizarProduto() {
        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigo = leitor.nextInt();
        boolean encontrado = false;

        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                System.out.println("Digite a nova quantidade em estoque:");
                int novaQuantidade = leitor.nextInt();

                produto.setQuantidade(novaQuantidade);
                encontrado = true;
                
                System.out.println("Produto atualizado com sucesso.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void removerProduto() {
        System.out.println("Digite o código do produto que deseja remover:");
        int codigo = leitor.nextInt();
        boolean removido = false;

        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                estoque.remove(produto);
                removido = true;
                System.out.println("Produto removido com sucesso.");
                break;
            }
        }

        if (!removido) {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void visualizarRelatorio() {
        System.out.println("Relatório de Estoque:");
        for (Produto produto : estoque) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Quantidade em Estoque: " + produto.getQuantidade());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("--------------------------------");
        }
    }
}
