public class Utilizador {

    protected String nome;
    protected String localidade;
    protected int idade;
    protected CamperService mediator;

    public Utilizador(String nome, String localidade, int idade) {
        this.nome = nome;
        this.localidade = localidade;
        this.idade = idade;

    }

    public Utilizador(String nome, String localidade, int idade, CamperService mediator) {
        this.nome = nome;
        this.localidade = localidade;
        this.idade = idade;
        this.mediator = mediator;

    }

    public CamperService getCamperService() {
        return this.mediator;
    }

    public void setCamperService(CamperService mediator) {
        this.mediator = mediator;
    }

    public String toString() {
        return nome;
    }

    

}
