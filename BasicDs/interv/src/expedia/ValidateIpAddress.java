package expedia;

import leetCodeTopInterview.PatternMatching;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateIpAddress {
    public String validIPAddress(String queryIP) {
        if(isValidIPv4(queryIP)){
            return "IPv4";
        }else if(isValidIPv6(queryIP)){
            return "IPv6";
        }else{
            return "Neither";
        }
    }

    private boolean isValidIPv4(String ip){
        if (ip.startsWith("\\.") || ip.endsWith("\\.")) {
            return false;
        }
        String[] parts = ip.split("\\.");
        if(parts.length != 4){
            return false;
        }
        for(String part : parts){
            //Check if each part is a valid integer between 0 and 255
            if(part.isEmpty() || part.length() > 3 || (part.charAt(0) == '0' && part.length() > 1)){
                return false;
            }
            try{
                int value = Integer.parseInt(part);
                if(value < 0 || value > 255){
                    return false;
                }
            }catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String ip){
        if (ip.startsWith(":") || ip.endsWith(":")) {
            return false;
        }
        String[] parts = ip.split(":");
        if(parts.length != 8){
            return false;
        }
        Pattern hexPattern = Pattern.compile("^[0-9a-fA-F]{1,4}$");
        for(String part : parts){
            //Check if each part is valid hexaecimal string of length 1 to 4
            if(!hexPattern.matcher(part).matches()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidateIpAddress validator = new ValidateIpAddress();
        // Example test cases
        System.out.println(validator.validIPAddress("1.1.1.1.")); // IPv4
//        System.out.println(validator.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // IPv6
//        System.out.println(validator.validIPAddress("256.256.256.256")); // Neither
//        System.out.println(validator.validIPAddress("2001:0db8:85a3::8A2E:037j:7334")); // Neither
    }
}
