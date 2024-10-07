import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Person {
    private String prioridade;
    private int numero;

    public Person(String prioridade, int numero) {
        this.prioridade = prioridade;
        this.numero = numero;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public int getNumero() {
        return numero;
    }
}

interface FilaPrioridade {
    boolean atendePrioridade(String prioridade);
    void adicionarPessoa(Person person);
    Person obterProximaPessoa();
    boolean isEmpty();
}

class FilaVermelha implements FilaPrioridade {
    private Queue<Person> fila = new LinkedList<>();

    @Override
    public boolean atendePrioridade(String prioridade) {
        return "vermelha".equals(prioridade);
    }

    @Override
    public void adicionarPessoa(Person person) {
        fila.add(person);
    }

    @Override
    public Person obterProximaPessoa() {
        return fila.poll();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }
}

class FilaAmarela implements FilaPrioridade {
    private Queue<Person> fila = new LinkedList<>();

    @Override
    public boolean atendePrioridade(String prioridade) {
        return "amarela".equals(prioridade);
    }

    @Override
    public void adicionarPessoa(Person person) {
        fila.add(person);
    }

    @Override
    public Person obterProximaPessoa() {
        return fila.poll();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }
}

class FilaVerde implements FilaPrioridade {
    private Queue<Person> fila = new LinkedList<>();

    @Override
    public boolean atendePrioridade(String prioridade) {
        return "verde".equals(prioridade);
    }

    @Override
    public void adicionarPessoa(Person person) {
        fila.add(person);
    }

    @Override
    public Person obterProximaPessoa() {
        return fila.poll();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }
}

class ProntoSocorro {
    private FilaPrioridade[] filas;
    private int contadorPessoas = 0;

    public ProntoSocorro(FilaPrioridade[] filas) {
        this.filas = filas;
    }

    public void enfileirarPessoa(String prioridade) {
        Person person = new Person(prioridade, ++contadorPessoas);
        for (FilaPrioridade fila : filas) {
            if (fila.atendePrioridade(prioridade)) {
                fila.adicionarPessoa(person);
                break;
            }
        }
        System.out.println("Pessoa com prioridade " + prioridade + " e número " + person.getNumero() + " chegou.");
    }

    public void iniciarAtendimento() {
        while (haPessoasParaAtender()) {
            for (FilaPrioridade fila : filas) {
                if (!fila.isEmpty()) {
                    Person person = fila.obterProximaPessoa();
                    if (person != null) {
                        System.out.println("Atendendo pessoa com prioridade " + person.getPrioridade() + " e número " + person.getNumero());
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
        }
    }

    private boolean haPessoasParaAtender() {
        for (FilaPrioridade fila : filas) {
            if (!fila.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void adicionarPessoasAleatoriamente() {
        String[] prioridades = {"vermelha", "amarela", "verde"};
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String prioridadeAleatoria = prioridades[random.nextInt(prioridades.length)];
            enfileirarPessoa(prioridadeAleatoria);
        }
    }
}

public class SistemaProntoSocorro {
    public static void main(String[] args) {
        FilaPrioridade[] filas = {new FilaVermelha(), new FilaAmarela(), new FilaVerde()};
        ProntoSocorro prontoSocorro = new ProntoSocorro(filas);
        prontoSocorro.enfileirarPessoa("vermelha");
        prontoSocorro.enfileirarPessoa("amarela");
        prontoSocorro.enfileirarPessoa("verde");
        prontoSocorro.enfileirarPessoa("vermelha");
        prontoSocorro.enfileirarPessoa("amarela");
        prontoSocorro.enfileirarPessoa("verde");

        Thread atendimento = new Thread(prontoSocorro::iniciarAtendimento);
        Thread chegadaPessoas = new Thread(prontoSocorro::adicionarPessoasAleatoriamente);

        atendimento.start();
        chegadaPessoas.start();

        try {
            atendimento.join();
            chegadaPessoas.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
