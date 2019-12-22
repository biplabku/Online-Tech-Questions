import java.util.ArrayList;
import java.util.HashMap;
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

    public static void main(String[] args) {
        String str = "aaa";
        String[] words = new String[]{"aaaa"};
        googlePrep ms = new googlePrep();
        System.out.println(ms.expressiveWords(str, words));
    }
}
