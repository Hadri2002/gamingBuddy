package model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlReader {
    
    public JSONArray read() {
        JSONArray games = new JSONArray();
        
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File("C:\\Adri\\uni\\progmodii\\gamingBuddy\\src\\main\\resources\\gamelibrary.xml");
            Document doc = db.parse(f);
            doc.normalize();
            
            NodeList nodeList = doc.getElementsByTagName("game");
            for(int i = 0; i < nodeList.getLength(); i++){
                Element el = (Element) nodeList.item(i);
                JSONObject game = new JSONObject();
                
                    String title = el.getElementsByTagName("title").item(0).getTextContent();
                    String rating = el.getElementsByTagName("rating").item(0).getTextContent();
                    String startingDate = el.getElementsByTagName("startingDate").item(0).getTextContent();
                    String endDate = el.getElementsByTagName("endDate").item(0).getTextContent();
                    
                    game.put("title", title);
                    game.put("rating", rating);
                    game.put("startingDate", startingDate);
                    game.put("endDate", endDate);
                
                games.put(game);
            }
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return games;
    }  
    
}
