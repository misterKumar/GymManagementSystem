package com.example.GymManagementSystem.service;

import com.example.GymManagementSystem.Models.Trainer;
import com.example.GymManagementSystem.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
     TrainerRepository trainerRepository;

    public Trainer findTrainerById(Long id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        return trainer.orElse(null);
    }

    public Trainer addTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }


}
