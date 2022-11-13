package model;

import java.time.LocalDate;

public class Game {
    
    private String title;
    private RatingEnum rating;
    private LocalDate startingDate;

    public Game() {
    }

    public Game(String title, RatingEnum rating, LocalDate startingDate) {
        this.title = title;
        this.rating = rating;
        this.startingDate = startingDate;
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

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }
    
    
}
