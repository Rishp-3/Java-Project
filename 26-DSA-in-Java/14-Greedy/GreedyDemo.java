import java.util.*;

public class GreedyDemo {

    // Greedy: make the locally optimal choice at each step, hoping it leads
    // to a globally optimal solution. Works for some problems, not all.

    // Activity Selection: pick the max number of non-overlapping activities
    record Activity(int start, int end) {}

    static int maxActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(Activity::end)); // greedy: always pick earliest finish
        int count = 1;
        int lastEnd = activities.get(0).end();
        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start() >= lastEnd) {
                count++;
                lastEnd = activities.get(i).end();
            }
        }
        return count;
    }

    // Coin Change (greedy version - works correctly for "canonical" coin systems like INR/USD)
    static int minCoins(int amount, int[] coins) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return amount == 0 ? count : -1;
    }

    // Fractional Knapsack: maximize value within a weight limit, items CAN be split
    record Item(int value, int weight) {}

    static double fractionalKnapsack(List<Item> items, int capacity) {
        items.sort((a, b) -> Double.compare(
            (double) b.value() / b.weight(), (double) a.value() / a.weight()));

        double totalValue = 0;
        for (Item item : items) {
            if (capacity <= 0) break;
            if (item.weight() <= capacity) {
                totalValue += item.value();
                capacity -= item.weight();
            } else {
                totalValue += item.value() * ((double) capacity / item.weight());
                capacity = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>(List.of(
            new Activity(1, 3), new Activity(2, 5), new Activity(4, 6),
            new Activity(6, 7), new Activity(5, 9), new Activity(8, 9)
        ));
        System.out.println("Max non-overlapping activities: " + maxActivities(activities));

        System.out.println("Min coins for 93 (using [1,5,10,25]): " + minCoins(93, new int[]{1, 5, 10, 25}));

        List<Item> items = List.of(new Item(60, 10), new Item(100, 20), new Item(120, 30));
        System.out.println("Max value in knapsack (capacity 50): " + fractionalKnapsack(items, 50));
    }
}
