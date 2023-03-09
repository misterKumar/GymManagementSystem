package com.example.GymManagementSystem.service;

import com.example.GymManagementSystem.Models.Gym;
import com.example.GymManagementSystem.Models.Member;
import com.example.GymManagementSystem.Models.Trainer;
import com.example.GymManagementSystem.Repository.GymRepository;
import com.example.GymManagementSystem.Repository.MemberRepository;
import com.example.GymManagementSystem.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GymService {
    @Autowired
    GymRepository gymRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TrainerRepository trainerRepository;

    public Gym addGym(Gym gym) {
        return gymRepository.save(gym);
    }

    public List<Gym> findAllGyms() {
        return gymRepository.findAll();
    }

    public List<Member> findMembersByTrainerId(Long trainerId) {
        return memberRepository.findByTrainerId(trainerId);
    }

    public List<Trainer> findAllTrainers() {
        return trainerRepository.findAll();
    }

    public Gym findGymWithMostMembers() {
        List<Gym> gyms = gymRepository.findAllWithMembers();
        Gym gymWithMostMembers = null;
        int maxMemberCount = 0;
        for (Gym gym : gyms) {
            int memberCount = gym.getMembers().size();
            if (memberCount > maxMemberCount) {
                maxMemberCount = memberCount;
                gymWithMostMembers = gym;
            }
        }
        return gymWithMostMembers;
    }

    public int countMembersWithTrainerInMultipleGyms() {
        List<Trainer> trainers = trainerRepository.findAllWithGyms();
        int count = 0;
        for (Trainer trainer : trainers) {
            if (trainer.getGyms().size() > 1) {
                count += trainer.getMembers().size();
            }
        }
        return count;
    }

    public Gym findGymByIdWithMembers(Long gymId) {
        Gym gym=gymRepository.findById(gymId).get();
        return gym;
    }
}
