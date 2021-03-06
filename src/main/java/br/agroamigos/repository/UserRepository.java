package br.agroamigos.repository;

import br.agroamigos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

//    Optional<User> findOneb(Long idUser);

//    List<User> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);
}
