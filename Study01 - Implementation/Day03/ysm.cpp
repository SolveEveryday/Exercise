class Solution {
public:
    int reverse(int x) {
        
        long number = 0;
        
        if( (x > std::pow(2, 31) - 1) || x < std::pow(-2, 31)) return 0;
        
        while(x != 0) {
            number = 10 * number + x % 10;
            x /= 10;     
        }
        
        return (number > INT_MAX || number < INT_MIN) ? 0 : number;
        
    };
};