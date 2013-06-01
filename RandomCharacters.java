// August Ryan Brenner
// abrenn10@my.smccd.edu
// CIS 255HJ
// RandomCharacters.java
// Draws 15 randomly placed random characters
// Lab 7
// April 23rd, 2012 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.FontMetrics;


public class RandomCharacters extends JPanel
{
	private Random randomNumbers = new Random();
	private FontMetrics metrics;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = screenSize.width;
	private int height = screenSize.height;
	
	
	//The Paint component to draw 15 characters
	public void paintComponent(Graphics g)
	{
		for (int i = 0; i < 15; i++)
		{
			g.setColor( getRandomColor() );
			g.setFont( new Font(getRandomFont(), 
					getRandomStyle(), getRandomFontSize() ) );
			metrics = g.getFontMetrics();
			g.drawString( getRandomCharacter(),
					getRandomX(), getRandomY() );
		}
	}//end method
	
	//method to generate random font
	public String getRandomFont()
	{
		String[] fontList = {"Serif", "Monospaced",
				"SansSerif", "Dialog", "DialogInput"};
		return fontList[randomNumbers.nextInt(5)];
	}//end method
	
	//method to generate random style
	public int getRandomStyle()
	{
		int[] styleList ={ Font.BOLD, Font.ITALIC, Font.PLAIN };
		return styleList[randomNumbers.nextInt(3)];
	}//end method
	
	//method to select random color
	public Color getRandomColor()
	{
		Color randomColor = new Color( randomNumbers.nextInt( 256 ),
				randomNumbers.nextInt( 256 ),
				randomNumbers.nextInt( 256 ) );
		return randomColor;
	}//end method
	
	//method to generate random font size
	public int getRandomFontSize()
	{
		return 8 + randomNumbers.nextInt( 325 );
	}//end method
	
	//method to get x-coordinate to space randomly on screen
	public int getRandomX()
	{
		return 12 + randomNumbers.nextInt( width - metrics.getMaxAscent()-12);
	}//end method
	
	//method to get y-coordinate to space randomly on screen
	public int getRandomY()
	{
		return metrics.getMaxAscent() + randomNumbers.nextInt(
				height - metrics.getMaxAscent() - metrics.getMaxDescent());
	}//end method
	
	//method to generate a random character
	public String getRandomCharacter()
	{
		char charArray[]= { (char) (randomNumbers.nextInt( 26 ) + 'a'),
		(char) (randomNumbers.nextInt( 26 ) + 'A')};
		
		return Character.toString(charArray[randomNumbers.nextInt(2)]);
	
	}//end method
	
	//main method to generate components and display
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Programmed By August Ryan Brenner");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;


		frame.getContentPane().add( new RandomCharacters() );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( width, height );
		frame.setBackground (Color.BLACK);
		frame.setUndecorated( false );
		frame.setVisible( true );
	} //end main method
}//end class
