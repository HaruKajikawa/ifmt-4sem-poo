package br.com.caelum.sistemacontas;

import br.com.caelum.sistemacontas.modelo.Conta;
import br.com.caelum.sistemacontas.modelo.ContaCorrente;
import br.com.caelum.sistemacontas.modelo.ContaPoupanca;

public class ManipuladorContas {

    // atributo de instância
    private Conta conta;

    // cria uma ContaCorrente com os dados informados
    public void criarContaCorrente(String agencia, int numero, String cliente) {
        this.conta = new ContaCorrente();
        this.conta.setAgencia(agencia);
        this.conta.setNumero(numero);
        this.conta.setCliente(cliente);
    }

    // cria uma ContaPoupanca com os dados informados
    public void criarContaPoupanca(String agencia, int numero, String cliente) {
        this.conta = new ContaPoupanca();
        this.conta.setAgencia(agencia);
        this.conta.setNumero(numero);
        this.conta.setCliente(cliente);
    }

    // deposita um valor na conta
    public void deposita(double valor) {
        this.conta.depositar(valor);
    }

    // saca um valor da conta
    public void saca(double valor) {
        this.conta.sacar(valor);
    }

    // transfere um valor para outra conta
    public void transfere(Conta destino, double valor) {
        this.conta.transferir(destino, valor);
    }

    public Conta getConta() {
        return this.conta;
    }
}