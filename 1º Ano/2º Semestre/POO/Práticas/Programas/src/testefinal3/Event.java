package testefinal3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Event implements IEvent {

  LocalDate data;
  ArrayList<Activity> listaAtividades = new ArrayList<>();

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public ArrayList<Activity> getListaAtividades() {
    return listaAtividades;
  }

  public void setListaAtividades(ArrayList<Activity> listaAtividades) {
    this.listaAtividades = listaAtividades;
  }

  public Event(LocalDate data) {
    this.data = data;
  }

  @Override
  public Event addActivity(Activity activity) {
    listaAtividades.add(activity);
    return this;
  }

  @Override
  public LocalDate getDate() {
    return data;
  }

  @Override
  public double totalPrice() {
    int total = 0;
    for (Activity a : listaAtividades) {
      total += a.getPrice() * a.getNumPessoas();
    }
    return total;
  }

  @Override
  public String toString() {
    return "\nEvento em " + data + ", total=" + totalPrice() + " euros\n"
        + listaAtividades.stream().map(Object::toString).collect(Collectors.joining("\n"));
  }

}
