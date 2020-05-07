class Solution {
    public boolean canReach(int[] arr, int start) {
        //validity
        if(arr == null || arr.length == 0 || start > arr.length-1 || start < 0){
            return false;
        }
        
        boolean [] visited = new boolean[arr.length];
        
        LinkedList<Integer> ist = new LinkedList<>();
        
        ist.add(start);
        
        while(ist.isEmpty() == false){
            
            int curr = ist.poll();
            
            if(arr[curr] == 0){
                return true;
            }
            
            visited[curr] = true;
            
            int left = curr - arr[curr];
            
            if(0 <= left && visited[left] == false){
                ist.add(left);
            }
            
            int right = curr + arr[curr];
            
            if(right < arr.length && visited[right] == false){
                ist.add(right);
            }
            
        }
        return false;
    }
}
