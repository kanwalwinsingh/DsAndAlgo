package lowleveldesigns.microsoftteams;

import nikhil_lohia.LongestCommonSubsequence;

import java.util.Date;
import java.util.UUID;

public class Chat {
    private UUID id;
    private String name;
    public void addMessage(Message message){}
}

class Message {
    private UUID id;
    private String content;
    private Date timeStamp;

    public void addAtachment(Attachment file){}
}

class Attachment {
    private UUID id;
    private String url;
    private Long size;
}
