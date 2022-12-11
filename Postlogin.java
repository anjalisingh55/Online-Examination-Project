import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Postlogin extends JPanel implements ActionListener
{
	JButton b1,b2,b3;
	static JLabel l1,l2;
	static JComboBox cb1;
	ImageIcon img1;
	Image bg;
	FDemo fmmm;
	Postlogin(FDemo f)
	{
		
		fmmm=f;
		setLayout(null);
		
		Color c3=new Color(128,214,255);
		
		img1=new ImageIcon("bg.jpg");
		bg=img1.getImage();
		
		Font f1=new Font("Bernard MT Condensed",Font.PLAIN,40);
		setFont(f1);
		
		Font f2=new Font("Bernard MT Condensed",Font.PLAIN,30);
		setFont(f2);
		
		l1=new JLabel();
		l1.setBounds(820,80,400,100);
		l1.setFont(f1);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel("Select Course");
		l2.setBounds(670,200,400,100);
		l2.setFont(f2);
		add(l2);
		
		cb1=new JComboBox();
		cb1.setBounds(900,220,300,50);
		cb1.addItem("None");
		cb1.addItem("APPTITUDE");
		cb1.addItem("JAVA");
		cb1.addItem("DBMS");
		add(cb1);
		
		b1=new JButton("START TEST");
		b1.setBounds(400,500,200,80);
		b1.setBackground(c3);
		add(b1);
		
		b2=new JButton("CHANGE PASSWORD");
		b2.setBounds(850,500,200,80);
		b2.setBackground(c3);
		add(b2);
		
		b3=new JButton("LOGOUT");
		b3.setBounds(1300,500,200,80);
		b3.setBackground(c3);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			fmmm.card.show(fmmm.cn,"changepass");
		}
		if(e.getSource()==b3)
		{
			fmmm.card.show(fmmm.cn,"userlogin");
		}
		if(e.getSource()==b1)
		{
			String Q=(String)cb1.getSelectedItem();
			if(Q!="None")
			{
			try
	        {
         	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
	        Statement st=con.createStatement();
	        st.executeUpdate("update save set sub='"+Q+"' where name='"+FDemo.s1+"'");
	        con.close();
	        }
	        catch(Exception e1){e1.printStackTrace();}
			Questions.count++;
			Questions.view(Q);
			Questions.time.start();
			fmmm.card.show(fmmm.cn,"instructions");
			}
			else
			JOptionPane.showMessageDialog(null,"Please select subject firstly...");
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bg,7,15,this);
	}
}