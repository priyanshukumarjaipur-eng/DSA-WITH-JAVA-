class Solution { 
    public boolean ispalindrom(String s){ 
        int i=0, j=s.length()-1; 
        while(i<j){ 
            if(s.charAt(i) != s.charAt(j)) return false; 
            i++; j--; 
        } 
        return true; 
    } 

    public int maxPalindromes(String s, int k) { 
        int n = s.length(); 
        int count = 0; 
        int l = 0; 
        
        while (l <= n - k) { 
            int x = l + k; 
            if (ispalindrom(s.substring(l, x))) { 
                count++; 
                l = x; 
                continue;
            } 
            x = l + k + 1;
            if (x <= n && ispalindrom(s.substring(l, x))) {
                count++;
                l = x; 
                continue;
            }
            l++; 
        } 
        return count; 
    } 
}
