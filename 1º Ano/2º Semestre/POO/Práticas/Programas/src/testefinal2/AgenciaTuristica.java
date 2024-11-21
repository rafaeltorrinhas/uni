package testefinal2;

import java.util.*;

public class AgenciaTuristica {
  String nome;
  String endereço;
  List<Reserva> reservas = new ArrayList<>();
  List<PacoteTuristico> pacotes = new ArrayList<>();

  public AgenciaTuristica(String nome, String endereço) {
    this.nome = nome;
    this.endereço = endereço;
  }

  public Reserva reserva(PacoteTuristico pacoteTuristico, int numPessoas) {
    Reserva reserva = new Reserva(pacoteTuristico, numPessoas);
    reservas.add(reserva);
    return reserva;
  }

  public PacoteTuristico pacoteTuristico(String nome, int nNoites, int precoNoite) {
    PacoteTuristico pacote = new PacoteTuristico(nome, nNoites, precoNoite);
    pacotes.add(pacote);
    return pacote;

  }

  public List<PacoteTuristico> listaPacotes() {
    return pacotes;
  }

  public List<Reserva> listaReservas() {
    return reservas;
  }

  public ArrayList<PacoteTuristico> pacotesPorPreco(int preco) {
    ArrayList<PacoteTuristico> pacoteso = new ArrayList<>();
    for (PacoteTuristico pacote : pacotes) {
      if (pacote.getPreco() <= preco) {
        pacoteso.add(pacote);
      }
    }
    return pacoteso;
  }

  public ArrayList<Reserva> reservasPorPreco() {
    ArrayList<Reserva> reservaso = new ArrayList<>();
    for (Reserva reserva : reservas) {

      reservaso.add(reserva);
    }
    return reservaso;
  }
}
