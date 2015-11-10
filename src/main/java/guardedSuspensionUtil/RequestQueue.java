package guardedSuspensionUtil;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestQueue {

	private Queue<Request> requestQueue = new ConcurrentLinkedQueue<Request>();

	public synchronized Request getRequest() {

		try {
			while (requestQueue.size() == 0) {
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requestQueue.poll();
	}

	public synchronized void addRequest(Request request) {
		requestQueue.add(request);
		notifyAll();
	}

}
