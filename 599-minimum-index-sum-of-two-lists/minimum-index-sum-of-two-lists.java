class Solution { 
    public String[] findRestaurant(String[] list1, String[] list2) { 
        int n1 = list1.length; 
        int n2 = list2.length; 
        String ans[] = new String[n1]; 
        int idx = 0;
        int min = Integer.MAX_VALUE;  
        int i = 0; 
        while (i < n1) { 
            String s = list1[i]; 
            int j = 0; 
            while (j < n2 && !s.equals(list2[j])) { 
                j++; 
            } 
            if (j < n2) {
                int currleast = j + i; 
                if (currleast < min) { 
                    min = currleast; 
                    idx = 0; 
                } 
                if (currleast == min) { 
                    ans[idx++] = s; 
                } 
            }
            i++; 
        } 
        String x[] = new String[idx]; 
        for (int k = 0; k < idx; k++) { 
            x[k] = ans[k]; 
        } 
        return x; 
    } 
}
