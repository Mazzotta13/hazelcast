package com.alessio;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class BackupDemo {

	public static void main(String[] args) {
		HazelcastInstance member1 = Hazelcast.newHazelcastInstance();
		HazelcastInstance member2 = Hazelcast.newHazelcastInstance();
		
		Map<Long, String> customers1 = member1.getMap("customers");
		customers1.put(1L, "google");
		customers1.put(2L, "apple");
		customers1.put(3L, "microsoft");
		
		System.out.println("hazelcast instances: "+Hazelcast.getAllHazelcastInstances().size());
		member1.shutdown();
		System.out.println("hazelcast instances: "+Hazelcast.getAllHazelcastInstances().size());
		Map<Long, String> customers2 = member2.getMap("customers");
		customers2.forEach((key, value) -> System.out.println(key + " - " + value));
	}

}
