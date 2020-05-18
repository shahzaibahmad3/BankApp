import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// lets create a subclass for authenticator
class BabyOfAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		// create object of PA with sender email credentials
		return new PasswordAuthentication("your mail",
				"your password");
	}
}

public class Email 
{
	public void email(String[] to,String[] files,String data,String sub) 
	{
		try 
		{
		// lets create an object of properties class to provide configuration
		// about mail service provider
		Properties properties = new Properties();
		
		// lets provide values for the configuration variables
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // rare use
		//properties.put("mail.debug", "true");

		// create object of subclass of authenticator
		BabyOfAuthenticator babyOfAuthenticator = new BabyOfAuthenticator();
		
		// get object of session
		Session session = Session.getInstance(properties, babyOfAuthenticator);
		
		// create object of mime-message (this is actual message to be sent)
		MimeMessage message = new MimeMessage(session);
		
		
		
		InternetAddress[] addressesto = new InternetAddress[to.length];
		//InternetAddress[] addressescc = new InternetAddress[cc.length];
	    //InternetAddress[] addressesbcc = new InternetAddress[bcc.length];
		
	    
	    
	
	
		
		for (int i = 0; i < addressesto.length; i++) 
			addressesto[i] = new InternetAddress(to[i]);
//		if(!cc[0].isEmpty())
//   	for (int i = 0; i < addressescc.length; i++) 
//			addressescc[i] = new InternetAddress(cc[i]);
//		if(!bcc[0].isEmpty())
//		for (int i = 0; i < addressesbcc.length; i++) 
//			addressesbcc[i] = new InternetAddress(bcc[i]);
//		
		
		// provide subject for the mail
		message.setSubject(sub);
		
		// provide the types of RCVR
		message.setRecipients(RecipientType.TO, addressesto);
//		if(!cc[0].isEmpty()) 
//		message.setRecipients(RecipientType.CC, addressescc);
//        if(!bcc[0].isEmpty())
//		message.setRecipients(RecipientType.BCC, addressesbcc);
//		
		
		
		// create some body parts to hold the content and attachments
		MimeBodyPart bodyPart1 = new MimeBodyPart();
		int len=0;
		if(files[0].isEmpty())
			len=0;
		else
			len=files.length;
	
		

	
		
		// associate some content with body part
		bodyPart1.setContent("<b style='color :blue;'>'"+data+"'<i></i></b>", "text/html");
	   

		
		// create object of multi-part to hold body parts as a single unit
		MimeMultipart multipart = new MimeMultipart();
		
		// store body parts in multi-parts
     	multipart.addBodyPart(bodyPart1);
     	//multipart.addBodyPart(bodyPart2);
   
     	for(int i=0;i<len;i++) {
     		MimeBodyPart bd=new MimeBodyPart();
     		bd.attachFile(files[i]);
         	multipart.addBodyPart(bd);
     	}

		
		
		// store multi-part inside message
		message.setContent(multipart);
			
		// send the message to the gmail server using smtp
		Transport.send(message);
			
		System.out.println("OK");
		} 
		catch (Exception e) 
		{
			System.out.println("error while sending mail to gmail server "+e);
		}
	}
}


