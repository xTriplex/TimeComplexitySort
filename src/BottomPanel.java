import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class BottomPanel extends JPanel
{
    public BottomPanel(DefaultListModel<ComplexityExpression> listModel)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setBackground(new Color(240, 240, 240));

        JButton randomButton = new JButton("Generate Random");
        styleButton(randomButton);

        JButton sortButton = new JButton("Sort");
        styleButton(sortButton);

        JButton clearButton = new JButton("Clear");
        styleButton(clearButton);

        // Action: Sort the list based on computed growth order
        sortButton.addActionListener(e -> {
            List<ComplexityExpression> expressions = Collections.list(listModel.elements());
            expressions = TimeComplexitySorter.sortComplexities(expressions);
            listModel.clear();
            expressions.forEach(listModel::addElement);
        });

        // Action: Clear the list of added complexity expressions
        clearButton.addActionListener(e -> listModel.clear());

        // Action: Generate 10 random complexities
        randomButton.addActionListener(e -> generateRandomComplexities(listModel));

        add(randomButton);
        add(sortButton);
        add(clearButton);
    }

    private void styleButton(JButton button)
    {
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new RoundedBorder(15));
    }

    private void generateRandomComplexities(DefaultListModel<ComplexityExpression> listModel)
    {
        Random rand = new Random();
        String[] baseFunctions = {"1", "log n", "n", "n log n", "n^2", "n^3", "2^n", "3^n", "4^n", "n!"};
        String[] operators = {"+", "*"};

        // Generate 10 random complexities
        for (int i = 0; i < 10; i++)
        {
            String term1 = baseFunctions[rand.nextInt(baseFunctions.length)];
            String operator = operators[rand.nextInt(operators.length)];
            String term2 = baseFunctions[rand.nextInt(baseFunctions.length)];

            List<String> terms = new ArrayList<>();
            terms.add(term1);
            String originalExpression = term1;

            // Randomly decide whether to generate a 1-term or 2-term complexity
            if (rand.nextBoolean())
            {
                originalExpression = term1;
            }
            else
            {
                originalExpression += " " + operator + " " + term2;
                terms.add(term2);
            }

            ComplexityExpression ce = new ComplexityExpression(originalExpression, terms, operator);
            listModel.addElement(ce);
        }
    }
}
