package twgitter.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Command {
	/**
	 * cmdにコマンドを送ってそれを実行する
	 *
	 * @param command コマンド
	 * @return コマンドで出てきた文字列（配列）
	 * @throws Exception
	 */
	public static String[] execCommand(String command) throws Exception
	{
		Runtime r = Runtime.getRuntime();
		Process process = r.exec(command);
		InputStream is = process.getInputStream();
		Vector<String> vecOsOutput = StreamToVector(is);

		String[] returnVar = new String[vecOsOutput.size()];
		for(int i=0; i< vecOsOutput.size(); i++){
			returnVar[i] = vecOsOutput.get(i);
		}

		//デバッグ、0なら正常終了
		/*
		int ret = process.waitFor();
		System.out.println(ret);
		*/

		System.out.println("[Misc]Successed to do the command");

		return returnVar;
	}

	/**
	 * コマンドで出てきた文字列をString[]に変換
	 *
	 * @param is InputStream
	 * @return String[]に変換されたコマンドで出てきた文字列
	 * @throws Exception
	 */
	private static Vector<String> StreamToVector(InputStream is) throws Exception {
		Vector<String> tb = new Vector<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s;
		while ((s = br.readLine()) != null) {
			tb.add(s);
		}
		return tb;
	}

	/**
	 * execCommand(new String[]{"notepad.exe","C:\test.txt"});
	 *
	 * Process.waitFor()を実行していますので、外部コマンドの実行が
	 * 終了するまでこのメソッドは待機します。
	 *
	 * @param cmds 実行するコマンドと引数を含む配列
	 * @return コマンド実行結果情報を保持するString配列
	 *    配列[0] ⇒ 標準出力
	 *    配列[1] ⇒ エラー出力
	 *    配列[2] ⇒ リターンコード
	 * @throws IOException 入出力エラーが発生した場合
	 */
	public static String[] execCommand(String[] cmds) throws IOException,
	                                                    InterruptedException {
	    String[] returns = new String[3];
	    String LINE_SEPA = System.getProperty("line.separator");
	    Runtime r = Runtime.getRuntime();
	    Process p = r.exec(cmds);
	    InputStream in = null;
	    BufferedReader br = null;
	    try {
	        in = p.getInputStream();
	        StringBuffer out = new StringBuffer();
	        br = new BufferedReader(new InputStreamReader(in));
	        String line;
	        while ((line = br.readLine()) != null) {
	            out.append(line + LINE_SEPA);
	        }
	        returns[0] = out.toString();
	        br.close();
	        in.close();
	        in = p.getErrorStream();
	        StringBuffer err = new StringBuffer();
	        br = new BufferedReader(new InputStreamReader(in));
	        while ((line = br.readLine()) != null) {
	            err.append(line + LINE_SEPA);
	        }
	        returns[1] = err.toString();
	        returns[2] = Integer.toString(p.waitFor());
	        return returns;
	    } finally {
	        if (br != null) {
	            br.close();
	        }
	        if (in != null) {
	            in.close();
	        }
	    }
	}
	public static String[] execCommand1(String cmd) throws IOException,InterruptedException {
		return execCommand(new String[] { cmd });
	}

}
