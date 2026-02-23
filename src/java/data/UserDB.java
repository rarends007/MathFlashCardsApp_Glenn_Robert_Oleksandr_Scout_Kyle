/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
//import scc.Admin;
//import scc.Parent;

import BaseClasses.User;
import util.PasswordUtil;

/**
 *
 * @author raren
 */
public class UserDB {

    // Registration db Functions start 
    public static int insertUser(User user) { //Accepts any User type - Student, Parent, Teacher, or Admin 
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql
                = "INSERT INTO user "
                + "(username, password, salt, first_name, middle_name, last_name, role)"
                + " VALUES "
                + "(?,?,?,?,?,?,?);";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            try {
                String hashedPassword = PasswordUtil.hashAndSaltPassword(user.getPassword()); //I don't want anything entered if the password doesn't hash right.

                String[] splitPass = hashedPassword.split("----Delim----"); //https://stackoverflow.com/questions/8547940/splitting-strings-based-on-a-delimiter

                String salt = splitPass[1];
                hashedPassword = splitPass[0];

                ps.setString(2, hashedPassword);
                ps.setString(3, salt);
                ps.setString(4, user.getFirstName());
                ps.setString(5, user.getMiddleName());
                ps.setString(6, user.getLastName());
                ps.setString(7, user.getRole());
                return ps.executeUpdate();
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Failure hashing password.");
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException in registerAdmin: " + ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static boolean usernameExists(String username) { // - if true then username exists
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT username"
                + " FROM user"
                + " WHERE username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("\n\nError in AminDB -> usernameExsists function: \n" + ex + "\n\n");
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    // Registration db Functions End
    //Delete - with this delete style, data can be retained, even for a deleted user, later any null users can be removed by a db admin if desired.
    public static int deleteUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql
                = "UPDATE user "
                + "SET username = CONCAT('deleted', '--', ?) " //spaces required, else sql error
                + "WHERE username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, username);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException in registerAdmin: " + ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
    //Delete End

    public static User loginUser(String username, String password, ArrayList message)
            throws NoSuchAlgorithmException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        User user = null;

        String sql = "SELECT * "
                + " FROM user"
                + " WHERE username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.next();

            String salt = rs.getString("salt");

            String hashedPass = PasswordUtil.hashPassword(password + salt);
            String retrievedPass = rs.getString("password");

            if (usernameExists(username)) {
                if (hashedPass.equals(retrievedPass)) { //TODO: will need portals for all 4 user types NOte: hash the entered password and compare
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    String lastName = rs.getString("last_name");
                    String role = rs.getString("role");

                    user = new User();
                    user.setUsername(username);
                    user.setFirstname(firstName);
                    user.setMiddlename(middleName);
                    user.setLastname(lastName);
                    user.setRole(role);
                    user.setPassword(password); //maybe I will change this to only store the hashed password later, not sure

                }
            } else {
                message.add("There is no account with this username.");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("\n\nError in AminDB -> usernameExsists function: \n" + ex + "\n\n");
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public static ArrayList getAParentsChildren(String username) { //only call after Parent user created and verified
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList arrayList = new ArrayList();

        String sql = "SELECT student_username "
                + " FROM parent_student"
                + " WHERE username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                arrayList.add(rs.getString("student_username"));
            }

            return arrayList;
        } catch (SQLException ex) {
            System.out.println("\n\nError in AminDB -> usernameExsists function: \n" + ex + "\n\n");
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList getUserClass(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList arrayList = new ArrayList();

        String sql = "SELECT class_id "
                + " FROM user_class"
                + " WHERE username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                arrayList.add(rs.getString("class_id"));
            }
               

            return arrayList;
        } catch (SQLException ex) {
            System.out.println("\n\nError in AminDB -> usernameExsists function: \n" + ex + "\n\n");
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

}
