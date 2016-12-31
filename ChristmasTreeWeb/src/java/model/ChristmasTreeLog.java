/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    ChristmasTreeLog () {
        widthList = new LinkedList <Integer> ();
        heightList = new LinkedList <Integer> ();
        dateList = new LinkedList <Date> ();       
    }
    
    public void addLog (int width, int height, Date date) {
        widthList.add(width);
        heightList.add(height);
        dateList.add(date);
    }
    
    public List <List> getList() {
        List <List> row = new LinkedList<List>();
        row.add(widthList);
        row.add(heightList);
        row.add(dateList);
        return row;
    }
}
