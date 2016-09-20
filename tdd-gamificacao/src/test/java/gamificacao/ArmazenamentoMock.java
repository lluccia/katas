package gamificacao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArmazenamentoMock implements Armazenamento {
	
	private String registraUsuario;
	private String registraTipo;
	private int registraPontos;

	@Override
	public void registra(String usuario, String tipo, int pontos) {
		this.registraUsuario = usuario;
		this.registraTipo = tipo;
		this.registraPontos = pontos;
	}
	
	public void verificaChamadaRegistra(String usuario, String tipo, int pontos) {
		assertThat("registraUsuario", registraUsuario, is(usuario));
		assertThat("registraTipo", registraTipo, is(tipo));
		assertThat("registraPontos", registraPontos, is(pontos));
		
	}
}
