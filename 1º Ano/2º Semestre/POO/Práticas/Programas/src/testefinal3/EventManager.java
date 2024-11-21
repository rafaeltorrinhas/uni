package testefinal3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EventManager {
  public String name;
  ArrayList<Event> events = new ArrayList<>();
  ArrayList<Client> clients = new ArrayList<>();
  ArrayList<String> clientsevents = new ArrayList<>();

  public Event addEvent(Client client, LocalDate localdate) {
    Event event = new Event(localdate);
    events.add(event);
    clientsevents.add(client.getNome());
    return event;
  }

  public Client addClient(String nome, String localidade) {
    Client client = new Client(nome, localidade);
    clients.add(client);
    return client;
  }

  public EventManager(String name) {
    this.name = name;
  }

  public String listClients() {
    return clients.stream().map(Object::toString).collect(Collectors.joining("\n"));
  }

  public String listEvents() {
    return events.stream().map(Object::toString).collect(Collectors.joining("\n"));
  }

  public ArrayList<String> clientsWithEvents() {
    return clientsevents;
  }

  public ArrayList<String> nextEventsByDate() {
    events.sort(Comparator.comparing(Event::getDate));
    ArrayList<String> eventslist = new ArrayList<>();
    for (Event e : events) {
      eventslist.add(String.valueOf(e));
    }
    return eventslist;
  }
}
