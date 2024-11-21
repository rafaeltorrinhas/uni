package testefinal2;

import java.util.Collection;

public interface IPacoteTuristico {
    PacoteTuristico adicionaServico(Servico servico);

    Collection<String> listaServicos();

    int precoTotal(int numPessoas);
}
