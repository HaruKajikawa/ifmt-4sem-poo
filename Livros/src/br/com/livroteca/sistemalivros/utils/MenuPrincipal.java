package br.com.livroteca.sistemalivros.utils;


/**
 * Classe para organizar o menu principal da aplicação
 */

public class MenuPrincipal {

    public static void Menu() {

        int opcao;
        do {

            System.out.println("1. Inserir Livro");
            System.out.println("2. Alterar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Listar Todos os Livros");
            System.out.println("5. Valor Total do Estoque");
            System.out.println("0. Sair");

            opcao = Teclado.lerInteiro("Digite a opção: ");

            switch (opcao) {
                case 1:
                    Funcoes.inserirLivro();
                    break;
                case 2:
                    Funcoes.alterarLivro();
                    break;
                case 3:
                    Funcoes.removerLivro();
                    break;
                case 4:
                    Funcoes.listarTodos();
                    break;
                case 5:
                    Funcoes.mostrarValorTotal();
                    break;
                case 0:
                    System.out.println("Saindo do sistema de livros...");
                    break;
                default:
                    System.out.println("Opção inválida. Insira novamente");
            }
        } while (opcao != 0);
    }
}