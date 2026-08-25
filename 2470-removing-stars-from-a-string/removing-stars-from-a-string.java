class Solution {
    public String removeStars(String s) {
     int n=s.length();
     StringBuilder sb=new StringBuilder(n);   
     for(int i=0;i<n;i++){
        char c=s.charAt(i);
        if( c == '*' && sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(c);
        }
     }
     return sb.toString();
    }
}