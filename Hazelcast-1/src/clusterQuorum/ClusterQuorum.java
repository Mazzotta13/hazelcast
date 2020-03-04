package clusterQuorum;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.QuorumConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class ClusterQuorum {
	// Do not work as expected: the last map.put should fail instead it is executed successfully
	public static void main(String[] args) {
		QuorumConfig quorumConfig = new QuorumConfig();
		quorumConfig.setName("MIN_TWO")
			.setEnabled(true)
			.setSize(2);
		
		MapConfig mapConfig = new MapConfig();
		mapConfig.setName("MIN_TWO").setQuorumName("MIN_TWO");
		
		HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
		HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
		
		IMap<String, String> map = hz1.getMap("MIN_TWO");
		map.put("1", "one");
		map.put("2", "two");
		
		Config config = new Config();
		config.addMapConfig(mapConfig);
		config.addQuorumConfig(quorumConfig);	
		
		map.forEach((key, value) -> System.out.println(value));
		
		hz2.getLifecycleService().shutdown();
		map.put("3", "three");
		
		map = hz1.getMap("MIN_TWO");
		map.forEach((key, value) -> System.out.println(value));
	}
}
