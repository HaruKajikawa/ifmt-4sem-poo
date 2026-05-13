package br.com.caelum.sistemacontas.modelo;

/**
 * ContaCorrente é subclasse de Conta
 * cada saque desconta 0,10 reais a mais (taxa operacional)
 * getTipo() retorna "Conta Corrente"
 */

public class ContaCorrente extends Conta{

    // sobrescreve o método sacar() para cobrar 0,10 reais de taxa
    @Override
    public boolean sacar(double valor) {
        double valorTaxa = valor + 0.10;
        if (valorTaxa > 0 && valorTaxa <= this.saldo) {
            this.saldo -= valorTaxa;
            return true;
        } else {
            return false;
        }
    }

    // retorna o tipo desta conta (corrente)
    @Override
    public String getTipo() {
        return super.getTipo() + " Corrente";
    }
}