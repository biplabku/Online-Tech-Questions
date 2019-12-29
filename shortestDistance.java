import java.util.*;

public class shortestDistance {

    // A = hit
    // B = cog
    // hot, dot, dog, lot, log
    public int solveWordLadderSelf(String beginWord, String endWord, List<String> words) {
        if(beginWord == null || endWord == null || words.size() == 0 || words == null) {
            return 0;
        }
        if(!words.contains(endWord)) {
            return 0;
        }
        int distance  = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        if(beginWord.equalsIgnoreCase(endWord)) {
            return 1;
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String t = queue.poll();
                if(t.equalsIgnoreCase(endWord)) {
                    return distance;
                }
                for
            }
        }
    }


    public int solveWordLadder(String start, String end, List<String> list) {
        if(start == null || end == null || list == null || start.length() != end.length()) {
            return 0;
        }
        Set<String> words = new HashSet<>(list);
        list.add(end);
        if(!list.contains(end)) {
            return 0;
        }
        if(start.equalsIgnoreCase(end)) {
            return 1;
        }
        Deque<String> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        deque.add(start);
        visited.add(start);
        int distance = 1;
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                String word = deque.removeFirst();
                if(word.equalsIgnoreCase(end)) {
                    return distance;
                }
                for(String neighbor : getNeighbors(word, words)) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        deque.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return 0;
    }


    public Set<String> getNeighbors(String str, Set<String> words) {
        Set<String> validWords = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            char[] neighbor = str.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++) {
                neighbor[i] = ch;
                String word = new String(neighbor);
                if(words.contains(word)) {
                    validWords.add(word);
                }
            }
        }
        validWords.remove(str);
        return validWords;
    }
    public boolean compareStrings(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(ch1 != ch2) {
                count++;
            }
        }
        return count <= 1 ? true:false;
    }

    public static void main(String[] args) {
        shortestDistance ss = new shortestDistance();
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        System.out.println(ss.solveWordLadder(start, end, list));

    }
}
