package twgitter;

import twgitter.gui.message.MessageCellTest;

public class GUITest extends Thread{
	public static void main(String[] args)
	{
		TestThread a = new TestThread();
		GUITest b = new GUITest();
		System.out.println("test");

		a.start();
		b.start();
	}

	public void run()
	{
		try {
			//twgitter.gui.Test.main();
			//Test JavaFX = new Test();
			//JavaFX.main();
			System.out.println("[GUI]Starting up GUI process...");
			MessageCellTest JavaFX = new MessageCellTest();
			JavaFX.main();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}