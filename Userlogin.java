import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Userlogin extends JPanel 
{
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4;
	JTextField tx1;
	JPasswordField tx2;
	ImageIcon img1;
	FDemo fmain;
	Image bg;
	Userlogin(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("USER LOGIN");
		l1.setBounds(800,50,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("USERNAME");
		l2.setBounds(700,200,200,100);
		l2.setFont(f2);
		add(l2);
		
		tx1=new JTextField(10);
		tx1.setBounds(820,230,200,40);
		add(tx1);
		
		l3=new JLabel("PASSWORD");
		l3.setBounds(700,300,200,100);
		l3.setFont(f2);
		add(l3);
		
		tx2=new JPasswordField(10);
		tx2.setBounds(820,330,200,40);
		add(tx2);
		
		b1=new JButton("LOGIN"); 
		b1.setBounds(850,420,100,40);
		b1.setBackground(c3);
		add(b1);
		
		l4=new JLabel("New User -");
		l4.setBounds(650,510,200,50);
		l4.setFont(f2);
		add(l4);
		
		b3=new JButton("REGISTER");
		b3.setBounds(800,510,200,50);
		b3.setBackground(c3);
		add(b3);
		
		b4=new JButton("BACK");
		b4.setBounds(800,600,200,50);
		b4.setBackground(c3);
		add(b4);
		
		b1.addActionListener(f);
		b3.addActionListener(f);
		b4.addActionListener(f);
	}
	// public void actionPerformed(ActionEvent e)
	// {
		
		// if(e.getSource()==b1)
		// {
			// String s1=tx1.getText();
			// String s2=tx2.getText();
			// try
		// {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			// Statement st=con.createStatement();
			// ResultSet rs=st.executeQuery("select * from login where Uname='"+s1+"' AND Upass='"+s2+"'");
			// if(rs.next())
			// {
				// fmain.card.show(fmain.cn,"postlogin");
			// }
			// else
			// {
				// fmain.card.show(fmain.cn,"userlogin");
			// }
			// con.close();
			// tx1.setText(" ");
			// tx2.setText(" ");
		// }
		// catch(Exception e1)
		// {
			// System.out.println(e1.getStackTrace());
		// }
		// }
	// }
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}