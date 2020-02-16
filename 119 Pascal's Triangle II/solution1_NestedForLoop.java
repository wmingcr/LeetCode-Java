class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0){
            return res;
        }
        res.add(1);
        if(rowIndex == 0){
            return res;
        }
        for(int i = 0; i < rowIndex; i++){
            List<Integer> tem = new ArrayList<>();
            tem.add(1);
            for(int j = 0; j < i; j++){
                tem.add(res.get(j) + res.get(j+1));
            }
            tem.add(1);
            res = tem;
        }
        return res;
    }
}
