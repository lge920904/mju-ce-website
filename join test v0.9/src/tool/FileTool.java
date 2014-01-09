package tool;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class FileTool {

	
	// 임시 이미지 규격 사이즈.
	private int w = 480;
	private int h = 480;
	
	// 이미지 리사이징.
	public ImageIcon resizeProfileImage(String imagePath){
		// TODO Auto-generated method stub

		BufferedImage bi, bdest;
		ImageIcon theIcon;
		
		try
		{
			File file = new File(imagePath);
			bi = ImageIO.read(file);
			bdest = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bdest.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance((double) w / bi.getWidth(),
					(double) h / bi.getHeight());
			g.drawRenderedImage(bi, at);

			//add the scaled image
			theIcon = new ImageIcon(bdest);
		}
		catch (Exception e)
		{
			System.out.println("This image can not be resized. Please check the path and type of file.");
			return null;
		}
		return theIcon;
	}
}
