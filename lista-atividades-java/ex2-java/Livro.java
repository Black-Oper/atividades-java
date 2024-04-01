public class Livro {
    private String titulo;
    private String autor;
    private int ano_publicacao;

    public Livro(String titulo, String autor, int ano_publicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + ano_publicacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return ano_publicacao;
    }

    public void setAnoPublicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }
}
