import java.util.*;

public final class TimeComplexitySorter
{
    // Enum for base functions and their "growth order"
    public enum BaseOrder
    {
        CONSTANT("1", 0),
        LOG_N("log n", 1),
        LINEAR("n", 2),
        LINEARITHMIC("n log n", 3),
        QUADRATIC("n^2", 4),
        CUBIC("n^3", 5),
        EXPONENTIAL_2("2^n", 6),
        EXPONENTIAL_3("3^n", 7),
        EXPONENTIAL_4("4^n", 8),
        FACTORIAL("n!", 9);

        private final String name;
        private final int order;

        BaseOrder(String name, int order)
        {
            this.name = name;
            this.order = order;
        }

        public String getName()
        {
            return name;
        }

        public int getOrder()
        {
            return order;
        }

        private static final Map<String, Integer> ORDER_MAP = new HashMap<>();

        static
        {
            for (BaseOrder baseOrder : values())
            {
                ORDER_MAP.put(baseOrder.getName(), baseOrder.getOrder());
            }
        }

        public static int getOrder(String name)
        {
            return ORDER_MAP.getOrDefault(name, -1);
        }
    }

    // Sort the complexity expressions based on their computed order
    public static List<ComplexityExpression> sortComplexities(List<ComplexityExpression> expressions)
    {
        Collections.sort(expressions);
        return expressions;
    }
}