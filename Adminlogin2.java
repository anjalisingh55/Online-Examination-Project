import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Adminlogin2 extends JPanel
{
	JButton b1,b2,b3,b4,b5,b6;
	JLabel l1;
	ImageIcon img1;
	Image bg;
	Adminlogin2(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,50);
		setFont(f1);
		
		l1=new JLabel("ADMIN");
		l1.setBounds(870,60,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		b1=new JButton("COURSE RESULTS");
		b1.setBounds(840,200,200,80);
		b1.setBackground(c3);
		add(b1);
		
		b2=new JButton("VERIFICATION");
		b2.setBounds(840,300,200,80);
		b2.setBackground(c3);
		add(b2);
		
		b3=new JButton("MANAGE COURSES");
		b3.setBounds(840,400,200,80);
		b3.setBackground(c3);
		add(b3);
		
		
		b4=new JButton("USERS");
		//b4.setBounds(840,400,200,80);
		b4.setBounds(840,500,200,80);
		b4.setBackground(c3);
		add(b4);
		
		b5=new JButton("LOGOUT");
		b5.setBounds(250,100,200,30);
		b5.setBackground(c3);
		add(b5);
		
		b6=new JButton("CHANGE PASSWORD");
		b6.setBounds(1500,100,200,30);
		b6.setBackground(c3);
		add(b6);
		b1.addActionListener(f);
		b2.addActionListener(f);
		b3.addActionListener(f);
		b4.addActionListener(f);
		b5.addActionListener(f);
		b6.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}