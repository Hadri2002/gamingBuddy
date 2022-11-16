package model;

public enum RatingEnum {
    Awful(1), Bad(2), Mid(3), Good(4), Amazing(5);
    
    public final int score;
    
    private RatingEnum (int score){
        this.score = score;
    }  
}