/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import model.ChristmasTree;
import model.ChristmasTreeSizeException;
import org.junit.*;

/**
 *
 * @author Ryszard
 * @version 1.0
 */
public class ChristmasTreeTest {
    ChristmasTree christmasTree;
    
    @Test
    public void testChangeSize () {
        //TODO
        try {
            christmasTree = new ChristmasTree();
            christmasTree.changeSize(0, 0);
            Assert.assertEquals("Width should be 0", christmasTree.getWidth(), 0);
            Assert.assertEquals("Height should be 0", christmasTree.getNoOfTriangles() * christmasTree.getWidth(), 0);
            christmasTree.changeSize(24, 0);
            Assert.assertEquals("Width should be 0", christmasTree.getWidth(), 24);
            Assert.assertEquals("Height should be 0", christmasTree.getNoOfTriangles() * christmasTree.getWidth(), 0);
            christmasTree.changeSize(5, 6);
            Assert.assertEquals("Width should be 0", christmasTree.getWidth(), 5);
            Assert.assertEquals("Height should be 0", christmasTree.getNoOfTriangles() * christmasTree.getWidth(), 30);
            christmasTree.changeSize(25, 1);
            Assert.fail("Should throw ChristmasTreeSizeException");
            
        } catch (ChristmasTreeSizeException e) {
            
        }
        
        try {
            christmasTree.changeSize(12, 5);
            Assert.fail("Should throw ChristmasTreeSizeException");
        } catch (ChristmasTreeSizeException e) {
            
        }
        
        try {
            christmasTree.changeSize(-3, -1);
            Assert.fail("Should throw ChristmasTreeSizeException");
        } catch (ChristmasTreeSizeException e) {
            
        }
    }
}
