import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Internet {
    public static String readData(Socket s) throws Exception {
        String data = "";

        DataInputStream reader = new DataInputStream(new BufferedInputStream(s.getInputStream()));
        
        data = reader.readLine();

        return data;
    }
    
    public static String read(Socket s) throws Exception {
    	Thread.sleep(100);
    	
    	InputStream reader = s.getInputStream();
    	
    	byte buffer[] = new byte[reader.available()];
    	reader.read(buffer);
    	
    	return String.valueOf(buffer);
    }
    
    public static String readSocketData(Socket s) throws Exception {
    	String data = "";
    	String cacheddata;
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    	
    	while ((cacheddata = reader.readLine()) != null) {
    		if (cacheddata.equals("")) {
    			break;
    		}
    		
    		data += cacheddata + "\n";
    	}
    	
    	if (!data.equals("")) {
    		data = data.substring(0, data.length() - 1);
    	}
    	
    	return data;
    }
    
    public static ArrayList <String> readSocketDataArray(Socket s) throws Exception {
    	ArrayList <String> data = new ArrayList <String> ();
    	String cacheddata;
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    	
    	while ((cacheddata = reader.readLine()) != null) {
    		if (cacheddata.equals("")) {
    			break;
    		}
    		
    		data.add(cacheddata);
    	}
    	
    	return data;
    }
    
    public static void flush(Socket s) throws Exception {
    	s.getOutputStream().flush();
    }

    public static void sendData(Socket s, String data) throws Exception {
        DataOutputStream writer = new DataOutputStream(s.getOutputStream());
        writer.write(data.getBytes("utf-8"));
    }
}
