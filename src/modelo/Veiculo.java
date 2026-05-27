package modelo;

/**
 * Superclasse de Carro e Moto
 * tudo o que um Veículo tem (atributos) e faz (métodos)
 */

public class Veiculo {

    // atributos de Veiculo
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private static int numeroVeiculos = 0;

    // construtor de Veiculo
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        numeroVeiculos++;
    }

    // método de Veiculo
    public String exibirInformacoes() {
        return "Placa: " + placa
        + " | Marca: " + marca
        + " | Modelo: " + modelo
        + " | Ano de fabricação: " + anoFabricacao;
    }

    // getters e setters de Veiculo
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public static int getNumeroVeiculos() { return numeroVeiculos; }
}