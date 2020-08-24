public class Problem4 {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 1, 2, 1};
        int[] arr2 = {9,8,7,6,5};
        int[] arr3 = {10, 10, 10};
        long res1 = countSawSubarrays (arr1);
        long res2 = countSawSubarrays (arr2);
        long res3 = countSawSubarrays (arr3);
        System.out.println (res1);
        System.out.println (res2);
        System.out.println (res3);
    }

    public static long countSawSubarrays(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int n = arr.length;
        long res = 0L;

        for (int i = 0, start; i < n - 1; ) {
            if(arr[i] == arr[i+1]){
                i++;
                continue;
            }
            boolean mark = arr[i] < arr[i + 1];
            start = i++;
            while (i < n - 1) {
                if (mark && arr[i] > arr[i + 1]) {
                    mark = !mark;
                    i++;
                } else if (!mark && arr[i] < arr[i + 1]) {
                    mark = !mark;
                    i++;
                } else {
                    break;
                }
            }
            int end = i;
            res += (long) (end - start) * (long) (end - start + 1) / 2;
        }

        return res;
    }
}
