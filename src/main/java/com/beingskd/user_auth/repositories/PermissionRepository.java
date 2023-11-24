package com.beingskd.user_auth.repositories;

import com.beingskd.user_auth.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}

