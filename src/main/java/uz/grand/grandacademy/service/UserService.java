package uz.grand.grandacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.grand.grandacademy.dto.UserDTO;
import uz.grand.grandacademy.entity.Role;
import uz.grand.grandacademy.entity.User;
import uz.grand.grandacademy.enums.ERole;
import uz.grand.grandacademy.repository.RoleRepository;
import uz.grand.grandacademy.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void create(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getPhoneNumber());


        Role roleUser = roleRepository.findByName(ERole.ROLE_USER).get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);


        Set<String> roleNamesString = userDTO.getRoleNames();
        Set<ERole> roleNames = new HashSet<>();
        roleNames.add(ERole.ROLE_USER);
        for (String s : roleNamesString) {
            switch (s) {
                case "ROLE_MODERATOR":
                    roleNames.add(ERole.ROLE_MODERATOR);
                    break;
                case "ROLE_ADMIN":
                    roleNames.add(ERole.ROLE_ADMIN);
                    break;

            }
        }
        if (!roleNames.isEmpty()) {
            for (ERole roleName : roleNames) {
                Role role = roleRepository.findByName(roleName).get();
                if (role.getName() != ERole.ROLE_USER) {
                    userRoles.add(role);
                }
            }

        }


        User registeredUser = userRepository.save(user);
    }

}
