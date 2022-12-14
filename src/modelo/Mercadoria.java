package modelo;

public class Mercadoria {
	private static int count = 1;
	
	private int id;
	private String nome;
	private Double preco;
	
	public Mercadoria(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
		
	}

}
