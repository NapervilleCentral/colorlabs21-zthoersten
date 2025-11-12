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
    static Color color1 = new Color(12, 48, 78); // dark blue
    static Color color2 = new Color(200, 46, 39); // red
    static Color color3 = new Color(117, 149, 159); // light blue
    static Color color4 = new Color(249, 228, 170); // off-white
    
    public static void main(String[] args) {
        // opens selfie picture
        // String fileName = FileChooser.pickAFile();
        // Picture pictObj = new Picture(fileName);
        // pictObj.explore();
        
        //change with selfie picture
        Picture me = new Picture("images/heylookitsme.jpg");
        
        me.explore();
        
        // method 1
        
        Picture me1 = method1(me);
        
        me1.explore();
        
        // method 2
        
        // custom colors
    }
    
    public static Pixel[] bubblesort(Pixel[] pixels) {
        int n = pixels.length;
        boolean swapped = false;
        
        while (!swapped) {
            swapped = false;
            for (int i = 1; i <= n - 1; i++) {
                if (comparePixels(pixels[i], pixels[i - 1])) {
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
    
    public static boolean comparePixels(Pixel pA, Pixel pB) {
        float valA = (pA.getRed() + pA.getGreen() + pA.getBlue()) / 3;
        float valB = (pB.getRed() + pB.getGreen() + pB.getBlue()) / 3;
        return valA > valB;
    }
    
    public static Picture method1(Picture picture) {
        Pixel[] pixels = picture.getPixels();
        List<Float> pixelStrengths = new ArrayList<>();
        
        for (Pixel pixel : pixels) {
            float strength = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3.0f;
            pixelStrengths.add(strength);
        }
        
        pixelStrengths.sort(Comparator());
        // figure out what the hell a comparator is
        int groupSize = sorted.length / 4;
        
        List group1 = Arrays.asList(Arrays.copyOfRange(sorted, 0, groupSize));
        List group2 = Arrays.asList(Arrays.copyOfRange(sorted, groupSize + 1, groupSize * 2));
        List group3 = Arrays.asList(Arrays.copyOfRange(sorted, groupSize * 2 + 1, groupSize * 3));
        List group4 = Arrays.asList(Arrays.copyOfRange(sorted, groupSize * 3 + 1, sorted.length));
        
        for (Pixel pixel : pixels) {
            if (group1.contains(pixel)) {
                pixel.setColor(color1); // change all pixels in group 1 to dark blue
            } else if (group2.contains(pixel)) {
                pixel.setColor(color2); // change all pixels in group 2 to red
            } else if (group3.contains(pixel)) {
                pixel.setColor(color3); // change all pixels in group 3 to light blue
            } else if (group4.contains(pixel)) {
                pixel.setColor(color4); // change all pixels in group 4 to off-white
            }
        }
        
        return picture;
    }
}