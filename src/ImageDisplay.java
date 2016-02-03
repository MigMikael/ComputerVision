import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageDisplay extends JFrame {
	
	public void readAndDisplayImage() {
		BufferedImage img = null;
		try {
			File imgFile = new File("C:\\Users\\Mig\\Pictures\\CaDyd4CUMAEQ0CA.jpg");
			img = ImageIO.read(imgFile);
		} catch (IOException e) {
			System.out.println("Error loading image");
			System.exit(ERROR);
		}
		
		ImagePanel imgPanel = new ImagePanel(img);
		this.setContentPane(imgPanel);
		prepareDisplay();
	}
	
	protected void prepareDisplay() {
		this.attachclosingEvent();
		this.setTitle("Inpitar");
		this.pack();
		this.setVisible(true);
	}
	
	protected void attachclosingEvent(){
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
	}
	
	public static void main(String[] args) {
		ImageDisplay imgDisplay = new ImageDisplay();
		imgDisplay.readAndDisplayImage();
		
		System.out.println("Program Exits Normally");
	}
}
