package modelo;

/**
 * Classe abstrata que representa uma entrega genérica
 * Não pode ser instanciada diretamente
 * Define os atributos e métodos comuns a todos os tipos de entrega
 * calculFrete() é um método abstrato que deve ser implementado com suas próprias regras pelas subclasses
 */

public abstract class Entrega {

    // atributos privados (encapsulamento)
    private String codigo;
    private String destinatario;
    private String endereco;
    private double peso;

    // método construtor
    public Entrega(String codigo, String destinatario, String endereco, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.peso = peso;
    }

    // método abstrato, cada subclasse deve implementar sua regra de frete
    public abstract double calcularFrete();

    // método concreto, comum a todos os tipos de entrega
    public void exibirResumo() {
        System.out.println("========================");
        System.out.pritnln("| Tipo: " + getClass().getSimpleName());
        System.out.println("| Código: " + codigo);
        System.out.println("| Destinatário: " + destinatario);
        System.out.println("| Endereço: " + endereco);
        System.out.printf("| Peso: %.2f kg%n", peso);
        System.out.printf("| Frete: R$ %.2f%n", calcularFrete());
        System.out.println("========================"); 
    }

    // getters e setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}