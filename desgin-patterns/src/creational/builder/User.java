package creational.builder;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;

    // private constructor (only builder can access)
    User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    // Static inner Builder class
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) { // required fields
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName + ", " + age + " years, " + email + "phone, " + phone;
    }
}
