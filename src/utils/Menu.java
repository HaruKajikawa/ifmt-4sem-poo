package utils;


/**
 * classe para organizar o menu principal da aplicação
 */

public class Menu {

    public static void menuPrincipal() {
        int opcao;

        do {
            System.out.println("=== SISTEMA DE GESTÃO DE VEICULOS ===\n");
            System.out.println("[1] Cadastrar veículo");
            System.out.println("[2] Alterar veículo");
            System.out.println("[3] Excluir veículo");
            System.out.println("[4] Consultar veículos");
            System.out.println("[5] Exibir total de veículos registrados");
            System.out.println("[0] Sair do sistema de gestão");
            opcao = Teclado.lerInteiro("Digite uma opção: ");

            switch(opcao) {
                case 1:
                    Funcoes.cadastrarVeiculo();
                    break;
                    case 2:
                        Funcoes.alterarDados();
                        break;
                        case 3:
                            Funcoes.excluirVeiculo();
                            break;
                            case 4:
                                Funcoes.consultarVeiculos();
                                break;
                                case 5:
                                    Funcoes.exibirTotal();
                                    break;
                                    case 0:
                                        System.out.println("Saindo do sistema de gestão de veículos...");
                                        break;
                                        default:
                                            System.out.println("Opção inválida");
                                            break;
            }
        }while (opcao!=0);
    }
}