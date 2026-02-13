/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.sql.*;

import scc.Admin;
import scc.User;

/**
 *
 * @author raren
 */
public class UserDB {
    
    // Registration db Functions start 
    public static int insertUser(User user){ //Accepts any User type - Student, Parent, Teacher, or Admin
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String sql = 
                "INSERT INTO user "
                +"(username, password, first_name, middle_name, last_name, role)"
                + " VALUES " +
                "(?,?,?,?,?,?);";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getMiddleName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getRole() );
            return ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println("SQLException in registerAdmin: " + ex);
            return 0;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    
    public static boolean usernameExists(String username){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT username"
                + "FROM user"
                + "WHERE username = ?";
        
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException ex){
            System.out.println("\n\nError in AminDB -> usernameExsists function: \n" + ex + "\n\n");
            return false;
        }finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    // Registration db Functions start
    
}
