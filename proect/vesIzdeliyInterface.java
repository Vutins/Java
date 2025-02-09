import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shopping {

    private static int countX = 0;
    private static int countY = 0;
    private static int countZ = 0;
    private static double[][] haracteristiki = new double[100][2]; // Убедитесь, что размерность правильная
    private static double[] saveVes = new double[100];

    private static double ves1Cronsh = 50;
    private static double ves1Karnis = 900;
    private static double ves1Tkan = 710;
    private static int corobTkan = 100;

    private static JTextArea historyArea;
    private static JTextField widthField;
    private static JTextField heightField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shopping Weight Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JLabel widthLabel = new JLabel("Введите ширину изделия (в метрах): ");
        widthField = new JTextField(10);
        JLabel heightLabel = new JLabel("Введите высоту изделия (в метрах): ");
        heightField = new JTextField(10);

        JButton calculateButton = new JButton("Посчитать вес изделия");
        JButton showHistoryButton = new JButton("Показать историю изделий");
        JButton clearHistoryButton = new JButton("Очистить историю изделий");

        historyArea = new JTextArea(10, 30);
        historyArea.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWeight();
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });

        clearHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearHistory();
            }
        });

        frame.add(widthLabel);
        frame.add(widthField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(calculateButton);
        frame.add(showHistoryButton);
        frame.add(clearHistoryButton);
        frame.add(new JScrollPane(historyArea));

        frame.setVisible(true);
    }

    private static void calculateWeight() {
        try {
            double shirina = Double.parseDouble(widthField.getText());
            double vysota = Double.parseDouble(heightField.getText());

            haracteristiki[countX][0] = shirina; // Исправлено: сохраняем ширину
            haracteristiki[countX][1] = vysota; // Исправлено: сохраняем высоту

            int countCronsh = (shirina > 1.6) ? 4 : 3;

            int vesKarnis = (int) (ves1Karnis * shirina);
            int vesTkan = (int) ((ves1Tkan * (shirina * vysota)) / 2);
            double vesIzdelGR = vesKarnis + vesTkan + (countCronsh * ves1Cronsh) + corobTkan;
            double vesIzdelKG = vesIzdelGR / 1000;

            saveVes[countZ++] = vesIzdelKG;
            countX++; // Увеличиваем countX после добавления нового изделия

            JOptionPane.showMessageDialog(null,
                    shirina + " * " + vysota + " вес в граммах: " + vesIzdelGR +
                            ". Вес в килограммах: " + vesIzdelKG);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа.");
        }
    }

    private static void showHistory() {
        StringBuilder history = new StringBuilder();
        for (int x = 0; x < countX; x++) {if (haracteristiki[x][0] != 0 && haracteristiki[x][1] != 0) {
            history.append(haracteristiki[x][0]).append(" * ").append(haracteristiki[x][1]).append(". Вес (в кг): ")
                    .append(saveVes[x]).append("\n");
        }
        }
        historyArea.setText(history.toString());
    }

    private static void clearHistory() {
        countX = 0; // Сбрасываем счетчик изделий
        countZ = 0; // Сбрасываем счетчик сохраненных весов
        for (int x = 0; x < 100; x++) {
            haracteristiki[x][0] = 0.0;
            haracteristiki[x][1] = 0.0;
            saveVes[x] = 0.0;
        }
        historyArea.setText(""); // Очищаем текстовую область
    }
}
