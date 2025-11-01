import java.util.ArrayList;
import java.util.List;

public class BasicCamperService implements ICamperService {

    public List<Camper> campers = new ArrayList<>();
    public List<Utilizador> users = new ArrayList<>();

    @Override
    public void registaUtilizador(Utilizador u) {
        users.add(u);
    }

    @Override
    public ICamper registaCamper(int lugares, String descricao) {
        Camper camper = new Camper(lugares, descricao);
        campers.add(camper);
        return camper;
    }

    @Override
    public String registaAluguer(Cliente u, ICamper c) {
        c.setEstado(Estado.Indisponivel);
        return "Utilizador " + u.toString() + " alugou " + c.getDescricao();
    }

    @Override
    public String terminaAluguer(Cliente u, ICamper c) {
        c.setEstado(Estado.Disponivel);
        return "Utilizador " + u.toString() + " devolveu " + c.getDescricao();
    }

    @Override
    public List<Camper> getCampersDisponiveis() {
        List<Camper> campersDisp = new ArrayList<>();

        for (Camper c : campers) {
            if (c.getEstado() == Estado.Disponivel) {
                campersDisp.add(c);
            }
        }
        return campersDisp;
    }

}
