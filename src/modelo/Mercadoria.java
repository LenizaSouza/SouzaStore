package modelo;

import utils.Utils;

public class Mercadoria {
	private static int count = 1;
	
	private int id;
	private String nome;
	private Double preco;
	
	public Mercadoria(String nome, Double preco) {
		this.id = count;
		this.nome = nome;
		this.preco = preco;
		Mercadoria.count +=1;		
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String oString() {
		return "Id: " + this.getId() +
				"\nNome: " + this.getNome() +
				"\nPreço: " + Utils.doubleToString(this.getPreco());
	}

}
