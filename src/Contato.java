public class Contato implements Comparable<Contato> {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return " [Nome: " + getNome() + ", Telefone: " + getTelefone() + ", e-mail: " + getEmail() + "]";
    }  

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Contato outro = (Contato) obj;

        if (nome == null) {
            if (outro.nome != null) {
                return false;
            }
        } 
        else if (!nome.equals(outro.nome)) {
                return false;
        }

        if (email == null) {
            if (outro.email != null) {
                return false;
            }
        }
        else if (!email.equals(outro.email)) {
                return false;
        }
        
        if (telefone == null) {
            if (outro.telefone != null) {
                return false;
            }
        }
        else if (!telefone.equals(outro.telefone)) {
                return false;
        }

        return true;
    }
*/

     // Método equals sobrecarregado para comparar por tipo (nome, email ou telefone)
     @Override
     public boolean equals(Object obj) {
         if (this == obj) {
             return true;
         }
         if (obj == null || getClass() != obj.getClass()) {
             return false;
         }
         Contato outro = (Contato) obj;
 
         // Aqui você pode alterar a lógica para definir qual critério deseja usar na comparação
         // Exemplo: comparar pelo nome
         return this.nome.equalsIgnoreCase(outro.getNome()) ||
                this.email.equalsIgnoreCase(outro.getEmail()) ||
                this.telefone.equals(outro.getTelefone());
     }

    // Implementação da interface Comparable, comparando o nome dos contatos
    @Override
    public int compareTo(Contato outro) {
        return this.nome.compareToIgnoreCase(outro.getNome());  // Ordena por nome de forma case-insensitive
    }


}
