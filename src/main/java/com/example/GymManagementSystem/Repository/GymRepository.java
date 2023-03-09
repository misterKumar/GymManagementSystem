package com.example.GymManagementSystem.Repository;

import com.example.GymManagementSystem.Models.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GymRepository extends JpaRepository<Gym,Long> {
    @Query(value = "SELECT g FROM Gym g LEFT JOIN FETCH g.members WHERE g.gymId = :gymId")
    Gym findByIdWithMembers(@Param("gymId") Long gymId);

    @Query(value = "SELECT g FROM Gym g LEFT JOIN FETCH g.trainers WHERE g.gymId = :gymId")
    Gym findByIdWithTrainers(@Param("gymId") Long gymId);

    @Query(value = "SELECT g FROM Gym g LEFT JOIN FETCH g.members")
    List<Gym> findAllWithMembers();

    @Query(value = "SELECT g FROM Gym g LEFT JOIN FETCH g.trainers")
    List<Gym> findAllWithTrainers();

}
