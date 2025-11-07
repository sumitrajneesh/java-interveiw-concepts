package creational.builder;


public class BuilderMain {
    public static void main(String[] args) {
        User user = new User.UserBuilder("John", "Doe")
                .age(30)
                .email("john.doe@gmail.com")
                .phone("9998887777")
                .address("New York, USA")
                .build();

        System.out.println(user);
    }
}
