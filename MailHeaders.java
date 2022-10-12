public class MailHeaders {
	public static String subject;
	public static String mailfrom;
	public static String rcptto;
	
	public String getMailHeaders() {
		return "Subject: " + subject + "\nFrom: " + mailfrom + "\nTo: " + rcptto + "\n\n";
	}
}
