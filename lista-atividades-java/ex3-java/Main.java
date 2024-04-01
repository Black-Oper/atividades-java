import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<ContaBancaria> listaContas = new ArrayList<>();
        int op;

        do {
            System.out.println("#############################");
            System.out.println();
            System.out.println("[ 1 ] - Cadastrar Cliente");
            System.out.println("[ 2 ] - Entrar em uma Conta");
            System.out.println("[ 3 ] - Listar Contas");
            System.out.println("[ 0 ] - Encerrar Programa");
            System.out.println();
            System.out.println("#############################");
            System.out.print("Opcao: ");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    cadastrarCliente(listaContas, leitor);
                    break;
                case 2:
                    entrarEmUmaConta(leitor, listaContas);
                    break;
                case 3:
                    listarContas(listaContas);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
        } while (true);
    }

    public static void cadastrarCliente(List<ContaBancaria> listaContas, Scanner leitor) {
        System.out.print("Numero da Conta: ");
        int numeroConta = leitor.nextInt();
        System.out.print("Nome do Titular: ");
        leitor.nextLine(); 
        String nomeTitular = leitor.nextLine();

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular);
        listaContas.add(conta);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public static void entrarEmUmaConta(Scanner leitor, List<ContaBancaria> listaContas) {
        System.out.print("Numero da Conta: ");
        int numeroConta = leitor.nextInt();
        ContaBancaria conta = encontrarConta(numeroConta, listaContas);

        if (conta != null) {
            int op;
            do {
                System.out.println("#################################");
                System.out.println();
                System.out.println("[ 1 ] - Consultar Saldo");
                System.out.println("[ 2 ] - Realizar Deposito");
                System.out.println("[ 3 ] - Realizar Saque");
                System.out.println("[ 0 ] - Voltar ao Menu Principal");
                System.out.println();
                System.out.println("#################################");
                System.out.print("Opção: ");
                op = leitor.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Saldo atual: R$" + conta.getSaldo());
                        break;
                    case 2:
                        System.out.print("Valor do Deposito: ");
                        double valorDeposito = leitor.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 3:
                        System.out.print("Valor do Saque: ");
                        double valorSaque = leitor.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 0:
                        System.out.println("Retornando ao Menu Principal...");
                        return;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        break;
                }
            } while (true);
        } else {
            System.out.println("Conta nao encontrada.");
        }
    }

    public static void listarContas(List<ContaBancaria> listaContas) {
        if (listaContas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Lista de Contas:");
            for (ContaBancaria conta : listaContas) {
                System.out.println("Número: " + conta.getNumeroConta() + " | Titular: " + conta.getNomeTitular());
            }
        }
    }

    public static ContaBancaria encontrarConta(int numeroConta, List<ContaBancaria> listaContas) {
        for (ContaBancaria conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}