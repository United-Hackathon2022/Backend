package com.hackaton.hackation2022.domain.mentorapplication.doamin.repository;

import com.hackaton.hackation2022.domain.mentorapplication.doamin.MentorApplication;
import com.hackaton.hackation2022.domain.mentorapplication.doamin.MentorApplicationId;
import org.springframework.data.repository.CrudRepository;

public interface MentorApplicationRepository extends CrudRepository<MentorApplication, MentorApplicationId> {
}
