package com.payu.networkpriorization;

import com.payu.networkpriorization.service.NetworkPrioritization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NetworkpriorizationApplicationTests {

	@Test
	public void testPrioritizeByResponseTime() {
		int[] responseTimes = {20, 15, 100, 15, 50, 9};
		int[] costs = {50, 60, 30, 55, 40, 70};
		String criteria = "RESPONSE_TIME";

		int[] expected = {5, 3, 1, 0, 4, 2};
		int[] result = NetworkPrioritization.prioritizeNetwork(responseTimes, costs, criteria);

		Assertions.assertArrayEquals(expected, result);
	}

	@Test
	public void testPrioritizeByCost() {
		int[] responseTimes = {20, 15, 100, 15, 50, 9};
		int[] costs = {50, 60, 30, 55, 40, 70};
		String criteria = "COST";

		// We sort by ascending cost, and in case of a tie, by response time.
		// With the data: index 2 (30), 4 (40), 0 (50), 3 (55), 1 (60) and 5 (70)
		int[] expected = {2, 4, 0, 3, 1, 5};
		int[] result = NetworkPrioritization.prioritizeNetwork(responseTimes, costs, criteria);

		Assertions.assertArrayEquals(expected, result);
	}

	@Test
	public void testInvalidCriteria() {
		int[] responseTimes = {20, 15, 100, 15, 50, 9};
		int[] costs = {50, 60, 30, 55, 40, 70};
		String criteria = "INVALID";

		Assertions.assertThrows(IllegalArgumentException.class, () -> NetworkPrioritization.prioritizeNetwork(responseTimes, costs, criteria));
	}

	@Test
	public void testMismatchedArrayLengths() {
		int[] responseTimes = {20, 15, 100};
		int[] costs = {50, 60};
		String criteria = "RESPONSE_TIME";

		Assertions.assertThrows(IllegalArgumentException.class, () -> NetworkPrioritization.prioritizeNetwork(responseTimes, costs, criteria));
	}
}
