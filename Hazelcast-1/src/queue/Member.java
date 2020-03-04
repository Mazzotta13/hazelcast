package queue;

import java.util.concurrent.BlockingQueue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Member {

	public static void main(String[] args) {
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		System.out.println("Instance started...");
		
		BlockingQueue<String> queue = hazelcastInstance.getQueue("queue");
		for(;;) {
			try {
				String object = queue.take();
				System.out.println("object: "+object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
