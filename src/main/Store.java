package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.Mercadoria;

public class Store {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Mercadoria> mercadorias;
	private static Map<Mercadoria, Integer> carrinho;
	
	public static void main(String[] args) {
		mercadorias = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();		
	}

	private static void menu() {

		System.out.println("--------------------------------------");
		System.out.println("-------------Souza Store-------------");
		System.out.println("--------------------------------------");
		System.out.println("-------Selecione a opção desejada-------");
		System.out.println("--------------------------------------");
		System.out.println("|   Opção 1 - Cadastrar Mercadorias   |");
		System.out.println("|   Opção 2 - Listar Mercadorias      |");
		System.out.println("|   Opção 3 - Comprar                 |");
		System.out.println("|   Opção 4 - Carrinho                |");
		System.out.println("|   Opção 5 - Sair                    |");
		
		int option = input.nextInt();
		
		switch (option) {
			case 1:
				cadastrarMercadorias();
				break;
			case 2:
				listarMercadorias();
				break;
			case 3:
				comprarMercadorias();
				break;
			case 4:
				VerCarrinho();
				break;
			case 5:
				System.out.println("Volte Sempre!");
				System.exit();
			default:
				System.out.println("Opção Inválida");
				menu();
				break;
				
		}
		
	}

	private static void cadastrarMercadorias() {
		System.out.println("Nome da mercadoria: ");
		String nome = input.next();
		
		System.out.println("Preço da mercadoria: ");
		Double preco = input.nextDouble();
		
		Mercadoria mercadoria = new Mercadoria(nome, preco);
		mercadorias.add(mercadoria);
		
		System.out.println(mercadoria.getNome() + " cadastrado com sucesso!");
		menu();		
	}
	
	private static void listarMercadorias() {
		if (mercadorias.size() > 0) {
			System.out.println("lista de produtos! \n");
			
			for (Mercadoria m : mercadorias) {
				System.out.println(m);
			}
		}else {
			System.out.println("Não há mercadoria cadastrada!");
		}
		
		menu();
	}
}
