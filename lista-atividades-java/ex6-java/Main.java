import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int op;

        do {
            System.out.println("[ 1 ] - Adicionar contato");
            System.out.println("[ 2 ] - Buscar contato");
            System.out.println("[ 3 ] - Remover contato");
            System.out.println("[ 0 ] - Sair");
            
            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1:
                        adicionarContato(scanner, agenda);
                        break;
                    case 2:
                        buscarContato(scanner, agenda);
                        break;
                    case 3:
                        removerContato(scanner, agenda);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                op = -1;
            }
        } while (op != 0);
        
        scanner.close();
    }

    public static void adicionarContato(Scanner scanner, Agenda agenda) {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone do contato:");
        String telefone = scanner.nextLine();

        if (!nome.isEmpty() && !telefone.isEmpty()) {
            Contato contato = new Contato(nome, telefone);
            agenda.adicionarContato(contato);
            System.out.println("Contato adicionado com sucesso!");
        } else {
            System.out.println("Nome ou telefone inválido. Contato não adicionado.");
        }
    }

    public static void buscarContato(Scanner scanner, Agenda agenda) {
        System.out.println("Digite o nome do contato que você deseja buscar:");
        String nome = scanner.nextLine().toLowerCase();

        List<Contato> contatosEncontrados = agenda.buscarContatoPorNome(nome);

        if (!contatosEncontrados.isEmpty()) {
            System.out.println("Contatos encontrados:");
            for (Contato contato : contatosEncontrados) {
                System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
            }
        } else {
            System.out.println("Nenhum contato encontrado com esse nome.");
        }
    }

    public static void removerContato(Scanner scanner, Agenda agenda) {
        System.out.println("Digite o nome do contato que você deseja remover:");
        String nome = scanner.nextLine();

        List<Contato> contatosEncontrados = agenda.buscarContatoPorNome(nome);

        if (!contatosEncontrados.isEmpty()) {
            agenda.removerContato(contatosEncontrados.get(0));
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado!");
        }
    }
}
