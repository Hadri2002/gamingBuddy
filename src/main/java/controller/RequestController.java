package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import model.RequestModel;
import model.XmlReader;
import view.GamesView;


@Path("application")
public class RequestController{
    
    @GET
    @Path ("getAllGames")
    public Response getAllGames(){
        XmlReader reader = new XmlReader();
        return Response.ok(GamesView.showGames(reader.read())).build();
    }
    
    @GET
    @Path ("getGameRating")
    public Response getGameRating(@QueryParam("game") String title){
        return Response.ok(RequestModel.getGameRating(title)).build();
    }
    
    @POST
    @Path ("addGame")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGame(String json) {
        JSONObject game = new JSONObject(json);
        
        Boolean isNew = RequestModel.isNew(game);
        
        if(isNew == true){
            Boolean result = RequestModel.addGame(game);
            if(result == true){
            return Response.ok("The game has been added to the database").build();
        }
            else {
                return Response.ok("You didn't enter all the necessary parameters to the request's body!").build();
            }
        }
        
        return Response.ok("You have already added that game to the database!").build();
}
    
    
}
