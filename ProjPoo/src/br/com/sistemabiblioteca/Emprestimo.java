package br.com.sistemabiblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now(); // pega a data atual
        this.dataDevolucao = null; // ainda não devolvido
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolverLivro() {
        this.dataDevolucao = LocalDate.now();
        this.livro.setDisponivel(true); // O livro volta a estar disponível
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario.getNome() +
               " | Livro: " + livro.getTitulo() +
               " | Data Empréstimo: " + dataEmprestimo +
               " | Data Devolução: " + (dataDevolucao == null ? "Não devolvido" : dataDevolucao);
    }
}
