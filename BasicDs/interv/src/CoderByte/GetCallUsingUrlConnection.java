package CoderByte;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetCallUsingUrlConnection {
  public static class Person {
      public String name;
      public int age;
      public List<String> hobbies = new ArrayList<>();
      Person(){

      }

  }

  public static String getStringFromStream(final InputStream inputStream)  {
      String result = null;
      try(BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8" ))) {
          result = streamReader.lines().collect(Collectors.joining("\n"));
      } catch (IOException e) {
          e.printStackTrace();
          return null;
      }finally {
          try {
              if(inputStream != null) {
                  inputStream.close();
              }
          }catch (IOException ioException){
              ioException.printStackTrace();
          }
      }
      return result;
  }

  public static String fillPersonObject(String jsonString){

      //Split the key-value pairs
      jsonString = jsonString.substring(1,jsonString.length()-1);
      String[] keyValuePairs = jsonString.split(",");
      Person person = new Person();
      for (String  pair : keyValuePairs){
            //split the key value pair
          String[] entry = pair.split(":");
          String key = entry[0].replace("\"","");
          String value = entry[1].trim();
          switch (key){
              case "name":
                  person.name = value.replace("\"","");
                  break;
              case "age":
                  person.age = Integer.parseInt(value);
                  break;
              case "hobbies":
                  value = value.substring(1, value.length() - 1); // Remove square brackets
                  String[] hobbiesArray = value.split(",");
                  List<String> hobbiesList = new ArrayList<>();
                  for (String hobby : hobbiesArray) {
                      hobbiesList.add(hobby.replace("\"", "").trim());
                  }
                  person.hobbies = hobbiesList;
                  break;

          }
      }
        return person.hobbies.toString();
  }

    public static void main(String[] args) {
      //  System.setProperties("http.agent","Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            URLConnection connection = url.openConnection();
           InputStream inputStream =  connection.getInputStream();
           String result = getStringFromStream(inputStream);
            fillPersonObject(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
