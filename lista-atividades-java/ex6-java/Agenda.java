import java.util.*;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> buscarContatoPorNome(String nome) {
        List<Contato> contatosEncontrados = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatosEncontrados.add(contato);
            }
        }
        return contatosEncontrados;
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }
}
