package lowleveldesigns.microsoftteams;

import java.util.UUID;

public abstract class Notification {
    private UUID id;
    private String message;
    private User user;

    public abstract void send();

}

class EmailNotification extends Notification{

    @Override
    public void send() {

    }
}

class SMSNotification extends Notification{

    @Override
    public void send() {

    }
}
