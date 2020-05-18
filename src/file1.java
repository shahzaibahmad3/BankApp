import java.io.FileOutputStream;

public class file1 {

public static void main(String[] args) {
	
	
	try {
		String s="images\\statement\\icici\\a.txt";
	FileOutputStream f=new FileOutputStream(s,true);
	
	String str="Account created on DATE";
	byte[] buffer=str.getBytes();
	
	f.write(buffer);
}	catch (Exception e) {
}
}
	
}
