import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println(args[0]);
			
			MailSenderSettings mss = new MailSenderSettings();
			mss.ehlomessage = args[1];
			mss.mailfrom = args[2];
			mss.rcptto = args[3];
			
			MailHeaders mailheaders = new MailHeaders();
			mailheaders.subject = args[4];
			mailheaders.mailfrom = args[5];
			mailheaders.rcptto = args[6];
			
			mss.data = mailheaders.getMailHeaders() + args[7];
			
			int mailcount = Integer.parseInt(args[8]);
			
			for (int i = 0;i < mailcount;i++) {
				Socket s = new Socket(args[0], 25);
				System.out.println("connected");
				
				MailSender.sendMail(s, mss);
				
				//Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
