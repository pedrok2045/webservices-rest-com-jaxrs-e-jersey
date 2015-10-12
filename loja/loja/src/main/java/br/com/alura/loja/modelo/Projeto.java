package br.com.alura.loja.modelo;

public class Projeto {
	private String nome;
	private Long id;
	private int ano;
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}
	public Projeto(long id, String nome, int ano) {
		super();
		this.nome = nome;
		this.id = id;
		this.ano = ano;
	}
	public String getNome() {
		return nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
}
