public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome, int pontuacaoInicial, int nivelInicial) {
        this.nome = nome;
        this.pontuacao = pontuacaoInicial;
        this.nivel = nivelInicial;
    }

    public String getNome() {
        return nome;
    }

    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
        }
    }

    public void subirNivel() {
        this.nivel++;
    }

    public void exibirInformacoes() {
        System.out.println("Nome do jogador: " + this.nome);
        System.out.println("Pontuação: " + this.pontuacao);
        System.out.println("Nível: " + this.nivel);
    }
}