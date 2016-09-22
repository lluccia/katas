package gamificacao;

public class Pontos {

	private String tipo;
	private int quantidade;

	public Pontos() {}
	
	public Pontos(String tipo, int quantidade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
}
