class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        
        // 1. Dùng Integer (Class) thay vì int (primitive) cho Map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int n = nums.length;
        // 2. Khai báo mảng các List (Xô)
        List<Integer>[] bucket = new List[n+1];
        for(int i = 0; i<n+1 ; i++){
            bucket[i] = new ArrayList<>();
        }
        // 3. Đổ dữ liệu từ Map vào Xô
        // Tần suất (value) là index, Giá trị (key) được thêm vào List tại index đó
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        // 4. Thu hoạch kết quả: Duyệt ngược từ cuối mảng (tần suất cao nhất)
        int index = 0;
        for (int i = n; i >= 0 && index < k; i--) {
            // Nếu xô tại tần suất 'i' có chứa số
            if (!bucket[i].isEmpty()) {
                // Duyệt qua từng số trong xô đó
                for (int num : bucket[i]) {
                    result[index++] = num;
                    // Nếu đã lấy đủ k phần tử thì thoát sớm
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}