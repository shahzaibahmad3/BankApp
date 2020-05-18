import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Terms extends JFrame {
	
	JLabel wc,tc;
	JTextArea t;
	JScrollPane p;
	JButton open,depo,with,check,del,tran;
	
	public void ShowP() {
		super.setBounds(200,60,400,400);
		super.setTitle("HOME PAGE");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\aaa.jpg");

		Font f1=new Font("",Font.BOLD,16);
		
		tc=new JLabel("Terms and Conditions");
		tc.setBounds(110,20,300,20);
		tc.setFont(f1);
		super.add(tc);
		
		t=new JTextArea();
		t.setBounds(0,0,200,200);
		t.setText("I. Terms and Conditions for Savings Account\r\n" + 
				"\r\n" + 
				"These terms and conditions apply to and \r\n" + 
				"regulate the operation of the Savings Account\r\n" + 
				"offered by ICICI Bank. \r\n" + 
				"These terms and conditions shall be in addition\r\n" + 
				" to any other terms as stipulated by\r\n" + 
				" ICICI Bank from time to time.\r\n" + 
				"\r\n" + 
				"1. Definitions\r\n" + 
				"\r\n" + 
				"In these terms and conditions, the following \r\n" + 
				"words and phrases have the meaning stated \r\n" + 
				"hereunder unless indicated otherwise:\r\n" + 
				"\r\n" + 
				"1.1 “Account Opening Form” (AOF) refers to \r\n" + 
				"the relationship form for Savings Account.\r\n" + 
				"\r\n" + 
				"1.2 \"Customer\" refers to any person \r\n" + 
				"holding an Account with ICICI Bank.\r\n" + 
				"\r\n" + 
				"1.3 “Quarter” shall mean a financial quarter \r\n" + 
				"i.e. April – June, July – September, October – \r\n" + 
				"December, January – March in any financial year.\r\n" + 
				"\r\n" + 
				"1.4 \"Services\" shall mean the services provided \r\n" + 
				"by ICICI Bank in connection with the Saving Account\r\n" + 
				" and more particularly described in these Terms.\r\n" + 
				"\r\n" + 
				"1.5 \"Website\" refers to the website owned, established\r\n" + 
				" and maintained by ICICI Bank at the URL www.icicibank.com.\r\n" + 
				"\r\n" + 
				"1.6 “ICICI Bank Customer Care Centre” refers to ICICI Bank\r\n" + 
				" - Phone Banking Service provided by ICICI Bank to the Customer.\r\n" + 
				"\r\n" + 
				"Interpretation:\r\n" + 
				"\r\n" + 
				"All references to singular include plural and vice versa\r\n" + 
				" and the word \"includes\" should be construed as \"without limitation\".\r\n" + 
				"Words importing any gender include the other gender.\r\n" + 
				"Reference to any statute, ordinance or other law \r\n" + 
				"includes all regulations and other instruments and \r\n" + 
				"all consolidations, amendments, re-enactments or\r\n" + 
				" replacements for the time being in force.\r\n" + 
				"\r\n" + 
				"All headings, bold typing and italics (if any) have\r\n" + 
				" been inserted for convenience of reference only and\r\n" + 
				" do not define limit or affect the meaning or \r\n" + 
				"interpretation of these Terms.\r\n" + 
				"Words “ICICI Bank”, “the Bank”, refer to ICICI Bank \r\n" + 
				"Limited having its registered office at Landmark,\r\n" + 
				" Race Course Circle, Vadodara 390007.\r\n" + 
				"");
		t.setEditable(false);
		p=new JScrollPane(t);
		p.setBounds(50,50,300,300);
		super.add(p);
		
	
		
		wc=new JLabel();
		wc.setBounds(0,0,400,400);
		wc.setIcon(i);
		super.add(wc);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	
}
