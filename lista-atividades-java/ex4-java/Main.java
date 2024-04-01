import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();

        int op;

        do {
            System.out.println("[ 1 ] - Cadastrar Jogador");
            System.out.println("[ 2 ] - Exibir Jogadores Cadastrados");
            System.out.println("[ 3 ] - Entrar em uma Conta");
            System.out.println("[ 0 ] - Sair");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    cadastrarJogador(jogadores, leitor);
                    break;
                case 2:
                    exibirJogadoresCadastrados(jogadores);
                    break;
                case 3:
                    entrarEmConta(jogadores, leitor);
                    break;
            }
        } while (op != 0);
    }

    public static void cadastrarJogador(List<Jogador> jogadores, Scanner leitor) {
        System.out.println("Digite o nome do jogador:");
        String nome = leitor.next();
        System.out.println("Digite a pontuação inicial do jogador:");
        int pontuacaoInicial = leitor.nextInt();
        System.out.println("Digite o nível inicial do jogador:");
        int nivelInicial = leitor.nextInt();
        Jogador novoJogador = new Jogador(nome, pontuacaoInicial, nivelInicial);
        jogadores.add(novoJogador);
        System.out.println("Jogador cadastrado com sucesso!");
    }

    public static void exibirJogadoresCadastrados(List<Jogador> jogadores) {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            System.out.println("Jogadores cadastrados:");
            for (Jogador jogador : jogadores) {
                jogador.exibirInformacoes();
            }
        }
    }

    public static void entrarEmConta(List<Jogador> jogadores, Scanner leitor) {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
        } else {
            System.out.println("Digite o índice do jogador:");
            int indice = leitor.nextInt();
            if (indice >= 0 && indice < jogadores.size()) {
                Jogador jogadorSelecionado = jogadores.get(indice);
                System.out.println("Entrou na conta do jogador: " + jogadorSelecionado.getNome());
                int opcao;
                do {
                    System.out.println("[ 1 ] - Aumentar Pontuação");
                    System.out.println("[ 2 ] - Subir de Nível");
                    System.out.println("[ 0 ] - Sair da Conta");
                    opcao = leitor.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite a quantidade de pontos a serem adicionados:");
                            int pontos = leitor.nextInt();
                            jogadorSelecionado.aumentarPontuacao(pontos);
                            System.out.println("Pontuação aumentada com sucesso!");
                            break;
                        case 2:
                            jogadorSelecionado.subirNivel();
                            System.out.println("Nível aumentado com sucesso!");
                            break;
                        case 0:
                            System.out.println("Saindo da conta do jogador.");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                } while (opcao != 0);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
}
