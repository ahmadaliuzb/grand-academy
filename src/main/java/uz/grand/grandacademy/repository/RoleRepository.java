package uz.grand.grandacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.grand.grandacademy.entity.Role;
import uz.grand.grandacademy.enums.ERole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
