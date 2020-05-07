class Solution {
    public String addBinary(String a, String b) {
        
        //validity
        if(a == null){
            return b;
        }
        
        //validity
        if(b == null){
            return a;
        }
        
        if(a.length() > b.length()){
            return addition(a, b);
        }else{
            return addition(b, a);
        }
    }
    
    private String addition(String a, String b){
        
        int lenA = a.length();
        int lenB = b.length();
        
        int dif = lenA - lenB, carrier = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = lenB-1; i >= 0; i --){
            
            int t1 = Character.getNumericValue(a.charAt(dif+i));
            int t2 = Character.getNumericValue(b.charAt(i));
            
            int sum = t1 + t2 + carrier;
            
            sb.append(sum%2);
            
            carrier = sum/2;
            
        }
        
        for(int i = dif - 1; i >= 0; i--){
            
            int t1 = Character.getNumericValue(a.charAt(i));
            
            int sum = t1 + carrier;
            
            sb.append(sum%2);
            
            carrier = sum/2;
        }
        
        if(carrier != 0){
            sb.append(carrier);
        }
        
        return sb.reverse().toString();
        
    }
}

