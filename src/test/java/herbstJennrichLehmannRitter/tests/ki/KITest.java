package herbstJennrichLehmannRitter.tests.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.ki.KI;

import org.junit.Test;

public class KITest {

	@Test
	//@Ignore
	public void testKi() throws InterruptedException {
		KI.startKIOnLocal("KI2000");
		KI.startKIOnLocal("KI3000");
		Globals.getLocalGameServer().start(GameType.COLLECTION_RAGE);
		Thread.sleep(6000);
	}
	
}
