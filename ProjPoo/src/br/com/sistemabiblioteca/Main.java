package br.com.sistemabiblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Usuários");
            System.out.println("6 - Listar Livros");
            System.out.println("7 - Listar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());
            
            switch (opcao) {
                case 1:
                    cadastrarUsuario(biblioteca, sc);
                    break;
                case 2:
                    cadastrarLivro(biblioteca, sc);
                    break;
                case 3:
                    realizarEmprestimo(biblioteca, sc);
                    break;
                case 4:
                    devolverLivro(biblioteca, sc);
                    break;
                case 5:
                    listarUsuarios(biblioteca);
                    break;
                case 6:
                    listarLivros(biblioteca);
                    break;
                case 7:
                    listarEmprestimos(biblioteca);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
        
        sc.close();
    }
    
    private static void cadastrarUsuario(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Informe o nome do Usuário: ");
        String nome = sc.nextLine();
        
        String cpf = lerCPFValido(sc);
        
        // Método que retorna o usuário criado:
        Usuario usuarioCriado = biblioteca.adicionarUsuario(nome, cpf);
        
        System.out.println("Usuário cadastrado com sucesso! ID gerado: " 
                + usuarioCriado.getIdUsuario());
    }
    
    private static void cadastrarLivro(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Informe o título do Livro: ");
        String titulo = sc.nextLine();
        System.out.print("Informe o autor do Livro: ");
        String autor = sc.nextLine();
        
        // Método que retorna o livro criado:
        Livro livroCriado = biblioteca.adicionarLivro(titulo, autor);
        
        System.out.println("Livro cadastrado com sucesso! ID gerado: " 
                + livroCriado.getIdLivro());
    }
    
    private static void realizarEmprestimo(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Informe o ID do Usuário: ");
        int idUsuario = Integer.parseInt(sc.nextLine());
        System.out.print("Informe o ID do Livro: ");
        int idLivro = Integer.parseInt(sc.nextLine());
        
        biblioteca.emprestarLivro(idUsuario, idLivro);
    }
    
    private static void devolverLivro(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Informe o ID do Livro: ");
        int idLivro = Integer.parseInt(sc.nextLine());
        
        biblioteca.devolverLivro(idLivro);
    }
    
    private static void listarUsuarios(Biblioteca biblioteca) {
        List<Usuario> lista = biblioteca.getUsuarios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("=== Lista de Usuários ===");
            for (Usuario u : lista) {
                System.out.println(u);
            }
        }
    }
    
    private static void listarLivros(Biblioteca biblioteca) {
        List<Livro> lista = biblioteca.getLivros();
        if (lista.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (Livro l : lista) {
                System.out.println(l);
            }
        }
    }
    
    private static void listarEmprestimos(Biblioteca biblioteca) {
        List<Emprestimo> lista = biblioteca.getEmprestimos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
        } else {
            System.out.println("=== Lista de Empréstimos ===");
            for (Emprestimo e : lista) {
                System.out.println(e);
            }
        }
    }
    
    //  MÉTODO DE VALIDAÇÃO DE CPF 
    private static String lerCPFValido(Scanner sc) {
        String cpf;
        while (true) {
            System.out.print("Informe o CPF (somente 11 dígitos numéricos): ");
            cpf = sc.nextLine().trim();
            
            // Verifica se tem EXATAMENTE 11 dígitos e se são todos números
            if (cpf.matches("\\d{11}")) {
                return cpf;
            } else {
                System.out.println("CPF inválido. Tente novamente.");
            }
        }
    }
}
