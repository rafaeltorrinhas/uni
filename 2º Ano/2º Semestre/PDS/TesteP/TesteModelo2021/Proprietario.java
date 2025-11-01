public class Proprietario extends Utilizador {
    protected CamperService mediator;

    public Proprietario(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
    }

    public Proprietario(String nome, String localidade, int idade, CamperService mediator) {
        super(nome, localidade, idade, mediator);
    }

    public void aceitar(Cliente cl, ICamper c) {
        mediator.aceitaPedido(cl, c);

    }

    public void rejeitar(Cliente cl, ICamper c) {
        mediator.rejeitaPedido(cl, c);
    }

}
