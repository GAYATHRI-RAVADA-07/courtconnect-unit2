package com.courtconnect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "courts")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Court name is required")
    @Column(nullable = false)
    private String courtName;

    @NotBlank(message = "Sport is required")
    @Column(nullable = false)
    private String sport;

    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "facility_manager_id", nullable = false)
    private FacilityManagerProfile facilityManager;

    public Court() {

    }

    public Court(String courtName, String sport, String location,String status,
                 FacilityManagerProfile facilityManager) {
        this.courtName = courtName;
        this.sport = sport;
        this.location = location;
        this.status = status;
        this.facilityManager = facilityManager;
    }

    public Long getId(){
        return id;
    }

    public String getCourtName(){
        return courtName;
    }

    public void setCourtName(String courtName){
        this.courtName = courtName;
    }

    public String getSport(){
        return sport;
    }

    public void setSport(String sport){
        this.sport = sport;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public FacilityManagerProfile getFacilityManager(){
        return facilityManager;
    }

    public void setFacilityManager(FacilityManagerProfile facilityManager){
        this.facilityManager = facilityManager;
    }


}
