package cl.java.evaluation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.java.evaluation.model.User;

public interface UserDao extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByEmail(String email);
}
