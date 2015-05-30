package com.wordpress.alissonpedrina.string;

import java.util.LinkedList;

/**
 * Rode este programa com o jdk 8 e com as flags -Xmx256m -XX:+UseG1GC. Depois
 * execute novamente o programa com as flags -Xmx256m -XX:+UseG1GC
 * -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
 * 
 * Outras flags importantes: -XX:StringDeduplicationAgeThreshold=3
 * 
 * Various strategies for String Duplication have been considered, but the one
 * implemented now follows the following approach: Whenever the garbage
 * collector visits String objects it takes note of the char arrays. It takes
 * their hash value and stores it alongside with a weak reference to the array.
 * As soon as it finds another String which has the same hash code it compares
 * them char by char. If they match as well, one String will be modified and
 * point to the char array of the second String. The first char array then is no
 * longer referenced anymore and can be garbage collected.
 * 
 * This whole process of course brings some overhead, but is controlled by tight
 * limits. For example if a string is not found to have duplicates for a while
 * it will be no longer checked.
 * 
 * @author alissonpedrina
 *
 */
public class DeduplicationString {

	private static final LinkedList<String> LOTS_OF_STRINGS = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		int iteration = 0;
		while (true) {
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 1000; j++) {
					LOTS_OF_STRINGS.add(new String("String " + j));
				}
			}
			iteration++;
			System.out.println("Survived Iteration: " + iteration);
			Thread.sleep(100);
		}
	}
}
