package modelo;

/**
 * Entrega com prioridade
 * Frete: peso * 8 + 20.00
 */

public class EntregaExpressa extends Entrega implements Rastreavel {

    // método construtor
    public EntregaExpressa(String codigo, String destinatario, String endereco, double peso) {
        super(codigo, destinatario, endereco, peso);
    }

    // implementação do método abstrato calcularFrete() da classe Entrega
    @Override
    public double calcularFrete() {
        return (getPeso() * 8) + 20.00;
    }

    // implementação do método rastrear() da interface Rastreavel
    @Override
    public void rastrear() {
        System.out.println(" [EXPRESSA] Entrega " + getCodigo()
         + " está em trânsito para " + getDestinatario() + " no endereço " + getEndereco()
        + " prazo de 2 a 5 dias úteis");
    }
}