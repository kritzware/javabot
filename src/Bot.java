public class Bot {

	private final String SERVER = "irc.twitch.tv";
	private final int PORT = 6667;

	private String channel, username, oauth;

	Bot(String username, String oauth, String channel) {
		this.username = username;
		this.oauth = oauth;
		this.channel = channel;
	}

	public static void main(String args[]) throws Exception {

		IRC irc = new IRC("irc.twitch.tv", 6667, args[0]);

	}
}