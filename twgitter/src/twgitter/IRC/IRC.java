package twgitter.IRC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import org.schwering.irc.lib.IRCConnection;
import org.schwering.irc.lib.IRCEventAdapter;
import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;
import org.schwering.irc.lib.SSLDefaultTrustManager;
import org.schwering.irc.lib.SSLIRCConnection;

/**
 * A simple command line client based on IRClib.
 */
@SuppressWarnings("deprecation")
public class IRC extends Thread {

  /** Reads input from the console. */
  private BufferedReader in;

  /** The IRC connection. */
  private IRCConnection conn;

  /** The current default target of PRIVMSGs (a channel or nickname). */
  private String target;

  /**
   * Parses the arguments and starts the client.
 * @throws UnsupportedEncodingException
   */
  public static void main(String[] args) throws UnsupportedEncodingException {
    Hashtable ht = null;
    try {
      ht = getHashtable(args);
    } catch (IllegalArgumentException exc) {
      printHelp();
      return;
    }
    String host = (String)ht.get("host");
    int port = new Integer((String)ht.get("port")).intValue();
    String pass = (String)ht.get("pass");
    String nick = (String)ht.get("nick");
    String user = (String)ht.get("user");
    String name = (String)ht.get("name");
    boolean ssl = ((Boolean)ht.get("ssl")).booleanValue();
    try {
      new IRC(host, port, pass, nick, user, name, ssl);
    } catch (IOException exc) {
      printHelp();
    }
  }

  /**
   * Returns a hashtable with settings like host, port, nick etc..
   */
  private static Hashtable getHashtable(String[] args) {
    Hashtable ht = new Hashtable();
    String serverPort = (String)getParam(args, "server");
    int colon = serverPort.indexOf(':');
    ht.put("host", serverPort.substring(0, colon));
    ht.put("port", serverPort.substring(colon + 1));
    ht.put("pass", getParam(args, "pass", ""));
    ht.put("nick", getParam(args, "nick"));
    ht.put("user", getParam(args, "user", ht.get("nick")));
    ht.put("name", getParam(args, "name", ht.get("user")));
    ht.put("ssl", getParam(args, "ssl", new Boolean(false)));
    return ht;
  }

  /**
   * Returns a value of a key in the arguments.
   */
  private static Object getParam(String[] args, Object key) {
    return getParam(args, key, null);
  }

  /**
   * Returns a value of a key in the arguments. If a key without a value is
   * found, a Boolean object with true is returned. If no key is found, the
   * default value is returned.
   */
  private static Object getParam(String[] args, Object key, Object def) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-"+ key)) {
        if (i + 1 < args.length) {
          String value = args[i + 1];
          if (value.charAt(0) == '-')
            return new Boolean(true);
          else
            return value;
        } else {
          return new Boolean(true);
        }
      }
    }
    if (def != null)
      return def;
    else
      throw new IllegalArgumentException("No value for "+ key +" found.");
  }

  /**
   * Prints some help.
 * @throws UnsupportedEncodingException
   */
  private static void printHelp() throws UnsupportedEncodingException {
    print("A simple command-line IRC client based on IRClib.");
    print("");
    print("Use it as follows:");
    print("java IRC -server <server:port> [-pass <server-password<] -nick "+
        "<nickname> [-user <username>] [-name <realname>] [-ssl]");
    print("");
    print("Note that you need the IRClib classes in your classpath.");
    print("You can get IRClib from http://moepii.sourceforge.net.");
    print("");
    print("Copyright (C) 2003, 2004, 2005, 2006 Christoph Schwering");
  }

  /**
   * A shorthand for the System.out.println method.
 * @throws UnsupportedEncodingException
   */
  private static void print(Object o) throws UnsupportedEncodingException {
    System.out.println("[IRC]" + o);
  }

  /**
   * Checks wether a string starts with another string (case insensitive).
   */
  private static boolean startsWith(String s1, String s2) {
    return (s1.length() >= s2.length()) ?
        s1.substring(0, s2.length()).equalsIgnoreCase(s2) : false;
  }

  /**
   * Creates a new IRCConnection instance and starts the thread.
   *
   * If you get confused by the two setDaemon()s: The conn.setDaemon(false) marks the
   * IRCConnection thread as user thread and the setDaemon(true) marks this class's thread
   * (which just listens for keyboard input) as daemon thread. Thus, if the IRCConnection
   * breaks, this console application shuts down, because due to the setDaemon(true) it
   * will no longer wait for keyboard input (no input would make sense without being
   * connected to a server).
   */
  public IRC(String host, int port, String pass, String nick, String user,
      String name, boolean ssl) throws IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    if (!ssl) {
      conn = new IRCConnection(host, new int[] { port }, pass, nick, user,
          name);
    } else {
      conn = new SSLIRCConnection(host, new int[] { port }, pass, nick, user,
          name);
      ((SSLIRCConnection)conn).addTrustManager(new SSLDefaultTrustManager());
    }
    conn.addIRCEventListener(new Listener());
    conn.setPong(true);
    conn.setDaemon(false);
    conn.setColors(false);
    conn.connect();
    setDaemon(true);
    start();
  }

  /**
   * The thread waits for input.
   */
  public void run() {
    while (true) {
      try {
        shipInput();
      } catch (Exception exc) {
        exc.printStackTrace();
      }
    }
  }

  /**
   * Parses the input and sends it to the IRC server.
   */
  public void shipInput() throws Exception {
    String input = in.readLine();

    input = toUTF8(input);

    if (input == null || input.length() == 0)
      return;

    if (input.charAt(0) == '/') {
      if (startsWith(input, "/TARGET")) {
        target = input.substring(8);
        return;
      } else if (startsWith(input, "/JOIN")) {
        target = input.substring(6);
      }
      input = input.substring(1);
      print("Exec: "+ input);
      conn.send(input);
    } else {
      conn.doPrivmsg(target, input);
      print(target +"> "+ input);
    }
  }

  //-----------------------------------------------------------------
  public static String toUTF8(String text) throws UnsupportedEncodingException{
  	String newText;

  	newText = new String(text.getBytes("UTF8"), "UTF8");

  	return newText;
  }

  /**
   * Treats IRC events. The most of them are just printed.
   */
  public class Listener extends IRCEventAdapter implements IRCEventListener {

    public void onRegistered() {
      try {
		print("Connected");
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onDisconnected() {
      try {
		print("Disconnected");
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onError(String msg) {
      try {
		print("Error: "+ msg);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onError(int num, String msg) {
      try {
		print("Error #"+ num +": "+ msg);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onInvite(String chan, IRCUser u, String nickPass) {
      try {
		print(chan +"> "+ u.getNick() +" invites "+ nickPass);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onJoin(String chan, IRCUser u) {
      try {
		print(chan +"> "+ u.getNick() +" joins");
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onKick(String chan, IRCUser u, String nickPass, String msg) {
      try {
		print(chan +"> "+ u.getNick() +" kicks "+ nickPass);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onMode(IRCUser u, String nickPass, String mode) {
      try {
		print("Mode: "+ u.getNick() +" sets modes "+ mode +" "+
		      nickPass);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onMode(IRCUser u, String chan, IRCModeParser mp) throws UnsupportedEncodingException {
      print(chan +"> "+ u.getNick() +" sets mode: "+ mp.getLine());
    }

    public void onNick(IRCUser u, String nickNew) {
      try {
		print("Nick: "+ u.getNick() +" is now known as "+ nickNew);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onNotice(String target, IRCUser u, String msg) {
      try {
		print(target +"> "+ u.getNick() +" (notice): "+ msg);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onPart(String chan, IRCUser u, String msg) {
      try {
		print(chan +"> "+ u.getNick() +" parts");
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onPrivmsg(String chan, IRCUser u, String msg) {
      try {
		print(chan +"> "+ u.getNick() +": "+ msg);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onQuit(IRCUser u, String msg) {
      try {
		print("Quit: "+ u.getNick());
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onReply(int num, String value, String msg) {
      try {
		print("Reply #"+ num +": "+ value +" "+ msg);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

    public void onTopic(String chan, IRCUser u, String topic) {
      try {
		print(chan +"> "+ u.getNick() +" changes topic into: "+ topic);
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
    }

  }

}