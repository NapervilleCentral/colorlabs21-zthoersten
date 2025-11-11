/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class ShepardFaireyLab {
    public static void main(String[] args) {
        // opens selfie picture
        // String fileName = FileChooser.pickAFile();
        // Picture pictObj = new Picture(fileName);
        // pictObj.explore();
        
        //change with selfie picture
        Picture me = new Picture("images/heylookitsme.jpg");
        
        me.explore();
        
        // method 1
        
        // method 2
        
        // custom colors
    }
    
    public static boolean comparePixels(Pixel pA, Pixel pB) {
        float valA = (pA.getRed() + pA.getGreen() + pA.getBlue()) / 3;
        float valB = (pB.getRed() + pB.getGreen() + pB.getBlue()) / 3;
        return valA > valB;
    }
    
    public static Pixel[] sortPixelList(Pixel[] pixels) {
        // bubble sort
        int n = pixels.length;
        boolean swapped = false;
        while (!swapped) {
            swapped = false;
            for (int i = 1; i <= n - 1; i++) {
                if (comparePixels(pixels[i - 1], pixels[i])) {
                    Pixel temp = pixels[i];
                    pixels[i] = pixels[i - 1];
                    pixels[i - 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
        return pixels;
    }
    
    public static Picture method1(Picture picture) {
        // sort list
        // do method 1
        // https://naperville.instructure.com/courses/1187860/files/68948179?module_item_id=13246961
        return picture;
    }
}