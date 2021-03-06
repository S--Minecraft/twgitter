package twgitter.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class GetHTTP {
	/**
	 * HTTP接続して内容を取得
	 * @param URI アクセスするURI
	 * @param Header 必要なヘッダを設定（Header[?][0]が名前、[?][1]が内容）
	 * @param CharCode 文字コード設定(ない場合はJISAutoDetect)
	 * @throws Exception
	 */
	public static void AccessHTTP(String URI,String[][] Header,String CharCode) throws Exception {
		// 引数からURIを生成
		URI uri = new URI(URI);

		// URI -> URL -> URLConnection の順で接続インスタンスを取得
		URLConnection connection = uri.toURL().openConnection();

		//ヘッダ設定
		if(!(Header[0][0].equals("") && Header[0][1].equals("")))
		{
			for(int i=0;i<Header.length;i++)
			{
					connection.setRequestProperty(Header[i][0] ,Header[i][1]);
			}
		}

        // ヘッダ情報を出力
		/*
		Map<String, List<String>> headers = connection.getHeaderFields();
		for (Object key : headers.keySet()) {
			System.out.println("[Misc]HTTP Headers{" + key + ": " + headers.get(key) + "}");
		}
		*/

		// コンテンツを出力
		/*
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), CharCode));
		String buffer = reader.readLine();
		System.out.println("[Misc]Successed to get HTTP");
		while(null != buffer)
		{
			System.out.println("G:" + buffer);
			buffer = reader.readLine();
		}
		*/
	}

	public static void AccessHTTP(String URI,String[][] Header) throws Exception{
		String CharCode1 = "JISAutoDetect";
		AccessHTTP(URI,Header,CharCode1);
	}

	public static void AccessHTTP(String URI,String CharCode) throws Exception{
		String Header1[][] = new String[1][2];
		Header1[0][0] = "";
		Header1[0][1] = "";
		AccessHTTP(URI,Header1,CharCode);
	}

	public static void AccessHTTP(String URI) throws Exception{
		String CharCode2 = "JISAutoDetect";
		String Header2[][] = new String[1][2];
		Header2[0][0] = "";
		Header2[0][1] = "";
		AccessHTTP(URI,Header2,CharCode2);
	}

	/**
	 * String[]で内容を返す
	 * @param URI アクセスするURI
	 * @param Header 必要なヘッダを設定（Header[?][0]が名前、[?][1]が内容）
	 * @param CharCode 文字コード設定(ない場合はJISAutoDetect)
	 * @return HTTPの内容
	 * @throws Exception
	 */
	public static List<String> AccessHTTPString(String URI,String[][] Header,String CharCode) throws Exception {
		List<String> out = new ArrayList<>();

		// 引数からURIを生成
		URI uri = new URI(URI);

		// URI -> URL -> URLConnection の順で接続インスタンスを取得
		URLConnection connection = uri.toURL().openConnection();

		//ヘッダ設定
		if(!(Header[0][0].equals("") && Header[0][1].equals("")))
		{
			for(int i=0;i<Header.length;i++)
			{
				connection.setRequestProperty(Header[i][0] ,Header[i][1]);
			}
		}

        // ヘッダ情報を出力
		/*
		Map<String, List<String>> headers = connection.getHeaderFields();
		for (Object key : headers.keySet()) {
			System.out.println("[Misc]HTTP Headers{" + key + ": " + headers.get(key) + "}");
		}
		*/

		// コンテンツを出力
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), CharCode));
		String buffer = reader.readLine();
		//System.out.println("[Misc]Successed to get HTTP");
		while(null != buffer)
		{
			out.add(buffer);
			//System.out.println("G:" + buffer);
			buffer = reader.readLine();
		}
		return out;
	}

	public static List<String> AccessHTTPString(String URI,String[][] Header) throws Exception{
		String CharCode1 = "JISAutoDetect";
		List<String> out1 = new ArrayList<>();
		out1 = AccessHTTPString(URI,Header,CharCode1);

		return out1;
	}

	public static List<String> AccessHTTPString(String URI,String CharCode) throws Exception{
		String Header1[][] = new String[1][2];
		Header1[0][0] = "";
		Header1[0][1] = "";
		List<String> out2 = new ArrayList<>();
		out2 = AccessHTTPString(URI,Header1,CharCode);

		return out2;
	}

	public static List<String> AccessHTTPString(String URI) throws Exception{
		String CharCode2 = "JISAutoDetect";
		String Header2[][] = new String[1][2];
		Header2[0][0] = "";
		Header2[0][1] = "";
		List<String> out3 = new ArrayList<>();
		out3 = AccessHTTPString(URI,Header2,CharCode2);

		return out3;
	}
}
