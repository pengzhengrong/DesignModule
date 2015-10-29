package decoratorUtil;

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
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IPacketCreator pc = new HttpPacketCreator(
				new DataCleanerPacketCreator(
						new PacketBodyCreator() ));
		System.out.println(pc.handle());
	}
	

}
