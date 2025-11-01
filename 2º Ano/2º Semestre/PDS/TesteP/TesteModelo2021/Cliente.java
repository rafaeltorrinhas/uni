public class Cliente extends Utilizador {
    protected CamperService mediator;

    public Cliente(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
    }

    public Cliente(String nome, String localidade, int idade, CamperService mediator) {
        super(nome, localidade, idade, mediator);
    }

    public void pedido(ICamper c) {
        mediator.registaPedido(this, c);
    }

    public void cancelar(ICamper c) {
        mediator.cancelaPedido(this, c);
    }

}
