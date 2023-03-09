package com.example.GymManagementSystem.controller;

import com.example.GymManagementSystem.Models.Gym;
import com.example.GymManagementSystem.Models.Member;
import com.example.GymManagementSystem.Models.Trainer;
import com.example.GymManagementSystem.service.GymService;
import com.example.GymManagementSystem.service.MemberService;
import com.example.GymManagementSystem.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
     GymService gymService;
    @Autowired
     MemberService memberService;
    @Autowired
     TrainerService trainerService;


    @PostMapping
    public Gym addGym(@RequestBody Gym gym) {
        return gymService.addGym(gym);
    }

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PostMapping("/trainers")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @GetMapping
    public List<Gym> findAllGyms() {
        return gymService.findAllGyms();
    }

    @GetMapping("/{gymId}/members")
    public List<Member> findMembersByTrainerId(@PathVariable Long gymId) {
        Gym gym = gymService.findGymByIdWithMembers(gymId);
        if (gym == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gym not found");
        }
        return gym.getMembers();
    }

    @GetMapping("/trainers")
    public List<Trainer> findAllTrainers() {
        return gymService.findAllTrainers();
    }

    @GetMapping("/most-members")
    public Gym findGymWithMostMembers() {
        return gymService.findGymWithMostMembers();
    }

    @GetMapping("/multi-gym-members")
    public int countMembersWithTrainerInMultipleGyms() {
        return gymService.countMembersWithTrainerInMultipleGyms();
    }

}