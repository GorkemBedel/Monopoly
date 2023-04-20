
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;



public class PropertyJsonReader {
    public ArrayList<properties> squares = new ArrayList<properties>();

	 
     public PropertyJsonReader() {
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             
             JSONArray Land = (JSONArray) jsonfile.get("1");
             for(Object i:Land){
            	 Land L = new Land(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost")));
            	 squares.add(L);
            	 //squares.add(new Land(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost"))));     
             }
             
             
             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             for(Object i:RailRoad){
            	 Railroad R = new Railroad(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost")));
            	 squares.add(R);
            	 //squares.add(new Railroad(Integer.parseInt((String)((JSONObject)i).get("id")),(String)((JSONObject)i).get("name"),Integer.parseInt((String)((JSONObject)i).get("cost"))));
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");
             for(Object i:Company){
            	 Company C = new Company(Integer.parseInt((String)((JSONObject)i).get("id")),(String)(((JSONObject)i).get("name")),Integer.parseInt((String)((JSONObject)i).get("cost")));
            	 //squares.add(new Company(Integer.parseInt((String)((JSONObject)i).get("id")),(String)(((JSONObject)i).get("name")),Integer.parseInt((String)((JSONObject)i).get("cost"))));
             }
             
         } catch (IOException e){
             e.printStackTrace();
         } catch (ParseException e){
             e.printStackTrace();
         }
     }
     //You can add function(s) if you want
}