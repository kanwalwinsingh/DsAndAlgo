package lowleveldesigns.microsoftteams;

import java.util.UUID;

public class Team {
    public void addMember(){}
}

class Membership {
    private User user;
    private Team team;
}

class Channel {
    private UUID id;
    private  String name;
    private Team team;
}
