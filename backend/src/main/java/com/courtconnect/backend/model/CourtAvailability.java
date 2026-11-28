package com.courtconnect.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "court_availability")
public class CourtAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Availability date is required")
    @Column(nullable = false)
    private LocalDate availabilityDate;

    @NotNull(message = "Start time is required")
    @Column(nullable = false)
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    @Column(nullable = false)
    private LocalTime endTime;

    @NotNull(message = "Availability status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailabilityStatus status;

    @ManyToOne
    @JoinColumn(name = "court_id", nullable = false)
    private Court court;

    public CourtAvailability() {

    }

    public CourtAvailability(LocalDate availabilityDate, LocalTime startTime, LocalTime endTime,
                             AvailabilityStatus status, Court court) {
        this.availabilityDate = availabilityDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.court = court;
    }

    public Long getId() {
        return id;
    }

    public  LocalDate getAvailabilityDate(){
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public AvailabilityStatus getStatus(){
        return status;
    }

    public void setStatus(AvailabilityStatus status){
        this.status = status;
    }

    public Court getCourt(){
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }


}
