package model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {
            
    public void write(Game newGame) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File("C:\\Adri\\uni\\progmodii\\gamingBuddy\\src\\main\\resources\\gamelibrary.xml");
            Document doc = db.parse(f);
            doc.normalize();
            
            Element root = doc.getDocumentElement();
            Element game = doc.createElement("game");
            root.appendChild(game);
            
            Element title = doc.createElement("title");
            Element rating = doc.createElement("rating");
            Element startingDate = doc.createElement("startingDate");
            Element endDate = doc.createElement("endDate");
            
            title.setTextContent(newGame.getTitle());
            rating.setTextContent(newGame.getRating().toString());
            startingDate.setTextContent(newGame.getStartingDate().toString());
            endDate.setTextContent(newGame.getEndDate().toString());
            
            game.appendChild(title);
            game.appendChild(rating);
            game.appendChild(startingDate);
            game.appendChild(endDate);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            
            t.transform(source, result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}