import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Questions extends JPanel implements ActionListener
{
	static String s1,s2,s3,s4,s5,s6,s7,s8,Q;
    JButton b1,b2,b3,b4;
	JTabbedPane tb;
	static JTextField t2,t3,t4,t5,t6;
	static JTextArea t1;
	JLabel l1,l2,l3,l4,t;
	static JRadioButton r1,r2,r3,r4;
	ImageIcon img1;
	Image bg;
	static Timer time;
	int sec=0,min=0;
	static ButtonGroup bg1;
	static int count=0;
	Questions(FDemo f)
	{
		setLayout(null);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Color c3=new Color(128,214,255);
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		tb=new JTabbedPane();
		tb.setBounds(250,200,1400,600);
		// tb.setBounds(100,100,1100,500);
		
		l1=new JLabel("Questions");
		l1.setBounds(840,30,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Question -");
		l2.setBounds(300,230,200,40);
		// l2.setBounds(150,230,200,40);
		l2.setFont(f2);
		add(l2);
		
		t1=new JTextArea();
		t1.setBounds(500,230,1000,300);
		// t1.setBounds(250,230,900,150);
		add(t1);
		
		l3=new JLabel("Course Name");
		l3.setBounds(300,150,200,40);
		// l3.setBounds(150,150,200,40);
		l3.setFont(f2);
		add(l3);
		
		t2=new JTextField();//course name
		t2.setBounds(500,150,200,25);
		// t2.setBounds(300,150,200,25);
		add(t2);
		
		l4=new JLabel("Options -");
		// l4.setBounds(150,400,200,40);
		l4.setBounds(300,550,200,40);
		l4.setFont(f2);
		add(l4);
		
		t=new JLabel("Timer : ");
		// t.setBounds(850,130,200,40);
		t.setBounds(1400,150,200,40);
		t.setFont(f2);
		add(t);
		
        bg1=new ButtonGroup();

		r1=new JRadioButton("1");
		r1.setBounds(500,550,50,30);
		// r1.setBounds(250,400,50,30);
		r1.setFont(f2);
		//r1.setBackground(Color.blue);
		add(r1);
		bg1.add(r1);
		
		t3=new JTextField();
		t3.setBounds(600,550,300,30);
		// t3.setBounds(300,400,300,30);
		add(t3);
		
		r2=new JRadioButton("2");
		r2.setBounds(500,600,50,30);
		// r2.setBounds(250,450,50,30);
		r2.setFont(f2);
		bg1.add(r2);
		add(r2);
		
		t4=new JTextField();
		t4.setBounds(600,600,300,30);
		// t4.setBounds(300,450,300,30);
		add(t4);
		
		r3=new JRadioButton("3");
		r3.setBounds(500,650,50,30);
		// r3.setBounds(250,500,50,30);
		r3.setFont(f2);
		bg1.add(r3);
		add(r3);

		t5=new JTextField();
		t5.setBounds(600,650,300,30);
		// t5.setBounds(300,500,300,30);
		add(t5);
		
		r4=new JRadioButton("4");
		r4.setBounds(500,700,50,30);
		// r4.setBounds(250,550,50,30);
		r4.setFont(f2);
		bg1.add(r4);
		add(r4);
		
		t6=new JTextField();
		t6.setBounds(600,700,300,30);
		// t6.setBounds(300,550,300,30);
		add(t6);
		add(tb);
		
		b1=new JButton("PREVIOUS");
		b1.setBounds(300,830,200,50);
		// b1.setBounds(150,600,200,50);
		b1.setBackground(c3);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("NEXT");
		b2.setBounds(800,830,200,50);
		// b2.setBounds(400,600,200,50);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(this);
		
		b4=new JButton("Submit");
		b4.setBounds(1400,830,200,50);
		// b4.setBounds(900,600,200,50);
		b4.setBackground(c3);
		add(b4);
		b4.addActionListener(f);
		
		b3=new JButton("BACK");
		b3.setBounds(800,920,200,50);
		b3.setBackground(c3);
		add(b3);
		b3.addActionListener(f);
	
	time=new Timer(1000,new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	t.setText("Timer : "+String.valueOf(min)+" m : "+String.valueOf(sec)+" s");
	if(sec==60)
	{  
    sec=0;
	min++;
    if(min==20)
	{
	time.stop();  
    JOptionPane.showMessageDialog(null,"Time over");
	}
    }
    sec++;
	}
	});
	}
// =================================================================================================================
	public static void save(String Q)
    {
	String ans;
	if(r1.isSelected())
    ans=s3;
    else if(r2.isSelected())
	ans=s4;
    else if(r3.isSelected())
	ans=s5;
	else if(r4.isSelected())
	ans=s6;
    else 
	ans=null;

    if(s2!=null&&s7!=null)
    {
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	// Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/on_exam?useSSL=false","root","root");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
	// Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anjali?useSSL=false","root","renu");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from result where ques='"+s2+"' ");
	if(rs.next())
	st.executeUpdate("update result set ans='"+ans+"' where ques='"+s2+"' ");
    else 
	st.executeUpdate("insert into result values('"+s2+"','"+ans+"','"+s7+"','"+Q+"')");
	con.close();
	}
	catch(Exception e1){e1.printStackTrace();}
	}
	else return;
    }
	public static void view(String Q)
	{
		save(Q);
		bg1.clearSelection();
		int x=0;
		if(Q!="None")
		{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			// Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anjali?useSSL=false","root","renu");
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("Select * from questions where course_name='"+Q+"' ");
		    while(r.next())
			x++;
		    if(count<=0)
			count=1;
		    else if(count>x)
			--count;
			
			ResultSet rs=st.executeQuery("select * from questions where id='"+count+"' AND course_name='"+Q+"' ");
			if(rs.next())
			{
				s1=rs.getString(8);
				s2=rs.getString(2);
				s3=rs.getString(3);
				s4=rs.getString(4);
				s5=rs.getString(5);
				s6=rs.getString(6);
				s7=rs.getString(7);//correct answer
				
				t2.setText(s1);
				t1.setText(s2);
				t3.setText(s3);
				t4.setText(s4);
				t5.setText(s5);
				t6.setText(s6);
			}
			
			ResultSet rs1=st.executeQuery("select * from result where ques='"+s2+"' ");
		if(rs1.next())
		{
			String v=rs1.getString(3);
			if(s3.equals(v))
			r1.setSelected(true);
			else if(s4.equals(v))
			r2.setSelected(true);
		    else if(s5.equals(v))
			r3.setSelected(true);
		    else if(s6.equals(v))
			r4.setSelected(true);
		    else
			bg1.clearSelection();
		}
	   con.close();
			
			con.close();
		}catch(Exception e1){System.out.println(e1);}	
		}
	}
	public void actionPerformed(ActionEvent e) 
	{
		Q=(String)Postlogin.cb1.getSelectedItem();
		if(e.getSource()==b2)
		{
			++count;
			view(Q);
		}
		if(e.getSource()==b1)
		{
			--count;
			view(Q);
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}