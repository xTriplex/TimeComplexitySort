import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{

    public Main()
    {
        setTitle("Time Complexity Sorter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        DefaultListModel<ComplexityExpression> listModel = new DefaultListModel<>();
        add(new ComplexityInputPanel(listModel), BorderLayout.NORTH);

        // List to display added complexities
        JList<ComplexityExpression> complexityList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(complexityList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the list
        add(scrollPane, BorderLayout.CENTER);

        // Add bottom panel with sort, clear, and random buttons
        add(new BottomPanel(listModel), BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
