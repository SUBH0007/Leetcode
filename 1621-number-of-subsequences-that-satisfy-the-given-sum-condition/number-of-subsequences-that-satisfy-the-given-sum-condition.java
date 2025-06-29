import java.util.Arrays;

class Solution {
    public int numSubseq(int[] mang, int muc_tieu) {
        int ket_qua = 0;
        int n = mang.length;
        int mod = (int)1e9 + 7;

        
        int[] luy_thua_2 = new int[n + 1];
        luy_thua_2[0] = 1;
        for (int i = 1; i <= n; ++i) {
            luy_thua_2[i] = (luy_thua_2[i - 1] * 2) % mod;
        }

        
        Arrays.sort(mang);

        
        int trai = 0, phai = n - 1;
        while (trai <= phai) {
            
            if (mang[trai] + mang[phai] > muc_tieu) {
                phai--;
            } else {
                
                ket_qua = (ket_qua + luy_thua_2[phai - trai]) % mod;
                trai++;
            }
        }

        return ket_qua;
    }
}