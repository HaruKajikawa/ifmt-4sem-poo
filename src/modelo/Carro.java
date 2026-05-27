package modelo;

/**
 * Subclasse de Veiculo
 * Atributo adicional: quantidadePortas e sobrescrita do método exibirInformacoes()
 */

public class Carro extends Veiculo {

    // atributo de Carro
    private int quantidadePortas;

    // construtor de Carro
    public Carro(String placa, String marca, String modelo, int anoFabricacao, int quantidadePortas) {
        super(placa, marca, modelo, anoFabricacao);
        this.quantidadePortas = quantidadePortas;
    }

    // sobrescrita do método exibirInformacoes() para Carro
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + " | Quantidade de portas: " + quantidadePortas;
    }

    // get e set de Carro
    public int getQuantidadePortas() { return quantidadePortas; }
    public void setQuantidadePortas(int quantidadePortas) { this.quantidadePortas = quantidadePortas; }
}