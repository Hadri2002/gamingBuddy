package model;

import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequestModel {
    
    public static Boolean addGame(JSONObject gameJSON){
        //get the data in the JSONObject and add it to the XML
        
        try{
            RatingEnum rating = RatingEnum.valueOf(gameJSON.getString("rating"));
            LocalDate startingDate = LocalDate.parse(gameJSON.getString("startingDate"));
            Game game = new Game(gameJSON.getString("title"), rating, startingDate);

            XmlWriter writer = new XmlWriter();
            writer.write(game);
        }
        catch(Exception ex){
            ex.getMessage();
            return false;
        }
            return true;
        }
    
    
    public static Boolean isNew(JSONObject gameJSON) {
        Boolean result = true; //it's true if it's new, false if it already exists
        
        XmlReader reader = new XmlReader();
        JSONArray games = reader.read();
            
            for(int i = 0; i < games.length(); i++){
                JSONObject game = games.getJSONObject(i);
                if(game.get("title").equals(gameJSON.get("title"))) {
                    result = false;
                    break;
                }
            }
        
        return result;
    }
    
    public static String getGameRating(String title){
        String rating = "The game you entered is not in the database of completed games!";
        
        XmlReader reader = new XmlReader();
        JSONArray games = reader.read();
        
        for(int i = 0; i < games.length(); i++){
            JSONObject game = games.getJSONObject(i);
            if(game.get("title").equals(title)){
                rating = "The rating of " + title + " is: " + 
                        game.getString("rating") + " (" + RatingEnum.valueOf(game.getString("rating")).score + ")";
                break;
            }
        }
        
        return rating;
    }
}
