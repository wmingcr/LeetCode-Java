class Solution {
    public List<Integer> getRow(int rowIndex) {
        //for results
        List<Integer> res = new ArrayList<>();
        //check validity of rowIndex
        if(rowIndex < 0){
            return res;
        }
        res.add(1);
        //if it's 0, return it here,
        if(rowIndex == 0){
            return res;
        }
        for(int i = 0; i < rowIndex; i++){
            //a temp List to store values
            List<Integer> tem = new ArrayList<>();
            tem.add(1);
            for(int j = 0; j < i; j++){
                //change the values, according to the triangle
                tem.add(res.get(j) + res.get(j+1));
            }
            //adding last element,
            tem.add(1);
            //pass it to result,
            res = tem;
        }
        return res;
    }
}

//------
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        
        //validity
        if(rowIndex < 0){
            return list;
        }
        
        for(int i = 0; i <= rowIndex; i ++){
            list.add(1);
            for(int j = list.size()-2; j >= 1; j--){
                list.set(j, list.get(j)+list.get(j-1));
            }
        }
        
        return list;
    }
}
