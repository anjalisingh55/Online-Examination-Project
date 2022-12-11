import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class showresult extends JPanel 
{
	JLabel l1,l2;
	ImageIcon img1;
	Image bg;
	showresult(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,50);
		setFont(f1);
		
		l1=new JLabel("Correct :");
		l1.setBounds(100,100,900,60);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Wrong :");
		l2.setBounds(100,200,900,60);
		l2.setFont(f1);
		l2.setForeground(Color.white);
		add(l2);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}