import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Adminhome extends JPanel implements ActionListener
{
	JTabbedPane tb;
	Add add;
	Delete del;
	Update up;
	FDemo fmmm;
	JButton b1,b2;
	Adminhome(FDemo f)
	{
		setLayout(new BorderLayout());
		fmmm=f;
		Color c3=new Color(128,214,255);
		
		tb=new JTabbedPane();
		add=new Add(f);
		del=new Delete();
		up=new Update();
		
		tb.add("Add Question",add);
		tb.add("Update Question",up);
		tb.add("Delete Question",del);
		
		b2=new JButton();
		b2.setBackground(c3);
		tb.add("Exit",b2);
		b2.addActionListener(this);
		add(tb);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
	{
		fmmm.card.show(fmmm.cn,"adminlogin2");
	}
	}
}
class Add extends JPanel implements ActionListener
{
	JButton b1,b2;
	JTextField t1,t2,t4,t5,t6,t7,t8,t9;
	JTextArea t3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	ImageIcon img1;
	Image bg;
	FDemo fmmm;
	Add(FDemo f)
	{
		fmmm=f;
		setLayout(null);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Color c3=new Color(128,214,255);
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("Add New Question");
		l1.setBounds(820,30,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Question ID");
		l2.setBounds(390,150,200,100);
		l2.setFont(f2);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(700,180,80,25);
		add(t1);
		
		l3=new JLabel("Question");
		l3.setBounds(400,250,200,40);
		l3.setFont(f2);
		add(l3);
		
		t3=new JTextArea();
		t3.setBounds(700,250,800,200);
		add(t3);
		
		l4=new JLabel("Option 1");
		l4.setBounds(400,500,200,40);
		l4.setFont(f2);
		add(l4);
		
		t4=new JTextField();
		t4.setBounds(700,500,200,25);
		add(t4);
		
		l5=new JLabel("Option 2");
		l5.setBounds(400,550,200,40);
		l5.setFont(f2);
		add(l5);
		
		t5=new JTextField();
		t5.setBounds(700,550,200,25);
		add(t5);
		
		l6=new JLabel("Option 3");
		l6.setBounds(400,600,200,40);
		l6.setFont(f2);
		add(l6);
		
		t6=new JTextField();
		t6.setBounds(700,600,200,25);
		add(t6);
		
		l7=new JLabel("Option 4");
		l7.setBounds(400,650,200,40);
		l7.setFont(f2);
		add(l7);
		
		t7=new JTextField();
		t7.setBounds(700,650,200,25);
		add(t7);
		
		
		l8=new JLabel("Answer");
		l8.setBounds(400,700,200,40);
		l8.setFont(f2);
		add(l8);
		
		t8=new JTextField();
		t8.setBounds(700,700,200,25);
		add(t8);
		
		
		l9=new JLabel("Course Name");
		l9.setBounds(1100,150,200,40);
		l9.setFont(f2);
		add(l9);
		
		t9=new JTextField();
		t9.setBounds(1300,150,200,25);
		add(t9);
		
		b1=new JButton("ADD");
		b1.setBounds(600,800,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BACK");
		b2.setBounds(1000,800,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==b1)
	{
		String s1=t1.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		String s6=t6.getText();
		String s7=t7.getText();
		String s8=t8.getText();
		String s9=t9.getText();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			Statement st=con.createStatement();
			String q=("insert into questions value('"+s1+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')");
			st.executeUpdate(q);
			
			JOptionPane.showMessageDialog(b1,"Data inserted");
			t1.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	if(e.getSource()==b2)
	{
		fmmm.card.show(fmmm.cn,"adminlogin2");
	}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}
class Delete extends JPanel implements ActionListener
{
	JButton b1,b2;
	JTextField t1,t2,t4,t5,t6,t7,t8,t9;
	JTextArea t3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	ImageIcon img1;
	Image bg;
	Delete()
	{
		setLayout(null);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Color c3=new Color(128,214,255);
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		l1=new JLabel("Delete Question");
		l1.setBounds(820,30,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Question ID");
		l2.setBounds(400,150,200,100);
		l2.setFont(f2);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(700,180,80,25);
		add(t1);
		
		l3=new JLabel("Question");
		l3.setBounds(400,250,200,40);
		l3.setFont(f2);
		add(l3);
		
		t3=new JTextArea();
		t3.setBounds(700,250,800,200);
		add(t3);
		
		l4=new JLabel("Option 1");
		l4.setBounds(400,500,200,40);
		l4.setFont(f2);
		add(l4);
		
		t4=new JTextField();
		t4.setBounds(700,500,200,25);
		add(t4);
		
		l5=new JLabel("Option 2");
		l5.setBounds(400,550,200,40);
		l5.setFont(f2);
		add(l5);
		
		t5=new JTextField();
		t5.setBounds(700,550,200,25);
		add(t5);
		
		l6=new JLabel("Option 3");
		l6.setBounds(400,600,200,40);
		l6.setFont(f2);
		add(l6);
		
		t6=new JTextField();
		t6.setBounds(700,600,200,25);
		add(t6);
		
		l7=new JLabel("Option 4");
		l7.setBounds(400,650,200,40);
		l7.setFont(f2);
		add(l7);
		
		t7=new JTextField();
		t7.setBounds(700,650,200,25);
		add(t7);
		
		l8=new JLabel("Answer");
		l8.setBounds(400,700,200,40);
		l8.setFont(f2);
		add(l8);
		
		t8=new JTextField();
		t8.setBounds(700,700,200,25);
		add(t8);
		
		l9=new JLabel("Course Name");
		l9.setBounds(1100,150,200,40);
		l9.setFont(f2);
		add(l9);
		
		t9=new JTextField();
		t9.setBounds(1300,150,200,25);
		add(t9);
		
		b1=new JButton("DELETE");
		b1.setBounds(600,800,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("SEARCH");
		b2.setBounds(1200,800,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			String s1=t1.getText();
			String s2=t9.getText();
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from questions where id='"+s1+"' AND course_name='"+s2+"'");
			    if(rs.next())
			    {
				    t1.setText(rs.getString(1));
			        t3.setText(rs.getString(2));
			        t4.setText(rs.getString(3));
			        t5.setText(rs.getString(4));
			        t6.setText(rs.getString(5));
			        t7.setText(rs.getString(6));
			        t8.setText(rs.getString(7));
				    t9.setText(rs.getString(8));
				}
				else
				JOptionPane.showMessageDialog(null,"data NOt found");
			    con.close();
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
	    }
	    if(e.getSource()==b1)
	    {
		    String s1=t1.getText();
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    String q=("delete from questions where id='"+s1+"'");
			    st.executeUpdate(q);
			
			    JOptionPane.showMessageDialog(b1,"Data deleted");
			    t1.setText(" ");
			    t3.setText(" ");
			    t4.setText(" ");
			    t5.setText(" ");
			    t6.setText(" ");
			    t7.setText(" ");
			    t8.setText(" ");
			    con.close();
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
	    }
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}
class Update extends JPanel implements ActionListener
{
	JButton b1,b2;
	JTextField t1,t2,t4,t5,t6,t7,t8,t9;
	JTextArea t3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	ImageIcon img1;
	Image bg;
	Update()
	{
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		l1=new JLabel("Update Question");
		l1.setBounds(820,30,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Question ID");
		l2.setBounds(400,150,200,100);
		l2.setFont(f2);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(700,180,80,25);
		add(t1);
		
		l3=new JLabel("Question");
		l3.setBounds(400,250,200,40);
		l3.setFont(f2);
		add(l3);
		
		t3=new JTextArea();
		t3.setBounds(700,250,800,200);
		add(t3);
		
		l4=new JLabel("Option 1");
		l4.setBounds(400,500,200,40);
		l4.setFont(f2);
		add(l4);
		
		t4=new JTextField();
		t4.setBounds(700,500,200,25);
		add(t4);
		
		l5=new JLabel("Option 2");
		l5.setBounds(400,550,200,40);
		l5.setFont(f2);
		add(l5);
		
		t5=new JTextField();
		t5.setBounds(700,550,200,25);
		add(t5);
		
		l6=new JLabel("Option 3");
		l6.setBounds(400,600,200,40);
		l6.setFont(f2);
		add(l6);
		
		t6=new JTextField();
		t6.setBounds(700,600,200,25);
		add(t6);
		
		l7=new JLabel("Option 4");
		l7.setBounds(400,650,200,40);
		l7.setFont(f2);
		add(l7);
		
		t7=new JTextField();
		t7.setBounds(700,650,200,25);
		add(t7);
		
		l8=new JLabel("Answer");
		l8.setBounds(400,700,200,40);
		l8.setFont(f2);
		add(l8);
		
		t8=new JTextField();
		t8.setBounds(700,700,200,25);
		add(t8);
		
		l9=new JLabel("Course Name");
		l9.setBounds(1100,150,200,40);
		l9.setFont(f2);
		add(l9);
		
		t9=new JTextField();
		t9.setBounds(1300,150,200,25);
		add(t9);
		
		b1=new JButton("UPDATE");
		b1.setBounds(600,800,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("SEARCH");
		b2.setBounds(1200,800,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			String s1=t1.getText();
			String s2=t9.getText();
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from questions where id='"+s1+"' AND course_name='"+s2+"'");
			    if(rs.next())
			    {
				    t1.setText(rs.getString(1));
			        t3.setText(rs.getString(2));
			        t4.setText(rs.getString(3));
			        t5.setText(rs.getString(4));
			        t6.setText(rs.getString(5));
			        t7.setText(rs.getString(6));
			        t8.setText(rs.getString(7));
				    t9.setText(rs.getString(8));
				}
				else
				JOptionPane.showMessageDialog(null,"data NOt found");
			    con.close();
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
	    }
	    if(e.getSource()==b1)
	    {
		    String s1=t1.getText();
		    String s3=t3.getText();
		    String s4=t4.getText();
		    String s5=t5.getText();
		    String s6=t6.getText();
		    String s7=t7.getText();
		    String s8=t8.getText();
		    String s9=t9.getText();
		    try
		    {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			    Statement st=con.createStatement();
			    String q=("update questions set que='"+s3+"',opt1='"+s4+"',opt2='"+s5+"',opt3='"+s6+"',opt4='"+s7+"',ans='"+s8+"'where course_name='"+s9+"' AND id='"+s1+"' ");
			    st.executeUpdate(q);
			    JOptionPane.showMessageDialog(b1,"Data updated");
			    t1.setText(" ");
			    t3.setText(" ");
			    t4.setText(" ");
			    t5.setText(" ");
			    t6.setText(" ");
			    t7.setText(" ");
			    t8.setText(" ");
			    t9.setText(" ");
			    con.close();
		    }
		    catch(Exception e1)
		    {
			    System.out.println(e1);
		    }
	    }
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}
/*
class Show extends JPanel 
{
	JTable jt;
	Show()
	{
		jt=new JTable();
		jt.setBounds(30,40,200,300);
		add(jt);
	}
}
*/