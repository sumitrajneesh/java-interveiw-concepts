package creational.factory.notification;

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification("EMAIL");
        notification.notifyUser();
    }
}
