package com.example.GymManagementSystem.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gym")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gymId;

    private String location;

    @OneToMany(mappedBy = "gym")
    private List<Member> members;

    @ManyToMany(mappedBy = "gyms")
    private List<Trainer> trainers;

    public Gym() {
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
