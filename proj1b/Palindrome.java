public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> res = wordToDeque(word);
        return isPalindrome(res);
    }

    private boolean isPalindrome(Deque<Character> res) {
        if (res.size() <= 1) {
            return true;
        }
        if (res.removeFirst() != res.removeLast()) {
            return false;
        }

        return isPalindrome(res);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> res = wordToDeque(word);
        while (res.size() > 1) {
            if (!cc.equalChars(res.removeFirst(), res.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
