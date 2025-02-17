package br.com.sistemabiblioteca;

public class Usuario extends Pessoa {

    private int idUsuario;

    public Usuario(int idUsuario, String nome, String cpf) {
        super(nome, cpf); // chama o construtor da classe Pessoa
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // polimorfismo:
    // método toString() para exibir informações de forma diferente
    @Override
    public String toString() {
        return "ID: " + idUsuario + " | Nome: " + getNome() + " | CPF: " + getCpf();
    }
}
