
import java.util.ArrayList;
import java.util.List;

public class CamperService implements ICamperService {
    public List<Camper> campers = new ArrayList<>();
    public List<Utilizador> users = new ArrayList<>();

    @Override
    public void registaUtilizador(Utilizador u) {
        users.add(u);
        u.setCamperService(this);
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

    public ICamper registaCamper(Proprietario p, int lugares, String descricao) {
        Camper camper = new Camper(p, lugares, descricao);
        campers.add(camper);
        return camper;
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

    public String registaPedido(Cliente u, ICamper c) {
        c.setEstado(Estado.Reservado);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Pendente";
    }

    public String cancelaPedido(Cliente u, ICamper c) {
        c.setEstado(Estado.Disponivel);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Cancelado";
    }

    public String aceitaPedido(Cliente u, ICamper c) {
        c.setEstado(Estado.Indisponivel);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Aceite";
    }

    public String rejeitaPedido(Cliente u, ICamper c) {
        c.setEstado(Estado.Disponivel);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Rejeitado";
    }

    public String registaDevolucao(Cliente u, ICamper c) {
        c.setEstado(Estado.Disponivel);
        return "";
    }

}
