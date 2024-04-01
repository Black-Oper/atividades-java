public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa, int velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = velocidadeAtual;
    }

    public void acelerar(int velocidade) {
        if (velocidade > 0) {
            this.velocidadeAtual += velocidade;
            System.out.println("Carro acelerado. Nova velocidade: " + this.velocidadeAtual);
        }
    }

    public void frear(int velocidade) {
        if (velocidade > 0 && velocidade <= this.velocidadeAtual) {
            this.velocidadeAtual -= velocidade;
            System.out.println("Carro freiado. Nova velocidade: " + this.velocidadeAtual);
        } else {
            System.out.println("A velocidade de frenagem não é válida.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("Placa: " + this.placa);
        System.out.println("Velocidade Atual: " + this.velocidadeAtual);
    }
}
