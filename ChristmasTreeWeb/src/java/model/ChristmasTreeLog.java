/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ryszard
 */
public class ChristmasTreeLog {
    private List <Integer> widthList;
    private List <Integer> heightList;
    private List <Date> dateList;
    private static Connection con = null;
    
    static {
        if (con==null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/lab", "lab", "lab");
            } catch (ClassNotFoundException cnfe) {
                System.err.println("ClassNotFound exception: " + cnfe.getMessage());
            } catch (SQLException sqle) {
                System.err.println("SQL exception: " + sqle.getMessage());
            }
        }
    }
    
    ChristmasTreeLog () {
        widthList = new LinkedList <Integer> ();
        heightList = new LinkedList <Integer> ();
        dateList = new LinkedList <Date> ();
        fetchData();
    }
    
    public void addLog (int width, int height, Date date) {
        widthList.add(width);
        heightList.add(height);
        dateList.add(date);
        this.insertData(width, height, date);
    }
    
    public List <List> getList() {
        List <List> row = new LinkedList<List>();
        row.add(widthList);
        row.add(heightList);
        row.add(dateList);
        return row;
    }
    
    public void insertData(int width, int height, Date date) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO log(width, height, date) VALUES (?,?,?)");
            pstmt.setInt(1, width);
            pstmt.setInt(2, height);
            pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        }
    }

    private void fetchData() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT width, height, date FROM log");
            while (rs.next()) {
                widthList.add(rs.getInt("width"));
                heightList.add(rs.getInt("height"));
                Date date = new Date();
                date.setTime(rs.getTimestamp("date").getTime());
                dateList.add(date);
            }
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        }
    }
}
