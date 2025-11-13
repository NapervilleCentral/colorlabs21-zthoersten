/**
 * Modify a picture by replacing the colors with 4
 * 
 * @author Zach H
 * 11/13/2025
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
    
    public static float[] pixelStrengths(Pixel[] pixels) {
        float[] strengths = new float[pixels.length];
        
        for (int i = 0; i < pixels.length; i++) {
            strengths[i] = (float)pixels[i].getAverage() / 3.0f;
        }
        
        return strengths;
    }
    
    public static Picture method1(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        Arrays.sort(strengths); // sort the strengths
        
        int groupSize = strengths.length / 4; // split into 4 groups
        int bound1 = groupSize * 1 - 1;
        int bound2 = groupSize * 2 - 1;
        int bound3 = groupSize * 3 - 1;
        int bound4 = groupSize * 4 - 1;
        List group1 = Arrays.asList(Arrays.copyOfRange(strengths, groupSize * 0, groupSize * 1 - 1));
        List group2 = Arrays.asList(Arrays.copyOfRange(strengths, groupSize * 1, groupSize * 2 - 1));
        List group3 = Arrays.asList(Arrays.copyOfRange(strengths, groupSize * 2, groupSize * 3 - 1));
        List group4 = Arrays.asList(Arrays.copyOfRange(strengths, groupSize * 3, groupSize * 4 - 1));
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            idx = Arrays.asList(strengths).indexOf(strength);
            if (idx <= bound1) {
                pixel.setColor(color1); // change all pixels in group 1 to dark blue
            } else if (idx <= bound2) {
                pixel.setColor(color2); // change all pixels in group 2 to red
            } else if (idx <= bound3) {
                pixel.setColor(color3); // change all pixels in group 3 to light blue
            } else if (idx <= bound4) {
                pixel.setColor(color4); // change all pixels in group 4 to off-white
            } else {
                pixel.setColor(new Color(255, 0, 0)); // set any other pixels to red
            }
        }
        
        return picture;
    }
}

class SortPixels implements Comparator {
    public int compare(Object pixel1, Object pixel2) {
        double val1 = ((Pixel)pixel1).getAverage() / 3.0;
        double val2 = ((Pixel)pixel2).getAverage() / 3.0;
        
        if (val1 > val2) {
            return 1;
        } else if (val1 < val2) {
            return -1;
        } else {
            return 0;
        }
    }
}