package com.example.GymManagementSystem.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    @OneToMany(mappedBy = "trainer")
    private List<Member> members;

    @ManyToMany
    @JoinTable(
            name = "trainer_gym",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    private List<Gym> gyms;

    public Trainer() {
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(List<Gym> gyms) {
        this.gyms = gyms;
    }
}
