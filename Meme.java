import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Meme extends JPanel {

	private static JFrame frame;
	private static JLabel displayLabel;
	private static JLabel myName;

	// Calculates the time between Two Dates
	public long daysBetween(Date one, Date two) {
		long dif = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(dif);
	}

	public static void main(String[] args) throws IOException {

		// Create Date objects 
		Date today = new Date();
		Calendar saikiCal = Calendar.getInstance();
		saikiCal.set(2018, 3, 1);
		Date dubPromised = saikiCal.getTime();

		Meme Object = new Meme();
		long days = Object.daysBetween(today, dubPromised);

		// Create Panel and Label for Meme
		displayLabel = new JLabel(days + " days have passed without a Saiki K season 2 & 3 English Dub.");
		JPanel top = new JPanel();
		top.setBackground(new Color(255,122,145));

		// Your OS needs to have impact installed for this to work, with the desired font
		displayLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		top.add(displayLabel);

		JPanel middle = new JPanel();
		// Heads Up, File names are case sensitve on Linux (9/5/2022)
		BufferedImage myPicture = ImageIO.read(new File("Meme.png"));
		JLabel imgLabel = new JLabel(new ImageIcon(myPicture));
		Dimension maxSize = new Dimension(800,863);
		imgLabel.setPreferredSize(maxSize);
		middle.setBackground(new Color(255,122,145));
		middle.add(imgLabel);

		myName = new JLabel("When will the Dub come out?.");
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(255,122,145));
		bottom.add(myName);
		myName.setFont(new Font("Impact", Font.PLAIN, 50));

		frame = new JFrame("Saiki K Dub Timer");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(top, BorderLayout.NORTH);
		frame.add(middle, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);

	}
}