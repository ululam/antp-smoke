import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class LongMethoder {

    public void longM() {
        System.out.println("Large-integer methods\n"
                + "Methods designed for hardware implementation generally do not scale to integers with "
                + "thousands or millions of decimal digits; these frequently occur, for example, in modular "
                + "reductions in cryptography. For these large integers, more efficient division algorithms "
                + "transform the problem to use a small number of multiplications, which can then be done "
                + "using an asymptotically efficient multiplication algorithm such as the Karatsuba "
                + "algorithm, Toom–Cook multiplication or the Schönhage–Strassen algorithm. The result is "
                + "that the computational complexity of the division is of the same order (up to a "
                + "multiplicative constant) as that of the multiplication. Examples include reduction to "
                + "multiplication by Newton's method as described above,[9] as well as the slightly faster "
                + "Barrett reduction and Montgomery reduction algorithms.[10][verification needed] Newton's "
                + "method is particularly efficient in scenarios where one must divide by the same divisor "
                + "many times, since after the initial Newton inversion only one (truncated) multiplication "
                + "is needed for each division."

                + "The division by a constant D is equivalent to the multiplication by its reciprocal. Since the "
                + "denominator is"
                + " constant, so is its reciprocal (1/D). Thus it is possible to compute the value of (1/D) "
                + "once at "
                + "compile time, and at run time perform the multiplication N·(1/D) rather than the division "
                + "N/D. In " + "floating-point arithmetic the use of (1/D) presents little problem, but in integer "
                + "arithmetic the " + "reciprocal will always evaluate to zero (assuming |D| > 1).\n" + "\n"
                + "It is not necessary to use specifically (1/D); any value (X/Y) that reduces to (1/D) may "
                + "be used. " + "For example, for division by 3, the factors 1/3, 2/6, 3/9, or 194/582 could be used. "
                + "Consequently,"
                + " if Y were a power of two the division step would reduce to a fast right bit shift. The "
                + "effect of "
                + "calculating N/D as (N·X)/Y replaces a division with a multiply and a shift. Note that the "
                + "parentheses are important, as N·(X/Y) will evaluate to zero.\n" + "\n"
                + "However, unless D itself is a power of two, there is no X and Y that satisfies the " + "conditions "
                + "above. Fortunately, (N·X)/Y gives exactly the same result as N/D in integer arithmetic "
                + "even when "
                + "(X/Y) is not exactly equal to 1/D, but \"close enough\" that the error introduced by the "
                + "approximation is in the bits that are discarded by the shift operation.[11][12][13]\n" + "\n"
                + "As a concrete fixed-point arithmetic example, for 32-bit unsigned integers, division by 3 "
                + "can be " + "replaced with a multiply by \n" + "2863311531\n" + "/\n" + "233\n"
                + ", a multiplication by 2863311531 (hexadecimal 0xAAAAAAAB) followed by a 33 right bit shift"
                + ". The " + "value of 2863311531 is calculated as \n" + "233\n" + "/\n" + "3\n"
                + ", then rounded up.\n" + "\n"
                + "Likewise, division by 10 can be expressed as a multiplication by 3435973837 (0xCCCCCCCD) "
                + "followed " + "by division by 235 (or 35 right bit shift).\n" + "\n"
                + "In some cases, division by a constant can be accomplished in even less time by converting " + "the "
                + "\"multiply by a constant\" into a series of shifts and adds or subtracts.[14] Of particular "
                + "interest is division by 10, for which the exact quotient is obtained, with remainder if required"
                + ".[15]");
        for (int i = 0; i < 10; i++) {
            i++;
            i--;
            i+=2;
            i+=3;
            i-=2;
            i-=3;
        }
        for (int i = 10; i < 20; i++) {
            i-=2;
            i++;
            i+=2;
            i--;
            i+=3;
            i-=3;
        }

        Object x = "";
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; Type t; ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType)t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return;
                }
            }
        }

    }
}
