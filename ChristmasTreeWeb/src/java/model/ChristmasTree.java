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
 * @version 1.1
 */

public class ChristmasTree {
    private int width; // number of * in triangle's bottom
    private int noOfTriangles; // numbers of triangles
    private List <String> rows;
    private ChristmasTreeLog log;
    
    private static ChristmasTree model = null;
    public static ChristmasTree getChristmasTree () {
        if (model == null) {
            model = new ChristmasTree();
        }
        return model;
    }
    
    // set the parameters in constructor
    public ChristmasTree () {
        this.rows = new LinkedList<String>();
        this.log = new ChristmasTreeLog();
        this.width = 0;
        this.noOfTriangles = 0;
    }
    
    
    public void changeSize(int width, int noOfTriangles) throws ChristmasTreeSizeException {
        this.setWidth(width);
        this.setNoOfTriangles(noOfTriangles);
        this.log.addLog(width, noOfTriangles, new Date());
        this.updateRows();
    }
    
    private void updateRows() {
        int i, j, h;
        String tmpStr = new String();
        
        this.rows.clear();
        
        for (h=0; h<this.noOfTriangles; h++) {
            for (i=0; i<this.width; i++) {
                tmpStr = "";
                for (j=0; j<(int)(this.width-i -1); j++) {
                    tmpStr += ' '; // space before each row
                }
                for (j=0; j<=i; j++) {
                    if (j==0 || j==i || i==this.width-1) {
                        tmpStr += "* "; // frame of triangle
                    } else {
                        tmpStr += "  "; // space inside triangle
                    }
                }
                this.rows.add(tmpStr);
            }
        }
    }
    
    private void setWidth (int width) throws ChristmasTreeSizeException {
        if (width > 24) { // if width is 13 then throw exception
            throw new ChristmasTreeSizeException("Max width of christmas tree is 24");
        } else if (width < 0) {
            throw new ChristmasTreeSizeException("Min width of christmas tree is 0");
        }
        this.width = width;
    }
    
    private void setNoOfTriangles (int noOfTriangles) throws ChristmasTreeSizeException {
        if (noOfTriangles * this.width > 36) {
            throw new ChristmasTreeSizeException("Christmas tree is too high. Max height is 36.");
        } else if (noOfTriangles < 0) {
            throw new ChristmasTreeSizeException("Christmas tree must have at least 0 triangles");
        }
        this.noOfTriangles = noOfTriangles;
    }
    
    public synchronized List <String> getRowsListSync(int width, int noOfTriangles) throws ChristmasTreeSizeException {
        changeSize(width, noOfTriangles);
        return getRowsList();
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getNoOfTriangles() {
        return noOfTriangles;
    }
    
    public List <String> getRowsList() {
        return rows;
    }
    
    public synchronized List <List> getLogHistorySync() {
        return log.getList();
    }
}
