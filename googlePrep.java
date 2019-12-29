import java.util.*;

public class googlePrep {

    class countChar {
        char ch;
        int count;
        public countChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    // heeellooo
    public List<countChar> addChar(String str, List<countChar> list) {
        countChar c;
        int count = 1;
        int i = 0;
        for( i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            count = 1;
            while(i < str.length()-1 && ch1 == str.charAt(i + 1)) {
                count++;
                i++;
            }
            c = new countChar(ch1, count);
            list.add(c);
        }
        if(i < str.length()) {
            c = new countChar(str.charAt(str.length() - 1), 1);
            list.add(c);
        }
        return list;
    }

    public int compare(List<countChar> list1, List<countChar> list2) {
        if(list1.size() != list2.size()) return -1;
        int res = 0;
        for(int i = 0; i < list2.size(); i++) {
            countChar c1 = list1.get(i);
            countChar c2 = list2.get(i);
            if(c1.ch == c2.ch && c1.count == c2.count) {
                continue;
            }else if(c1.ch == c2.ch && c1.count != c2.count) {
                if(c1.count < 3) {
                    return -1;
                }else {
                    res++;
                }
                if(c2.count > c1.count) {
                    return -1;
                }
            }else if(c1.ch != c2.ch) {
                return -1;
            }

        }
        return res;
    }
    // time complexity -
    // addchar complexity - O(N);
    // Compare complexity - O(N * K)
    public int expressiveWords(String str, String[] words) {
        int result = 0;
        int res = 0;
        List<countChar> list = addChar(str, new ArrayList<>());
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            result = compare(list, addChar(s, new ArrayList<>()));
            if(result != -1) {
                res += 1;
            }
        }
        return res == 0? -1: res;
    }

    public int numDistinct(String str, String text) {
        int res = 0;
        int m = str.length();
        int n = text.length();
        if(m > n) {
            return 0;
        }
        int[][] mat = new int[str.length() + 1][text.length() + 1];
        return res;
    }



    public int checkIfMatch(int[][] array) {
        int res = 0;
        for(int i = 0; i < array.length; i++) {
            if(i < array.length && i < array[0].length && array[i][i] != -1) {
                res += 1;
            }
        }
        return res;
    }

    public int editDistance(String str1, String str2 ) {
        int res = 0;
        int[][] array = new int[str1.length()][str2.length()];
        for(int i =0; i < str1.length(); i++) {
            if(i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
                array[i][i] = -1;
            }
        }
        res = checkIfMatch(array);
        return res;
    }


    public HashSet<Character> checkSizeChars(String str) {
        HashSet<Character> hset = new HashSet<>();
        for(int i = 0;i < str.length(); i++) {
            hset.add(str.charAt(i));
        }
        return hset;
    }

    public circularNode insert(int insertVal, circularNode head) {
        if(head == null) {
            head = new circularNode(insertVal);
            head.next = head;
        }
        circularNode prev = head;
        circularNode curr = head;
        while(prev != curr.next) {
            circularNode temp = curr.next;
            if(insertVal >= curr.val && curr.next.val >= insertVal) {
                curr.next = new circularNode(insertVal);
                curr = curr.next;
                curr.next = temp;
                return head;
            }
            curr = temp;
        }
        return head;
    }

    public int maximumPlotLand(int[] array, int budget) {
        int res = 0;
        for(int i = 0; i < array.length; i++) {
            int sum = 0;
            for(int j = i ; j < array.length; j++) {
               sum += array[j];
               if(sum == budget) {
                   res = Math.max(j - i + 1, res);
                   break;
               }
            }
        }
        return res;
    }

    public int maxiPlotLand(int[] array, int budget) {
        int res = 0;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(sum == budget) {
                res = Math.max(i - index + 1, res);
            }else if(sum > budget) {
                sum -= array[index];
                index++;
            }
        }
        return res;
    }

    public int maxSquarePossible(int[][] array, int budget) {
        int result = 0;
        boolean[][] visited = new boolean[array.length][array[0].length];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                int sum = 0;
            }
        }
        return result;
    }

    public int calculateSumSize(int[][] array, int sum, int budget, int i, int j) {
        if(sum == budget) {

        }
        for(int st = i; st < array.length; st++) {
        }
        return 1;
    }
    // time complexity -
    // O(N) to insert the list in hashmap.
    // Even if its running since we are removing the values from hashmap it will still be O(N)
    public void parentChild(List<List<Integer>> list) {
        if(list == null) {
            return ;
        }
        HashMap<Integer, List<Integer>> hmap1 = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            int key1 = temp.get(0);
            int key2 = temp.get(1);
            List<Integer> cur;
            if(!hmap1.containsKey(key1) ) {
                cur = new ArrayList<>();
                cur.add(key2);
                hmap1.put(key1, cur);
            }
        }
        for(List<Integer> l : list){
            int key = l.get(0);
            int value = l.get(1);
            List<Integer> t = new ArrayList<>();
            t.add(value);
            while(hmap1.containsKey(value)) {
                List<Integer> valFromHmap = hmap1.get(value);
                t.addAll(valFromHmap);
                hmap1.remove(value);
                value = valFromHmap.get(0);
                hmap1.put(key, t);
            }
        }

        Iterator iter = hmap1.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            int key = (int)pair.getKey();
            List<Integer> value = (List<Integer>)pair.getValue();
            System.out.println(key + ", " + value);
        }
    }

    public int maxPossibleSum(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum1 = array[0];
        int sum2 = array[array.length - 1];
        for(int i = 1; i < array.length-1; i++) {
            int val = array[i];
            queue.add(val);
        }
        k = k -2;
        while(k >= 0 && !queue.isEmpty())  {
            int val = queue.poll();
            sum1 += val;
            sum2 += val;
            k--;
        }
        int res = sum1 > sum2? sum1:sum2;
        return res;
    }

    public boolean transform(String str1, String str2) {
        return true;
    }

    public static class TreeNode {
        int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {
            left = null;
            right = null;
        }

        public TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    // sorted list to BST - Height balanced tree
    public TreeNode sortedListToBST(LinkNode node) {
        if(node == null) {
            return new TreeNode();
        }
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = addNode(arr, 0, arr.length - 1);
        return root;
    }

    public int countNode(LinkNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public TreeNode linklistToBST(LinkNode node) {
        int count = countNode(node);
        if(count == 0) {
            return new TreeNode();
        }
        TreeNode root = listToBST(node, 0, count);
        return root;
    }

    public TreeNode listToBST(LinkNode node, int start, int end) {
        if(node == null) {
            return new TreeNode();
        }
        int mid = (start + end)/2;
        LinkNode midNode = getLinkNode(node);
        TreeNode root = new TreeNode(midNode.data);
        root.left = listToBST(node, start, mid - 1);
        root.right = listToBST(node, mid + 1, end);
        return root;
    }

    public LinkNode getLinkNode( LinkNode node) {
        int count = countNode(node);
        count /= 2;
        while(count != 0) {
            node = node.next;
        }
        return node;
    }

    public TreeNode addNode(int[] array, int start, int end){
        if(start > end) {
            return null;
        }
        int mid = (end + start)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = addNode(array, start, mid - 1);
        root.right = addNode(array, mid + 1, end);
        return root;
    }
    // sorted array to BST - Height balanced tree;


    public static void main(String[] args) {
        googlePrep ms = new googlePrep();
        int[] array = new int[]{5,10,2,9,11};
        int k = 3;
        LinkNode l = new LinkNode(1);
        l.next = new LinkNode(2);
        l.next.next = new LinkNode(3);
        l.next.next.next = new LinkNode(4);
        l.next.next.next.next = new LinkNode(5);

        System.out.println(ms.sortedListToBST(l));
    }
}
