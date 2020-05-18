import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class Mail extends JFrame implements ActionListener{

	JLabel to1,cc1,bcc1,sub1,data1,wc;
	JButton browse,send;
	JTextField to,cc,bcc,file1,sub,data;
	
	public void showUI() {
		
		ImageIcon im=new ImageIcon("images\\im.png");
		
		super.setBounds(200,60,500,600);
		super.setTitle("MAIL");
		super.setResizable(false);
		
		Font f1=new Font("",Font.PLAIN,16);

		to1=new JLabel("TO : ");
		to1.setBounds(80,80,200,30);
		to1.setFont(f1);
		to1.setForeground(Color.white);
		super.add(to1);
		
		
		to=new JTextField();
		to.setBounds(180,80,250,30);
		to.setFont(f1);
		super.add(to);
		
		
		cc1=new JLabel("CC : ");
		cc1.setBounds(80,130,200,30);
		cc1.setFont(f1);
		cc1.setForeground(Color.white);
		super.add(cc1);
		
		
		cc=new JTextField();
		cc.setBounds(180,130,250,30);
		cc.setFont(f1);
		super.add(cc);
		
		bcc1=new JLabel("BCC : ");
		bcc1.setBounds(80,180,200,30);
		bcc1.setFont(f1);
		bcc1.setForeground(Color.white);
		super.add(bcc1);
		
		
		bcc=new JTextField();
		bcc.setBounds(180,180,250,30);
		bcc.setFont(f1);
		super.add(bcc);
		
		sub1=new JLabel("SUBJECT : ");
		sub1.setBounds(80,230,200,30);
		sub1.setFont(f1);
		sub1.setForeground(Color.white);
		super.add(sub1);
		
		
		sub=new JTextField();
		sub.setBounds(180,230,250,30);
		sub.setFont(f1);
		super.add(sub);
		
		
		data1=new JLabel("DATA : ");
		data1.setBounds(80,280,200,30);
		data1.setFont(f1);
		data1.setForeground(Color.white);
		super.add(data1);
		
		
		data=new JTextField();
		data.setBounds(180,280,250,100);
		data.setFont(f1);
		super.add(data);
		

		file1=new JTextField();
		file1.setBounds(180,400,250,40);
		file1.setFont(f1);
		super.add(file1);
		
		 browse=new JButton("BROWSE");
		 browse.setBounds(180,460,250,40);
		 super.add(browse);
		 browse.addActionListener(this);
		
		 
		 send=new JButton("SEND");
		 send.setBounds(180,510,250,40);
		 super.add(send);
		 send.addActionListener(this);
		
		wc=new JLabel();
		wc.setBounds(0,0,500,630);
		wc.setIcon(im);
		super.add(wc);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==browse) {
			
			JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			j.setMultiSelectionEnabled(true);
			int r=j.showOpenDialog(null);
			if(r==JFileChooser.APPROVE_OPTION)
			{
				File files[]=j.getSelectedFiles();
				file1.setText(files[0].getAbsolutePath());
				int t=1;
				while(t++<files.length) {
					file1.setText(file1.getText()+","+files[t-1].getAbsolutePath());
					
				}
			}
			
		}
		if(e.getSource()==send) {
			
			String[] to2=to.getText().split(",");
			String[] cc2=cc.getText().split(",");
			String[] bcc2=bcc.getText().split(",");
			
			String sub2=sub.getText();
			String data2=sub.getText();
			
			String[] file2=file1.getText().split(",");
			
			Email em=new Email();
			em.email(to2,  file2, data2, sub2);
		}
		
	}
}  
