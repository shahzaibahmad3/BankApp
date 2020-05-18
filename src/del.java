import java.io.File;

public class del {

	public static void del() {
		try {
		File f=new File("images\\result\\r.xlsx");
		if(f.delete()){
			System.out.println("OK");
		}
		else {
			System.out.println("Not Found");
		}
		}
		catch(Exception e){
			System.out.println("error: "+e);
		}
	}
}
