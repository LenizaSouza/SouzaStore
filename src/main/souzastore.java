package main;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.Mercadoria;
import utils.Utils;

public class souzastore {

	private static ArrayList<Mercadoria> mercadorias;
	private static Map<Mercadoria, Integer> carrinho;

	public static void main(String[] args) {
		mercadorias = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}

	private static void menu() {

		int option = Integer.parseInt(JOptionPane.showInputDialog("---Selecione uma opção---" +

				"\n|   Opção 1 - Cadastrar Mercadorias   " + "\n|   Opção 2 - Listar Mercadorias      "
				+ "\n|   Opção 3 - Comprar                 " + "\n|   Opção 4 - Carrinho                "
				+ "\n|   Opção 5 - Sair                    "));

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
			verCarrinho();
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Volte Sempre!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida");
			menu();
			break;

		}

	}

	private static void cadastrarMercadorias() {
		Mercadoria mercadoria = new Mercadoria();

		mercadoria.setNome(JOptionPane.showInputDialog("Nome da mercadoria: "));

		Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço da mercadoria: "));
		mercadoria.setPreco(preco);

		mercadorias.add(mercadoria);
		JOptionPane.showMessageDialog(null, " cadastrado realizado com sucesso!");
		menu();
	}

	private static void listarMercadorias() {
		if (mercadorias.size() > 0) {

			for (Mercadoria m : mercadorias) {
				JOptionPane.showMessageDialog(null, m);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há mercadoria cadastrada para listar!");
		}

		menu();
	}

	private static void comprarMercadorias() {
		if (mercadorias.size() > 0) {

			JOptionPane.showMessageDialog(null, "---------Mercadorias Disponíveis---------");
			for (Mercadoria m : mercadorias) {
				JOptionPane.showMessageDialog(null, m + "\n");
			}

			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da mercadoria"));
			boolean isPresent = false;

			for (Mercadoria m : mercadorias) {
				if (m.getId() == id) {
					isPresent = true;
					int qtd = 0;
					try {
						qtd = carrinho.get(m);
						// checa se a mercadoria já está no carrinho, incrementa a quantidade.
						carrinho.put(m, qtd + 1);
					} catch (NullPointerException e) {
						// se a mercadoria for a primeira no carrinho.
						carrinho.put(m, 1);
					}
					JOptionPane.showMessageDialog(null, m.getNome() + " adicionado(a) ao carrinho");

					if (isPresent) {

						int option = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Se deseja adicionar outra mercadoria ao carrinho, digite " + "\n(1) para Sim ou "
										+ "\n(0) para finalizar a compra. \n"));

						if (option == 1) {
							comprarMercadorias();
						} else {
							finalizarCompra();
						}
					}

				}
			}
			if (isPresent == false) {
				JOptionPane.showMessageDialog(null, "Mercadoria não encontrada! ");
				menu();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Não há mercadoria disponível para a compra!");
			menu();
		}
	}

	private static void verCarrinho() {

		if (carrinho.size() > 0) {
			for (Mercadoria m : carrinho.keySet()) {
				JOptionPane.showMessageDialog(null, "Mercadoria: " + m + "\nQuantidade: " + carrinho.get(m));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Carrinho vazio!");
		}
		menu();
	}

	private static void finalizarCompra() {
		Double valorDaCompra = 0.0;
		JOptionPane.showMessageDialog(null, "Suas Mercadorias!");

		for (Mercadoria m : carrinho.keySet()) {
			int qtd = carrinho.get(m);
			valorDaCompra += m.getPreco() * qtd;
			JOptionPane.showMessageDialog(null, m);
			JOptionPane.showMessageDialog(null, "Quantidade:" + qtd);

		}
		JOptionPane.showMessageDialog(null, "O valor da compra é: " + Utils.doubleToString(valorDaCompra));
		carrinho.clear();
		JOptionPane.showMessageDialog(null, "Obrigado pela preferência!");
		menu();

	}

}
