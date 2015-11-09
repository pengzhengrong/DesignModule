package futureUtil;

public class Test {

	public static void main(String[] args) {
		
		Client client = new Client();
		Data data = client.request("my question ");
		System.out.println(data.getResult());
		
	}
}
