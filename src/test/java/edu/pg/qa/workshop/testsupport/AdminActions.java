package edu.pg.qa.workshop.testsupport;

public interface AdminActions {
    void createAdminUser(String username);
    void assignRoleToUser(String username, String role);
}
