package expedia;
import java.util.*;
public class FolderNames {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> nameMap = new HashMap<>();
        String[] result = new String[names.length];

        for(int i = 0; i< names.length; i++){
            String name = names[i];
            if(!nameMap.containsKey(name)){
                //If name is not taken, use it and initalize its counter
                result[i] = name;
                nameMap.put(name,1);
            }else{
                // if name is taken, find the next available suffix
                int k = nameMap.get(name);
                String newName = name + "("+k+")";
                while (nameMap.containsKey(newName)){
                    k++;
                    newName = name+"("+k+")";
                }
                result[i] = newName;
                nameMap.put(name, k+1); //Update the next available name
                nameMap.put(newName,1); //Track the new name
            }
        }
        return result;
    }
    public String[] getFolderNamesOptimized(String[] names){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i< names.length; i++){
            String current = names[i];
            while (map.containsKey(current)){
                int count = map.get(names[i]);
                count += 1;
                map.put(names[i],count);
                StringBuilder sb = new StringBuilder();
                sb.append(current);
                sb.append("(");
                sb.append(count);
                sb.append(")");
                current = sb.toString();
            }
            map.put(current,0);
            names[i] = current;
        }
        return names;
    }
    public static void main(String[] args) {
        FolderNames solution = new FolderNames();
        String[] names = {"gfg", "gfg", "gfg", "code", "gfg(1)"};
        String[] result = solution.getFolderNamesOptimized(names);
        for (String name : result) {
            System.out.println(name);
        }
    }
}
