package aula6;

import utility.*;
import java.util.Scanner;

public class Ex02 {

    public static Contacto[] searchContactName(Contacto[] lista, String search) {
        String nome;
        int count = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                nome = lista[i].getPerson().getNome();
                if (nome.equals(search)) {
                    count++;
                }
            }
        }

        Contacto[] result = new Contacto[count];
        int index = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                nome = lista[i].getPerson().getNome();
                if (nome.equals(search)) {
                    result[index] = lista[i];
                    index++;
                }
            }
        }
        return result;
    }

    public static Contacto searchContacto(Contacto[] lista) {
        System.out.println("Search by ID [1] or by Name [2]?");
        int resp = UserInput.getInt("Option ID is choosed by default: ");

        if (resp == 2) {
            String search = UserInput.getString("Name");
            Contacto[] result = searchContactName(lista, search);
            if (result.length == 1) {
                return result[0];
            } else {
                System.out.println("There are multiple contacts with that name. Please choose one: ");
                for (int i = 0; i < result.length; i++) {
                    System.out.println(i + " - \n");
                    Contacto.printContact(result[i]);
                    System.out.println("\n");
                }

                int id = UserInput.getIntBetween("ID:", 0, result.length - 1);
                return result[id];
            }
        } else {
            int id = UserInput.getInt("ID");
            if (lista[id] != null) {
                return lista[id];
            } else {
                System.out.println("Error. Contact not found.");
                return null;
            }
        }
    }

    public static int findContactIndex(Contacto[] lista, Contacto contacto) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (lista[i].equals(contacto)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Contacto[] lista = new Contacto[100];

        int resp, telefone, dianasc, mesnasc, anonasc, cc, index;
        String nome, email;
        String cont = "S";

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n1 - Add Contact");
            System.out.println("2 - Edit Contact");
            System.out.println("3 - Remove Contact");
            System.out.println("4 - Search Contact");
            System.out.println("5 - List Contacts");
            System.out.println("0 - Exit\n>>>");

            resp = input.nextInt();

            switch (resp) {
                case 1:
                    System.out.print("Name: ");
                    nome = input.nextLine();
                    cc = UserInput.getInt("CC");
                    System.out.println("Email: ");
                    email = input.nextLine();
                    telefone = UserInput.getInt("Phone");
                    dianasc = UserInput.getInt("Day of Birth");
                    mesnasc = UserInput.getInt("Month of Birth");
                    anonasc = UserInput.getInt("Year of Birth");

                    DateYMD datanasc = new DateYMD(dianasc, mesnasc, anonasc);
                    Pessoa pessoa = new Pessoa(nome, cc, datanasc);

                    for (int i = 0; i < lista.length; i++) {
                        if (lista[i] != null) {
                            if (lista[i].getPerson().equals(pessoa)) {
                                cont = UserInput.getString(
                                        "This person already exists. Do you want to add a new contact? (Y/N)");
                                break;
                            }
                        }
                    }

                    Contacto contacto = new Contacto(pessoa, email, telefone);

                    if (cont.equals("S")) {
                        lista[Contacto.getId()] = contacto;
                    }
                    break;

                case 2:
                    index = findContactIndex(lista, searchContacto(lista));

                    if (index == -1) {
                        System.out.println("Error. This contact does not exist.");
                        break;
                    } else {
                        System.out.println("Contact Found: " + lista[index].getPerson().getNome());
                        System.out.println("Edit Contact: ");
                        System.out.println("1 - Name");
                        System.out.println("2 - CC");
                        System.out.println("3 - Email");
                        System.out.println("4 - Phone");
                        System.out.println("5 - Date of Birth");
                        System.out.println("0 - Exit\n>>>");

                        resp = input.nextInt();

                        switch (resp) {
                            case 1:
                                nome = UserInput.getString("Name");
                                lista[index].getPerson().setNome(nome);
                                break;
                            case 2:
                                cc = UserInput.getInt("CC");
                                lista[index].getPerson().setCc(cc);
                                break;
                            case 3:
                                email = UserInput.getString("Email");
                                lista[index].setEmail(email);
                                break;
                            case 4:
                                telefone = UserInput.getInt("Phone");
                                lista[index].setTelephone(telefone);
                                break;
                            case 5:
                                dianasc = UserInput.getInt("Day of Birth");
                                mesnasc = UserInput.getInt("Month of Birth");
                                anonasc = UserInput.getInt("Year of Birth");
                                datanasc = new DateYMD(dianasc, mesnasc, anonasc);
                                lista[index].getPerson().setDataNasc(datanasc);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                case 3:
                    index = findContactIndex(lista, searchContacto(lista));

                    if (index == -1) {
                        System.out.println("Error. This contact does not exist.");
                        break;
                    } else {
                        System.out.println("Contact Removed: " + lista[index].getPerson().getNome());
                        lista[index] = null;
                    }
                    break;

                case 4:
                    index = findContactIndex(lista, searchContacto(lista));

                    if (index == -1) {
                        System.out.println("Error. This contact does not exist.");
                        break;
                    } else {
                        System.out.println("Contact Found: ");
                        Contacto.printContact(lista[index]);
                    }
                    break;

                case 5:
                    for (int i = 1; i < lista.length; i++) {
                        if (lista[i] != null) {

                            Contacto.printContact(lista[i]);
                            System.out.println("\n");
                        }
                    }
                    break;

                default:
                    break;
            }

        } while (resp != 0);
        input.close();

    }

}
