package br.com.caelum.sistemacontas.modelo;

/**
 * ContaPoupanca é subclasse de Conta
 * sem taxa adicional no saque (herda o método sacar() padrão da Conta)
 * getTipo() retorna "Conta Poupança"
 */

public class ContaPoupanca extends Conta {

    // retorna o tipo desta conta (poupança)
    @Override
    public String getTipo() {
        return super.getTipo() + " Poupança";
    }
}