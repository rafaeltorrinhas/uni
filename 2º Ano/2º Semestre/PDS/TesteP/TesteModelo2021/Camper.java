
public class Camper implements ICamper {
    public Estado estado;
    public int lugares;
    public String descricao;
    public Proprietario proprietario;

    public Camper(int lugares, String descricao) {
        this.estado = Estado.Disponivel;
        this.lugares = lugares;
        this.descricao = descricao;
    }

    public Camper(Proprietario p, int lugares, String descricao) {
        this.estado = Estado.Disponivel;
        this.lugares = lugares;
        this.descricao = descricao;
        this.proprietario = p;
    }
    

    @Override
    public void setEstado(Estado e) {
        this.estado = e;
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public int getLugares() {
        return this.lugares;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

}
