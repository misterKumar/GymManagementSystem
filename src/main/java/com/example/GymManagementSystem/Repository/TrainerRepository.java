package com.example.GymManagementSystem.Repository;

import com.example.GymManagementSystem.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    @Query(value = "SELECT t FROM Trainer t LEFT JOIN FETCH t.gyms WHERE t.trainerId = :trainerId")
    Trainer findByIdWithGyms(@Param("trainerId") Long trainerId);

    @Query(value = "SELECT t FROM Trainer t LEFT JOIN FETCH t.members WHERE t.trainerId = :trainerId")
    Trainer findByIdWithMembers(@Param("trainerId") Long trainerId);

    @Query(value = "SELECT t FROM Trainer t LEFT JOIN FETCH t.gyms")
    List<Trainer> findAllWithGyms();

}
