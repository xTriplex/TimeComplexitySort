import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class ComplexityInputPanel extends JPanel
{
    public ComplexityInputPanel(DefaultListModel<ComplexityExpression> listModel)
    {
        setLayout(new GridLayout(2, 4, 10, 10)); // Grid layout with spacing
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

        String[] baseFunctions = {"1", "log n", "n", "n log n", "n^2", "n^3", "2^n", "3^n", "4^n", "n!"};
        JComboBox<String> combo1 = new JComboBox<>(baseFunctions);
        JComboBox<String> combo2 = new JComboBox<>(baseFunctions);
        combo2.insertItemAt("None", 0);
        combo2.setSelectedIndex(0);

        String[] operators = {"+", "*"};
        JComboBox<String> operatorCombo = new JComboBox<>(operators);

        add(new JLabel("Term 1:"));
        add(combo1);
        add(operatorCombo);
        add(new JLabel("Term 2:"));
        add(combo2);

        JButton addButton = new JButton("Add Complexity");
        addButton.setBackground(new Color(100, 149, 237));
        addButton.setForeground(Color.WHITE); // White text
        addButton.setFocusPainted(false);
        addButton.setBorder(new RoundedBorder(15));
        add(addButton);

        addButton.addActionListener(e ->
        {
            String term1 = (String) combo1.getSelectedItem();
            String term2 = (String) combo2.getSelectedItem();
            String operator = (String) operatorCombo.getSelectedItem();
            List<String> terms = new ArrayList<>();
            terms.add(term1);
            String originalExpression = term1;

            if (term2 != null && !term2.equals("None"))
            {
                terms.add(term2);
                originalExpression += " " + operator + " " + term2;
            }

            ComplexityExpression ce = new ComplexityExpression(originalExpression, terms, operator);
            listModel.addElement(ce);
        });
    }
}
