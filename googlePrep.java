import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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



    public static void main(String[] args) {
        String str = "aaa";
        String[] words = new String[]{"aaaa"};
        googlePrep ms = new googlePrep();
        String str1 = "rabbbit";
        String str2 = "rabbit";
        circularNode n = new circularNode(3);
        circularNode n1 = new circularNode(4);
        circularNode n2 = new circularNode(1);
        n.next = n1;
        n1.next = n2;
        n2.next = n;
        int[] array = new int[]{1,1,3,2,4,3,2,1,1,1,1,1,1,1};
        System.out.println(ms.maxiPlotLand(array, 7));
    }
}
