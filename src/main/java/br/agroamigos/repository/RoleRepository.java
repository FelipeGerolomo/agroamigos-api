package br.agroamigos.repository;

import br.agroamigos.enums.RoleName;
import br.agroamigos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
