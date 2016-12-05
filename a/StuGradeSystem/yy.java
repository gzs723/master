package StuGradeSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;
public class yy extends JPanel{
	
	private Image img2 = Toolkit.getDefaultToolkit().createImage("D:\\1.jpg"); 
	yy(){
		repaint();
		
		
		
	}
	public void paint(Graphics g)
	{

		g.drawImage(img2,0,0,350,450,this);
	

	}
	

}
