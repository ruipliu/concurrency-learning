package examples;

import java.math.BigInteger;
import java.util.concurrent.atomic.*;
import javax.servlet.*;

import net.jcip.annotations.*;

/**
 * UnsafeCachingFactorizer
 *
 * Servlet that attempts to cache its last result without adequate atomicity
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {
    private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<BigInteger[]>();

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(resp, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            // 因为无法同时更改两个数值，所以线程不安全。
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}

