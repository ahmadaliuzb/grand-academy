package uz.grand.grandacademy.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.grand.grandacademy.entity.Role;
import uz.grand.grandacademy.entity.User;
import uz.grand.grandacademy.enums.ERole;
import uz.grand.grandacademy.repository.RoleRepository;
import uz.grand.grandacademy.repository.UserRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class Runner1 implements ApplicationRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleUser = new Role();
        roleUser.setName(ERole.ROLE_USER);
        roleUser.setCreated(new Date());
        Role roleAdmin = new Role();
        roleAdmin.setName(ERole.ROLE_ADMIN);
        roleAdmin.setCreated(new Date());
        Role roleModerator = new Role();
        roleModerator.setName(ERole.ROLE_MODERATOR);
        roleModerator.setCreated(new Date());

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleModerator);

        //---------------------------//

        //Admin settings
        User superUser = new User();
        superUser.setName("admin");
        superUser.setPassword(passwordEncoder.encode("ahmadali1976"));

        Set<Role> superUserRoles = new HashSet<>();
        superUserRoles.add(roleUser);
        superUserRoles.add(roleModerator);
        superUserRoles.add(roleAdmin);
        superUser.setRoles(superUserRoles);
        userRepository.save(superUser);
    }
}
