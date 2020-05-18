import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChangePass extends JFrame implements ActionListener {
	
	JLabel b,wc,accnum,pass1,box,z,amo,bale,p11,p12;
	JTextField acc,pass,amount,pa1,pa2;
	JComboBox bank;
	JButton check,back;

	
	
	public void ShowP() {
		super.setBounds(200,60,640,400);
		super.setTitle("CHECK BALANCE");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\b_chng.png");
		ImageIcon p2=new ImageIcon("images\\chng.png");
		ImageIcon p7=new ImageIcon("images\\goback.png");
		
		Font f1=new Font("",Font.PLAIN,16);
		
		 back=new JButton();
		 back.setBounds(0,0,40,34);
		 back.setIcon(p7);
		 super.add(back);
		 back.addActionListener(this);
		
		b=new JLabel("Select Bank : ");
		b.setBounds(80,100,200,30);
		b.setFont(f1);
		b.setForeground(Color.darkGray);
		super.add(b);
		
		String[] banks= {"SBI","PNB","ICICI","HDFC","UBI"};
		bank=new JComboBox(banks);
		bank.setBounds(210,100,200,30);
		bank.setForeground(Color.darkGray);
		bank.setBackground(Color.WHITE);
		super.add(bank);
		
		accnum=new JLabel("Account no. : ");
		accnum.setBounds(80,140,200,30);
		accnum.setFont(f1);
		accnum.setForeground(Color.darkGray);
		super.add(accnum);
		
		
		acc=new JTextField();
		acc.setBounds(210,140,200,30);
		acc.setFont(f1);
		super.add(acc);
		
		
	     	pass1=new JLabel("Old Password : ");
			pass1.setBounds(80,180,200,30);
			pass1.setFont(f1);
			pass1.setForeground(Color.darkGray);
			super.add(pass1);
			
			
			pass=new JTextField();
			pass.setBounds(210,180,200,30);
			pass.setFont(f1);
			super.add(pass);
			
			p11=new JLabel("New Password : ");
			p11.setBounds(80,220,200,30);
			p11.setFont(f1);
			p11.setForeground(Color.darkGray);
			super.add(p11);
			
			
			pa1=new JTextField();
			pa1.setBounds(210,220,200,30);
			pa1.setFont(f1);
			super.add(pa1);
			
			p12=new JLabel("Confirm : ");
			p12.setBounds(80,260,200,30);
			p12.setFont(f1);
			p12.setForeground(Color.darkGray);
			super.add(p12);
			
			
			pa2=new JTextField();
			pa2.setBounds(210,260,200,30);
			pa2.setFont(f1);
			super.add(pa2);
			
			
			 check=new JButton();
			 check.setBounds(215,310,200,45);
			 check.setIcon(p2);
			 super.add(check);
			 check.addActionListener(this);
		   
		   Font f2=new Font("",Font.BOLD,25);
		   bale=new JLabel();
		   bale.setBounds(200,240,200,20);
		   bale.setFont(f2);
		   bale.setForeground(Color.DARK_GRAY);
		  
		   super.add(bale);
		   
			
		
		
		wc=new JLabel();
		wc.setBounds(0,0,640,400);
		wc.setIcon(i);
		super.add(wc);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==back) {
			this.dispose();
			HomePage hp=new HomePage();
			hp.ShowP();
		}
		
		if(e.getSource()==check) {
			
			
			String bt=""+bank.getSelectedItem();
			String accno=acc.getText(),
					opas=pass.getText(),npas1=pa1.getText(),npas2=pa2.getText();
			
				if(!accno.isEmpty() && !opas.isEmpty() && npas1.contentEquals(npas2)){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8917"); 
						Statement st=co.createStatement();
						ResultSet rs=st.executeQuery("select * from "+bt+" where aac_no='"+accno+"' AND password=sha1('"+opas+"')");
					if(rs.next()) {
						st.executeUpdate("update "+bt+" set password=sha1('"+npas1+"') where aac_no='"+accno+"' AND password=sha1('"+opas+"') ");
						DateAndTime.stmt(bt, accno, "Password changed on  " );
						
						JOptionPane.showMessageDialog(this, "Password changed");
						this.dispose();
						HomePage hp=new HomePage();
						hp.ShowP();
											
					}
					else {
						JOptionPane.showMessageDialog(this,"No Account Found"
								+ "\nCheck your Details");
					}
						}
						catch (Exception e2) {
							e2.printStackTrace();
						}
			}
		}
  }
}
	