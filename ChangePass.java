import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class ChangePass extends JPanel 
{
	JLabel l1,l2,l3;
	JButton b1,b2;
	JTextField tx1,tx2;
	ImageIcon img1;
	Image bg;
	ChangePass(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("CHANGE PASSWORD");
		l1.setBounds(630,50,600,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("OLD PASSWORD");
		l2.setBounds(500,200,200,100);
		l2.setFont(f2);
		add(l2);
		
		tx1=new JTextField(10);
		tx1.setBounds(700,230,200,30);
		add(tx1);
		
		l3=new JLabel("NEW PASSWORD");
		l3.setBounds(500,300,200,100);
		l3.setFont(f2);
		add(l3);
		
		tx2=new JPasswordField(10);
		tx2.setBounds(700,330,200,30);
		add(tx2);
		
		b1=new JButton("CHANGE");
		b1.setBounds(400,500,200,50);
		b1.setBackground(c3);
		add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(800,500,200,50);
		b2.setBackground(c3);
		add(b2);
		
		b1.addActionListener(f);
		b2.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}