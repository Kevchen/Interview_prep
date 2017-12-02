class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    class TrieNode{
        private HashMap<Character, TrieNode> map;
        private boolean isWord;

        public TrieNode(boolean isWord){
            map = new HashMap<>();
            this.isWord = isWord;
        }
        public TrieNode addNode(char c,boolean isWord){
            if(!map.containsKey(c)){
                TrieNode newNode = new TrieNode(isWord);
                map.put(new Character(c),newNode);
                return newNode;
            }
            return null;
        }
        public TrieNode getNode(char c){
            return map.containsKey(c) ? map.get(c): null;
        }
        public boolean getIsWord(){
            return isWord;
        }
    }
    public Trie() {
        root = new TrieNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trav = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode next = trav.getNode(c);
            if(next!=null){
                trav=next;
            }else{
                trav = trav.addNode(c,(i==word.length()-1));
            }
        }
        trav.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode found = find(word);
        return found!=null && found.isWord? true: false;
    }

    public TrieNode find(String word){
        TrieNode trav = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode next = trav.getNode(c);
            if(next!=null){
                trav=next;
            }else{
                return null;
            }
        }
        return trav;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode found = find(prefix);
        return found!=null? true:false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */