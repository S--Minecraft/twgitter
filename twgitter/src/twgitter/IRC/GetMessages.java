package twgitter.IRC;

import java.io.UnsupportedEncodingException;



public class GetMessages {
	public static void getMessages(String server,String password,String Nickname,String UserName,String RealName,boolean Ssl,String chan) throws UnsupportedEncodingException{
		int ssl;
		if(Ssl)
		{
			ssl = 11;
		}else{
			ssl = 10;
		}

		String[] args = new String[ssl];

		if(Ssl)
		{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-pass";
			args[3] = password;
			args[4] = "-nick";
			args[5] = Nickname;
			args[6] = "-user";
			args[7] = UserName;
			args[8] = "-name";
			args[9] = RealName;
			args[10] = "-ssl";
		}else{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-pass";
			args[3] = password;
			args[4] = "-nick";
			args[5] = Nickname;
			args[6] = "-user";
			args[7] = UserName;
			args[8] = "-name";
			args[9] = RealName;
		}

		Connect.IRCConnect(args,chan);
	}

	public static void getMessages(String server,String password,String Nickname,String UserName,String RealName,String chan) throws UnsupportedEncodingException{
		getMessages(server,password,Nickname,UserName,RealName,false,chan);
	}

	public static void getMessages(String server,String Nickname,String UserName,String RealName,boolean Ssl,String chan) throws UnsupportedEncodingException{
		int ssl;
		if(Ssl)
		{
			ssl = 9;
		}else{
			ssl = 8;
		}

		String[] args = new String[ssl];

		if(Ssl)
		{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-nick";
			args[3] = Nickname;
			args[4] = "-user";
			args[5] = UserName;
			args[6] = "-name";
			args[7] = RealName;
			args[8] = "-ssl";
		}else{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-nick";
			args[3] = Nickname;
			args[4] = "-user";
			args[5] = UserName;
			args[6] = "-name";
			args[7] = RealName;
		}

		Connect.IRCConnect(args,chan);
	}

	public static void getMessages(String server,String Nickname,String UserName,String RealName,String chan) throws UnsupportedEncodingException{
		getMessages(server,Nickname,UserName,RealName,false,chan);
	}

	public static void getMessages(String server,String Nickname,boolean Ssl,String chan) throws UnsupportedEncodingException{
		int ssl;
		if(Ssl)
		{
			ssl = 5;
		}else{
			ssl = 4;
		}

		String[] args = new String[ssl];

		if(Ssl)
		{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-nick";
			args[3] = Nickname;
			args[4] = "-ssl";
		}else{
			args[0] = "-server";
			args[1] = server;
			args[2] = "-nick";
			args[3] = Nickname;
		}

		Connect.IRCConnect(args,chan);
	}

	public static void getMessages(String server,String Nickname,String chan) throws UnsupportedEncodingException{
		getMessages(server,Nickname,false,chan);
	}
}
