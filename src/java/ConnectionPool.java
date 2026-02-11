/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raren
 */

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/scc"); //The end of the string of the datasource is scc and MUST be scc, or what ever is defined in the context.xml resource name, we are sticking with scc for now. 
            
        }catch(NamingException ex) {
            System.out.println("\n\nError in Connection pool NamingException:    " + ex + "\n\n");
        }
    }
    

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        
        return pool;
    }
    
    
}
