package com.example.GymManagementSystem.Repository;

import com.example.GymManagementSystem.Models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query(value = "SELECT m FROM Member m WHERE m.trainer.trainerId = :trainerId")
    List<Member> findByTrainerId(@Param("trainerId") Long trainerId);
}
