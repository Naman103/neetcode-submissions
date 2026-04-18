interface Sorting {
    void sort(int[] nums);
}

class MergeSort implements Sorting {
    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        
        int mid = (left + right)/2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        List<Integer> sortedList = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sortedList.add(nums[i]);
                i++;
            } else {
                sortedList.add(nums[j]);
                j++;
            }
        }

        while(i <= mid) {
            sortedList.add(nums[i]);
            i++;
        }

        while (j <= right) {
            sortedList.add(nums[j]);
            j++;
        }

        i = left;
        for(int num : sortedList) {
            nums[i] = num;
            i++;
        }
    }
}

class Solution {
    Sorting sortingAlgo;
    public int[] sortArray(int[] nums) {
       sortingAlgo = new MergeSort();
       sortingAlgo.sort(nums);
       return nums;
    }
    
}