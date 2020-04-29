//recursion, 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        //check if numRows is 0,
        if(numRows == 0){
            return lists;
        }
        //ending recursion condition
        if(numRows == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            return lists;
        }
        //get List of n-1
        List<List<Integer>> lastLists = generate(numRows - 1);
        //get its last list
        List<Integer> lastList = lastLists.get(lastLists.size() - 1);
        //prepare the new list we gonna add,
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i < lastList.size(); i++){
            if(i == 0){
                //0
                newList.add(1);
            }else{
                newList.add(lastList.get(i - 1) + lastList.get(i));
            }
        }
        //last one,
        newList.add(1);
        lastLists.add(newList);
        return lastLists;
    }
}
