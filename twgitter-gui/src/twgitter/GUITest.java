package twgitter;

import twgitter.gui.Test;

public class GUITest extends Thread{
	public static void main(String[] args)
	{
		TestThread a = new TestThread();
		GUITest b = new GUITest();

		a.start();
		b.start();
	}

	public void run()
	{
		try {
			//twgitter.gui.Test.main();
			Test JavaFX = new Test();
			JavaFX.main();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}