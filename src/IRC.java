import java.io.*;
import java.net.*;

public class IRC {

	private Socket socket;
	private String server;
	private int port;
	private String oauth = "oauth_here";
	private String username = "javabot123";
	// private String channel = args[0];

	IRC(String server, int port, String channel) throws Exception {
		this.server = server;
		this.port = port;
		Socket socket = new Socket(server, port);

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		writer.write("PASS " + oauth + "\r\n");
		writer.write("NICK " + username + "\r\n");
		writer.flush();

		String line = null;
		while((line = reader.readLine()) != null) {
			if(line.indexOf("376") >= 0) {
				break;
			}
		}

		writer.write("JOIN #" + channel + "\r\n");
		writer.flush();

		while((line = reader.readLine()) != null) {
			if(line.toLowerCase().startsWith("PING ")) {
				writer.write("PONG " + line.substring(5) + "\r\n");
				System.out.println("PING! PONG SENT BACK");
				writer.flush();
			} else {
				System.out.println(line);
			}
		}
	}



}