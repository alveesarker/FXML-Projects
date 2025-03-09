package com.example.movieticketbookingsystem;

import java.time.LocalDate;

public class Movie {
    private String movieName;
    private String genre;
    private LocalDate showDate;

    public String getSeatAvailability() {
        return seatAvailability;
    }

    private String seatAvailability;
    private int totalSeats;

    public Movie() {
    }

    public Movie(String movieName, String genre, LocalDate showDate, String seatAvailability, int totalSeats) {
        this.movieName = movieName;
        this.genre = genre;
        this.showDate = showDate;
        this.seatAvailability = seatAvailability;
        this.totalSeats = totalSeats;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public String setSeatAvailability() {
        return seatAvailability;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", showDate=" + showDate +
                ", seatAvailability=" + seatAvailability +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
