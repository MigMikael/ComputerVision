import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PixelReader {
	public static void main(String[] args) {
		BufferedImage img = null;
		try {
			File imgFile = new File("C:\\Users\\Mig\\Pictures\\CaDyd4CUMAEQ0CA.jpg");
			img = ImageIO.read(imgFile);
		} catch (IOException e) {
			System.out.println("Error loading image");
		}
		
		int width = img.getWidth();
		int hight = img.getHeight();
		int[][][] pixelArray = new int[hight][width][3];
		
		Raster raster = img.getRaster();
		int[] pixelBuffer = new int[3];
		for (int row = 0; row < hight; row++) {
			for (int col = 0; col < width; col++) {
				raster.getPixel(col, row, pixelBuffer);
				pixelArray[row][col][0] = pixelBuffer[0];
				pixelArray[row][col][1] = pixelBuffer[1];
				pixelArray[row][col][2] = pixelBuffer[2];
			}
		}
		
		WritableRaster wRaster = img.getRaster();
		for (int row = 0; row < hight; row++) {
			for (int col = 0; col < width; col++) {
				pixelBuffer[0] = 255 - pixelArray[row][col][0];
				pixelBuffer[1] = 255 - pixelArray[row][col][1];
				pixelBuffer[2] = 255 - pixelArray[row][col][2];
				wRaster.setPixel(col, row, pixelBuffer);
			}
		}
		
		try {
			File file = new File("C:\\Users\\Mig\\Pictures\\convert_CaDyd4CUMAEQ0CA.jpg");
			ImageIO.write(img, "jpg", file);
			System.out.println("Program Exits Normally");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
