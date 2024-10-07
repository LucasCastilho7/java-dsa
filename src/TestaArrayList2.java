import java.util.ArrayList;
import java.util.Scanner;

public class TestaArrayList2 {
    private ArrayList<Contato> listaContatos;
    private final Scanner scanner;

    public TestaArrayList2() {
        listaContatos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Verificar quantidade de contatos");
            System.out.println("3. Imprimir contatos");
            System.out.println("4. Obter contato de uma posição específica");
            System.out.println("5. Verificar se existe o contato");
            System.out.println("6. Adicionar contato em qualquer posição");
            System.out.println("7. Duplicar tamanho do vetor");
            System.out.println("8. Remover contato");
            System.out.println("9. Pesquisar por nome");
            System.out.println("10. Pesquisar por e-mail");
            System.out.println("11. Pesquisar por telefone");
            System.out.println("12. Ordenar por nome");
            System.out.println("13. Ordenar por e-mail");
            System.out.println("14. Ordenar por telefone");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    verificarQuantidade();
                    break;
                case 3:
                    imprimirContatos();
                    break;
                case 4:
                    obterContatoPorPosicao();
                    break;
                case 5:
                    verificarContato();
                    break;
                case 6:
                    adicionarContatoEmPosicao();
                    break;
                case 7:
                    duplicarTamanhoVetor();
                    break;
                case 8:
                    removerContato();
                    break;
                case 9:
                    pesquisarPorNome();
                    break;
                case 10:
                    pesquisarPorEmail();
                    break;
                case 11:
                    pesquisarPorTelefone();
                    break;
                case 12:
                    ordenarPorNome();
                    break;
                case 13:
                    ordenarPorEmail();
                    break;
                case 14:
                    ordenarPorTelefone();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarContato() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();
        listaContatos.add(new Contato(nome, telefone, email));
        System.out.println("Contato adicionado!");
    }

    private void verificarQuantidade() {
        System.out.println("Quantidade de contatos: " + listaContatos.size());
    }

    private void imprimirContatos() {
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato na lista.");
        } else {
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        }
    }

    private void obterContatoPorPosicao() {
        System.out.print("Digite a posição do contato (0 a " + (listaContatos.size() - 1) + "): ");
        int posicao = scanner.nextInt();
        if (posicao >= 0 && posicao < listaContatos.size()) {
            System.out.println("Contato na posição " + posicao + ": " + listaContatos.get(posicao));
        } else {
            System.out.println("Posição inválida.");
        }
    }

    private void verificarContato() {
        System.out.print("Digite o nome, e-mail ou telefone do contato: ");
        String valor = scanner.nextLine();
        Contato contato = new Contato(valor, valor, valor);
        if (listaContatos.contains(contato)) {
            System.out.println("Contato encontrado!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void adicionarContatoEmPosicao() {
        System.out.print("Digite a posição (0 a " + listaContatos.size() + "): ");
        int posicao = scanner.nextInt();
        scanner.nextLine();
        if (posicao >= 0 && posicao <= listaContatos.size()) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Digite o e-mail: ");
            String email = scanner.nextLine();
            listaContatos.add(posicao, new Contato(nome, telefone, email));
            System.out.println("Contato adicionado na posição " + posicao);
        } else {
            System.out.println("Posição inválida.");
        }
    }

    private void duplicarTamanhoVetor() {
        ArrayList<Contato> novaLista = new ArrayList<>(listaContatos.size() * 2);
        novaLista.addAll(listaContatos);
        listaContatos = novaLista;
        System.out.println("Tamanho da lista duplicado.");
    }

    private void removerContato() {
        System.out.print("Digite o nome, e-mail ou telefone do contato para remover: ");
        String valor = scanner.nextLine();
        Contato contato = new Contato(valor, valor, valor);
        if (listaContatos.remove(contato)) {
            System.out.println("Contato removido!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void pesquisarPorNome() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        for (Contato contato : listaContatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
            }
        }
    }

    private void pesquisarPorEmail() {
        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();
        for (Contato contato : listaContatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                System.out.println(contato);
            }
        }
    }

    private void pesquisarPorTelefone() {
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        for (Contato contato : listaContatos) {
            if (contato.getTelefone().equals(telefone)) {
                System.out.println(contato);
            }
        }
    }

    private void ordenarPorNome() {
        bubbleSort("nome");
        System.out.println("Contatos ordenados por nome.");
    }

    private void ordenarPorEmail() {
        bubbleSort("email");
        System.out.println("Contatos ordenados por e-mail.");
    }

    private void ordenarPorTelefone() {
        bubbleSort("telefone");
        System.out.println("Contatos ordenados por telefone.");
    }

    private void bubbleSort(String criterio) {
        int n = listaContatos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Contato contato1 = listaContatos.get(j);
                Contato contato2 = listaContatos.get(j + 1);
                boolean troca = false;

                switch (criterio) {
                    case "nome":
                        troca = contato1.getNome().compareToIgnoreCase(contato2.getNome()) > 0;
                        break;
                    case "email":
                        troca = contato1.getEmail().compareToIgnoreCase(contato2.getEmail()) > 0;
                        break;
                    case "telefone":
                        troca = contato1.getTelefone().compareTo(contato2.getTelefone()) > 0;
                        break;
                }

                if (troca) {
                    listaContatos.set(j, contato2);
                    listaContatos.set(j + 1, contato1);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestaArrayList2 programa = new TestaArrayList2();
        programa.exibirMenu();
    }
}
