package com.beingskd.user_auth.services;

import com.beingskd.user_auth.entities.Role;
import com.beingskd.user_auth.entities.User;
import com.beingskd.user_auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PermissionService {

    @Autowired
    private UserRepository userRepository;

    public boolean hasPermission(String username, String permissionName) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Set<Role> roles = user.getRoles();

            for (Role role : roles) {
                if (role.getPermissions().stream().anyMatch(permission -> permission.getName().equals(permissionName))) {
                    return true;
                }
            }
        }
        return false;
    }

}

