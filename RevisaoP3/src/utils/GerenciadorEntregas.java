package utils;

import modelo.*;

/**
 * Contém toda a lógica das operações do sistema
 * cadastrar, alterar, excluir e listar entregas
 */

public class GerenciadorEntregas {

    private static int CAPACIDADE = 20;

    private Entrega[] entregas = new Entrega[CAPACIDADE];
    private int qntd = 0;

    // cadastrar entrega
    public void cadastrar() {
        if (qntd == CAPACIDADE) {
            System.out.println("\n Capacidade máxima (" + CAPACIDADE + " entregas) atingida");
            return;
        }

        System.out.println("\n Tipo de entrega:");
        System.out.println(" 1. Normal");
        System.out.println(" 2. Expressa");
        System.out.println(" 3. Internacional");
        int tipo = Teclado.lerInt(" Escolha: ");

        if (tipo < 1 || tipo > 3) {
            System.out.println(" Tipo inválido");
            return;
        }

        String codigo = Teclado.lerString(" Código: ");
        if (buscarIndicePorCodigo(codigo) != -1) {
            System.out.println(" Já existe uma entrega com esse código");
            return;
        }

        Sring destinatario = Teclado.lerString(" Destinatário: ");
        String endereco = Teclado.lerString(" Endereço: ");
        double peso = Teclado.lerDouble(" Peso (kg): ");

        Entrega nova = switch (tipo) {
            case 1 -> new EntregaNormal(codigo, destinatario, endereco, peso);
            case 2 -> new EntregaExpressa(codigo, destinatario, endereco, peso);
            case 3 -> new EntregaInternacional(codigo, destinatario, endereco, peso);
            default -> null;
        };

        entregas[qtd++] = nova;
        System.out.println("\n Entrega cadastrada com sucesso");
    }

    // alterar entrega
    public void alterar() {
        if (qtd == 0) {
            System.out.println("\n Nenhuma entrega cadastrada");
            return;
        }

        String codigo = Teclado.lerString("\n Código da entrega a alterar: ");
        int idx = buscarIndicePorCodigo(codigo);

        if (idx == -1) {
            System.out.println(" Entrega não encontrada");
            return;
        }

        Entrega e = entregas[idx];

        String novoDestinatario = Teclado.lerString(" Destinatário [" + e.getDestinatario() + "]:");
        String novoEndereco = Teclado.lerString(" Endereço [" + e.getEndereco() + "]:");
        String novoPeso = Teclado.lerString(" Peso (kg) [" + e.getPeso() + "]:");

        if (!novoDestinatario.isEmpty()) e.setDestinatario(novoDestinatario);
        if (!novoEndereco.isEmpty()) e.setEndereco(novoEndereco);

        if (!novoPeso.isEmpty()) {
            try {
                e.setPeso(Double.parseDouble(novoPeso.replace(",", ".")));
            } catch (NumberFormatException ex) {
                System.out.println(" Peso inválido");
            }
        }

        System.out.println("\n Entrega alterada com sucesso");
    }

    // excluir entrega
    public void excluir() {
        if (qtd == 0) {
            System.out.println("\n Nenhuma entrega cadastrada");
            return;
        }

        String codigo = Teclado.lerString(" Código da entrega a excluir: ");
        int idx = buscarIndicePorCodigo(codigo);

        if (idx == -1) {
            System.out.println(" Entrega não encontrada");
            return;
        }

        for (int i = idx; i < qtd - 1; i++) {
            entregas[i] = entregas[i + 1];
        }
        entregas[--qtd] = null;

        System.out.println("\n Entrega excluída com sucesso");
    }

    // listar entregas
    public void listar() {
        if (qtd == 0) {
            System.out.println("\n Nenhuma entrega cadastrada");
            return;
        }

        System.out.println("\n ======== LISTA DE ENTREGAS ============");
        for (int i = 0; i < qtd; i++) {
            entregas[i].exibirResumo();
            System.out.printf(" Frete calculado: R$ %.2f%n", entregas[i].calcularFrete());

            if (entregas[i] instanceof Rastreavel r) {
                r.rastrear();
            }
            System.out.println();
        }
        System.out.println(" Total de entregas: " + qtd);
    }

    // método auxiliar
    private int buscarIndicePorCodigo(String codigo) {
        for (int i = 0; i < qtd; i++) {
            if (entregas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
}
