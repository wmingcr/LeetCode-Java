import java.util.LinkedList;
import java.util.List;

public class QuanPaiLie {

    List<List<Integer>> res = new LinkedList<> ();

    public static void main(String[] args) {

        int[] arr = {1,2,3};

        QuanPaiLie qq = new QuanPaiLie ();

        qq.backtrack (arr, new LinkedList<> ());

        System.out.println (qq.res);
    }


    private void backtrack(int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack (nums, track);
            track.removeLast ();
        }

    }
}
