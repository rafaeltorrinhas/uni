package aula6;

public class Contacto {

    private Pessoa person;
    private String email;
    private int telephone;
    private static int id = 1;

    public Contacto(Pessoa person, String email, int telephone) {
        if (person == null) {
            System.out.println("Erro. Dados da pessoa inválidos.");
        } else {

            if (String.valueOf(telephone).matches("9\\d{8}")) {
                this.telephone = telephone;
            } else {
                this.telephone = 0;
            }

            if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                this.email = email;
            } else {
                this.email = null;
            }
        }
    }

    public static void printContact(Contacto contacto) {
        System.out.println("ID: " + Contacto.getId());
        System.out.println("Name: " + contacto.getPerson().getNome());
        System.out.println("Email: " + contacto.getEmail());
        System.out.println("Phone: " + contacto.getTelephone());

        System.out.println("Date of Birth: " + contacto.getPerson().getDataNasc());
    }

    public Pessoa getPerson() {
        return person;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.person.setNome(name);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public static void setId(int id) {
        Contacto.id = id;
    }
}
