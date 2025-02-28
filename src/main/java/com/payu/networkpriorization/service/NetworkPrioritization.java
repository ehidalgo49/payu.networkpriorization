package com.payu.networkpriorization.service;

import java.util.Comparator;
import java.util.stream.IntStream;

public class NetworkPrioritization {

    /**
     * Sorts the payment network indexes by the specified criteria using streams.
     * If criteria is "RESPONSE_TIME", sort by response time (ascending) and in case of a tie, use cost (ascending).
     * If criteria is "COST", sort by cost (ascending) and in case of a tie, use response time (ascending).
     *
     * @param responseTimes array of response times
     * @param costs array of costs in USD cents
     * @param criteria sorting criteria ("RESPONSE_TIME" or "COST")
     * @return array of payment network indexes sorted by the criteria
     */
    public static int[] prioritizeNetwork(int[] responseTimes, int[] costs, String criteria) {
        if (responseTimes == null || costs == null || criteria == null) {
            throw new IllegalArgumentException("Input arrays and criteria cannot be null");
        }
        if (responseTimes.length != costs.length) {
            throw new IllegalArgumentException("Response time and cost arrangements must be of the same length");
        }

        Comparator<Integer> comparator;
        if("RESPONSE_TIME".equalsIgnoreCase(criteria)){
            comparator = Comparator.comparingInt((Integer i) -> responseTimes[i])
                    .thenComparingInt(i -> costs[i]);
        } else if("COST".equalsIgnoreCase(criteria)){
            comparator = Comparator.comparingInt((Integer i) -> costs[i])
                    .thenComparingInt(i -> responseTimes[i]);
        } else {
            throw new IllegalArgumentException("Invalid criteria: " + criteria);
        }
        return IntStream.range(0, responseTimes.length)
                .boxed()
                .sorted(comparator)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}