package uz.grand.grandacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.grand.grandacademy.entity.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends JpaRepository<User, Integer> {

}
