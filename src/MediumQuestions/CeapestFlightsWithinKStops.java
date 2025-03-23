package MediumQuestions;

import java.util.Arrays;

public class CeapestFlightsWithinKStops {
    /**
    Cheapest Flights Within K Stops

     There are n cities connected by some number of flights.
     You are given an array flights where flights[i] = [from, to, price] indicates that there is a flight from city from, to city to with cost price.
     You are also given three integers src, dst, and k, return the cheapest price from sre to dst with at most k stops. If there is no such route, return -1.
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize a prices array to store the cheapest price to reach each city
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Repeat the relaxation process for k + 1 times
        for (int i = 0; i <= k; i++) {
            // Create a temporary copy of prices to avoid overwriting during the iteration
            int[] tempPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];

                // If the source city has been reached and the cost isn't MAX_VALUE
                if (prices[from] != Integer.MAX_VALUE) {
                    // Update the price to reach the destination city
                    tempPrices[to] = Math.min(tempPrices[to], prices[from] + cost);
                }
            }

            // Update the original prices array with the temporary prices
            prices = tempPrices;
        }

        // If the price to reach dst remains MAX_VALUE, return -1 (no route found)
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    /**
     Explanation:
     Bellman-Ford Algorithm:

     This approach iteratively relaxes the edges for k + 1 iterations (because k stops allow k + 1 edges).

     It ensures we explore the cheapest prices with the given limit on stops.

     Key Components:

     prices array: Keeps track of the cheapest cost to each city.

     Temporary array (tempPrices): Prevents overwriting during the current iteration.

     Edge Relaxation:

     For each flight, update the price to the destination city if the source city can be reached at a cheaper price.

     Final Check:

     If the destination city (dst) still has Integer.MAX_VALUE as its price, return -1 (indicating no valid route was found).
     */
}
