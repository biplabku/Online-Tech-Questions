import java.util.*;

public class WallOfBricksd {

    public int[] doFactorials(int number) {
        int[] result = new int[number == 0? 1:number];
        factorials(number, result, 0);
        return result;
    }

    public int trappingRainWater(int[] array) {
        int totalRainWater = 0;
        int[] leftmax = new int[array.length];
        leftmax[0] = array[0];
        for(int i = 1; i < array.length; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], array[i]);
        }
        int[] rightmax = new int[array.length];
        rightmax[array.length - 1] = array[array.length - 1];
        for(int i = array.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], array[i]);
        }

        for(int i = 0; i < array.length; i++) {
            totalRainWater += Math.min(leftmax[i], rightmax[i]) - array[i];
        }
        return totalRainWater;
    }


    public int factorials(int number, int[] results, int level) {
        if(number > 1) {
            results[level] = number * factorials(number - 1, results, level + 1);
            return results[level];
        }else{
            results[level] = 1;
            return 1;
        }
    }

    public boolean doBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        return binarySearch(array, left, right, target);
    }

    public boolean binarySearch(int[] array, int left, int right, int target) {
        if(left > right) {
            return false;
        }
        int mid = (left + right)/2;
        if(array[mid] == target) {
            return true;
        }else if(array[mid] < target) {
            return binarySearch(array, mid + 1, right, target);
        }else{
            return binarySearch(array, left, mid, target);
        }
    }

    public PriorityQueue<Integer> targetSum(int[] array, int target) {
        PriorityQueue<Integer> list = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            list.add(array[i]);
            if(sum == target) {
                return list;
            }
            while(sum > target) {
                int val = list.poll();
                sum = sum - val;
                if(sum == target) {
                    return list;
                }
            }
        }
        return null;
    }

    public List<Integer> missingIntegers(Integer[] array) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        List<Integer> list = Arrays.asList(array);
        for(int i = 0; i < array.length; i++) {
            smallest = Math.min(smallest, array[i]);
            largest = Math.max(largest, array[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = smallest ; i <= largest; i++) {
            if(!list.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }


    public LinkNode remove2Largest(LinkNode head, int number) {
        if(head == null) {
            return null;
        }
        int max1 = 0;
        int position1 = 0;
        int max2 = 0;
        int position2 = 0;

        LinkNode cur = head;

        int index = 0;
        // doing it based on poisition because there could be duplicates
        while(cur != null) {
            int val = cur.data;
            if(max1 < val) {
                max2 = max1;
                max1 = val;
                position1 = index;
            }else if(max2 < val) {
                max2 = val;
                position2 = index;
            }
            index++;
            cur = cur.next;
        }
        // checking here if the length of the linked list is less than the given number
        // if its less then return null
        if(index < number) {
            return null;
        }
        LinkNode res = null;
        if(position1 > position2) {
            deleteNode(head, position1);
            res = deleteNode(head, position2);
        }else {
            deleteNode(head, position2);
            res = deleteNode(head, position1);
        }
        head = res;
        while(head != null) {
            System.out.print(head.data + " ---> ");
            head = head.next;
        }
        return head;
    }


    public LinkNode deleteNode(LinkNode head, int position) {
        if(position == 0) {
            LinkNode newHead = new LinkNode(0);
            head = head.next;
            newHead.next = head;
            newHead = newHead.next;
            head = newHead;
            return head;
        }
        LinkNode tempHead = new LinkNode(0);
        tempHead.next = head;
        tempHead = tempHead.next;
        LinkNode prev = new LinkNode(0);
        LinkNode res = prev;
        for(int i = 0; i < position- 1; i++) {
            prev.next = tempHead;
            prev = prev.next;
            tempHead = tempHead.next;
        }
        if(tempHead.next.next == null) {
            LinkNode temp = null;
            tempHead.next = temp;
            res = tempHead;
            return res;
        }
        prev.next = tempHead.next;
        head = res;
        return head;
    }

    public boolean isCycle(LinkNode head) {
        LinkNode slowPointer = head;
        LinkNode fastPointer = head;
        while(slowPointer.next != null && fastPointer.next != null) {
            if(slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }

    public LinkNode deleteNode(LinkNode delete) {
        LinkNode cur = delete;
        LinkNode prev = cur;
        while(cur.next != null) {
            prev = cur;
            cur.data = cur.next.data;
            cur = cur.next;
        }
        prev.next = null;
        return delete;
    }

    public LinkNode removeDuplicates(LinkNode head) {
        LinkNode cur = head;
        while(cur != null) {
            LinkNode temp = cur;
            while(temp != null && temp.data == cur.data) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    public LinkNode removeDuplicates2(LinkNode head) {
        LinkNode cur = head;
        while(cur != null) {
            LinkNode temp = cur;
            while(temp != null && temp.data == cur.data) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    // letters = ['e', 'o', 'b', 'a', 'm', 'g', 'l']
    // dict = ["go", "bat", "me", "eat", "goal", "boy", "run"]
    // can we use duplicates?
    //
    public List<String> checkWords(char[] letters, List<String> words) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < letters.length; i++) {
            if(hmap.containsKey(letters[i])) {
                hmap.put(letters[i], hmap.get(letters[i]) + 1);
            }else {
                hmap.put(letters[i], 1);
            }
        }
        for(int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            HashMap<Character, Integer> temp = new HashMap<>();
            temp.putAll(hmap);
            boolean complete = false;
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(temp.containsKey(ch)) {
                    temp.remove(ch);
                    complete = true;
                }else { // if it does not contains
                    complete = false;
                    break;
                }
            }
            if(complete) {
                result.add(str);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        WallOfBricksd ws = new WallOfBricksd();
        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(3);
        head.next.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);

        //head.next.next.next.next.next = new LinkNode(1);
        char[] letters = new char[]{'e', 'o', 'b', 'a', 'm', 'g', 'l'};
        List<String> input = new ArrayList<>();
        input.add("go");
        input.add("bat");
        input.add("me");
        input.add("eat");
        input.add("goal");
        input.add("boy");
        input.add("run");
        System.out.println(ws.checkWords(letters, input));
    }
}
