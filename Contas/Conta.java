package br.com.caelum.contas;

public class Conta {
    private int numero;
    private String cliente;
    private double saldo;
    private double limite;

    public Conta(int numero, String cliente, double saldo, double limite) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
    }

    void sacar(double quantidade) {
        if (quantidade > 0) {
            this.saldo -= quantidade;
            System.out.println("[SACAR] " + quantidade + ". Novo saldo: " + this.saldo);
        }
        else {
            System.out.println("Quantidade inválida");
        }
    }

    void depositar(double quantidade) {
        if (quantidade > 0) {
            this.saldo += quantidade;
            if (this.saldo >= limite) {
                    System.out.println("Limite excedido");
            }
            System.out.println("[DEPÓSITO] " + quantidade+ ". Novo saldo: " + this.saldo);
        }
        else {
            System.out.println("Valor inválido");
        }
    }

    void transferir(Conta destino, double valor) {
        if (valor > 0) {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("[TRANSFERÊNCIA] " + valor + " para " + destino.getCliente() + ". Saldo atual: " +this.saldo);
        }
    }

    void exibir() {
        System.out.println("Cliente: " + this.cliente
        + " | Número: " + this.numero
        + " | Saldo atual: " + this.saldo
        + " | Limite: " + this.limite);
    }

    public int getNumero() { return this.numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getCliente() { return this.cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public double getSaldo() { return this.saldo; }
}