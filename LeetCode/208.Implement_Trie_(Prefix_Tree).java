/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/
// My version, 214 ms
class TrieNode {
    public char val;
    public boolean isEnd; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}


public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(tmp.children[c - 'a'] == null){
                tmp.children[c - 'a'] = new TrieNode(c);
            }
            tmp = tmp.children[c - 'a'];
        }
        tmp.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for(int i = 0; i <word.length(); i++){
            char c = word.charAt(i);
            if(tmp.children[c - 'a'] == null){
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return tmp.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i = 0; i <prefix.length(); i++){
            char c = prefix.charAt(i);
            if(tmp.children[c - 'a'] == null){
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return true;
    }
}
