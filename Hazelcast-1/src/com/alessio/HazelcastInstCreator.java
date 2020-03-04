package com.alessio;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastInstCreator {

	public static void main(String[] args) {
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		Map<Long, String> map = hazelcastInstance.getMap("customers");
		map.put(1L, "apple");
		map.put(2L, "android");
		
		System.out.println("size map: "+hazelcastInstance.getMap("customers").size());
	}

}
