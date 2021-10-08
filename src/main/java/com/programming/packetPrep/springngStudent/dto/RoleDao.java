package com.programming.packetPrep.springngStudent.dto;


import com.programming.packetPrep.springngStudent.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {
}
