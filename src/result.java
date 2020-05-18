import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class result extends JFrame implements ActionListener
{
	JLabel wc;
	JTextField roll;
	JButton p;
	
	
	 public void showUI() {
		 
		 ImageIcon i=new ImageIcon("images\\result\\R.png");
		 ImageIcon p2=new ImageIcon("images\\result\\g.png");
		 Font f1=new Font("",Font.PLAIN,16);
		 
		 super.setBounds(200,60,500,300);
			super.setTitle("RESULT");
			super.setResizable(false);
			
			
		
			roll=new JTextField();
			roll.setBounds(130,90,200,30);
			roll.setFont(f1);
			super.add(roll);
			
			 p=new JButton();
			 p.setBounds(130,140,200,32);
			 p.setIcon(p2);
			 super.add(p);
			 p.addActionListener(this);
			
			
			wc=new JLabel();
			wc.setBounds(0,0,500,300);
			wc.setIcon(i);
			super.add(wc);
			super.setLayout(null);
			super.setVisible(true);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		 
	
	 public void actionPerformed(ActionEvent e) {
			if(e.getSource()==p) {
				
				String rno=roll.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","8917"); 
					Statement st=co.createStatement();
					ResultSet rs=st.executeQuery("select * from result where roll='"+rno+"'");
				if(rs.next()) {
					XSSFWorkbook w=new XSSFWorkbook();
					XSSFSheet s=w.createSheet(rs.getString("name"));
					
					s.autoSizeColumn(0);
					s.autoSizeColumn(1);
					
					Row r1=s.createRow(0);
					Row r2=s.createRow(1);
					Row r3=s.createRow(2);
					Row r4=s.createRow(3);
					
					Cell c11=r1.createCell(0);
					c11.setCellValue("Roll No.");
					Cell c12=r1.createCell(1);
					c12.setCellValue(rs.getString("roll"));
					
					Cell c21=r2.createCell(0);
					c21.setCellValue("Name");
					Cell c22=r2.createCell(1);
					c22.setCellValue(rs.getString("name"));
					
					Cell c31=r3.createCell(0);
					c31.setCellValue("Marks");
					Cell c32=r3.createCell(1);
					c32.setCellValue(rs.getString("marks"));
					
					Cell c41=r4.createCell(0);
					c41.setCellValue("Status");
					Cell c42=r4.createCell(1);
					c42.setCellValue(rs.getString("status"));
					
					File f1=new File("images\\result\\r.xlsx");
					w.write(new FileOutputStream(f1,false));
					w.close();
					f1.deleteOnExit();
					
					
					
					String[] to= {rs.getString("mail")};
					String[] f= {"images\\result\\r.xlsx"};
					
					
					
					Email em=new Email();
					em.email(to, f, "Result: "+rs.getString("status"),"Result of "+ rs.getString("name"));
					JOptionPane.showMessageDialog(this,"Check your mail");
					this.dispose();
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(this,"Inavlid Roll Number");
				}
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
				
				
				
				
				
			}
			
		}
	 

	 public static void main(String[] args) {
		result r=new result();
		r.showUI();
		
	}

	
}

