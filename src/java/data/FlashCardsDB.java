/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import java.sql.*;
import java.util.HashMap;
import scc.QuestionAndAnswer;


/**
 *
 * @author raren
 */
public class FlashCardsDB {
    
    public static int insertQuestionAnswer(QuestionAndAnswer qa){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String sql = 
                """
                     INSERT INTO qa 
                     (question, answer, points, difficulty) 
                     VALUES 
                     (?, ?, ?, ?); 
                """;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, qa.getQuestion());
            ps.setString(2, qa.getAnswer());
            ps.setDouble(3, qa.getPoints());
            ps.setInt(4, qa.getDifficulty());
            
            return ps.executeUpdate();
            
        }catch (SQLException ex){
            System.out.println("\n\nissue in .insertQuestionAnswer() \n" + ex + "\n\n");
            return 0;
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    /**
     * 
     * @param qaHashMap : A reference object HashMap<Integer, QuestionAndAnswer> to be passed that will populate with any values added in the db call.
     * @return description: Returns a value of true if there were no issues, if there was an issue, returns a value of false. 
     */
    public static boolean loadAllQA(HashMap<Integer, QuestionAndAnswer> qaHashMap){
        //HashMap<Integer, QuestionAndAnswer> qaHashMap = new HashMap<>(); hashmap is reference, so this isn't needed -RA
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean isLoaded = false; //tracked bool
        
        String sql = 
                """
                   SELECT *
                   FROM qa;
                """;
        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("qa_id");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                double points = rs.getDouble("points");
                int difficulty = rs.getInt("difficulty");
                
                QuestionAndAnswer qa = new QuestionAndAnswer(id, question, answer, difficulty, points);
                
                qaHashMap.put(qa.id, qa);
                isLoaded = true;
                
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.out.print("RA -> issue in -> loadAllQA() -> " +  ex);
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return isLoaded;
        
    }
    
    public static boolean deleteQA(int qa_id){
        //TODO add logic
        return true;
    }
}
