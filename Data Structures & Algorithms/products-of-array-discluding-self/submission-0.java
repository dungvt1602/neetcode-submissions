class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // Bước 1: Tính tích bên trái và lưu vào res
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // Bước 2: Tính tích bên phải bằng biến tạm và nhân vào res
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right; // Tích bên trái * Tích bên phải
            right *= nums[i];        // Cập nhật tích bên phải cho vòng lặp sau
        }
        
        return res;
    }
}