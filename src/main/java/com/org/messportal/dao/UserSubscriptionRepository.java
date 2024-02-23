package com.org.messportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.UserSubscription;


@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

}
