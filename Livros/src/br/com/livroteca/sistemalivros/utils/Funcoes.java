package br.com.livroteca.sistemalivros.utils;

import br.com.livroteca.sistemalivros.modelo.Livro;
import br.com.livroteca.sistemalivros.modelo.LivroFisico;
import br.com.livroteca.sistemalivros.modelo.LivroDigital;

/**
 * Classe para organizar as funções usadas no menu da aplicação
 */

public class Funcoes {

    private static Livro[] cadastro = new Livro[10];

    // Funções usadas no menu principal
    static void inserirLivro() {

        int tipo = Teclado.lerInteiro("Tipo (1 Físico / 2 Digital): ");

        int id = Teclado.lerInteiro("ID: ");

        String titulo = Teclado.lerString("Título do livro: ");

        double preco = Teclado.lerDouble("Preço base: ");
        
        int qtd = Teclado.lerInteiro("Quantidade em estoque: ");

        if (tipo == 1) {
            double custo = Teclado.lerDouble("Custo de impressão: R$ ");

            for (int i = 0; i < cadastro.length; i++) {
                if (cadastro[i] == null) {
                    cadastro[i] = new LivroFisico(id, titulo, preco, qtd, custo);
                    System.out.println("Livro Físico inserido com sucesso");
                    return;
                }
            }
            System.out.println("Cadastro de livros cheio");
        } else {
            double desconto = Teclado.lerDouble("Desconto (%): ");

            for (int i = 0; i < cadastro.length; i++) {
                if (cadastro[i] == null) {
                    cadastro[i] = new LivroDigital(id, titulo, preco, qtd, desconto);
                    System.out.println("Livro Digital inserido com sucesso");
                    return;
                }
            }
            System.out.println("Cadastro de livros cheio");
        }
    }

    static void alterarLivro() {
        int id = Teclado.lerInteiro("ID do livro a ser alterado: ");

        for (Livro livro : cadastro) {
            if (livro != null && livro.getId() == id) {

                livro.setTitulo(Teclado.lerString("Novo título: "));

                livro.setPrecoBase(Teclado.lerDouble("Novo preço: "));

                livro.setQuantidadeEstoque(Teclado.lerInteiro("Nova quantidade no estoque: "));

                System.out.println("Livro alterado com sucesso");
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    
    static void removerLivro() {
        int id = Teclado.lerInteiro("ID do livro a ser removido: ");

        for (int i = 0; i < cadastro.length; i++) {
            if (cadastro[i] != null && cadastro[i].getId() == id) {
                cadastro[i] = null;
                System.out.println("Livro removido com sucesso");
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    static void listarTodos() {
        System.out.println("\n=== LIVROS CADASTRADOS ===");
        boolean temLivro = false;

        for (Livro l : cadastro) {
            if (l != null) {
                System.out.println(l);
                temLivro = true;
            }
        }
        if (!temLivro) System.out.println("Nenhum livro cadastrado");
    }

    static void mostrarValorTotal() {
        double total = Livro.calcularValorTotalEstoque(cadastro);
        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", total));
    }
}