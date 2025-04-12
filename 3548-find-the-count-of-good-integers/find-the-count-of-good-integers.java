class Solution {
    public long countGoodIntegers(int n, int k) {
        int a = (int) Math.pow(10, (n - 1) / 2);
        int b = (int) Math.pow(10, (n - 1) / 2 + 1);
        Set<String> c = new HashSet<>();
        for (int d = a; d < b; d++) {
            long e = f(d, n);
            if (e % k == 0) {
                char[] g = String.valueOf(e).toCharArray();
                Arrays.sort(g);
                c.add(new String(g));
            }
        }
        long h = 0;
        for (String i : c) {
            Map<Character, Integer> j = m(i);
            h += p(j);
            if (j.containsKey('0')) {
                j.put('0', j.get('0') - 1);
                h -= p(j);
            }
        }
        return h;
    }

    long f(int a, int b) {
        long c = a;
        if (b % 2 == 1) a /= 10;
        while (a > 0) {
            c = c * 10 + a % 10;
            a /= 10;
        }
        return c;
    }

    long p(Map<Character, Integer> a) {
        long b = 1;
        int c = 0;
        for (int d : a.values()) {
            b *= q(d);
            c += d;
        }
        return q(c) / b;
    }

    long q(int a) {
        long b = 1;
        while (a > 0) b *= a--;
        return b;
    }

    Map<Character, Integer> m(String a) {
        Map<Character, Integer> b = new HashMap<>();
        for (char c : a.toCharArray()) {
            b.put(c, b.getOrDefault(c, 0) + 1);
        }
        return b;
    }
}