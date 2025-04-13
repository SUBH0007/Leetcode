class Solution {
    public long m = (long)1e9 + 7 ;
    public long findPower(long a  , long b){
        if(b==0)
        return 1;

        long half = findPower(a , b/2);
        long result = (half * half) % m;
        if(b%2==1)
        result = (result * a) % m ;

        return result;
    }
    public int countGoodNumbers(long n) {
      long no_of_even_idx = (n+1)/2;

        long no_of_odd_idx = (n)/2;

        return (int)((findPower(5,no_of_even_idx) % m * findPower(4 , no_of_odd_idx) % m)%m);   
    }
}