import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Home extends JPanel 
{
	JLabel l1;
	JButton b2;
	ImageIcon img1;
	Image front;
	Home(FDemo f)
	{
		
		setLayout(null);
		
		Color c=new Color(176,216,255);
		setBackground(c);
		
		Color c2=new Color(0,162,232);
		 
		Color c3=new Color(128,214,255);
		
		Font f1=new Font("Badoni MT Black",Font.ITALIC,70);
		setFont(f1);
		
		Font f3=new Font("Bernard MT Condensed",Font.PLAIN,70);
		setFont(f3);
		
		l1=new JLabel("ONLINE EXAMINATION SYSTEM");
		l1.setBounds(600,40,2000,120);
		l1.setFont(f3);
		l1.setForeground(c2);
		add(l1);
		
		img1=new ImageIcon("front.jpg");
		front=img1.getImage();
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBounds(200,500,300,80);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(front,7,15,this);
	}
}