package view;

import model.RatingEnum;
import org.json.JSONArray;
import org.json.JSONObject;

public class GamesView {
    
    public static String showGames(JSONArray games) {
        String gamesToString = "You have not completed any games yet.";
        
        if(games.length()!=0){
            gamesToString = "You've completed the following games:\n\n";
            
            for(int i = 0; i < games.length(); i++){
                JSONObject game = games.getJSONObject(i);
                gamesToString += showGame(game);
            }
            
            System.out.println(gamesToString);
        }
        
        return gamesToString;
    }
    
    public static String showGame(JSONObject game){
        String gameToString = "";
        
        gameToString += "TITLE: " + game.getString("title") + ",\n";
        gameToString += "RATING: " + game.getString("rating") + " (" +
                        RatingEnum.valueOf(game.getString("rating")).score + "),\n";
        gameToString += "STARTING DATE: " + game.getString("startingDate") + ";\n\n";
        
        return gameToString;
    }
    
}
