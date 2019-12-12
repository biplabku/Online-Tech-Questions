import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class minDeleteProblem {
    // add digit 5 to make it the highest
    // Microsoft online tech screen question - Add a digit 5 to a number to get the highest possible number
    // 267 - 5267
    // 0 - 50
    // -1 - 15
    public int addNumber(int value) {
        int number = 0;
        boolean isNegative = value < 0? true:false;
        value = Math.abs(value);
        StringBuilder sb = new StringBuilder();
        while(value > 0) {
            sb.append(value%10);
            value = value/10;
        }
        sb = sb.reverse();
        number = addCheckNumberCombo(sb.toString(), isNegative);
        return number;
    }

    public int addCheckNumberCombo(String str, boolean isNegative) {
        String s = "5";
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= str.length(); i++) {
            StringBuilder temp = new StringBuilder(str);
            temp.insert(i, s);
            int number;
            if(isNegative) {
                number = (-1) * Integer.parseInt(new String(temp));
            }else{
                number = Integer.parseInt(new String(temp));
            }
            list.add(number);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0);
    }

    // 1,2,3,4,5
    // buckets = 3
    public List<List<Integer>> getSumbuckets(int[] array, int number) {
        List<List<Integer>> result  = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        List<Integer> input =  new ArrayList<>();
        for(int i=0; i < array.length; i++) {
            input.add(array[i]);
        }
        while(!input.isEmpty()) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            while(sum != number) {
                if(sum <= number) {

                }
            }
        }
        return result;
    }

    public List<Integer> convertToArrayList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length;i++) {
            list.add(array[i]);
        }
        return list;
    }

    // 2,3,6,7
    // target = 7
    public List<List<Integer>> combinationSum(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = convertToArrayList(array);
        doCombineSum(result, 0, input, new ArrayList<>(), target, 0);
        return result;
    }

    public void doCombineSum(List<List<Integer>> result, int startIndex, List<Integer> list, List<Integer> temp, int target, int sum) {
        if(startIndex == list.size() - 1)  {
            return ;
        }
        for(int i = startIndex; i < list.size(); i++) {
            if(i != 0 && list.get(i) == list.get(i - 1)) {
                continue;
            }
            if(sum + list.get(i) == target) {
                temp.add(list.get(i));
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                break;
            }else if(sum + list.get(i) < target) {
                temp.add(list.get(i));
                doCombineSum(result, startIndex, list, temp, target, sum + list.get(i)); // here we are basically backtracking the steps weh have taken if its not matching
                temp.remove(temp.size() - 1);
            }else{
                break;
            }
        }
    }

    // i = 2;
    // love = 2;
    // leetcode = 1;
    // coding = 1;
    // one idea is to use a maxheap to get the value that has the highest occurences and then
    // we need to sort if we have multiple such occurencess
    public List<String> topKfrequent(String[] words, int k) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i =0; i < words.length; i++) {
            String str = words[i];
            if(!hmap.containsKey(str)) {
                hmap.put(str, 1);
            }else {
                hmap.put(str, hmap.get(str) + 1);
            }
        }
        PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            int val = (int)pair.getValue();
            result.add(val);
        }
        iter = hmap.entrySet().iterator();
        PriorityQueue<String> output = new PriorityQueue<>();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            String temp = (String)pair.getKey();
            int val = (int) pair.getValue();
            if(val == result.peek()) {
                output.add(temp);
                if(output.size() == k) {
                    break;
                }
            }
        }
        List<String> t = new ArrayList<>(output);
        return t;
    }

    public List<List<Integer>> subsetSum(List<Integer> list, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < list.size(); i++) {
            result.add(combinationSum(list, new ArrayList<>(), target, 0, 0));
        }
        return result;
    }

    public List<Integer> combinationSum(List<Integer> list, List<Integer> result, int target, int start, int sum) {
        if(start > list.size() - 1 || sum == target) {
            return result;
        }
        if(sum < target) {
            sum += list.get(start);
            result.add(list.get(start));
            return combinationSum(list, result, target, start + 1, sum);
        }else {
            sum -= list.get(start - 1);
            result.remove(result.size() - 1);
            return combinationSum(list, result, target, start + 2, sum);
        }
    }

    // 1,2,3,4
    // permutation.
    public List<List<Integer>> doPermutations(int[] array) {
        List<List<Integer>> result= new ArrayList<>();
        permute(convertToArrayList(array), 0, array.length, result);
        return result;
    }

    public void permute(List<Integer> array, int start, int end, List<List<Integer>> result) {
        if(start == array.size()) {
            result.add(new ArrayList<>(array));
            return ;
        }
        for(int i = start; i < array.size(); i++) {
            swap(array, start, i);
            permute(array, start+1, end, result);
            swap(array, start, i);
        }
    }

    public void swap(List<Integer> array, int left, int right) {
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    class freqNumber{
        int number;
        int numOfTimes;

        public freqNumber(int num, int times) {
            this.number = num;
            this.numOfTimes = times;
        }
    }

    public void mostFrequentNumber(int[] array) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // Time complexity for below code - O(N);
        for(int i = 0; i < array.length; i++) {
            int val = array[i];
            if(!hmap.containsKey(val)) {
                hmap.put(val, 1);
            }else {
                hmap.put(val, hmap.get(val) + 1);
            }
        }

        // O(logN)
        PriorityQueue<freqNumber> frequency = new PriorityQueue<>(new Comparator<freqNumber>() {
            @Override
            public int compare(freqNumber f1, freqNumber f2) {
                return f2.numOfTimes - f1.numOfTimes;
            }
        });

        Iterator iter = hmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            int key = (int)pair.getKey();
            int value = (int)pair.getValue();
            frequency.add(new freqNumber(key, value));
        }

        while(!frequency.isEmpty()) {
            freqNumber m = frequency.poll();
            System.out.println(m.number + " " + m.numOfTimes);
        }
    }

    public int shortestPath(int[][] grid) {
        int dist = Integer.MAX_VALUE;
        int res = 0;
        getShortestPath(grid, 0, 0, res, dist);
        return dist;
    }

    public boolean isSafe(int[][] grid, int x, int y) {
        return (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length );
    }

    public int getShortestPath(int[][] grid, int x, int y, int res, int dist) {
        if(grid[x][y] == 9) {
            dist = Math.min(res, dist);
            return dist;
        }
        int temp = grid[x][y];
        grid[x][y] = 1;
        if(isSafe(grid, x + 1, y) && grid[x + 1][y] == 1) {
            res += getShortestPath(grid, x + 1, y, res + 1, dist);
        }
        if(isSafe(grid, x, y + 1) && grid[x][y + 1] == 1) {
            res += getShortestPath(grid, x, y + 1, res + 1, dist);
        }
        if(isSafe(grid, x - 1, y) && grid[x - 1][y] == 1) {
            res += getShortestPath(grid, x - 1, y, res + 1, dist);
        }
        if(isSafe(grid, x, y - 1) && grid[x][ y - 1] == 1) {
            res += getShortestPath(grid, x, y - 1, res + 1, dist);
        }
        grid[x][y] = temp;
        return res;
    }

    class point{
        int index;
        char ch;

        public point(int x, char ch) {
            this.index = x;
            this.ch = ch;
        }
    }
    public int maxDistance(String str) {
        PriorityQueue<point> queue = new PriorityQueue<>(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                return o1.index - o2.index;
            }
        });
        HashSet<Character> hset = new HashSet<>();
        int temp = 0;
        int maxDistance = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hset.contains(ch)) {
                hset.add(ch);
                point p = new point(i, ch);
                temp += 1;
                queue.add(p);
                maxDistance = Math.max(maxDistance, temp);
            }else {
                while(!queue.isEmpty()) {
                    point p = queue.poll();
                    if(p.ch == ch) {
                        maxDistance = Math.max(maxDistance, i - p.index);
                        temp = 0;
                        break;
                    }
                }
            }
        }
        maxDistance = Math.max(temp, maxDistance);
        return maxDistance;
    }

    static class LinkNode {
        LinkNode next;
        int data;

        public LinkNode(int val ) {
            this.data = val;
        }
    }

    public LinkNode swapNodePairs(LinkNode cur) {
        LinkNode head = cur;
        LinkNode dummy = new LinkNode(0);
        dummy.next = cur;
        LinkNode previous = dummy;
        while(head != null && head.next != null) {
            LinkNode firstNode = head;
            LinkNode seconNode = head.next;
            previous.next = seconNode;
            firstNode.next = seconNode.next;
            seconNode.next = firstNode;

            previous = firstNode;
            head = firstNode.next;

        }
        return dummy.next;
    }


    public static void main(String[] args) {
        minDeleteProblem ds = new minDeleteProblem();
        String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the",
                "sunny", "is", "is"};
        int k = 4;
        int[] array = new int[]{1,1,2,3,3,3,5,7,1};
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        int[][] grid = {{1,1,1,1},{2,2,2,1},{3,3,1,1},{9,1,1,2}};
        String str = "suabcdeag";
        LinkNode t = new LinkNode(1);
        t.next = new LinkNode(2);
        t.next.next = new LinkNode(3);
        t.next.next.next = new LinkNode(4);
        t.next.next.next.next = new LinkNode(5);

        System.out.println(ds.swapNodePairs(t));

    }
}
