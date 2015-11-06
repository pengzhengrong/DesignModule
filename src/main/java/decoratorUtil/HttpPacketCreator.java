package decoratorUtil;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HttpPacketCreator extends PacketDecorator{

	public HttpPacketCreator(IPacketCreator c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public String handle() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<body>");
		sb.append(component.handle());
		sb.append("</body>");
		
		try {
//			FileInputStream fis = new FileInputStream(new File("/home/save/cms") );
//			DataInputStream dis = new DataInputStream(fis);
//			BufferedInputStream bis = new BufferedInputStream(dis);
			//装饰者
			BufferedInputStream bis = new BufferedInputStream(
					new DataInputStream(
							new FileInputStream(
									new File("/home/save/cms")
									)
							)
					);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IPacketCreator pc = new HttpPacketCreator(
				new DataCleanerPacketCreator(
						new PacketBodyCreator() ));
		System.out.println(pc.handle());
	}
	

}
