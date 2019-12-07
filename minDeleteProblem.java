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


    public int delteMinChars(String str) {
        return 1;
    }

    public static void main(String[] args) {
        minDeleteProblem ds = new minDeleteProblem();
        String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the",
                "sunny", "is", "is"};
        int k = 4;
        System.out.println(ds.addNumber(-1234));

    }
}
