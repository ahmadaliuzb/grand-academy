package uz.grand.grandacademy.entity;

import org.springframework.security.core.GrantedAuthority;
import uz.grand.grandacademy.enums.ERole;
import uz.grand.grandacademy.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "roles")

public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
    public Role(){}

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
