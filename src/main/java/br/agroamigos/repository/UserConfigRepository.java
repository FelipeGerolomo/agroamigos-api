package br.agroamigos.repository;


import br.agroamigos.model.User;
import br.agroamigos.model.UserConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserConfigRepository extends JpaRepository<UserConfig, Long> {
    Page<UserConfig> findAll(Pageable pageable);

    Page<UserConfig> findByIdUser(Optional<User> userId, Pageable pageable);
}
