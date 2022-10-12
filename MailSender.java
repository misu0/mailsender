import java.net.Socket;

public class MailSender {
	public static void sendMail(Socket s, MailSenderSettings mailsendersettings) throws Exception {
		//System.out.println(s.getSendBufferSize());
		Internet.read(s);
		Internet.sendData(s, "ehlo " + mailsendersettings.ehlomessage + "\n");
		Internet.read(s);
		Internet.sendData(s, "mail from:<" + mailsendersettings.mailfrom + ">\n");
		Internet.read(s);
		Internet.sendData(s, "rcpt to:<" + mailsendersettings.rcptto + ">\n");
		Internet.read(s);
		Internet.sendData(s, "data\n");
		Internet.read(s);
		Internet.sendData(s, mailsendersettings.data + "\n.\n");
	}
}
