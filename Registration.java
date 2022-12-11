import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class Registration extends JPanel implements ActionListener
{
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l9,l10;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
	//JRadioButton r1,r2,r3;
	JComboBox cb1,cb2,cb3;
	ImageIcon img1,img2;
	Image bg,reg;
	Registration(FDemo f)
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		//img2=new ImageIcon("reg.png");
		//reg=img2.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("REGISTRATION FORM");
		l1.setBounds(700,10,400,200);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("USERNAME");
		l2.setBounds(300,150,200,100);
		l2.setFont(f2);
		add(l2);
		
		tx1=new JTextField(10);
		tx1.setBounds(450,180,200,30);
		add(tx1);
		
		l3=new JLabel("PASSWORD");
		l3.setBounds(800,140,200,100);
		l3.setFont(f2);
		add(l3);
		
		tx2=new JPasswordField(10);
		tx2.setBounds(920,180,200,30);
		add(tx2);
		
		l4=new JLabel("NAME");
		l4.setBounds(500,200,200,100);
		l4.setFont(f2);
		add(l4);
		
		tx3=new JTextField(10);
		tx3.setBounds(720,230,200,30);
		add(tx3);
		
		tx4=new JTextField(10);
		tx4.setBounds(940,230,200,30);
		add(tx4);
		
		l5=new JLabel("MOBILE NO.");
		l5.setBounds(480,270,200,100);
		l5.setFont(f2);
		add(l5);
		
		tx5=new JTextField(10);
		tx5.setBounds(720,300,200,30);
		add(tx5);
		
		l6=new JLabel("GENDER");
		l6.setBounds(490,330,200,100);
		l6.setFont(f2);
		add(l6);
		
		/*
		ButtonGroup bg=new ButtonGroup();
		r1=new JRadioButton("Male");
		r1.setBounds(700,360,100,30);
		r1.setFont(f2);
		bg.add(r1);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(900,360,100,30);
		r2.setFont(f2);
		bg.add(r2);
		add(r2);
		
		r3=new JRadioButton("Other");
		r3.setBounds(1100,360,100,30);
		r3.setFont(f2);
		bg.add(r3);
		add(r3);
		*/
		
		
		tx6=new JTextField(10);
		tx6.setBounds(720,360,200,30);
		add(tx6);
		
		l7=new JLabel("EMAIL");
		l7.setBounds(500,400,200,100);
		l7.setFont(f2);
		add(l7);
		
		tx7=new JTextField(10);
		tx7.setBounds(720,430,500,30);
		add(tx7);
		
	    l9=new JLabel("COLLEGE");
		l9.setBounds(500,470,200,100);
		l9.setFont(f2);
		add(l9);
		
		tx8=new JTextField(10);
		tx8.setBounds(720,500,200,30);
		add(tx8);
		
		l10=new JLabel("ADDRESS");
		l10.setBounds(500,550,200,100);
		l10.setFont(f2);
		add(l10);
		
		tx9=new JTextField(10);
		tx9.setBounds(720,580,400,80);
		add(tx9);
	
		b1=new JButton("SUBMIT");
		b1.setBounds(400,730,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("RESET");
		b2.setBounds(800,730,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("BACK");
		b3.setBounds(100,950,200,30);
		b3.setBackground(c3);
		add(b3);
		b3.addActionListener(f);	
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
	       String s1=tx1.getText();
		   String s2=tx2.getText();
		   String s3=tx3.getText();
		   String s4=tx4.getText();
		   String s5=tx5.getText();
		   String s6=tx6.getText();
		   /*
		   String s6="";
           public void itemStateChanged(ItemEvent e2)
            {
                if(e.getSource()==r1)
                {
                    s6=r1.getText();
                    //System.out.println(s);
                }
                else if(e.getSource()==r2)
                {
                    s6=r2.getText();
                    //System.out.println(s);
                }
				*/
		   String s7=tx7.getText();
		   String s8=tx8.getText();
		   String s9=tx9.getText();
	       String s10="";
		
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    st.executeUpdate("insert into login values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')");
			    JOptionPane.showMessageDialog(null,"registration done...");
			    con.close();
			    tx1.setText(" ");
			    tx2.setText(" ");
			    tx3.setText(" ");
			    tx4.setText(" ");
			    tx5.setText(" ");
			    tx6.setText(" ");
			    tx7.setText(" ");
			    tx8.setText(" ");
			    tx9.setText(" ");
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
		}
		/*
		if(e.getSource()==b2)
		{
		    String s1=tx1.getText();
		    String s2=tx2.getText();
		    String s3=tx3.getText();
		    String s4=tx4.getText();
		    String s5=tx5.getText();
		    String s6=tx6.getText();
		    String s7=tx7.getText();
		    String s8=tx8.getText();
		    String s9=tx9.getText();
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    String q=("update login set Uname='"+s1+"',Upass='"+s2+"',Firstname='"+s3+"',Lastname='"+s4+"',Mobile='"+s5+"',Gender='"+s6+"',Email='"+s7+"',College='"+s8+"',Email='"+s9+"'");
			    st.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"data reset...");
			
			    tx1.setText(" ");
			    tx2.setText(" ");
			    tx3.setText(" ");
			    tx4.setText(" ");
			    tx5.setText(" ");
			    tx6.setText(" ");
			    tx7.setText(" ");
			    tx8.setText(" ");
			    tx9.setText(" ");
			    con.close();
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
		
	    }
		*/
	}
}