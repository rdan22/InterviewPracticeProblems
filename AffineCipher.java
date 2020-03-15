public class AffineCipher {
    int m = 26;

    public String encode(String clearText, int a, int b) {

        if ( greatestCommonDivisor(a,m) != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");

        StringBuffer sb = new StringBuffer();

        for (int c : clearText.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = c - 'a';

                c = (((c * a) + b) % m);

                sb.append((char) ('a' + c));
            }
            if (c >= '0' && c <= '9') {
                sb.append((char) c);
            }
        }
        return blockString(sb.toString());
    }

    String blockString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && i % 5 == 0)
                sb.append(' ');

            sb.append(s.charAt(i));
        }
        return sb.toString().trim();
    }

    static int mod(int a, int m) {
        while ( a < 0 )
            a+=m;

        return a % m;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    static int greatestCommonDivisor(int a, int b) {
        int gcd = 1;
        for (int i = 1;
             i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }


    public String decode(String cipherText, int a, int b) {

        if ( greatestCommonDivisor(a,m) != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");

        int mi = modInverse(a,m);

        StringBuffer sb = new StringBuffer();

        for (int c : cipherText.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = mod( mi * ( c - 'a' - b ) , m);
                sb.append((char) ('a' + c));
            }
            if (c >= '0' && c <= '9') {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}