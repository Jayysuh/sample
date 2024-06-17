package com.GLAB309_8_1.service;

import com.GLAB309_8_1.models.Role;

import java.util.List;
public interface RoleService {
    public void saveRole(Role role);
    public Role findRoleByRoleName(String name);
    public List<Role> getAllRoles();
    public List<Role> getRolesByUser(long id);
}
