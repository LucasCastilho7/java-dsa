import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RedeSocial {

    private final Map<String, LinkedList<String>> grafo;

    public RedeSocial() {
        this.grafo = new HashMap<>();
    }

    public void criarConta(String nome) {
        grafo.putIfAbsent(nome, new LinkedList<>());
        System.out.println("Conta criada para: " + nome);
    }

    public void removerConta(String nome) {
        if (grafo.containsKey(nome)) {
            grafo.remove(nome);
            for (LinkedList<String> amigos : grafo.values()) {
                amigos.remove(nome);
            }
            System.out.println("Conta removida: " + nome);
        } else {
            System.out.println("Conta não encontrada: " + nome);
        }
    }

    public void seguir(String seguidor, String seguido) {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            grafo.get(seguidor).add(seguido);
            System.out.println(seguidor + " agora segue " + seguido);
        } else {
            System.out.println("Usuário(s) não encontrado(s).");
        }
    }

    public void deixarDeSeguir(String seguidor, String seguido) {
        if (grafo.containsKey(seguidor) && grafo.get(seguidor).remove(seguido)) {
            System.out.println(seguidor + " deixou de seguir " + seguido);
        } else {
            System.out.println(seguidor + " não segue " + seguido);
        }
    }

    public void imprimirGrafo() {
        System.out.println("\nGrafo da Rede Social:");
        for (Map.Entry<String, LinkedList<String>> entry : grafo.entrySet()) {
            System.out.println(entry.getKey() + " segue: " + entry.getValue());
        }
    }

    public LinkedList<String> procurarAmigos(String nome) {
        return grafo.getOrDefault(nome, new LinkedList<String>());
    }

    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();

        redeSocial.criarConta("Alice");
        redeSocial.criarConta("Bob");
        redeSocial.criarConta("Carol");
        redeSocial.criarConta("David");

        redeSocial.seguir("Alice", "Bob");
        redeSocial.seguir("Alice", "Carol");
        redeSocial.seguir("Bob", "Alice");
        redeSocial.seguir("Bob", "David");
        redeSocial.seguir("Carol", "Alice");
        redeSocial.seguir("Carol", "David");
        redeSocial.seguir("David", "Carol");

        redeSocial.imprimirGrafo();

        redeSocial.removerConta("Bob");

        redeSocial.imprimirGrafo();

        redeSocial.deixarDeSeguir("Alice", "Carol");

        redeSocial.imprimirGrafo();
    }
}
