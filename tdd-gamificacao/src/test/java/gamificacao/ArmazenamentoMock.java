package gamificacao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmazenamentoMock implements Armazenamento {
	
	private String registraUsuario;
	private String registraTipo;
	private int registraPontos;

	private String obtemUsuario;
	private String obtemTiposDePontosUsuario;
	private String obtemTipo;
	private List<String> obtemTiposDePontos;
	private Map<String, Pontos> obtemPontos = new HashMap<>();

	@Override
	public void registra(String usuario, String tipo, int pontos) {
		registraUsuario = usuario;
		registraTipo = tipo;
		registraPontos = pontos;
	}
	
	@Override
	public List<String> obtemTiposDePontos(String usuario) {
		obtemTiposDePontosUsuario = usuario;
		return obtemTiposDePontos;
	}
	
	@Override
	public Pontos obtem(String usuario, String tipo) {
		this.obtemUsuario = usuario;
		this.obtemTipo = tipo;
		return obtemPontos.get(tipo);
	}
	
	public void verificaChamadaRegistra(String usuario, String tipo, int pontos) {
		assertThat("registraUsuario", registraUsuario, is(usuario));
		assertThat("registraTipo", registraTipo, is(tipo));
		assertThat("registraPontos", registraPontos, is(pontos));
		
	}

	public void verificaChamadaObtem(String usuario, String tipo) {
		assertThat("obtemUsuario", obtemUsuario, is(usuario));
		assertThat("obtemTipo", obtemTipo, is(tipo));
	}

	public void verificaChamadaObtemTiposDePontos(String usuario) {
		assertThat("obtemTiposDePontosUsuario", obtemTiposDePontosUsuario, is(usuario));
	}
	
	public void devolverPontos(String tipo, Pontos pontos) {
		this.obtemPontos.put(tipo, pontos) ;
	}

	public void devolverTiposDePontos(String... tipos) {
		this.obtemTiposDePontos = Arrays.asList(tipos);
	}

}
