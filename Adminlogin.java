import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class Adminlogin extends JPanel implements KeyListener
{
	JLabel l1;
	JButton b1,b2;
	JTextField tx1;
	JPasswordField tx2;
	ImageIcon img1;
	Image bg;
	Adminlogin(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		l1=new JLabel("ADMIN LOGIN");
		l1.setBounds(780,50,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		tx1=new JTextField("ENTER USERNAME",10);
		tx1.setBounds(750,230,300,60);
		tx1.setForeground(Color.gray);
		tx1.addKeyListener(this);
		add(tx1);
		
		tx2=new JPasswordField("ENTER PASSWORD",10);
		tx2.setBounds(750,330,300,60);
		tx2.setForeground(Color.gray);
		tx2.addKeyListener(this);
		tx2.setEchoChar((char)0);
		add(tx2);

		
		b1=new JButton("LOGIN");
		b1.setBounds(800,500,200,50);
		b1.setBackground(c3);
		add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(800,700,200,50);
		b2.setBackground(c3);
		add(b2);
		
		b1.addActionListener(f);
		b2.addActionListener(f);
	}
	public void keyReleased(KeyEvent e)
	{
		if(tx1.isFocusOwner())
		{
		  String s1=tx1.getText().trim();
		   if(s1.equals(""))
		  {
			tx1.setText("ENTER USERNAME");
			tx1.setForeground(Color.gray);
		  }
		}
		if(tx2.isFocusOwner())
		{
		  String s1=tx2.getText().trim();
		   if(s1.equals(""))
		  {
			tx2.setText("ENTER PASSWORD");
			tx2.setForeground(Color.gray);
		  }
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if(tx1.isFocusOwner())
		{
			String s1=tx1.getText();
		    if(s1.equals("ENTER USERNAME"))
		    {
			tx1.setText("");
			tx1.setForeground(Color.black);
		   }
		}
		if(tx2.isFocusOwner())
		{
			String s1=tx2.getText();
		    if(s1.equals("ENTER PASSWORD"))
		   {
			tx2.setText("");
			tx2.setEchoChar('*');
			tx2.setForeground(Color.black);
		   }
		}
		
	}
	public void keyTyped(KeyEvent e) {}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}