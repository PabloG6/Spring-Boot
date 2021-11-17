package com.propfile.profile.repository;

import com.propfile.profile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //User findByEmail(String email);
    Optional<User> findById(Long id);

    //Jpa findByEmail does not work with findById so a custom query has to be used
    @Query("FROM User WHERE email = ?1")
    User findByEmail(String email);
}
