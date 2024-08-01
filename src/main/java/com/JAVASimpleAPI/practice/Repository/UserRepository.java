package com.JAVASimpleAPI.practice.Repository;
import com.JAVASimpleAPI.practice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}

