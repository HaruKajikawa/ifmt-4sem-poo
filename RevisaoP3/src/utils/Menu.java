package utils;

/**
 * Classe para exibição do menu e pelo loop da aplicação
 * Cada operação do menu é implementado pelo GerenciadorEntregas
 */

public class Menu {
    private GerenciadorEntregas gerenciador = new GerenciadorEntregas();

    public void exibirMenu() {
        int opcao;

        do {
            imprimirMenu();
            opcao = Teclado.lerInt(" Opção: ");

            switch(opcao) {
                case 1 -> gerenciador.cadastrar();
                case 2 -> gerenciador.alterar();
                case 3 -> gerenciador.exclcuir();
                case 4 -> gerenciador.listar();
                case 0 -> System.out.println("\n Saindo do sistema...");
                default -> System.out.println("\n Opção inválida. Tente novamente");
            }
        } while (opcao != 0);
    }

    private void imprimirMenu() {
        System.out.println("\n===================================");
        Sstem.out.println(" SISTEMA DE GERENCIAMENTO DE ENTREGAS");
        System.out.println("===================================");
        System.out.println(" [1] Cadastrar entrega");
        System.out.println(" [2] Alterar entrega");
        System.out.println(" [3] Excluir entrega");
        System.out.println(" [4] Listar entregas");
        System.out.println(" [0] Sair");
        Systme.out.println("===================================");
    }
}