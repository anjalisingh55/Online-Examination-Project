import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class save extends JPanel 
{
	JTable jt;
	JTextField tx1;
	JLabel l1;
	JButton b2;
	ImageIcon img1;
	Image bg;
	JScrollPane sp;
	String s[]={"Name","Subject","Correct","Wrong"};
	String data[][]=new String[50][4];
	save(FDemo f)
	{
		setLayout(null);
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,20);
		setFont(f2);
		
		jt=new JTable(data,s);
		sp=new JScrollPane(jt);
		sp.setBounds(300,200,1200,600);
		jt.setPreferredScrollableViewportSize(new Dimension(1200,800));
		add(sp);
		Color c3=new Color(128,214,255);
		
	    img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		
		l1=new JLabel("Students Result");
		l1.setBounds(820,50,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		b2=new JButton("BACK");
		b2.setBounds(100,100,120,40);
		b2.setBackground(c3);
		add(b2);
		b2.addActionListener(f);
		
		int y=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from save ");
			while(rs.next())
			{
				data[y][0]=rs.getString(1);
				data[y][1]=rs.getString(2);
				data[y][2]=rs.getString(3);
				data[y][3]=rs.getString(4);
				y++;
			}
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getStackTrace());
		}
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}