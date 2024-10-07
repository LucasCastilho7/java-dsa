import java.util.LinkedList;
import java.util.Queue;

class Pessoa {
    private String tipoSenha;
    private int numeroSenha;

    public Pessoa(String tipoSenha, int numeroSenha) {
        this.tipoSenha = tipoSenha;
        this.numeroSenha = numeroSenha;
    }

    public String getTipoSenha() {
        return tipoSenha;
    }

    public int getNumeroSenha() {
        return numeroSenha;
    }
}

class SistemaAtendimento {
    private Queue<Pessoa> filaPrioritaria = new LinkedList<>();
    private Queue<Pessoa> filaNormal = new LinkedList<>();
    private int contadorNormal = 0;

    public void distribuirSenha(String tipoSenha, int numeroSenha) {
        Pessoa pessoa = new Pessoa(tipoSenha, numeroSenha);
        if (tipoSenha.equals("prioritaria")) {
            filaPrioritaria.add(pessoa);
        } else {
            filaNormal.add(pessoa);
        }
    }

    public void iniciarAtendimento() {
        while (!filaPrioritaria.isEmpty() || !filaNormal.isEmpty()) {
            for (int i = 0; i < 3 && !filaPrioritaria.isEmpty(); i++) {
                Pessoa pessoa = filaPrioritaria.poll();
                System.out.println("Atendendo pessoa com senha " + pessoa.getTipoSenha() + " número " + pessoa.getNumeroSenha());
            }
            if (!filaNormal.isEmpty()) {
                Pessoa pessoa = filaNormal.poll();
                System.out.println("Atendendo pessoa com senha " + pessoa.getTipoSenha() + " número " + pessoa.getNumeroSenha());
            }
        }
    }
}

public class DistribuicaoSenhas {
    public static void main(String[] args) {
        SistemaAtendimento sistema = new SistemaAtendimento();
        sistema.distribuirSenha("prioritaria", 1);
        sistema.distribuirSenha("normal", 2);
        sistema.distribuirSenha("prioritaria", 3);
        sistema.distribuirSenha("normal", 4);
        sistema.distribuirSenha("prioritaria", 5);
        sistema.distribuirSenha("prioritaria", 6);
        sistema.distribuirSenha("normal", 7);
        sistema.iniciarAtendimento();
    }
}
