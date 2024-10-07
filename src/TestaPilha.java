import java.lang.*;
import java.util.Stack;

public class TestaPilha {

    private Stack<String> pilha;

    public TestaPilha() {
        pilha = new Stack<>();
    }

    public void empilhar(String elemento) {
        pilha.push(elemento);
        System.out.println("Elemento '" + elemento + "' empilhado.");
    }

    public int tamanhoPilha() {
        return pilha.size();
    }

    public String topoPilha() {
        if (pilha.isEmpty())
            return "A pilha está vazia!";

        return pilha.peek();
    }

    public String desempilhar() {
        if (pilha.isEmpty())
            return "A pilha está vazia!";

        return pilha.pop();
    }

    public boolean elementoExiste(String elemento) {
        return pilha.contains(elemento);
    }

    public void imprimirPilha() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }

        System.out.println("Elementos da pilha (do topo para a base):");

        for (String elem : pilha) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        TestaPilha pilhaTeste = new TestaPilha();

        // Empilhando elementos
        pilhaTeste.empilhar("Elemento 1");
        pilhaTeste.empilhar("Elemento 2");
        pilhaTeste.empilhar("Elemento 3");

        System.out.println("Tamanho da pilha: " + pilhaTeste.tamanhoPilha());

        System.out.println("Topo da pilha: " + pilhaTeste.topoPilha());

        System.out.println("Elemento 2 existe na pilha? " + pilhaTeste.elementoExiste("Elemento 2"));

        System.out.println("Desempilhando elemento: " + pilhaTeste.desempilhar());
        System.out.println("Desempilhando elemento: " + pilhaTeste.desempilhar());

        pilhaTeste.imprimirPilha();

        System.out.println("Desempilhando elemento: " + pilhaTeste.desempilhar());
    }
}