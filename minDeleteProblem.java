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


    public int delteMinChars(String str) {
        return 1;
    }

    public static void main(String[] args) {
        minDeleteProblem ds = new minDeleteProblem();
        String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the",
                "sunny", "is", "is"};
        int k = 4;
        int[] array = new int[]{2,3,5,7};
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(ds.combinationSum(array, 7));

    }
}
