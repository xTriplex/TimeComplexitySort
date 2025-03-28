import java.util.*;
import java.util.regex.*;

public class ComplexityExpression implements Comparable<ComplexityExpression>
{
    String original;
    String simplified;
    int order;

    public ComplexityExpression(String original, List<String> terms, String operator)
    {
        this.original = original;

        if (terms.size() == 1)
        {
            this.order = TimeComplexitySorter.BaseOrder.getOrder(terms.get(0));
            this.simplified = "O(" + terms.get(0) + ")";
        }
        else if (terms.size() == 2)
        {
            int order1 = TimeComplexitySorter.BaseOrder.getOrder(terms.get(0));
            int order2 = TimeComplexitySorter.BaseOrder.getOrder(terms.get(1));

            if (operator.equals("+"))
            {
                if (order1 >= order2)
                {
                    this.order = order1;
                    this.simplified = "O(" + terms.get(0) + ")";
                }
                else
                {
                    this.order = order2;
                    this.simplified = "O(" + terms.get(1) + ")";
                }
            }
            else if (operator.equals("*"))
            {
                this.order = order1 + order2;
                this.simplified = "O(" + formatMultiplication(terms.get(0), terms.get(1)) + ")";
            }
        }
    }

    private String formatMultiplication(String term1, String term2)
    {
        String nPattern = "n(\\^\\d+)?";
        String logPattern = "log n(\\^\\d+)?";

        if (term1.equals("1"))
        {
            return term2;
        }
        else if (term2.equals("1"))
        {
            return term1;
        }
        else if (term1.matches(nPattern) && term2.matches(nPattern))
        {
            return simplifyExponentiationMultiplication(term1, term2, "n");
        }
        else if (term1.matches(logPattern) && term2.matches(logPattern))
        {
            return simplifyExponentiationMultiplication(term1, term2, "log n");
        }
        else if ((term1.matches(nPattern) && term2.matches(logPattern)) || (term1.matches(logPattern) && term2.matches(nPattern)))
        {
            return term1.matches(nPattern) ? term1 + " " + term2 : term2 + " " + term1;
        }
        else if (term1.equals("n log n") && term2.equals("n log n"))
        {
            return "n^2(log n)^2";
        }
        else if (term1.matches(nPattern) && term2.equals("n log n"))
        {
            return simplifyExponentiationMultiplication(term1, "n", "n") + " log n";
        }
        else if (term1.equals("n log n") && term2.matches(nPattern))
        {
            return simplifyExponentiationMultiplication(term2, "n", "n") + " log n";
        }
        else if (term1.equals("log n") && term2.equals("n log n"))
        {
            return "n(log n)^2";
        }
        else if (term1.equals("n log n") && term2.equals("log n"))
        {
            return "n(log n)^2";
        }
        else
        {
            return term1 + " * " + term2;
        }
    }

    private String simplifyExponentiationMultiplication(String term1, String term2, String base)
    {
        int exponent1 = extractExponent(term1, base);
        int exponent2 = extractExponent(term2, base);
        return base + "^" + (exponent1 + exponent2);
    }

    private int extractExponent(String term, String base)
    {
        if (term.equals(base))
        {
            return 1;
        }
        else
        {
            Pattern pattern = Pattern.compile(base + "\\^(\\d+)");
            Matcher matcher = pattern.matcher(term);
            if (matcher.find())
            {
                return Integer.parseInt(matcher.group(1));
            }
            else
            {
                return 1;
            }
        }
    }

    @Override
    public int compareTo(ComplexityExpression other)
    {
        return Integer.compare(this.order, other.order);
    }

    @Override
    public String toString()
    {
        return String.format("%s : %s", original, simplified);
    }
}