import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Instructions extends JPanel
{
	JLabel l1;
	JButton b1,b2;
	ImageIcon img1;
	Image bg;
	Instructions(FDemo f)
	{
		setLayout(null);
		
		//Color c2=new Color(128,214,255);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,50);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("--------------------INSTRUCTIONS-------------------");
		l1.setBounds(550,5,900,200);
		l1.setFont(f1);
		l1.setForeground(Color.red);
		add(l1);
		
		b1=new JButton("NEXT");
		b1.setBounds(500,800,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(f);
		
		b2=new JButton("BACK");
		b2.setBounds(1300,800,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
		
		g.drawString("* First user has to fill all his details in the registration form.",600,200);
		g.drawString("* All the filled details by the user must be correct.",600,250);
		g.drawString("* Then user should login with his/her respective username and password to start the test.",600,300);
		g.drawString("* Click on the next button to start the test.",600,350);
		g.drawString("* There is no negative marking for wrong answers.",600,400);
		g.drawString("* Only submitted answers will be considered in final result",600,450);
		g.drawString("* Your test will be started when you click the start test button.",600,500);
		g.drawString("* To know your result click on 'Submit' button.",600,550);
		g.drawString("* Test must be completed within the given time period.",600,600);
		g.drawString("* If any candidate starts the test late due to his/her own reasons then no extra time will be given to them.",600,650);
	    setForeground(Color.yellow);
	}
}