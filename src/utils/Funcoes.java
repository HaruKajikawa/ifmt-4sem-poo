package utils;

import modelo.*;

/**
 * classe para organizar as funções usadas no menu principal
 */

public class Funcoes {

    // array para armazenar os veiculos na garagem
    private static Veiculo[] garagem = new Veiculo[10];

    // métodos para o menu principal
    public static void cadastrarVeiculo() {
        for (int i = 0; i < garagem.length; i++) {
            if (garagem[i] == null) {
                System.out.println("=== Cadastro de veículo ===\n");
                String placa = Teclado.lerString("Placa: ").trim().toUpperCase();
                String marca = Teclado.lerString("Marca: ");
                String modelo = Teclado.lerString("Modelo: ");
                int anoFabricacao = Teclado.lerInteiro("Ano de fabricação: ");
                int tipoVeiculo = Teclado.lerInteiro("Tipo do veículo (1-Carro / 2-Moto): ");

                if (tipoVeiculo == 1) {
                    int quantidadePortas = Teclado.lerInteiro("Quantidade de portas: ");
                    garagem[i] = new Carro(placa, marca, modelo, anoFabricacao, quantidadePortas);
                    System.out.println("Carro registrado na garagem com sucesso");
                    return;
                } else if (tipoVeiculo == 2) {
                    int cilindradas = Teclado.lerInteiro("Cilindradas: ");
                    garagem[i] = new Moto(placa, marca, modelo, anoFabricacao, cilindradas);
                    System.out.println("Moto registrada na garagem com sucesso");
                    return;
                } else {
                    System.out.println("Tipo de veículo inválido");
                    return;
                }
            }
        }
        System.out.println("Garagem cheia");
    }

    public static void alterarDados() {
        String placa = Teclado.lerString("Placa do veículo a ser alterado: ").trim().toUpperCase();
        Veiculo veiculo = buscarPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não cadastrado na garagem");
            return;
        } else {
            System.out.println("=== Alterando dados do veículo ===");
            veiculo.setPlaca(Teclado.lerString("Nova placa: ").trim().toUpperCase());
            veiculo.setMarca(Teclado.lerString("Nova marca: "));
            veiculo.setModelo(Teclado.lerString("Novo modelo"));
            veiculo.setAnoFabricacao(Teclado.lerInteiro("Novo ano de fabricação: "));

            if (veiculo instanceof Carro car) {
                car.setQuantidadePortas(Teclado.lerInteiro("Nova quantidade de portas: "));
                System.out.println("Carro modificado com sucesso");
                return;
            } else if (veiculo instanceof Moto mot) {
                mot.setCilindradas(Teclado.lerInteiro("Nova cilindrada: "));
                System.out.println("Moto modificada com sucesso");
                return;
            }
        }
    }

    public static void excluirVeiculo() {
        String placa = Teclado.lerString("Placa do veículo a ser removido da garagem: ").trim().toUpperCase();

        for (int i = 0; i < garagem.length; i++) {
            if (garagem[i] != null && garagem[i].getPlaca().equals(placa)) {
                garagem[i] = null;
                System.out.println("Veículo removido da garagem com sucesso");
                return;
            }
        }
        System.out.println("Veículo não registrado na garagem");
    }

    public static void consultarVeiculos() {
        boolean temVeiculo = false;

        for (Veiculo veiculo : garagem) {
            if (veiculo != null) {
                System.out.println(veiculo.exibirInformacoes());
                temVeiculo = true;
            }
        }
        if (!temVeiculo) {
            System.out.println("Nenhum veículo registrado na garagem");
        }
    }

    public static void exibirTotal() {
        System.out.println("Total de veículos registrados na garagem: " + Veiculo.getNumeroVeiculos());
    }

    private static Veiculo buscarPlaca(String placa) {
        placa = placa.trim().toUpperCase();

        for (Veiculo veiculo : garagem) {
            if (veiculo != null && veiculo.getPlaca().trim().toUpperCase().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}