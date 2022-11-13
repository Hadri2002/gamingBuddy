package model;

import java.time.LocalDate;

public class Game {
    
    private String title;
    private RatingEnum rating;
    private LocalDate startingDate;
    private LocalDate endDate;

    public Game() {
    }

    public Game(String title, RatingEnum rating, LocalDate startingDate) {
        this.title = title;
        this.rating = rating;
        this.startingDate = startingDate;
        this.endDate = LocalDate.now();
    }

    public Game(String title, RatingEnum rating, LocalDate startingDate, LocalDate endDate) {
        this.title = title;
        this.rating = rating;
        this.startingDate = startingDate;
        
        if(endDate.isAfter(startingDate)){
            this.endDate = endDate;
        }
        else{
            this.endDate = LocalDate.now();
        }
        
    }

    public String getTitle() {
        return title;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }  
    
}
