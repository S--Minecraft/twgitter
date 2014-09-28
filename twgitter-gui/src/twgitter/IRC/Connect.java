package twgitter.IRC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import org.schwering.irc.lib.IRCConnection;
import org.schwering.irc.lib.IRCEventAdapter;
import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;
import org.schwering.irc.lib.SSLDefaultTrustManager;
import org.schwering.irc.lib.SSLIRCConnection;

import twgitter.gui.Test;

@SuppressWarnings("deprecation")
public class Connect extends Thread{
	private IRCConnection conn;
	private String channel;

	public static void IRCConnect(String[] args,String chan) throws UnsupportedEncodingException {

		Hashtable<?, ?> ht = null;
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
	      new Connect(host, port, pass, nick, user, name, ssl, chan);
	    } catch (IOException exc) {
	      printHelp();
	    }
	  }

	private static Hashtable<String, Object> getHashtable(String[] args) {
	    Hashtable<String, Object> ht = new Hashtable<String, Object>();
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

	private static Object getParam(String[] args, Object key) {
	    return getParam(args, key, null);
	  }

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


	private static void print(Object o) throws UnsupportedEncodingException {
	    System.out.println("[IRC]" + o);
	    Test.println("[IRC]" + o);
	  }


	private static void printHelp() throws UnsupportedEncodingException {
	    print("Error with connecting...");
	  }


	public Connect(String host, int port, String pass, String nick, String user,String name, boolean ssl, String chan) throws IOException {
		    channel = chan;

		    //print(channel);
		    //print(chan);

			if (!ssl) {
		      conn = new IRCConnection(host, new int[] { port }, pass, nick, user, name);
		    } else {
		      conn = new SSLIRCConnection(host, new int[] { port }, pass, nick, user, name);
		      ((SSLIRCConnection)conn).addTrustManager(new SSLDefaultTrustManager());
		    }
		    conn.addIRCEventListener(new Listener());
		    conn.setPong(true);
		    conn.setDaemon(false);
		    conn.setColors(false);
		    conn.connect();
		    setDaemon(true);
		    start();
		    print("Starting up IRC...");
		  }

	public Connect(String host,int port, String password,String Nickname,String UserName,String RealName,String chan) throws IOException{
		new Connect(host,port,password,Nickname,UserName,RealName,false,chan);
	}

	public Connect(String host,int port, String Nickname,String UserName,String RealName,boolean Ssl,String chan) throws IOException{
		new Connect(host,port,null,Nickname,UserName,RealName,Ssl,chan);
	}

	public Connect(String host,int port, String Nickname,String UserName,String RealName,String chan) throws IOException{
		new Connect(host,port,null,Nickname,UserName,RealName,false,chan);
	}

	public Connect(String host,int port, String Nickname,boolean Ssl,String chan) throws IOException{
		new Connect(host,port,null,Nickname,null,null,Ssl,chan);
	}

	public Connect(String host,int port, String Nickname,String chan) throws IOException{
		new Connect(host,port,null,Nickname,null,null,false,chan);
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		try {
			print(channel);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
		if(!channel.equals(null))
		{
			conn.doJoin(channel);
		}
		/*
		try {
			doPrivmsgUTF8(conn,channel,"test");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
	  }

	public void doPrivmsgUTF8(IRCConnection con,String chan,String text) throws UnsupportedEncodingException
	{
		con.doPrivmsg(chan,UTF8Encode(text));
	}

	public String UTF8Decode(String text) throws UnsupportedEncodingException
	{
		return new String(text.getBytes("ISO_8859_1"), "UTF8");
	}

	public String UTF8Encode(String text) throws UnsupportedEncodingException
	{
		return new String(text.getBytes("UTF8"), "ISO_8859_1");
	}

	  /**
	   * Treats IRC events. The most of them are just printed.
	   */
	  public class Listener extends IRCEventAdapter implements IRCEventListener {

	    public void onRegistered() {
	      try {
			print("接続しました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onDisconnected() {
	      try {
			print("接続を切りました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onError(String msg) {
	      try {
			print("エラー: "+ msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onError(int num, String msg) {
	      try {
			print("エラー #"+ num +": "+ msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onInvite(String chan, IRCUser u, String nickPass) {
	      try {
			print("[" + chan +"]["+ u.getNick() +"][Invite]" + u.getNick() + "さんが"+ nickPass + "さんを招待しました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onJoin(String chan, IRCUser u) {
	      try {
			print("[" + chan + "][" + u.getNick() +"][Join]" + u.getNick() + "さんが入ってきました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onKick(String chan, IRCUser u, String nickPass, String msg) {
	      try {
			print("[" + chan + "]["+ u.getNick() +"][Kick]"+ u.getNick() + "さんが" + nickPass + "さんをキックしました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onMode(IRCUser u, String nickPass, String mode) {
	      try {
			if(u.getNick().equals(nickPass))
			  {
				print("[AllChan][" + u.getNick() +"][Mode]" + u.getNick() + "さんが自分のモードを" + mode +"に変更しました");
			  }else{
				  print("[AllChan][" + u.getNick() +"][Mode]" + u.getNick() + "さんが" + nickPass + "さんのモードを" + mode +"に変更しました");
			  }
		  } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		  }
	    }

	    public void onMode(IRCUser u, String chan, IRCModeParser mp) throws UnsupportedEncodingException {
	      print("[" + chan +"]["+ u.getNick() +"][Mode]" + u.getNick() + "さんがチャンネルのモードを" + mp.getLine() + "に変更しました");
	    }

	    public void onNick(IRCUser u, String nickNew) {
	      try {
			print("[AllChan][" + u.getNick() +"][ChangeNick]"+ u.getNick() + "さんが" + nickNew + "にニックネームを変更しました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onNotice(String target, IRCUser u, String msg) {

	      String DecodeEncodeStr = "";
		try {
		  DecodeEncodeStr = UTF8Decode(msg);
		  print("[" + target +"]["+ u.getNick() +"][Notice]"+ DecodeEncodeStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			}
	    }

	    public void onPart(String chan, IRCUser u, String msg) {
	      try {
			print("[" + chan + "]["+ u.getNick() +"][Part]" + u.getNick() + "さんが" + chan + "から離れました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onPrivmsg(String chan, IRCUser u, String msg) {
	      String DecodeEncodeStr = "";
		try {
		  if(chan.equals("#parallelnote")|chan.equals("#S__twgitter"))
		  {
			  DecodeEncodeStr = UTF8Decode(msg);
		  }else{
			  DecodeEncodeStr = msg;
		  }
		  print("[" + chan +"]["+ u.getNick() +"]"+ DecodeEncodeStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onQuit(IRCUser u, String msg) {
	      try {
			print("[AllChan][" + u.getNick() + "][Quit]" + u.getNick() + "さんがIRCから離れました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	    public void onReply(int num, String value, String msg) {
	    	/*
	    try {
			print("Reply #"+ num +": "+ value +" "+ msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
	    }

	    public void onTopic(String chan, IRCUser u, String topic) {
	      try {
			print("[" + chan +"]["+ u.getNick() +"][ChangeTopic]トピックを\"" + topic + "\"変更しました");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    }

	  }

}
