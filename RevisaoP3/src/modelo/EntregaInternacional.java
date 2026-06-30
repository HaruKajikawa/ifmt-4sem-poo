package modelo;

/**
 * Entrega para destinos internacionais
 * Frete: peso * 15 + 50.00
 */

public class EntregaInternacional extends Entrega implements Rastreavel {

    // método construtor
    public EntregaInternacional(String codigo, String destinatario, String endereco, double peso) {
        super(codigo, destinatario, endereco, peso);
    }

    // implementação do método abstrato calcularFrete() da classe Entrega
    @Override
    public double calcularFrete() {
        return (getPeso() * 15) + 50.00;
    }

    // implementação do método rastrear() da interface Rastreavel
    @Override
    public void rastrear() {
        System.out.println(" [INTERNACIONAL] Entrega " + getCodigo()
         + " está em trânsito para " + getDestinatario() + " no endereço " + getEndereco()
        + " prazo de 15 a 30 dias úteis");
    }
}