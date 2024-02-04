package cl.java.evaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.java.evaluation.model.Phone;

public interface PhoneDao extends JpaRepository<Phone, Long> {

    // List<Phone> findById_user(Long id_user);
}
