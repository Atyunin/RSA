import java.math.BigInteger;
import java.util.ArrayList;

class RSA
{
    private PrimeNum primeNum = new PrimeNum();
    private long n = -1;
    private long d = -1;

    public ArrayList<String> Encode(String text)
    {
        ArrayList<String> result = new ArrayList<String>();
        int p = primeNum.GetPrimeNumber();
        int q = primeNum.GetPrimeNumber();
        BigInteger c;

        if (p == q)
            while(p == q)
                q = primeNum.GetPrimeNumber();

        n = p * q;

        long m = (p - 1) * (q - 1);
        d = CalcD(m);

        long e = CalcE(d, m);

        for (int i = 0; i < text.length(); i++)
        {
            int index = text.charAt(i);

            c = new BigInteger(Integer.toString(index));
            c = c.modPow(new BigInteger(Long.toString(e)), new BigInteger(Long.toString(n)));

            result.add(c.toString());
        }

        return result;
    }

    public String Decode(ArrayList<String> input)
    {
        String result = "";
        BigInteger m;

        if (d > 0 && n > 0)
        {
            for (int i = 0; i < input.size(); i++)
            {
                m = new BigInteger(input.get(i));

                m = m.modPow(new BigInteger(Long.toString(d)), new BigInteger(Long.toString(n)));

                int index = m.intValue();
                result += (char) index;
            }
        }

        return result;
    }

    private long CalcD(long m)
    {
        long d = m - 1;

        for (long i = 2; i <= m; i++)
        {
            if (m % i == 0 && d % i == 0)
            {
                d--;
                i = 1;
            }
        }

        return d;
    }

    private long CalcE(long d, long m)
    {
        long e = 10;

        while (true)
        {
            if ((e * d) % m == 1)
                break;
            else
                e++;
        }

        return e;
    }
}
