/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class TestPicture17 {
    public static void main(String[] args) {
        //opens picture using a dialog box
        /*
        String fileName = FileChooser.pickAFile();
        Picture pictObj = new Picture(fileName);
        pictObj.explore();
        */
        
        //opens a pictue using a path
        //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
        
        //relative path
        Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
        
        // to change color of picture, get all pixels
        //makes an array of pixels
        Pixel[] pixels;
        //gets pixels from picture and assigns to pixels array
        pixels = ferris1.getPixels();
        //how many pixels or how large array
        System.out.println("This is a large array"+pixels.length  );
        
        //access each index
        // System.out.println(pixels[17]);
        
        //access each pixel
        // Pixel spot = ferris1.getPixel(100,100);
        // System.out.println(pixels[17].getColor());
        // System.out.println(spot);
        
        // Pixel spot17 = pixels[17];
        // spot17.setRed(255);
        // spot17.setBlue(255);
        // spot17.setGreen(0);
        
        // Pixel spot50 = pixels[50];
        // Color ltsteel = new Color(176, 196, 222);
        // spot50.setColor(ltsteel);
        
        int red, green, blue;
        for (Pixel spot : pixels) {
            red = spot.getRed();
            red *= 0.5;
            spot.setRed(red);
            
            green = spot.getGreen();
            green *= 0.75;
            spot.setGreen(green);
            
            blue = spot.getBlue();
            blue *= 0.875;
            spot.setBlue(blue);
        }
        ferris1.explore();
        
        //write/save a picture as a file
        ferris1.write("images/ferris11.jpg");
    }
}