package gamificacao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PlacarTest {
    
    private Placar placar;
    private ArmazenamentoMock armazenamentoMock;

    @Before
    public void setup() {
        placar = new Placar();
        
        armazenamentoMock = new ArmazenamentoMock();
        placar.setArmazenamento(armazenamentoMock);
    }
    
    @Test
    public void registroDePontos() {
        placar.registra("guerra", "estrela", 10);
        
        armazenamentoMock.verificaChamadaRegistra("guerra", "estrela", 10);
    }
    
    @Test
    public void obtencaoDePontos() {
        armazenamentoMock.devolverTiposDePontos("estrela", "topico");
        armazenamentoMock.devolverPontos("estrela", new Pontos("estrela", 10));
        
        Pontos pontos = placar.obtem("guerra");
        
        armazenamentoMock.verificaChamadaObtemTiposDePontos("guerra");
        armazenamentoMock.verificaChamadaObtem("guerra", "estrela");
        
        assertThat(pontos, is(notNullValue()));
        assertThat(pontos.getTipo(), is("estrela"));
        assertThat(pontos.getQuantidade(), is(10));
    }

}
