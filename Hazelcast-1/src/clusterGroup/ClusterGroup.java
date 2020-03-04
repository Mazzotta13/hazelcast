package clusterGroup;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class ClusterGroup {

	public static void main(String[] args) {
		Config config1 = new Config();
		config1.getGroupConfig().setName("group1").setPassword("group1-pass");
		
		Config config2 = new Config();
		config2.getGroupConfig().setName("group2").setPassword("group2-pass");
		
		HazelcastInstance hz1 = Hazelcast.newHazelcastInstance(config1);
		HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(config2);
		HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(config2);
		
		System.out.println("size cluster1: "+hz1.getCluster().getMembers().size());
		System.out.println("size cluster2: "+hz3.getCluster().getMembers().size());
	}

}
