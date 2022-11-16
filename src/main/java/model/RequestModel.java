package model;

import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequestModel {
    
    public static Boolean addGame(JSONObject gameJSON){
        //get the data in the JSONObject and add it to the XML
        
        try{
            int ratingInt = gameJSON.getInt("rating");
            RatingEnum rating;
            System.out.println(ratingInt);
            switch (ratingInt) {
                case 1: 
                    rating = RatingEnum.Awful;
                    break;
                case 2:
                    rating = RatingEnum.Bad;
                    break;
                case 3:
                    rating = RatingEnum.Mid;
                    break;
                case 4:
                    rating = RatingEnum.Good;
                    break;
                case 5:
                    rating = RatingEnum.Amazing;
                    break;
                default: return false;
                    
            }
             //= RatingEnum.valueOf(gameJSON.getString("rating"));
            LocalDate startingDate = LocalDate.parse(gameJSON.getString("startingDate"));
            
            Game game;
            
            if(gameJSON.length() == 3){
                game = new Game(gameJSON.getString("title"), rating, startingDate);
            }
            else {
                LocalDate endDate = LocalDate.parse(gameJSON.getString("endDate"));
                game = new Game(gameJSON.getString("title"), rating, startingDate, endDate);
            }

            XmlWriter writer = new XmlWriter();
            writer.write(game);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
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