import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Carro> carros = new ArrayList<>();

        int op;

        do {
            System.out.println("[ 1 ] - Cadastrar Carro");
            System.out.println("[ 2 ] - Exibir Carros Cadastrados");
            System.out.println("[ 3 ] - Acelerar Carro");
            System.out.println("[ 4 ] - Frear Carro");
            System.out.println("[ 0 ] - Sair");
            System.out.println();
            System.out.print("Opcao: ");
            op = leitor.nextInt();
            leitor.nextLine();
            switch (op) {
                case 1:
                    cadastrarCarro(carros, leitor);
                    break;
                case 2:
                    exibirCarrosCadastrados(carros);
                    break;
                case 3:
                    acelerarCarro(carros, leitor);
                    break;
                case 4:
                    frearCarro(carros, leitor);
                    break;
            }
        } while (op != 0);
    }

    public static void cadastrarCarro(List<Carro> carros, Scanner leitor) {
        System.out.println("Digite a marca do carro:");
        String marca = leitor.nextLine();
        System.out.println("Digite o modelo do carro:");
        String modelo = leitor.nextLine();
        System.out.println("Digite o ano do carro:");
        int ano = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Digite a placa do carro:");
        String placa = leitor.nextLine();
        System.out.println("Digite a velocidade atual do carro:");
        int velocidadeAtual = leitor.nextInt();
        Carro novoCarro = new Carro(marca, modelo, ano, placa, velocidadeAtual);
        carros.add(novoCarro);
        System.out.println("Carro cadastrado com sucesso!");
    }

    public static void exibirCarrosCadastrados(List<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("Carros cadastrados:");
            for (int i = 0; i < carros.size(); i++) {
                System.out.println("Carro " + (i + 1) + ":");
                carros.get(i).exibirInformacoes();
            }
        }
    }

    public static void acelerarCarro(List<Carro> carros, Scanner leitor) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("Digite o índice do carro:");
            int indice = leitor.nextInt();
            if (indice >= 0 && indice < carros.size()) {
                Carro carroSelecionado = carros.get(indice);
                System.out.println("Digite a quantidade de velocidade a ser adicionada:");
                int velocidade = leitor.nextInt();
                carroSelecionado.acelerar(velocidade);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public static void frearCarro(List<Carro> carros, Scanner leitor) {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("Digite o índice do carro:");
            int indice = leitor.nextInt();
            if (indice >= 0 && indice < carros.size()) {
                Carro carroSelecionado = carros.get(indice);
                System.out.println("Digite a quantidade de velocidade a ser reduzida:");
                int velocidade = leitor.nextInt();
                carroSelecionado.frear(velocidade);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
}
