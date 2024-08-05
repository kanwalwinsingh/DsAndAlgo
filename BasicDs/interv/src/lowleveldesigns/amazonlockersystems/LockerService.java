package lowleveldesigns.amazonlockersystems;

import java.util.List;
import java.util.Stack;

public class LockerService {
    private List<LockerLocation> locations;
    private static  LockerService lockerService;

    public static LockerService getInstance(){
        if(lockerService == null){
            lockerService = new LockerService();
        }
        return lockerService;
    }
}
