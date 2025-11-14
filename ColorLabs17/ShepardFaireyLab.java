/**
 * Modify a picture by replacing all colors with only four
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
        Picture me = new Picture("images/heylookitsme.jpg");
        me.explore();
        
        // call one of the methods below
        
        // Picture modified = method1(me);
        // Picture modified = method2(me);
        // Picture modified = method3(me);
        // Picture modified = method3_gray(me);
        // Picture modified = method3_grayInvert(me);
        
        // modified.explore(); modified.write("sf_default.jpg");
    }
    
    public static float[] pixelStrengths(Pixel[] pixels) {
        float[] strengths = new float[pixels.length]; // create new array with appropriate length
        
        for (int i = 0; i < pixels.length; i++) {
            strengths[i] = (float)pixels[i].getAverage() / 3.0f; // fill the array with the average of the channels
        }
        Arrays.sort(strengths); // sort the array in ascending order (smallest to largest)
        
        return strengths; // return array for further use
    }
    
    public static Picture method1(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        
        int groupSize = strengths.length / 4; // split into 4 groups
        float bound1 = strengths[groupSize * 1 - 1];
        float bound2 = strengths[groupSize * 2 - 1];
        float bound3 = strengths[groupSize * 3 - 1];
        float bound4 = strengths[groupSize * 4 - 1];
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            if (strength <= bound1) {
                pixel.setColor(color1); // change all pixels in group 1 to dark blue
            } else if (strength <= bound2) {
                pixel.setColor(color2); // change all pixels in group 2 to red
            } else if (strength <= bound3) {
                pixel.setColor(color3); // change all pixels in group 3 to light blue
            } else if (strength <= bound4) {
                pixel.setColor(color4); // change all pixels in group 4 to off-white
            } else {
                pixel.setColor(new Color(255, 0, 0)); // set any other pixels to red
            }
        }
        
        return picture;
    }
    
    public static Picture method2(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        
        // Arrays.sort works in ascending order (i.e. smallest to largest)
        float minStrength = strengths[0];
        float maxStrength = strengths[strengths.length - 1];
        float intervalSize = (maxStrength - minStrength) / 4;
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            if (strength < minStrength + intervalSize * 1) {
                pixel.setColor(color1); // change all pixels in group 1 to dark blue
            } else if (strength < minStrength + intervalSize * 2) {
                pixel.setColor(color2); // change all pixels in group 2 to red
            } else if (strength < minStrength + intervalSize * 3) {
                pixel.setColor(color3); // change all pixels in group 3 to light blue
            } else if (strength < minStrength + intervalSize * 4) {
                pixel.setColor(color4); // change all pixels in group 4 to off-white
            } else {
                pixel.setColor(new Color(255, 0, 0)); // set any other pixels to red
            }
        }
        
        return picture;
    }
    
    public static Picture method3(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        
        // Arrays.sort works in ascending order (i.e. smallest to largest)
        float minStrength = strengths[0];
        float maxStrength = strengths[strengths.length - 1];
        float intervalSize = (maxStrength - minStrength) / 4;
        
        Color color1 = new Color(255, 74, 74); // red
        Color color2 = new Color(255, 158, 74); // orange
        Color color3 = new Color(63, 217, 63); // green
        Color color4 = new Color(53, 173, 179); // light blue
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            if (strength < minStrength + intervalSize * 1) {
                pixel.setColor(color1); // change all pixels in group 1 to red
            } else if (strength < minStrength + intervalSize * 2) {
                pixel.setColor(color2); // change all pixels in group 2 to orange
            } else if (strength < minStrength + intervalSize * 3) {
                pixel.setColor(color3); // change all pixels in group 3 to green
            } else if (strength < minStrength + intervalSize * 4) {
                pixel.setColor(color4); // change all pixels in group 4 to light blue
            } else {
                pixel.setColor(color4); // set any other pixels to group 4's color
            }
        }
        
        return picture;
    }
    
    public static Picture method3_gray(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        
        // Arrays.sort works in ascending order (i.e. smallest to largest)
        float minStrength = strengths[0];
        float maxStrength = strengths[strengths.length - 1];
        float intervalSize = (maxStrength - minStrength) / 4;
        
        Color color1 = new Color(0, 0, 0); // black
        Color color2 = new Color(85, 85, 85); // dark gray
        Color color3 = new Color(170, 170, 170); // light gray
        Color color4 = new Color(255, 255, 255); // white
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            if (strength < minStrength + intervalSize * 1) {
                pixel.setColor(color1); // change all pixels in group 1 to black
            } else if (strength < minStrength + intervalSize * 2) {
                pixel.setColor(color2); // change all pixels in group 2 to dark gray
            } else if (strength < minStrength + intervalSize * 3) {
                pixel.setColor(color3); // change all pixels in group 3 to light gray
            } else if (strength < minStrength + intervalSize * 4) {
                pixel.setColor(color4); // change all pixels in group 4 to white
            } else {
                pixel.setColor(color4); // set any other pixels to group 4's color
            }
        }
        
        return picture;
    }
    
    public static Picture method3_grayInvert(Picture picture) {
        Pixel[] pixels = picture.getPixels(); // create array of pixels from picture
        float[] strengths = pixelStrengths(pixels); // calculate the strength of each pixel (average of each color channel)
        
        // Arrays.sort works in ascending order (i.e. smallest to largest)
        float minStrength = strengths[0];
        float maxStrength = strengths[strengths.length - 1];
        float intervalSize = (maxStrength - minStrength) / 4;
        
        Color color1 = new Color(255, 255, 255); // white
        Color color2 = new Color(170, 170, 170); // light gray
        Color color3 = new Color(85, 85, 85); // dark gray
        Color color4 = new Color(0, 0, 0); // black
        
        Pixel pixel;
        float strength;
        int idx;
        for (int i = 0; i < pixels.length; i++) {
            pixel = pixels[i]; // get the current pixel
            strength = (float)pixel.getAverage() / 3.0f; // calculate this pixel's strength
            if (strength < minStrength + intervalSize * 1) {
                pixel.setColor(color1); // change all pixels in group 1 to white
            } else if (strength < minStrength + intervalSize * 2) {
                pixel.setColor(color2); // change all pixels in group 2 to light gray
            } else if (strength < minStrength + intervalSize * 3) {
                pixel.setColor(color3); // change all pixels in group 3 to dark gray
            } else if (strength < minStrength + intervalSize * 4) {
                pixel.setColor(color4); // change all pixels in group 4 to black
            } else {
                pixel.setColor(color4); // set any other pixels to group 4's color
            }
        }
        
        return picture;
    }
}