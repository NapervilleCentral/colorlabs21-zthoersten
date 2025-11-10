public class ColorLab {
    public static void main(String[] args) {
        Picture pic = new Picture("images/moon-surface.jpg");
        
        // initial picture
        pic.explore();
        
        // make modifications
        pic = adjustRed(pic, 0.5);
        pic = adjustGreen(pic, 1.5);
        pic = adjustBlue(pic, 0.25);
        
        pic = negate(pic);
        pic = grayscale(pic);
        
        pic = lighten(pic);
        pic = darken(pic);
        
        // final modified picture
        pic.explore();
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
            val = (int)Math.round(avg * 15/255); // scale down to 0-15
            
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
            val = (int)Math.round(avg * 15/255); // scale down to 0-15
            
            pixel.setRed(red - val);
            pixel.setGreen(green - val);
            pixel.setBlue(blue - val);
        }
        return picture;
    }
    
    public static Picture changeColors(Picture picture, int redAmount, int greenAmount, int blueAmount) {
        // add amounts to current vals
        return picture;
    }
}