import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
 class  FDemo extends JFrame implements ActionListener
{
	int c,w;
	static String s1;
	Container cn=getContentPane();
	CardLayout card;
	Home hm;
	Registration rg;
	Login lg;
	Userlogin ul;
	Adminlogin al;
	Adminlogin2 al2;
	Verification vf;
	Postlogin pl;
	ChangePass cp;
	Users us;
	Adminhome ah;
	Instructions in;
	Questions ques;
	Result re;
	save s;
	FDemo()
	{
		card=new CardLayout();
		setLayout(card);
	
		hm=new Home(this);
		add("home",hm);
		
		vf=new Verification(this);
		add("verification",vf);
		
		ul=new Userlogin(this);
		add("userlogin",ul);
	    
		s=new save(this);
		add("save",s);
		
		Postlogin pl=new Postlogin(this);
		add("postlogin",pl);
		
		lg=new Login(this);
		add("login",lg);
		
		al=new Adminlogin(this);
		add("adminlogin",al);
		
		al2=new Adminlogin2(this);
		add("adminlogin2",al2);
		
		re=new Result(this);
		add("result",re);
		
		ques=new Questions(this);
		add("questions",ques);
		
		cp=new ChangePass(this);
		add("changepass",cp);
		
		us=new Users(this);
		add("users",us);
		
		ah=new Adminhome(this);
		add("adminhome",ah);
		
		in=new Instructions(this);
		add("instructions",in);
		
		rg=new Registration(this);
		add("registration",rg);
	}
	public void actionPerformed(ActionEvent e)
	{
	String crr,ans;
	if(e.getSource()==ques.b4)
    {
	card.show(cn,"result");
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from result");
	while(rs.next())
	{
      crr=rs.getString(2);		
      ans=rs.getString(3);
      if(crr.equals(ans))	
      c++;
      if(!crr.equals(ans))
      w++;		  
	}
	st.executeUpdate("update save set score='"+c+"', wrong='"+w+"' where name='"+s1+"'");
	re.l1.setText("Correct : "+c);
	re.l2.setText("Wrong : "+w);
	con.close();
	}
	catch(Exception e1){e1.printStackTrace();}
	}	
		if(e.getSource()==hm.b2)
		{
			card.show(cn,"login");
		}
		if(e.getSource()==lg.b1)
		{
			card.show(cn,"userlogin");
		}
		if(e.getSource()==lg.b2)
		{
			card.show(cn,"adminlogin");
		}
		if(e.getSource()==lg.b3)
		{
			card.show(cn,"home");
		}
		if(e.getSource()==ul.b4)
		{
			card.show(cn,"login");
		}
		if(e.getSource()==al.b2)
		{
			card.show(cn,"login");
		}
		if(e.getSource()==s.b2)
		{
			card.show(cn,"adminlogin2");
		}
		if(e.getSource()==al.b1)
		{
			String a1=al.tx1.getText();
			String a2=al.tx2.getText();
			
			try
		    {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin where Uname='"+a1+"' AND Upass='"+a2+"'");
			if(rs.next())
			card.show(cn,"adminlogin2");
			else
			JOptionPane.showMessageDialog(null,"Acess denied");
			con.close();
			al.tx1.setText("");
			al.tx2.setText("");
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
			
		}
		if(e.getSource()==rg.b3)
		{
			card.show(cn,"login");
		}
		if(e.getSource()==al2.b2)
		{
			card.show(cn,"verification");
		}
		if(e.getSource()==al2.b4)
		{
			card.show(cn,"users");
		}
		if(e.getSource()==al2.b5)
		{
			card.show(cn,"adminlogin");
		}
		if(e.getSource()==al2.b3)
		{
			card.show(cn,"adminhome");
		}
		if(e.getSource()==al2.b6)
		{
			card.show(cn,"changepass");
		}
		if(e.getSource()==al2.b1)
		{
			card.show(cn,"save");
		}
		if(e.getSource()==vf.b3)
		{
			card.show(cn,"adminlogin2");
		}
		if(e.getSource()==vf.b1)
		{
			card.show(cn,"users");
		}
		if(e.getSource()==cp.b2)
		{
			card.show(cn,"adminlogin");
		}
		if(e.getSource()==us.b2)
		{
			card.show(cn,"adminlogin2");
		}
		if(e.getSource()==ques.b3)
		{
			card.show(cn,"instructions");
		}
		if(e.getSource()==ul.b1)
		{
			s1=ul.tx1.getText();
			String s2=ul.tx2.getText();
			try
		    {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false&allowPublicKeyRetrieval=true","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from login where Uname='"+s1+"' AND Upass='"+s2+"' AND verify='Verfied'");
			if(rs.next())
			{
				pl.l1.setText("WELCOME  "+s1);
				card.show(cn,"postlogin");
				ResultSet r=st.executeQuery("select * from save where name='"+s1+"' ");
				if(!r.next())
				st.executeUpdate("insert into save(name) value('"+s1+"') ");
				st.executeUpdate("delete from result");
			}
			else
			{
				ResultSet rs1=st.executeQuery("select * from login where Uname='"+s1+"' AND Upass='"+s2+"' AND verify=''");
				if(rs1.next())
				JOptionPane.showMessageDialog(null,"Verification pending");
				else
				JOptionPane.showMessageDialog(null,"Invalid data");
			}
			con.close();
			ul.tx1.setText("");
			ul.tx2.setText("");
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		}
		if(e.getSource()==vf.b2)
		{
		        String s1=vf.tx1.getText();
		        try
		        {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			        Statement st=con.createStatement();
			        ResultSet rs=st.executeQuery("select * from login where Uname='"+s1+"'");
			        if(rs.next())
			        {
				        JOptionPane.showMessageDialog(null,"User Verified");
			        }
			        else
			        {
				        JOptionPane.showMessageDialog(null,"User Not Found");
			        }
			        con.close();
				}
		        catch(Exception e1)
		        {
			        System.out.println(e1);
		        }
	    }
		if(e.getSource()==cp.b1)
		{
		        String s1=cp.tx1.getText();
		        String s2=cp.tx2.getText();
				int x=0,x1=0;
		        try
		        {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_examination?useSSL=false","root","root");
			        Statement st=con.createStatement();
			        x=st.executeUpdate("update login set Upass='"+s2+"' where upass='"+s1+"'");
					if(x!=0)
					JOptionPane.showMessageDialog(null,"Password Changed");
			        else
					{
						x1=st.executeUpdate("update admin set Upass='"+s2+"' where upass='"+s1+"'");
						if(x1!=0)
					    JOptionPane.showMessageDialog(null,"Password Changed");
						else
                        JOptionPane.showMessageDialog(null,"NO match found");							
					}
					cp.tx1.setText("");
					cp.tx2.setText("");
					con.close();
				}
		        catch(Exception e1)
		        {
			        System.out.println(e1);
		        }
	    }
		if(e.getSource()==ul.b3)
		{
			card.show(cn,"registration");
		}
		if(e.getSource()==in.b1)
		{
			card.show(cn,"questions");
		}
		if(e.getSource()==in.b2)
		{
			card.show(cn,"postlogin");
		}
		
	}
}
class Demo
{
	public static void main(String args[])
	{
		int w=1900;
		int h=1100;
		FDemo f=new FDemo();
		f.setVisible(true);
		//f.setBounds(0,0,1700,800);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		f.setBounds((d.width-w)/2,(d.height-h)/2,w,h);
		
		Image i=t.getImage("icon.png");
		f.setIconImage(i);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}