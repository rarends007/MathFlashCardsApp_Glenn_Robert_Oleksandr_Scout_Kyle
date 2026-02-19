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
            System.out.println("\n\nissue in .inserQuestionAnswer() \n" + ex + "\n\n");
            return 0;
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
    
    public static HashMap<Integer, QuestionAndAnswer> loadAllQA(){
        HashMap<Integer, QuestionAndAnswer> qa = new HashMap<>();
        //TODO add logic
        return qa;
    }
    
    public static boolean deleteQA(int qa_id){
        //TODO add logic
        return true;
    }
}
