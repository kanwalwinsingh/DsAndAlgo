package lowleveldesigns.microsoftteams;

import java.util.Date;
import java.util.UUID;

public class VideoCall {
    private UUID id;
    private String link;
    private Date startTime;
}

class Participant {
    private UUID id;
    private User user;
    private VideoCall videoCall;
}

class SearchService{
    public void search(){}
}