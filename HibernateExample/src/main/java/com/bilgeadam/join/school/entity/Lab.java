package com.bilgeadam.join.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lab {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int labId;
    private String labLokasyon;

    public Lab() {
    }

    public Lab(String labLokasyon) {
        this.labLokasyon = labLokasyon;
    }

    public int getLabId() {
        return this.labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLokasyon() {
        return this.labLokasyon;
    }

    public void setLokasyon(String lokasyon) {
        this.labLokasyon = lokasyon;
    }

    public String toString() {
        return "Lab{labId=" + this.labId + ", lokasyon='" + this.labLokasyon + "'}";
    }
}
