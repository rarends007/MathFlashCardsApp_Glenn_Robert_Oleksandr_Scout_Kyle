/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import BaseClasses.Assessment;
import java.sql.*;
import java.util.HashMap;
import scc.Drill;
import scc.QuestionAndAnswer;

/**
 *
 * @author raren
 */
public class FlashCardsDB {

    public static int insertQuestionAnswer(QuestionAndAnswer qa) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql
                = """
                     INSERT INTO qa 
                     (question, answer, points, difficulty) 
                     VALUES 
                     (?, ?, ?, ?); 
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, qa.getQuestion());
            ps.setString(2, qa.getAnswer());
            ps.setDouble(3, qa.getPoints());
            ps.setInt(4, qa.getDifficulty());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("\n\nissue in .insertQuestionAnswer() \n" + ex + "\n\n");
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    /**
     *
     * @param qaHashMap : A reference object HashMap<Integer, QuestionAndAnswer>
     * to be passed that will populate with any values added in the db call.
     * @return description: Returns a value of true if there were no issues, if
     * there was an issue, returns a value of false.
     */
    public static boolean loadAllQA(HashMap<Integer, QuestionAndAnswer> qaHashMap) {
        //HashMap<Integer, QuestionAndAnswer> qaHashMap = new HashMap<>(); hashmap is reference, so this isn't needed -RA
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean isLoaded = false; //tracked bool

        String sql
                = """
                   SELECT *
                   FROM qa;
                """;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
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

        } catch (SQLException ex) {
            System.out.print("RA -> issue in -> loadAllQA() -> " + ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return isLoaded;

    }

    public static boolean deleteQA(int qa_id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        boolean success = false; //boolean to track successful deletion

        String sql
                = """
                     DELETE FROM qa 
                      WHERE qa_id = ?
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, qa_id);

            ps.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            System.out.println("\nissue in .deleteQA() \n" + ex + "\n\n");
            success = false;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return success;
    }

    public static HashMap<Integer, Assessment> selectAssessmentsByType(String assessmentType) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap<Integer, Assessment> assessments = new HashMap<Integer, Assessment>();

        String sql
                = """
                    SELECT *
                    FROM assessment
                    WHERE type = ?
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, assessmentType);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("assessment_id");
                String rules = rs.getString("rules");
                String type = rs.getString("type");
                int level = rs.getInt("level");
                double points = rs.getDouble("points");
                int attempts = rs.getInt("allowed_attempts");
                int allowed_time = rs.getInt("allowed_time");
                String random = rs.getString("random_or_specific");

                Assessment assessment = new Assessment();
                assessment.setID(id);
                assessment.setSubject(rules);
                assessment.setDifficulty(level);
                assessment.setAssessmentType(type);
                assessment.setRules(rules);
                assessment.setAttemptsAllowed(attempts);
                assessment.setIsRandom(random.equals("R"));
                assessment.setScore(points);
                assessment.setAllowed_time(allowed_time);

                assessments.put(assessment.getAssessmentID(), assessment);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println("\nissue in .selectAssessments() \n" + ex + "\n\n");
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return assessments;
    }

    public static HashMap<Integer, Assessment> selectAssessmentsByClass(String classId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        HashMap<Integer, Assessment> assessments = new HashMap<>();

        String sql
                = """
                    SELECT a.*
                    FROM assessment a
                        JOIN assessment_class AS ac
                            ON a.assessment_id = ac.assessment_id
                    WHERE ac.class_id = ?;
                """;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, classId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("assessment_id");
                String rules = rs.getString("rules");
                int level = rs.getInt("level");
                String type = rs.getString("type");
                int attempts = rs.getInt("allowed_attempts");
                String random = rs.getString("random_or_specific");
                double points = rs.getDouble("points");

                Assessment assessment = new Assessment();
                assessment.setID(id);
                assessment.setSubject(rules);
                assessment.setDifficulty(level);
                assessment.setAssessmentType(type);
                assessment.setAttemptsAllowed(attempts);
                assessment.setIsRandom(random.equals("R"));
                assessment.setScore(points);

                assessments.put(assessment.getAssessmentID(), assessment);

            }
        } catch (SQLException ex) {
            System.out.println("\nissue in .selectAssessmentsByClass() \n" + ex + "\n\n");
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return assessments;

    }

    public static HashMap<String, String> selectAssessmentResults(String classId, int assessmentId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        HashMap<String, String> results = new HashMap<>();

        String sql
                = """
                SELECT u.username, sa.grade
                FROM user AS u
                    JOIN user_class AS uc
                        ON uc.username = u.username
                    LEFT JOIN student_assessment AS sa
                        ON sa.student_username = u.username
                        AND sa.assessment_id = ?
                WHERE uc.class_id = ?
                AND u.role = 'STU';
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, assessmentId);
            ps.setString(2, classId);

            rs = ps.executeQuery();

            while (rs.next()) {
                results.put(
                        rs.getString("username"),
                        rs.getString("grade")
                );
            }
        } catch (SQLException ex) {
            System.out.println("\nissue in .selectAssessmentResult() \n" + ex + "\n\n");
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return results;
    }

    public static QuestionAndAnswer selectQuestionAnswer(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        QuestionAndAnswer qa = null;

        String sql
                = """
                     SELECT * FROM qa
                     WHERE qa_id = ?
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            qa = new QuestionAndAnswer();
            qa.setID(rs.getInt("qa_id"));
            qa.setQuestion(rs.getString("question"));
            qa.setAnswer(rs.getString("answer"));
            qa.setPoints(rs.getDouble("points"));
            qa.setDifficulty(rs.getInt("difficulty"));
        } catch (SQLException ex) {
            System.out.println("\n\nissue in .selectQuestionAnswer() \n" + ex + "\n\n");
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return qa;
    }

    public static Assessment selectAssessment(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Assessment assessment = null;

        String sql
                = """
                     SELECT * FROM assessment
                     WHERE assessment_id = ?
                """;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            
            int assessment_id = rs.getInt("assessment_id");
            String rules = rs.getString("rules");
            String type = rs.getString("type");
            int level = rs.getInt("level");
            double points = rs.getDouble("points");
            int attempts = rs.getInt("allowed_attempts");
            int allowed_time = rs.getInt("allowed_time");
            String random = rs.getString("random_or_specific");

            assessment = new Assessment();
            assessment.setID(assessment_id);
            assessment.setSubject(rules);
            assessment.setDifficulty(level);
            assessment.setAssessmentType(type);
            assessment.setRules(rules);
            assessment.setAttemptsAllowed(attempts);
            assessment.setIsRandom(random.equals("R"));
            assessment.setAllowed_time(allowed_time);
            assessment.setScore(points);
        } catch (SQLException ex) {
            System.out.println("\n\nissue in .selectAssessment() \n" + ex + "\n\n");
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return assessment;
    }
}
