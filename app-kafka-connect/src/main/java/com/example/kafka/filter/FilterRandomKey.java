package com.example.kafka.filter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class FilterRandomKey implements Predicate<Long> {

	public static final Long LOWEST = 500l;
	public static final Long HIGHEST = 1000l;
	
	@Override
	public boolean test(Long t) {
		if(t.equals(ThreadLocalRandom.current().nextLong(LOWEST, HIGHEST))){
			return true;
		};
		return false;
	}

}
