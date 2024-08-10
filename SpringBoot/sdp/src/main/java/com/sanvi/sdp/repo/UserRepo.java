package com.sanvi.sdp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanvi.sdp.model.Users;

public interface UserRepo extends JpaRepository<Users,Long>{
   Users findUserByEmail(String email);
}