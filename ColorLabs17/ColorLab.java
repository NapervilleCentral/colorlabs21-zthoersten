/**
 * Do stuff with a picture
 * 
 * @author Zach H
 * 23/23/133221
 */

public class ColorLab {
    public static void main(String[] args) {
        Picture pic = new Picture("images/heylookitsme.jpg");
        Picture pic2 = new Picture("images/heylookitsme.jpg");
        Picture pic3 = new Picture("images/heylookitsme.jpg");
        Picture pic4 = new Picture("images/heylookitsme.jpg");
        Picture pic5 = new Picture("images/heylookitsme.jpg");
        Picture pic6 = new Picture("images/heylookitsme.jpg");
        Picture pic7 = new Picture("images/heylookitsme.jpg");
        
        // make modifications
        pic2 = adjustRed(pic2, 0.75);
        pic3 = negate(pic3);
        pic4 = grayscale(pic4);
        pic5 = lighten(pic5);
        pic6 = changeColors(pic6, 190, 0, 0);
        pic7 = blueify(pic7);
        
        // final modified picture
        pic.explore();
        pic2.explore();
        pic3.explore();
        pic4.explore();
        pic5.explore();
        pic6.explore();
        pic7.explore();
    }
    
    public static Picture adjustRed(Picture picture, double factor) {
        int red;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            red *= factor;
            pixel.setRed(red);
        }
        return picture;
    }
    
    public static Picture adjustBlue(Picture picture, double factor) {
        int blue;
        for (Pixel pixel : picture.getPixels()) {
            blue = pixel.getBlue();
            blue *= factor;
            pixel.setBlue(blue);
        }
        return picture;
    }
    
    public static Picture adjustGreen(Picture picture, double factor) {
        int green;
        for (Pixel pixel : picture.getPixels()) {
            green = pixel.getGreen();
            green *= factor;
            pixel.setGreen(green);
        }
        return picture;
    }
    
    public static Picture negate(Picture picture) {
        int red, green, blue;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            red = 255 - red;
            green = 255 - green;
            blue = 255 - blue;
            
            pixel.setRed(red);
            pixel.setGreen(green);
            pixel.setBlue(blue);
        }
        return picture;
    }
    
    public static Picture grayscale(Picture picture) {
        int red, green, blue, val;
        double avg;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            avg = (red + green + blue) / 3;
            val = (int)Math.round(avg);
            
            pixel.setRed(val);
            pixel.setGreen(val);
            pixel.setBlue(val);
        }
        return picture;
    }
    
    public static Picture lighten(Picture picture) {
        int red, green, blue, val;
        double avg;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            avg = (red + green + blue) / 3;
            val = (int)Math.round(avg * 100/255); // scale down to 0-100
            
            pixel.setRed(red + val);
            pixel.setGreen(green + val);
            pixel.setBlue(blue + val);
        }
        return picture;
    }
    
    public static Picture darken(Picture picture) {
        int red, green, blue, val;
        double avg;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            avg = (red + green + blue) / 3;
            val = (int)Math.round(avg * 100/255); // scale down to 0-100
            
            pixel.setRed(red - val);
            pixel.setGreen(green - val);
            pixel.setBlue(blue - val);
        }
        return picture;
    }
    
    public static Picture changeColors(Picture picture, int redAmount, int greenAmount, int blueAmount) {
        int red, green, blue;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            pixel.setRed(red + redAmount);
            pixel.setGreen(green + greenAmount);
            pixel.setBlue(blue + blueAmount);
        }
        return picture;
    }
    
    public static Picture blueify(Picture picture) {
        int red, green, blue;
        for (Pixel pixel : picture.getPixels()) {
            red = pixel.getRed();
            green = pixel.getGreen();
            blue = pixel.getBlue();
            
            if (160 <= red && red <= 220 &&
                115 <= green && green <= 175 &&
                115 <= blue && blue <= 175) {
                pixel.setRed(red / 2);
                pixel.setGreen(green / 2);
                pixel.setBlue(blue * 2);
            }
        }
        return picture;
    }
}