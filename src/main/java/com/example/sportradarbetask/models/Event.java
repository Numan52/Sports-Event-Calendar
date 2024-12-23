package com.example.sportradarbetask.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private LocalDate date;
    private LocalTime time;
    private String description;
    private int entranceFee;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "_venue_name", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "_venue_address", referencedColumnName = "address", nullable = false)
    })  // an event must have one and only one venue
    private Venue venue;

    @ManyToMany
    @JoinTable(
            name = "event_team",
            joinColumns = @JoinColumn(name = "_event_id"),
            inverseJoinColumns = @JoinColumn(name = "_team_id")
    )
    private List<Team> teams;

    @ManyToOne
    @JoinColumn(name = "_sport", nullable = false)
    private Sport sport;


    public Event() {
    }

    public Event(Long eventId, LocalDate date, String description, int entranceFee, Venue venue, List<Team> teams,
                 LocalTime time, Sport sport) {

        this.eventId = eventId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.entranceFee = entranceFee;
        this.venue = venue;
        this.teams = teams;
        this.sport = sport;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(int entranceFee) {
        this.entranceFee = entranceFee;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> team) {
        this.teams = team;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", entranceFee=" + entranceFee +
                ", venue=" + venue +
                ", teams=" + teams +
                ", sport=" + sport +
                '}';
    }
}
