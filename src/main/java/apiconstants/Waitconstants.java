package apiconstants;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waitconstants {



	

	/**
	 * This page contains constants for waits
	 * 
	 * @author varsha
	 * 
	 */ 
	
		
			
			public static final Duration WAIT_FOR_ELEMENT = Duration.ofSeconds(20);
			public static final Duration WAIT_FOR_ELEMENT_TO_DISAPPEAR = Duration.ofSeconds(10);
			public static int  WAIT_FOR_UPLOAD_TO_FINISH = 4000;
			public static void waitTest()  {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

}
