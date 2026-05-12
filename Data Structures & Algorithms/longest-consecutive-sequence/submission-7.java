class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }

        int max = 0;
        for(int i:set)
        {
            if(!set.contains(i-1))
            {
                int lengh = 1;
                int count = 1;
                while(set.contains(i+lengh))
                {
                    count++;
                    lengh++;
                }
                if(count>=max) max = count;
            }
        }

        return max;
    }
}
