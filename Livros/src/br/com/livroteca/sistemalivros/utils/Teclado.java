package br.com.livroteca.sistemalivros.utils;

import java.util.Scanner;

public class Teclado{
	
	private static Scanner scann = new Scanner(System.in);

	public static int lerInteiro(String rotulo) {
		System.out.print(rotulo);
		int valor = scann.nextInt();
		scann.nextLine();
		return valor;
	}

	public static double lerDouble(String rotulo) {
		System.out.print(rotulo);
		double valor = scann.nextDouble();
		scann.nextLine();
		return valor;
	}

	public static String lerString(String rotulo) {
		System.out.print(rotulo);
		return scann.nextLine();
	}
}