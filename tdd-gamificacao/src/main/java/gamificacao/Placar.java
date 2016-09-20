package gamificacao;

public class Placar {

	private Armazenamento armazenamento;
	
	public void setArmazenamento(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public void registra(String usuario, String tipo, int pontos) {
		armazenamento.registra(usuario, tipo, pontos);
	}

	

}
