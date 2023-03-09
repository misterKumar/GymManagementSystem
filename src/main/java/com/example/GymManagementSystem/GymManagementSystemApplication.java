package com.example.GymManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManagementSystemApplication.class, args);
	}
}
	/*
		Api -url
	 s.no|Type  | 			functionality 					| url
		1.POST -- add gym									-->http://localhost:9998/gyms
		2.POST -- add Members								-->http://localhost:9998/gyms/members
		3.Post -- add Trainers								-->http://localhost:9998/gyms/trainers
		4.GET -- get all gyms								-->http://localhost:9998/gyms
		5.GET -- Get members of a specific gym -			->http://localhost:9998/gyms/{gymId}/members
		6.GET -- Get all trainers 							-->http://localhost:9998/gyms/trainers
		7.GET -- Get gym with most members 					-->GET http://localhost:9998/gyms/most-members
		8.GET -- Count members with trainer in multiple gyms -->GET http://localhost:9998/gyms/multi-gym-members
 	*/
