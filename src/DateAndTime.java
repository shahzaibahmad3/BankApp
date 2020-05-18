import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateAndTime {

	public static String getDate() {
		
		DateTimeFormatter d=DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		
		
		return d.format(now);
	}
	
	
	public static void stmt(String bt,String accno,String st) {
		try {
		FileOutputStream f=new FileOutputStream("images\\statement\\"+bt+"\\"+accno+".txt",true);
		
		String str="\r\n"+st+DateAndTime.getDate();
		byte[] buffer=str.getBytes();
		f.write(buffer);
		}
		catch (Exception e) {
		
		}
	}
}
