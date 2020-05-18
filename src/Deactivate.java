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

public class Deactivate extends JFrame implements ActionListener {
	
	JLabel b,wc,accnum,pass1,box,z,amo;
	JTextField acc,pass;
	JComboBox bank;
	JButton del,back;
	int o,n;
	String ty;

	
	
	public void ShowP(int o1,int n1) {
		
		o=o1;
		n=n1;
		String pa="",pa1="",pa2="";
		if(o==0) {
			pa="images\\b_del.png";
			pa1="DEACTIVATE ACCOUNT";
			pa2="images\\deac.png";
			ty="Deactivated";
		}
		else {
		    pa="images\\b_acti.png";
		    pa1="ACTIVATE ACCOUNT";
		    pa2="images\\acti.png";
			ty="Activated";
		}
		
		super.setBounds(200,60,640,400);
		super.setTitle(pa1);
		super.setResizable(false);
		
		
		
			
		ImageIcon i=new ImageIcon(pa);
		ImageIcon p2=new ImageIcon(pa2);
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
		bank.setBounds(180,100,200,30);
		bank.setForeground(Color.darkGray);
		bank.setBackground(Color.WHITE);
		super.add(bank);
		
		accnum=new JLabel("Account no. : ");
		accnum.setBounds(80,140,200,30);
		accnum.setFont(f1);
		accnum.setForeground(Color.darkGray);
		super.add(accnum);
		
		
		acc=new JTextField();
		acc.setBounds(180,140,200,30);
		acc.setFont(f1);
		super.add(acc);
		
		
	     	pass1=new JLabel("Password : ");
			pass1.setBounds(80,180,200,30);
			pass1.setFont(f1);
			pass1.setForeground(Color.darkGray);
			super.add(pass1);
			
			
			pass=new JTextField();
			pass.setBounds(180,180,200,30);
			pass.setFont(f1);
			super.add(pass);
			
			
			 del=new JButton();
			 del.setBounds(180,250,200,44);
			 del.setIcon(p2);
			 super.add(del);
			 del.addActionListener(this);
			 
			 
			
	
			
		   z=new JLabel();
		   z.setBounds(570,412,200,20);
		   z.setForeground(Color.RED);
		   super.add(z);
		   
			
			
		
		
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
		
		if(e.getSource()==del) {
			
			
			String bt=""+bank.getSelectedItem();
			String accno=acc.getText(),
					pas=pass.getText();
				
				if(!accno.isEmpty() && !pas.isEmpty()){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8917"); 
						Statement st=co.createStatement();
						ResultSet rs=st.executeQuery("select * from "+bt+" where aac_no='"+accno+"' AND password=sha1('"+pas+"')");
						
						if(rs.next()) {
						if(rs.getInt("status")==o) {
						st.executeUpdate("update "+bt+" set status='"+n+"' where aac_no='"+accno+"' AND password=sha1('"+pas+"') ");
						DateAndTime.stmt(bt, accno, "Account is "+ty+" on  " );
						
						JOptionPane.showMessageDialog(this, "Account is "+ty);
						this.dispose();
						HomePage hp=new HomePage();
						hp.ShowP();
						}
						else {
							JOptionPane.showMessageDialog(this, "Account is already "+ty);
						}
						
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
	