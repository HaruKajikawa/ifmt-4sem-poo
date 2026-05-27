package modelo;

/**
 * Subclasse de Veiculo
 * Atributo adicional: cilindradas e sobrescrita do método exibirInformacoes()
 */

public class Moto extends Veiculo {

    // atributo de Moto
    private int cilindradas;

    // construtor de Moto
    public Moto(String placa, String marca, String modelo, int anoFabricacao, int cilindradas) {
        super(placa, marca, modelo, anoFabricacao);
        this.cilindradas = cilindradas;
    }

    // sobrescrita do método exibirInformacoes() para Moto
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + " | Cilindradas: " + cilindradas;
    }

    // get e set de Moto
    public int getCilindradas() { return cilindradas; }
    public void setCilindradas(int cilindradas) { this.cilindradas = cilindradas; }
}