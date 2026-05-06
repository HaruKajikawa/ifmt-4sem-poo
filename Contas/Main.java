package br.com.caelum.contas;

public class Main {
    public static void main(String[] args) {
        Conta c = new Conta(1, "João", 1500.0, 7500.50);
        Conta c1 = new Conta(2, "Ana", 0.0, 8000.0);
        c.sacar(500.0);
        c.depositar(1000.0);
        c.transferir(c1, 500.0);
        c.exibir();
        c1.exibir();
    }
}