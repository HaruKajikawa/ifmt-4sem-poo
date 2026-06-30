package utils;

import java.util.Scanner;

/**
 * Centraliza a leitura de dados do teclado.
 * Usar um único Scanner estático evita abrir/fechar streams repetidamente.
 */
public class Teclado {

    private static final Scanner scanner = new Scanner(System.in);

    private Teclado() {
        // Utilitário — não deve ser instanciado
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Entrada inválida. Digite um número válido (ex: 2.5).");
            }
        }
    }
}