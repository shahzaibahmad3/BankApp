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

public class Withdraw extends JFrame implements ActionListener {
	
	JLabel b,wc,accnum,pass1,box,z,amo;
	JTextField acc,pass,amount;
	JComboBox bank;
	JButton deposit,back;

	
	
	public void ShowP() {
		super.setBounds(200,60,640,400);
		super.setTitle("WITHDRAW");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\b_with.png");
		ImageIcon p2=new ImageIcon("images\\with.png");
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
			
			amo=new JLabel("Amount : ");
			amo.setBounds(80,220,200,30);
			amo.setFont(f1);
			amo.setForeground(Color.darkGray);
			super.add(amo);
			
			
			amount=new JTextField();
			amount.setBounds(180,220,200,30);
			amount.setFont(f1);
			super.add(amount);
			
			 deposit=new JButton();
			 deposit.setBounds(236,290,150,35);
			 deposit.setIcon(p2);
			 super.add(deposit);
			 deposit.addActionListener(this);
			 
			 
			
	
			
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
		
		if(e.getSource()==deposit) {
			
			
			String bt=""+bank.getSelectedItem();
			String accno=acc.getText(),
					pas=pass.getText(),
					bala=amount.getText();
			
				if(!accno.isEmpty() && !pas.isEmpty()){
					try {
						Class.forName("com.mysql.jdbc.Driver");
						java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8917"); 
						Statement st=co.createStatement();
						ResultSet rs=st.executeQuery("select * from "+bt+" where aac_no='"+accno+"' AND password=sha1('"+pas+"')");
					if(rs.next()) {
						if(rs.getInt("status")==0) {
						int n=Integer.parseInt(bala);
						if(n<=rs.getInt("balance")) {
						int bal=rs.getInt("balance")-n;
						st.executeUpdate("update "+bt+" set balance='"+bal+"' where aac_no='"+accno+"' AND password=sha1('"+pas+"') ");
						DateAndTime.stmt(bt, accno, "Amount Withdrawn  "+bala+" on  " );
						
						JOptionPane.showMessageDialog(this, "Amount withdrawn: "+bala+
								"\nNew Balance:  "+bal);
						this.dispose();
						HomePage hp=new HomePage();
						hp.ShowP();
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
	