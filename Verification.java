import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Verification extends JPanel implements ActionListener
{
	FDemo fmmm;
	JTextField tx1;
	ImageIcon img1;
	Image bg;
	String s=""; 
	String s1,s2,s3,s4;
	String a="Verfied";
	JLabel l1,l2,l3,l4,l5,l6,l7,a1;
	JButton b1,b3,b2;
	Verification()
	{}
	Verification(FDemo f)
	{
		setLayout(null);
		fmmm=f;
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,50);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		a1=new JLabel("VERIFICATION PAGE");
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		l6=new JLabel();
		l7=new JLabel();
		
		a1.setBounds(650,70,400,40);
		l1.setBounds(770,200,400,40);
		l2.setBounds(650,200,400,40);
		l3.setBounds(650,250,400,40);
		l4.setBounds(650,300,400,40);
		l5.setBounds(650,350,400,40);
		l6.setBounds(650,400,400,40);
		l7.setBounds(650,450,400,40);
		
		a1.setForeground(Color.white);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);
		l7.setForeground(Color.white);
		
		l1.setFont(f2);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		
		add(a1);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBounds(775,500,120,40);
		b1.setFont(f2);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Refresh");
		b2.setBounds(775,140,120,40);
		b2.setFont(f2);
		b2.addActionListener(this);
		add(b2);
	    
		b3=new JButton("Back");
		b3.setBounds(100,100,120,40);
		b3.addActionListener(f);
		add(b3);
		b3.setFont(f2);
	
		a1.setFont(f1);
		view();	
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
	void view()
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from login where verify='"+s+"'");
	if(rs.next())
	{
		b1.setOpaque(true);
		b1.setContentAreaFilled(true);
		b1.setBorderPainted(true);
		b1.setText("verify");
		s1=rs.getString(1);
		l2.setText("Name = "+rs.getString(3)+" "+rs.getString(4));
		l3.setText("Mobile no. ="+rs.getString(5));
		l4.setText("Gender ="+rs.getString(6));
		l5.setText("E-mail ="+rs.getString(7));
		l6.setText("College name ="+rs.getString(8));
		l7.setText("Address ="+rs.getString(9));
	}
	else
	{
		l1.setText("Data not found");
	}
	con.close();
	}
	catch(Exception e1){e1.printStackTrace();}
	}
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==b1)
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
	Statement st=con.createStatement();
	st.executeUpdate("Update login set verify='"+a+"' where uname='"+s1+"'");
	JOptionPane.showMessageDialog(null,"data verified");
	l1.setText("");
	l2.setText("");
	l3.setText("");
	l4.setText("");
	l5.setText("");
	l6.setText("");
	l7.setText("");
	b1.setText("");
	b1.setOpaque(false);
	b1.setContentAreaFilled(false);
	b1.setBorderPainted(false);
	b1.removeActionListener(this);
	con.close();
	}
	catch(Exception e1){e1.printStackTrace();}
	}
	if(e.getSource()==b2)
	view();
	}
}