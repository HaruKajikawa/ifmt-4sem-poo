package br.com.caelum.sistemacontas.modelo;

/**
 * essa classe vai ser responsável por moldar as contas do sistema do banco
 * ela é uma superclasse de ContaCorrente e ContaPoupanca
 */

public class Conta {

    /**
     *  do cap. 5: proteger os membros da classe (encapsulamento) com os modificadores de acesso
     *  public (qualquer um acessa), protected (classes do mesmo pacote e subclasses), default (classes do mesmo pacote),
     *  private (só a classe)
     *  atributo ou método estático é da própria classe e pode ser acessado pela classe diretamente
     *  construtores são métodos especiais chamados quando um objeto é instanciado (não possui retorno)
     */

    // Atributos da Conta (o que ela tem)
    private int numero;
    private String agencia;
    private String cliente;
    protected double saldo;
    private static int totalContas;
    private int identificador;

    // Métodos construtores da Conta
    public Conta() {
        Conta.totalContas++;
        this.identificador = Conta.totalContas;
    }

    public Conta(String cliente) {
        this();
        this.cliente = cliente;
    }

    // Métodos (o que ela faz)

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor inválido");
        }
    }

    public void transferir(Conta destino, double valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public double calcularRendimento() {
        return this.saldo * 0.1;
    }

    // Métodos getters e setters

    public String getTipo() { return "Conta"; }

    public double getSaldo() { return this.saldo; }

    public String getCliente() { return this.cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public int getNumero() { return this.numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getAgencia() { return this.agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public int getIdentificador() { return this.identificador; }

    // Método estático (da própria classe)

    public static int getTotalContas() { return Conta.totalContas; }

    // Sobrescrita do toString()

    @Override
    public String toString() {
        return getTipo()
                + " | Agência: " + this.agencia
                + " | Número: " + this.numero
                + " | Cliente: " + this.cliente
                + " | Saldo: R$" + this.saldo;
    }
}