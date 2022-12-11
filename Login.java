import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Login extends JPanel
{
	JButton b1,b2,b3;
	JLabel l1;
	ImageIcon img1;
	Image bg;
	
	Login(FDemo f)
	{
		setLayout(null);
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		l1=new JLabel("LOGIN PAGE");
		l1.setBounds(840,100,300,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		b1=new JButton("USER");
		b1.setBounds(800,250,300,80);
		b1.setBackground(c3);
		add(b1);
		
		b2=new JButton("ADMIN");
		b2.setBounds(800,350,300,80);
		b2.setBackground(c3);
		add(b2);
		
		b3=new JButton("BACK");
		b3.setBounds(850,600,200,50);
		b3.setBackground(c3);
		add(b3);
		
		b1.addActionListener(f);
		b2.addActionListener(f);
		b3.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}