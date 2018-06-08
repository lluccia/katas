package gamificacao;

import java.util.List;

public class Placar {

    private Armazenamento armazenamento;
    
    public void setArmazenamento(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }
    
    public void registra(String usuario, String tipo, int pontos) {
        armazenamento.registra(usuario, tipo, pontos);
    }

    public Pontos obtem(String usuario) {
        List<String> tiposDePontos = armazenamento.obtemTiposDePontos(usuario);
        
        for (String tipoDePonto: tiposDePontos)
            return armazenamento.obtem(usuario, tipoDePonto);
        
        return null;
    }

    

}
