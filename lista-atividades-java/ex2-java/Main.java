import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Livro> listaLivros = new ArrayList<>();
        int op;

        do {
            System.out.println("1 - Cadastrar um livro");
            System.out.println("0 - Sair");
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = leitor.nextLine();

                    System.out.println("Digite o nome do autor:");
                    String autor = leitor.nextLine();

                    System.out.println("Digite o ano de publicação:");
                    int ano_publicacao = leitor.nextInt();
                    leitor.nextLine();

                    Livro livro = new Livro(titulo, autor, ano_publicacao);
                    listaLivros.add(livro);

                    System.out.println("Livro cadastrado com sucesso!\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (op != 0);

        System.out.println("Lista de livros cadastrados:");
        for (Livro livro : listaLivros) {
            livro.exibirInfo();
            System.out.println();
        }
    }
}

