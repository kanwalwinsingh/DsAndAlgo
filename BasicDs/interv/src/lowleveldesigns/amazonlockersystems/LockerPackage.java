package lowleveldesigns.amazonlockersystems;

import java.util.Date;

public class LockerPackage extends  Package{
    private int codeValidDays;
    private String lockerId;
    private String packageId;
    private String packageDeliveryTime;
    private Date packageeliveryTime;

    public boolean isValidCode(){
        return false;
    }
    public boolean verifyCode(String code){
        return false;
    }
}
