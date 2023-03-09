package com.example.GymManagementSystem.service;

import com.example.GymManagementSystem.Models.Member;
import com.example.GymManagementSystem.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;


    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
}
