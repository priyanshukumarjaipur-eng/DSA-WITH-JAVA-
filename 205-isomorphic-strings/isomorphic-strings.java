class Solution { 
    public boolean isIsomorphic(String s, String t) { 
        int l1 = s.length(); 
        int l2 = t.length(); 
        
      
        int[] idxS = new int[256]; 
        int[] idxT = new int[256]; 
        
        if (l1 != l2) { 
            return false; 
        } 
        
        for (int i = 0; i < l1; i++) { 
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
           
            if (idxS[charS] != idxT[charT]) { 
                return false; 
            } 
            
            
            idxS[charS] = i + 1; 
            idxT[charT] = i + 1; 
        } 
        
        return true; 
    } 
}
