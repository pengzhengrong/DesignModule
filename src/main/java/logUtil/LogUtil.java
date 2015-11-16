package logUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

	private static Logger Log = LoggerFactory.getLogger("STDOUT");
	
	public static void debug( String msg ){
		Log.debug(msg);
	}
	
	
}
