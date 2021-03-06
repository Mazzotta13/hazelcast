package queue;

import java.util.Queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class Client {
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		HazelcastInstance client = HazelcastClient.newHazelcastClient();
		
		Queue<String> queue = client.getQueue("queue");
		queue.add("Sent from client");
		client.shutdown();
	}
}
