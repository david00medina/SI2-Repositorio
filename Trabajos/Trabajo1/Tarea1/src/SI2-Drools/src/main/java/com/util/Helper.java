package com.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Helper {
	public static boolean has(List<Object> list, Object o2) {
		for (Object o1 : list) {
			if (o2.equals(o1)) return true;
		}
		return false;
	}
	
	public static int intersectionCardinality(List<Object> l1, List<Object> l2) {
		Set<Object> intersection = l1.parallelStream()
				.distinct()
				.filter(l2::contains)
				.collect(Collectors.toSet());
		return intersection.size();
	}
}
