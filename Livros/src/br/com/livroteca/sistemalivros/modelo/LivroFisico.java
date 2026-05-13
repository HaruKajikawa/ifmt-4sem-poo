package br.com.livroteca.sistemalivros.modelo;

/**
 * Subclasse de Livro 
 * tem atributo adicional (custoImpressao) e sobrescreve o método calcularPrecoFinal()
 */

public class LivroFisico extends Livro {

    // Atributo adicionao de LivroFisico
    private double custoImpressao;

    // Construtor de LivroFisico
    public LivroFisico(int id, String titulo, double precoBase, int quantidadeEstoque, double custoImpressao) {
        super(id, titulo, precoBase, quantidadeEstoque);
        this.custoImpressao = custoImpressao;
    }

    // Sobrescrita do método calcularPrecofinal()
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() + custoImpressao;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Físico | Custo impressão: R$ " + custoImpressao;
    }
}