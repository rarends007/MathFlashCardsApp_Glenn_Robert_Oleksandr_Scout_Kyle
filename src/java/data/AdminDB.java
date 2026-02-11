/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.sql.*;

import scc.Admin;

/**
 *
 * @author raren
 */
public class AdminDB {
    
    public static int insertAdmin(Admin admin){
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
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getFirstName());
            ps.setString(4, admin.getMiddleName());
            ps.setString(5, admin.getLastName());
            ps.setString(6, "ADM" );
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
    
}
