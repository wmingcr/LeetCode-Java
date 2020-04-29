class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        //check validity
        if(numRows <= 0){
            return lists;
        }
        
        for(int i = 0; i < numRows; i ++){
            if(lists.size() == 0){
                List<Integer> list = new ArrayList();
                list.add(1);
                lists.add(list);
            }else{
                List<Integer> temp = lists.get(lists.size() - 1);
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for(int j = 0; j < temp.size()-1; j ++){
                    list.add(temp.get(j)+temp.get(j+1));
                }
                list.add(1);
                lists.add(list);
            }
        }
        return lists;
    }
}
