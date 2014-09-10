package twgitter.get;

import java.io.BufferedReader;
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
}
