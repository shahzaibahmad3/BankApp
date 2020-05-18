import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OpenAcc extends JFrame implements ActionListener {
	
	JLabel b,wc,fname1,lname1,phone1,mail1,father1,add1,pass11,pass21,box,z;
	JTextField fname,lname,phone,mail,father,add,pass1,pass2;
	JComboBox bank;
	JButton signup,back;
	JCheckBox ch;
	
	
	public void ShowP() {
		super.setBounds(200,60,920,582);
		super.setTitle("OPEN ACCOUNT");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\b_open.png");
		ImageIcon p1=new ImageIcon("images\\open.png");
		ImageIcon p2=new ImageIcon("images\\depo.png");
		ImageIcon p3=new ImageIcon("images\\with.png");
		ImageIcon p4=new ImageIcon("images\\check.png");
		ImageIcon p5=new ImageIcon("images\\deac.png");
		ImageIcon p6=new ImageIcon("images\\tran.png");
		ImageIcon p7=new ImageIcon("images\\goback.png");
		
		Font f1=new Font("",Font.PLAIN,16);
		
		 back=new JButton();
		 back.setBounds(0,0,40,34);
		 back.setIcon(p7);
		 super.add(back);
		 back.addActionListener(this);
		
		b=new JLabel("Select Bank* : ");
		b.setBounds(80,120,200,30);
		b.setFont(f1);
		b.setForeground(Color.darkGray);
		super.add(b);
		
		String[] banks= {"SBI","PNB","ICICI","HDFC","UBI"};
		bank=new JComboBox(banks);
		bank.setBounds(180,120,200,30);
		bank.setForeground(Color.darkGray);
		bank.setBackground(Color.WHITE);
		super.add(bank);
		
		fname1=new JLabel("First Name* : ");
		fname1.setBounds(80,170,200,30);
		fname1.setFont(f1);
		fname1.setForeground(Color.darkGray);
		super.add(fname1);
		
		
		fname=new JTextField();
		fname.setBounds(180,170,200,30);
		fname.setFont(f1);
		super.add(fname);
		
		lname1=new JLabel("Last Name : ");
		lname1.setBounds(420,170,200,30);
		lname1.setFont(f1);
		lname1.setForeground(Color.darkGray);
		super.add(lname1);
		
		
		lname=new JTextField();
		lname.setBounds(520,170,200,30);
		lname.setFont(f1);
		super.add(lname);

		father1=new JLabel("Father's Name* : ");
		father1.setBounds(64,240,200,30);
		father1.setFont(f1);
		father1.setForeground(Color.darkGray);
		super.add(father1);
		
		
		father=new JTextField();
		father.setBounds(180,240,200,30);
		father.setFont(f1);
		super.add(father);
		
		add1=new JLabel("Address* : ");
		add1.setBounds(420,240,200,30);
		add1.setFont(f1);
		add1.setForeground(Color.darkGray);
		super.add(add1);
		
		
		add=new JTextField();
		add.setBounds(520,240,200,30);
		add.setFont(f1);
		super.add(add);
		
		
	    phone1=new JLabel("Phone* : ");
		phone1.setBounds(80,310,200,30);
		phone1.setFont(f1);
		phone1.setForeground(Color.darkGray);
		super.add(phone1);
		
		
		phone=new JTextField();
		phone.setBounds(180,310,200,30);
		phone.setFont(f1);
		super.add(phone);
		
		mail1=new JLabel("Mail ID* : ");
		mail1.setBounds(420,310,200,30);
		mail1.setFont(f1);
		mail1.setForeground(Color.darkGray);
		super.add(mail1);
		
		
		mail=new JTextField();
		mail.setBounds(520,310,200,30);
		mail.setFont(f1);
		super.add(mail);
		
		
	     	pass11=new JLabel("Password* : ");
			pass11.setBounds(80,380,200,30);
			pass11.setFont(f1);
			pass11.setForeground(Color.darkGray);
			super.add(pass11);
			
			
			pass1=new JTextField();
			pass1.setBounds(180,380,200,30);
			pass1.setFont(f1);
			super.add(pass1);
			
			pass21=new JLabel("Confirm* : ");
			pass21.setBounds(420,380,200,30);
			pass21.setFont(f1);
			pass21.setForeground(Color.darkGray);
			super.add(pass21);
			
			
			pass2=new JTextField();
			pass2.setBounds(520,380,200,30);
			pass2.setFont(f1);
			super.add(pass2);
			
			 signup=new JButton();
			 signup.setBounds(520,470,200,44);
			 signup.setIcon(new ImageIcon("images\\signup.png"));
			 super.add(signup);
			 signup.addActionListener(this);
			 
			 
			
			ch=new JCheckBox("Accept all Terms and Conditions.");
			ch.setBounds(465,440,255,20);
			ch.setFont(f1);
			super.add(ch);
			ch.addActionListener(this);
			
		   z=new JLabel();
		   z.setBounds(570,412,200,20);
		   z.setForeground(Color.RED);
		   super.add(z);
		   
			
			
		
		
		wc=new JLabel();
		wc.setBounds(0,0,920,582);
		wc.setIcon(i);
		super.add(wc);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ch) {
			Terms t=new Terms();
			t.ShowP();
		}
		if(e.getSource()==back) {
			this.dispose();
			HomePage hp=new HomePage();
			hp.ShowP();
		}
		
		if(e.getSource()==signup) {
			String bt=""+bank.getSelectedItem();
			String name=fname.getText(),name1=lname.getText(),
				fath=father.getText(),addr=add.getText(),
				pno=phone.getText(),mid=mail.getText(),
				pas1=pass1.getText(),pas2=pass2.getText();
			
				if(!name.isEmpty() && !fath.isEmpty() && !addr.isEmpty()
						&& !pno.isEmpty() && !mid.isEmpty() && !pas1.isEmpty()) {
					if(pas1.contentEquals(pas2)) {
						z.setText(null);
						
						
						
						
						try {
							Class.forName("com.mysql.jdbc.Driver");
							java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8917"); 
							Statement st=co.createStatement();
							ResultSet rss=st.executeQuery("select * from "+bt+" where phone='"+pno+"'");
				     		if(!rss.next()) {
				     			ResultSet rs=st.executeQuery("select count(*) from "+bt);
				     			rs.next();
								int num=rs.getInt(1)+1;
								String accno=bt+"100"+num;
							st.executeUpdate("insert into "+bt+" values('"+accno+"','"+name+"','"+name1+"','"+pno+"','"+mid+"','"+0+"','"+0+"','"+0+"','"+addr+"','"+fath+"',sha1('"+pas1+"'))");
							JOptionPane.showMessageDialog(this, "Account created"
									+ "\nYour acc no. is :"+accno);
							DateAndTime.stmt(bt, accno, "Account created on  ");
							this.dispose();
							HomePage hp=new HomePage();
							hp.ShowP();
							}
							else {
								JOptionPane.showMessageDialog(this, "Phone Number already in use");
							}
							
						}
						catch (Exception e2) {
							e2.printStackTrace();
							
						}
				}
					else {
						z.setText("*Passwords do not match");
					}
					
				}
				else {
					
				}
		}
		
	}
	
}