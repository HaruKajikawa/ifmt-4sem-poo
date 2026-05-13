package br.com.livroteca.sistemalivros.modelo;

/**
 * Superclasse de LivroFisico e Livrodigital
 * Contém o que todo livro tem e faz
 */

public class Livro {

    // Atributos de Livro (o que ele tem)
    private int id;
    private String titulo;
    private double precoBase;
    private int quantidadeEstoque;

    // Construtor completo de Livro
    public Livro(int id, String titulo, double precoBase, int quantidadeEstoque) {
        this.id = id;
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public double getPrecoBase() { return this.precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = precoBase; }

    public int getQuantidadeEstoque() { return this.quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    // Método de Livro (o que ele faz)
    public double calcularPrecoFinal() {
        return precoBase;
    }

    // Método static da própria classe Livro 
    public static double calcularValorTotalEstoque(Livro[] livros) {
        double total = 0;

        for (Livro livro : livros) {
            if (livro != null) {
                total += livro.calcularPrecoFinal() * livro.getQuantidadeEstoque();
            }
        }
        return total;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return "ID: " + id
        + " | Título: " + titulo
        + " | Preço Base: " + precoBase
        + " | Quantidade em estoque: " + quantidadeEstoque;
    }
}