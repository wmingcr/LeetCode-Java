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
