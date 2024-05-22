/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

/**
 *
 * @author hugos
 */
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSelectionExample extends JFrame {
    private JLabel label1, label2, daysLabel;
    private JDateChooser dateChooser1, dateChooser2;

    public DateSelectionExample() {
        super("Date Selection Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        JButton button1 = new JButton("Seleccionar Fecha 1");
        JButton button2 = new JButton("Seleccionar Fecha 2");
        label1 = new JLabel("Fecha seleccionada: ");
        label2 = new JLabel("Fecha seleccionada: ");
        daysLabel = new JLabel("Días entre fechas: ");

        dateChooser1 = new JDateChooser();
        dateChooser2 = new JDateChooser();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, dateChooser1, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Date selectedDate = dateChooser1.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    label1.setText("Fecha seleccionada: " + sdf.format(selectedDate));
                    dateChooser2.setMinSelectableDate(selectedDate);
                    updateDaysLabel();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, dateChooser2, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    Date selectedDate = dateChooser2.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    label2.setText("Fecha seleccionada: " + sdf.format(selectedDate));
                    updateDaysLabel();
                }
            }
        });

        panel.add(button1);
        panel.add(label1);
        panel.add(button2);
        panel.add(label2);
        panel.add(daysLabel);

        add(panel);
    }

    private void updateDaysLabel() {
        Date date1 = dateChooser1.getDate();
        Date date2 = dateChooser2.getDate();
        if (date1 != null && date2 != null) {
            long diff = Math.abs(date2.getTime() - date1.getTime());
            long diffDays = diff / (24 * 60 * 60 * 1000);
            daysLabel.setText("Días entre fechas: " + diffDays);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DateSelectionExample().setVisible(true);
            }
        });
    }
}