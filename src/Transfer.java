import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Transfer extends JFrame implements ActionListener {
	
	JLabel b1,b2,wc,accnum1,accnum2,pass1,box,z,amo;
	JTextField acc1,acc2,pass,amount;
	JComboBox bank1,bank2;
	JButton tran,back;

	
	
	public void ShowP() {
		super.setBounds(200,60,700,400);
		super.setTitle("TRANSFER");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\b_tran.png");
		ImageIcon p2=new ImageIcon("images\\tran.png");
		ImageIcon p7=new ImageIcon("images\\goback.png");
		
		Font f1=new Font("",Font.PLAIN,16);
		
		 back=new JButton();
		 back.setBounds(0,0,40,34);
		 back.setIcon(p7);
		 super.add(back);
		 back.addActionListener(this);
		
		b1=new JLabel("Select Bank 1: ");
		b1.setBounds(20,100,200,30);
		b1.setFont(f1);
		b1.setForeground(Color.darkGray);
		super.add(b1);
		
		String[] banks1= {"SBI","PNB","ICICI","HDFC","UBI"};
		bank1=new JComboBox(banks1);
		bank1.setBounds(130,100,200,30);
		bank1.setForeground(Color.darkGray);
		bank1.setBackground(Color.WHITE);
		super.add(bank1);
		
		b2=new JLabel("Select Bank 2: ");
		b2.setBounds(360,100,200,30);
		b2.setFont(f1);
		b2.setForeground(Color.darkGray);
		super.add(b2);
		
		String[] banks2= {"SBI","PNB","ICICI","HDFC","UBI"};
		bank2=new JComboBox(banks2);
		bank2.setBounds(470,100,200,30);
		bank2.setForeground(Color.darkGray);
		bank2.setBackground(Color.WHITE);
		super.add(bank2);
		
		accnum1=new JLabel("Account no. 1: ");
		accnum1.setBounds(20,140,200,30);
		accnum1.setFont(f1);
		accnum1.setForeground(Color.darkGray);
		super.add(accnum1);
		
		acc1=new JTextField();
		acc1.setBounds(130,140,200,30);
		acc1.setFont(f1);
		super.add(acc1);
		
		accnum2=new JLabel("Account no. 2: ");
		accnum2.setBounds(360,140,200,30);
		accnum2.setFont(f1);
		accnum2.setForeground(Color.darkGray);
		super.add(accnum2);
		
		
		acc2=new JTextField();
		acc2.setBounds(470,140,200,30);
		acc2.setFont(f1);
		super.add(acc2);
		
			pass1=new JLabel("Password : ");
			pass1.setBounds(220,200,200,30);
			pass1.setFont(f1);
			pass1.setForeground(Color.darkGray);
			super.add(pass1);
			
			pass=new JTextField();
			pass.setBounds(300,200,200,30);
			pass.setFont(f1);
			super.add(pass);
			
			amo=new JLabel("Amount : ");
			amo.setBounds(220,240,200,30);
			amo.setFont(f1);
			amo.setForeground(Color.darkGray);
			super.add(amo);
			
			amount=new JTextField();
			amount.setBounds(300,240,200,30);
			amount.setFont(f1);
			super.add(amount);
			
			 tran=new JButton();
			 tran.setBounds(300,290,200,35);
			 tran.setIcon(p2);
			 super.add(tran);
			 tran.addActionListener(this);
			 
		   z=new JLabel(); 
		   z.setBounds(570,412,200,20);
		   z.setForeground(Color.RED);
		   super.add(z);
		   
		wc=new JLabel();
		wc.setBounds(0,0,700,400);
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
		
		if(e.getSource()==tran) {
			
			
			String bt1=""+bank1.getSelectedItem();
			String bt2=""+bank2.getSelectedItem();
			String accno1=acc1.getText(),accno2=acc2.getText(),
					pas=pass.getText(),
					bala=amount.getText();
			
				if(!accno1.isEmpty() && !pas.isEmpty() && !accno2.isEmpty()){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8917"); 
						Statement st=co.createStatement();
						Statement st1=co.createStatement();
						ResultSet rs=st.executeQuery("select * from "+bt1+" where aac_no='"+accno1+"' AND password=sha1('"+pas+"')");
					if(rs.next()) {
						if(rs.getInt("status")==0 ) {
						int n=Integer.parseInt(bala);
						if(n<=rs.getInt("balance")) {
							ResultSet rss=st1.executeQuery("select * from "+bt2+" where aac_no='"+accno2+"'");
							if(rss.next()) {
						int bal1=rs.getInt("balance")-n;
						int bal2=rss.getInt("balance")+n;
						st.executeUpdate("update "+bt1+" set balance='"+bal1+"' where aac_no='"+accno1+"' AND password=sha1('"+pas+"') ");
						DateAndTime.stmt(bt1, accno1, "Amount "+bala+" transfered to "+accno2+" on  " );
						st1.executeUpdate("update "+bt2+" set balance='"+bal2+"' where aac_no='"+accno2+"'");
						DateAndTime.stmt(bt2, accno2, "Amount "+bala+" transfered from "+accno1+" on  " );
						JOptionPane.showMessageDialog(this, "Amount Transfereimages "+bala+
								"\nNew Balance:  "+bal1);
						this.dispose();
						HomePage hp=new HomePage();
						hp.ShowP();
							}
							else {
								JOptionPane.showMessageDialog(this,"No Account Found"
										+ "\nCheck your Details");
								}
						}
						else {
							JOptionPane.showMessageDialog(this, "Insufficient Balance");
						}
						}
						else {
							JOptionPane.showMessageDialog(this, "Account is Deactivated");
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