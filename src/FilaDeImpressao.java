import java.util.LinkedList;
import java.util.Queue;

class Documento {
    private String nome;
    private int quantidadeFolhas;

    public Documento(String nome, int quantidadeFolhas) {
        this.nome = nome;
        this.quantidadeFolhas = quantidadeFolhas;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeFolhas() {
        return quantidadeFolhas;
    }
}

class Impressora {
    private Queue<Documento> filaDeImpressao = new LinkedList<>();

    public void enfileirarDocumento(Documento doc) {
        filaDeImpressao.add(doc);
        System.out.println("Documento '" + doc.getNome() + "' enfileirado com " + doc.getQuantidadeFolhas() + " folhas.");
    }

    public void iniciarImpressao() {
        while (!filaDeImpressao.isEmpty()) {
            Documento doc = filaDeImpressao.poll();
            Thread threadImpressao = new Thread(() -> imprimirDocumento(doc));
            threadImpressao.start();
            try {
                threadImpressao.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos os documentos foram impressos.");
    }

    private void imprimirDocumento(Documento doc) {
        System.out.println("Imprimindo documento: " + doc.getNome());
        try {
            Thread.sleep(doc.getQuantidadeFolhas() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Documento '" + doc.getNome() + "' impresso.");
    }
}

public class FilaDeImpressao {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();
        impressora.enfileirarDocumento(new Documento("Documento1", 5));
        impressora.enfileirarDocumento(new Documento("Documento2", 10));
        impressora.enfileirarDocumento(new Documento("Documento3", 3));
        impressora.iniciarImpressao();
    }
}