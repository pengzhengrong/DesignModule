package NGSFutureUtil;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestQueue {

	private Queue<Request> requestQueue = new ConcurrentLinkedQueue<Request>();

	public synchronized void addRequest(Request request) {
		requestQueue.add(request);
		notifyAll();
	}

	public synchronized Request getRequest() {
		try {
			while (requestQueue.size() == 0) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestQueue.poll();
	}

}
