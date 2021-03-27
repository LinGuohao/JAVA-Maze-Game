
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lin
 */
public class database {
    PreparedStatement insertStatement;
    Connection connection;
    /**
     * Constructor.
     * @throws java.sql.SQLException   
     */
    public database() throws SQLException
    {
         
         String dbURL = "jdbc:derby://localhost:1527/Labyrinth";
         connection = DriverManager.getConnection(dbURL);
         String insertQuery = "INSERT INTO Labyrinth (NAME,POINT) VALUES (?,?)";
         insertStatement = connection.prepareStatement(insertQuery);
        
    }
    /**
     * Read the data in the database and sort all the data in the database in descending order.
     * @return ArrayList
     * @throws java.sql.SQLException   
     */
    public ArrayList<data> getHighScores() throws SQLException {
        String query = "SELECT * FROM Labyrinth";
        ArrayList<data> Points = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()) {
            String name = results.getString("NAME");
            int point = results.getInt("POINT");
            
            Points.add(new data(name, point));
        }
        sortPoints(Points);
        return Points;
    }
     /**
     * Sort array.
     * @param Points
     */
      private void sortPoints(ArrayList<data> Points) {
        Collections.sort(Points, new Comparator<data>() {
             /**
     * Sort descending.
     * @param t
     * @param t1
     */
            @Override
            
            public int compare(data t, data t1) {
                return t1.getPoints() - t.getPoints();
            }
        });
    }
      /**
     * Insert data into the database.
     * @param name
     * @param point
     * @throws java.sql.SQLException   
     */
      
      public void insertScore(String name ,int point) throws SQLException {
        //Timestamp ts = new Timestamp(System.currentTimeMillis());
        insertStatement.setString(1, name);
        insertStatement.setInt(2, point);
        insertStatement.executeUpdate();
    }
}
