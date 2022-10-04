class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> output(2);
        for(int x = 0; x < nums.size()-1; x++) {
            for(int y = x+1; y < nums.size(); y++) {
                int num1 = nums[x];
                int num2 = nums[y];
            
                if(num1 + num2 == target) {
                    output[0] = x;
                    output[1] = y;
                    break;
                }
            }
        }
        
        return output;
    }
};