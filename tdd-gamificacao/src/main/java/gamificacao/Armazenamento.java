package gamificacao;

import java.util.List;

public interface Armazenamento {

    void registra(String usuario, String tipo, int pontos);

    Pontos obtem(String usuario, String tipo);

    List<String> obtemTiposDePontos(String usuario);


}
