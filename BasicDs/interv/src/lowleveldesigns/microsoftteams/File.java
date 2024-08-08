package lowleveldesigns.microsoftteams;

import java.util.UUID;

public class File {
    private UUID id;
    private String name;
    private String url;
    private long size;
}
class FileManager {
    public void uploadFile(File file){}
    public File downloadFile(){ return new File();}
}
