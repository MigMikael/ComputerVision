import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	protected BufferedImage biImage = null;
	
	public ImagePanel(BufferedImage bImage) {
		// TODO Auto-generated constructor stub
		this.biImage = bImage;
		this.setPreferredSize(new Dimension(bImage.getWidth(), bImage.getHeight()));
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (biImage != null) {
			g.drawImage(biImage, 0, 0, null);
		}
	}
	
}
