package com.eCommerceWeb.eCommerceWeb.repository;

import com.eCommerceWeb.eCommerceWeb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findById(int id);
    User findByEmail(String email);

}
