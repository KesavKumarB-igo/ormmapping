package com.sprinboot.ormmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprinboot.ormmapping.entity.Profile;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
