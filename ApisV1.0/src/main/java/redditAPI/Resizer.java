package redditAPI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.ctc.wstx.sr.InputProblemReporter;

public class Resizer {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int scaledWidth = 1080;
//		   int scaledHeight =  1350;
//           try {
//			resize("C:\\Users\\elach\\Pictures\\Reddit\\Bois he did it.jpg", "C:\\Users\\elach\\Pictures\\Reddit\\Bois he did itrerer43.jpg", scaledWidth, scaledHeight);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	 public static void resize(String inputImagePath,
							   String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        //System.out.println(inputFile.delete());
	       
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	
	        // writes to output file
	        ImageIO.write(outputImage, "jpg", new File(outputImagePath));
		  
	    }
	 
	    /**
	     * Resizes an image by a percentage of original size (proportional).
	     * @param inputImagePath Path of the original image
	     * @param outputImagePath Path to save the resized image
	     * @param percent a double number specifies percentage of the output image
	     * over the input image.
	     * @throws IOException
	     */
	    public static void resize(String inputImagePath,
	            String outputImagePath, double percent) throws IOException {
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	        int scaledWidth = (int) (inputImage.getWidth() * percent);
	        int scaledHeight = (int) (inputImage.getHeight() * percent);
	        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	    }
}
