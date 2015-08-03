
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
//import src.java.ImportnExport.ExportTestResultsExcel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EmailTestReport
{
	//Set the host smtp address
	Properties props = new Properties();
	private String smtpHostName = null;
	private String recipient = null;
	private String subject = null;
	private String from = null;
	private String message = null;
	private String port = null;
	private String smtp = null;
	private String countersText = null;
	
	public EmailTestReport() {
		try {
			InputStream is = new FileInputStream("../Selenium/src/properties/Email.properties");
			System.out.println(is);
			props.load(is);
			is.close();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}	
	}	
	
	public void postMail(int[] counters) throws MessagingException
	{
		boolean debug = false;
		
		Message msg;
		smtpHostName = props.getProperty("SMTP_HOST_NAME");
		recipient = props.getProperty("recipients");
		from = props.getProperty("from");
		subject = props.getProperty("subject");
		message = props.getProperty("message");
		port = props.getProperty("SMTP_PORT");
		
		
		countersText = "Total Cases Executed: " + counters[0] + "<br>" + "Total Cases Passed: " + counters[1] + "<br>" + "Total Cases Failed: " + counters[2];
		message = message.replace("&&Counters&&",countersText);
		Properties newprops = new Properties();
		newprops.put("mail.smtp.host", smtpHostName);
		newprops.setProperty("mail.port", port);
		
		Session session = Session.getDefaultInstance(newprops, null);
		
		// create a message
		msg = new MimeMessage(session);
		
		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
		
		String[] recipients = recipient.split(";");
		InternetAddress[] addressTo =new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++)
		{
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		// Setting the Subject and Content Type
		msg.setSubject(subject +" - "+ (new java.util.Date()).toString());
		//msg.setContent(message, "text/html");
		
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		String testResultPath = ExportTestResultsExcel.testResultPath;
		messageBodyPart = new MimeBodyPart();
		DataSource tResult = new FileDataSource(testResultPath);
		messageBodyPart.setDataHandler(new DataHandler(tResult));
		messageBodyPart.setFileName(testResultPath.substring(testResultPath.lastIndexOf('/')+ 1, testResultPath.length()));
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);


		System.out.println(counters[0]);
		System.out.println(counters[1]);
		System.out.println(counters[2]);

		
		Transport.send(msg);
	}
	

}