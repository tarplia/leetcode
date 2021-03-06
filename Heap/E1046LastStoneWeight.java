/* You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * (1) If x == y, both stones are destroyed, and
 * (2) If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 * At the end of the game, there is at most one stone left.
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*/

import java.util.PriorityQueue;
import java.util.Collections;

class E1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) maxHeap.add(stone1-stone2);
        }

        if (maxHeap.isEmpty()) return 0;

        return maxHeap.peek();
    }

    public void test() {
        int[] input1 = new int[] {2,7,4,1,8,1};
        int[] input2 = new int[] {1};
        int[] input3 = new int[0];

        System.out.println("The weight of the last stone is: " + lastStoneWeight(input1));
        System.out.println("The weight of the last stone is: " + lastStoneWeight(input2));
        System.out.println("The weight of the last stone is: " + lastStoneWeight(input3));
    }

    public static void main(String[] args) {
        E1046LastStoneWeight prog = new E1046LastStoneWeight();
        prog.test();
    }
}
