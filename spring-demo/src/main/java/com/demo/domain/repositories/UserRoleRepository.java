package com.demo.domain.repositories;

import com.demo.domain.valueobjects.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
