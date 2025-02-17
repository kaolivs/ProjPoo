package br.com.sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private List<Usuario> usuarios;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    // Contador para gerar ID de usuário automaticamente
    private int proximoIdUsuario = 1;
    
    //  Contador para gerar ID de livro automaticamente
    private int proximoIdLivro = 1;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // USUÁRIOS 
    public Usuario adicionarUsuario(String nome, String cpf) {
        // cria usuário com ID gerado automaticamente
        Usuario novo = new Usuario(proximoIdUsuario, nome, cpf);
        usuarios.add(novo);
        proximoIdUsuario++;
        return novo;
    }
    
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // LIVROS 
    public Livro adicionarLivro(String titulo, String autor) {
        Livro l = new Livro(proximoIdLivro, titulo, autor);
        livros.add(l);
        proximoIdLivro++;
        return l;
    }
    
    public Livro buscarLivroPorId(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l;
            }
        }
        return null;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    //  EMPRÉSTIMOS 
    public void emprestarLivro(int idUsuario, int idLivro) {
        Usuario u = buscarUsuarioPorId(idUsuario);
        Livro l = buscarLivroPorId(idLivro);
        
        if (u != null && l != null && l.isDisponivel()) {
            Emprestimo emp = new Emprestimo(u, l);
            l.setDisponivel(false);
            emprestimos.add(emp);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o empréstimo. "
                    + "Verifique se usuário e livro existem, e se o livro está disponível.");
        }
    }

    public void devolverLivro(int idLivro) {
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().getIdLivro() == idLivro && e.getDataDevolucao() == null) {
                e.devolverLivro();
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Não foi encontrado empréstimo ativo para este livro.");
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
