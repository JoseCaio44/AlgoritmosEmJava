import java.util.*;

class Item implements Comparable<Item> {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Item other) {
        double ratio1 = (double) value / weight;
        double ratio2 = (double) other.value / other.weight;
        return Double.compare(ratio2, ratio1);
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        Collections.sort(items);

        double totalValue = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += (double) item.value * capacity / item.weight;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = fractionalKnapsack(weights, values, capacity);
        System.out.println("Maximum value achievable: " + maxValue);
    }
}
