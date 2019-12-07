import java.util.*;

public class microQuest {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public void runMedian(int[] array) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < array.length;i++) {
            addNum(array[i]);
            findMedian();
        }
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        // balancing both maximum and minimum heaps
        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }

    public int maxSum(int[] array) {
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            List<Integer> temp;
            int val = returnSum(array[i]);
            if(!hmap.containsKey(val)) {
                temp = new ArrayList<>();
                temp.add(array[i]);
                hmap.put(val, temp);
            }else {
                temp = hmap.get(val);
                temp.add(array[i]);
                hmap.put(val, temp);
            }
        }
        int result = 0;
        Iterator iter = hmap.entrySet().iterator();
        if(hmap.size() < 2) {
            return -1;
        }
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            List<Integer> list = (List<Integer>)pair.getValue();
            if (list.size() < 2 ){
                return -1;
            }
            int val = 0;
            for(int i = 0; i < list.size(); i++ ) {
                val += list.get(i);
            }
            if(val > result) {
                result = val;
            }

        }
        return result;
    }

    public int returnSum(int number) {
        int result = 0;
        int remainder = 0;
        for(int i = 0; i < number/10; i++) {
            remainder = number % 10;
            number = number/10;
            result += remainder;
        }
        result += number;
        return result;
    }

    public int getSumPair(int[] array) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int result = -1;
        for(int i = 0; i < array.length; i++) {
            int sum = returnSum(array[i]);
            if(!hmap.containsKey(sum)) {
                hmap.put(sum, array[i]);
            }else {
                result = Math.max(result, hmap.get(array[i]) + array[i]);
                hmap.put(sum, result);
            }
        }
        return result;
    }

    // string example -
    // baaaaa - It should return 1
    // baaabbaabbba - It should return 2
    public int minCountLetters(String str) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int result = 0;
        int count = 0;
        while(count < str.length()) {
            char temp = str.charAt(count);
            if(!hmap.containsKey(temp)) {
                hmap.put(temp, 1);
                count += 1;
            }else {
                hmap.put(temp, hmap.get(temp) + 1);
                char ch = temp;
                while(ch == temp && hmap.containsKey(temp)) {
                    if(hmap.get(temp) == 3) {

                    }
                    count += 1;
                    temp = str.charAt(count);
                }
            }
        }
        return result;
    }


    public int minCountLettersMethod2(String str) {
        int result = 0;
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i - 1) != str.charAt(i)) {
                count = 1;
            }else if(str.charAt(i - 1) == str.charAt(i)) {
                count += 1;
                if(count == 3) {
                    result += 1;
                    i = i+1;
                }
                if(count >= 3) {
                    count = 1;
                }
            }
        }
        return result;
    }

    // mamad -- mamda -- madma -- madam
    // asflkj
    // aabb
    // ntiin
    public int minSwapPalindrome(String str) {
        char[] array = str.toCharArray();
        int left =0;
        int right = str.length() - 1;
        int counter = 0;
        // first check if palindrome is possible
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!hmap.containsKey(ch)) {
                hmap.put(ch, 1);
            }else {
                hmap.put(ch, hmap.get(ch) + 1);
            }
        }
        Iterator iter = hmap.entrySet().iterator();
        int c1 = 0;
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if((int)pair.getValue()%2 == 1) {
                c1 += 1;
            }
        }
        if(c1 > 1) {
            return -1;
        }
        while(left < right) {
            char chStart = array[left];
            char chEnd = array[right];
            int endpoint = right;
            int c = 0;
            while(chStart != chEnd) {
                chEnd = array[right - 1];
                char temp = array[right - 1];
                array[right - 1] = array[right];
                array[right] = temp;
                right = right - 1;
                if(chEnd != array[right + 1]) {
                    c += 1;
                }
            }
            if(endpoint == right) {
                left += 1;
                right -= 1;
            }else{
                counter += c;
                right = endpoint;
            }
        }
        return counter;
    }













    public static void main(String[] args) {
        microQuest ms = new microQuest();
        int[] array = new int[]{5,6,1,2,3,8,9,10};
        String str = "aabb";
        ms.runMedian(array);
        //System.out.println(ms.runMedian(array));
    }
}
