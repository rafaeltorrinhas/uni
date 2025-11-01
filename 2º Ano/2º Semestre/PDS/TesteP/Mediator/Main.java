public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        ChatRoomMediator med = new UserMediator();

        med.sendMessage("A", u3);
        med.sendMessage("B", u2);
        med.sendMessage("C", u1);
    }
}
