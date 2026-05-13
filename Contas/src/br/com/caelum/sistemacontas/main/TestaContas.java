package br.com.caelum.sistemacontas.main;

import br.com.caelum.sistemacontas.ManipuladorContas;
import br.com.caelum.sistemacontas.modelo.Conta;
import br.com.caelum.sistemacontas.modelo.ContaCorrente;
import br.com.caelum.sistemacontas.modelo.ContaPoupanca;

/**
 * teste dos exercícios do cap. 9 sobre herança e polimorfismo
 */

public class TestaContas {

    public static void main(String[] args) {

        System.out.println("=== Exercício 2: Criando ContaCorrente e Contapoupanca ===");
        ContaCorrente cc = new ContaCorrente();
        cc.setCliente("Batman");
        cc.setAgencia("1234");
        cc.setNumero(111);

        ContaPoupanca cp = new ContaPoupanca();
        cp.setCliente("Robin");
        cp.setAgencia("1234");
        cp.setNumero(222);

        System.out.println("Conta criada: " + cc.getTipo() + " - Titular: " + cc.getCliente());
        System.out.println("Conta criada: " + cp.getTipo() + " - Titular: " + cp.getCliente());

        System.out.println("\n=== Exercício 4: getTipo() ===");
        System.out.println("Tipo da conta corrente: " + cc.getTipo());
        System.out.println("Tipo da conta poupanca: " + cp.getTipo());

        System.out.println("\n=== Exercício 5 e 6: Depósito e saque ===");
        cc.depositar(1000.0);
        cp.depositar(1000.0);
        System.out.println("Saldo CC após o depósito de 1000 reais: R$ " + cc.getSaldo());
        System.out.println("Saldo CP após depósito de 2000 reais: R$ " + cp.getSaldo());

        cc.sacar(100.0);
        cp.sacar(100.0);
        System.out.println("Saldo CC após saque de 100 reais (+ 0,10 de taxa): R$ " + cc.getSaldo());
        System.out.println("Saldo CP após saque de 100 reais (sem taxa): R$ " + cp.getSaldo());

        System.out.println("\n=== Exercício 7: Polimorfismo no ManipuladorContas ===");
        ManipuladorContas manipCC = new ManipuladorContas();
        manipCC.criarContaCorrente("5678", 333, "Coringa");
        manipCC.deposita(500.0);
        manipCC.saca(50.0);
        System.out.println("Conta via manipulador: " + manipCC.getConta());

        ManipuladorContas manipCP = new ManipuladorContas();
        manipCP.criarContaPoupanca("5678", 444, "Mulher-Maravilha");
        manipCP.deposita(500.0);
        manipCP.saca(50.0);
        System.out.println("Conta via manipulador: " + manipCP.getConta());

        System.out.println("\n=== Exercício 9: Transferência ===");
        ContaCorrente origem = new ContaCorrente();
        origem.setCliente("Flash");
        origem.depositar(800.0);

        ContaPoupanca destino = new ContaPoupanca();
        destino.setCliente("Aquaman");
        destino.depositar(200.0);

        System.out.println("Antes da transferência:");
        System.out.println("Flash (CC): R$ " + origem.getSaldo());
        System.out.println("Aquaman (CP): R$ " + destino.getSaldo());

        origem.transferir(destino, 300.0);

        System.out.println("Após transferência de 300 reais:");
        System.out.println("Flash (CC): R$ " + origem.getSaldo() + " (descontou 300 reais + 0,10 de taxa)");
        System.out.println("Aquaman (CP): R$ " + destino.getSaldo());

        System.out.println("\n=== Exercício 10: Polimorfismo com referência do tipo Conta ===");
        Conta c1 = new ContaCorrente();
        Conta c2 = new ContaPoupanca();
        c1.depositar(100.0);
        c2.depositar(100.0);
        System.out.println("c1 é do tipo: " + c1.getTipo());
        System.out.println("c2 é do tipo: " + c2.getTipo());

        System.out.println("\n=== Total de contas criadas ===");
        System.out.println("Total: " + Conta.getTotalContas());
    }
}