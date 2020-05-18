import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame implements ActionListener {
	
	JLabel wc;
	JButton open,depo,with,check,del,tran,acti,chngp,stmt;
	
	public void ShowP() {
		super.setBounds(200,60,920,600);
		super.setTitle("HOME PAGE");
		super.setResizable(false);
		
		
		ImageIcon i=new ImageIcon("images\\a.png");
		ImageIcon p1=new ImageIcon("images\\open.png");
		ImageIcon p2=new ImageIcon("images\\depo.png");
		ImageIcon p3=new ImageIcon("images\\with.png");
		ImageIcon p4=new ImageIcon("images\\check.png");
		ImageIcon p5=new ImageIcon("images\\deac.png");
		ImageIcon p6=new ImageIcon("images\\tran.png");		
		ImageIcon p7=new ImageIcon("images\\chng.png");
		ImageIcon p8=new ImageIcon("images\\acti.png");	
		ImageIcon p9=new ImageIcon("images\\stmt.png");	
		
		
		open=new JButton();
		open.setBounds(530,142,200,44);
		open.setIcon(p1);
		super.add(open);
		open.addActionListener(this);
		
		depo=new JButton();
		depo.setBounds(530,217,200,44);
		depo.setIcon(p2);
		super.add(depo);
		depo.addActionListener(this);
		
		with=new JButton();
		with.setBounds(530,290,200,44);
		with.setIcon(p3);
		super.add(with);
		with.addActionListener(this);
		
		check=new JButton();
		check.setBounds(530,368,200,44);
		check.setIcon(p4);
		super.add(check);
		check.addActionListener(this);
		
		del=new JButton();
		del.setBounds(530,440,200,44);
		del.setIcon(p5);
		super.add(del);
		del.addActionListener(this);
		
		acti=new JButton();
		acti.setBounds(137,518,200,40);
		acti.setIcon(p8);
		super.add(acti);
		acti.addActionListener(this);
		
		stmt=new JButton();
		stmt.setBounds(137,379,200,40);
		stmt.setIcon(p9);
		super.add(stmt);
		stmt.addActionListener(this);
		
		tran=new JButton();
		tran.setBounds(530,514,200,40);
		tran.setIcon(p6);
		super.add(tran);
		tran.addActionListener(this);
		
		chngp=new JButton();
		chngp.setBounds(137,446,200,40);
		chngp.setIcon(p7);
		super.add(chngp);
	    chngp.addActionListener(this);
		
		
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
		if(e.getSource()==open) {
			OpenAcc hp=new OpenAcc();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==depo) {
			Deposit hp=new Deposit();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==check) {
			CheckBalance hp=new CheckBalance();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==with) {
			Withdraw hp=new Withdraw();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==del) {
			Deactivate hp=new Deactivate();
			this.dispose();
			hp.ShowP(0,1);
		}
		if(e.getSource()==acti) {
			Deactivate hp=new Deactivate();
			this.dispose();
			hp.ShowP(1,0);
		}
		if(e.getSource()==chngp) {
			ChangePass hp=new ChangePass();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==tran) {
			Transfer hp=new Transfer();
			this.dispose();
			hp.ShowP();
		}
		if(e.getSource()==stmt) {
			GetStatement hp=new GetStatement();
			this.dispose();
			hp.ShowP();
		}
		
	}
	
}
