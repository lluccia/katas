package gamificacao;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class PlacarTest {
	
	@Test
	public void registroDePontos() {
		Placar placar = new Placar();
		ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
		placar.setArmazenamento(armazenamentoMock);
		
		placar.registra("guerra", "estrela", 10);
		
		armazenamentoMock.verificaChamadaRegistra("guerra", "estrela", 10);
	}

}
