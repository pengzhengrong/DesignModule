package decoratorUtil;

import java.util.regex.Pattern;

public class DataCleanerPacketCreator extends PacketDecorator{

	public final static String blank = "&nbsp;";
	
	public DataCleanerPacketCreator(IPacketCreator c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public String handle() {
		// TODO Auto-generated method stub
//		System.out.println(component.handle());
		String content = removeBlank(component.handle());
		content = removeBlankAfterP(content);
		return content;
	}
	
	
	public static String removeBlank( String content ){
		content = content.trim();
		while( content.startsWith(blank)){
			int len = blank.length();
			content = content.substring(len);
		}
		return content;
	}
	
	public static String removeBlankAfterP( String content ){
		String regex = "(?<=<p>)(&nbsp;)*?";
		content.replaceAll(regex, "");
		return content;
		
	}
	
	
	
	public static void main(String[] args) {
		IPacketCreator pc = new DataCleanerPacketCreator(new PacketBodyCreator());
		System.out.println(pc.handle());
	}
	
	
}


class NHttpPacketcreator extends PacketDecorator{

	public NHttpPacketcreator(IPacketCreator c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handle() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("Http1.1 Status: Ok MIMIE: txt/html");
		sb.append(  component.handle() );
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IPacketCreator packetCreator = new NHttpPacketcreator(
				new HttpPacketCreator(
						new DataCleanerPacketCreator( 
								new PacketBodyCreator()
								)
						)
				);
		
		System.out.println( packetCreator.handle() );
	}
	
}
