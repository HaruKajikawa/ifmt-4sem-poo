package modelo;

/**
 * Entrega normal, sem nenhuma prioridade
 * Frete: peso * 5
 */

public class EntregaNormal extends Entrega implements Rastreavel {

    // método construtor
    public EntregaNormal(String codigo, String destinatario, String endereco, double peso) {
        super(codigo, destinatario, endereco, peso);
    }

    // implementação do método abstrato calcularFrete() da classe Entrega
    @Override
    public double calcularFrete() {
        return getPeso() * 5.0;
    }

    // implementação do método rastrear() da interface Rastreavel
    @Override
    public void rastrear() {
        System.out.println(" [NORMAL] Entrega " + getCodigo()
         + " está em trânsito para " + getDestinatario() + " no endereço " + getEndereco()
        + " prazo padrão de 5 a 10 dias úteis");
    }
}