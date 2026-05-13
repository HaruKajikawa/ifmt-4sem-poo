package br.com.livroteca.sistemalivros.modelo;

/**
 * Subclasse de Livro
 * tem atributo adicional (percentualDesconto) e sobrescreve o método calcularPrecofinal()
 */

public class LivroDigital extends Livro {

    // Atributo adicional de LivroDigital
    private double percentualDesconto;


    // Construtor de LivroDigital
    public LivroDigital(int id, String titulo, double precoBase, int quantidadeEstoque, double percentualDesconto) {
        super(id, titulo, precoBase, quantidadeEstoque);
        this.percentualDesconto = percentualDesconto;
    }

    // Sobrescrita do método calcularPrecoFinal()
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() - (getPrecoBase() * percentualDesconto / 100);
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Digital | Desconto: " + percentualDesconto + "%";
    }
}