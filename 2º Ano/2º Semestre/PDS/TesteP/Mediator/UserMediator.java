public class UserMediator implements ChatRoomMediator {

    @Override
    public void sendMessage(String message, User sender) {
        // System.out.println(User.userlist);
        for (User user : User.userlist) {

            if (user != sender) {
                System.out.println("Message '" + message + "' sent to: " + user);
            }
        }
    }

}
