/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

/**
 *
 * @author hugos
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SaveTxtOnButtonClick {

    public static void main(String[] args) {
        // Crear un JFrame para la demostración
        JFrame frame = new JFrame("Reserva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel();
        JButton buttonReservar = new JButton("Reservar");
        panel.add(buttonReservar);
        frame.getContentPane().add(panel);

        // Añadir ActionListener al botón
        buttonReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Generar y guardar el archivo .txt
                    saveReservationAsTxt("src/main/java/Facturas/factura.txt", "Detalle de la reserva: ...");
                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(frame, "La reserva se ha guardado como factura.txt");

                    // Ofrecer opción de descarga
                    offerTxtDownload("factura.txt", "Detalle de la reserva: ...");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error al guardar la reserva", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void saveReservationAsTxt(String filePath, String content) throws IOException {
        // Asegurarse de que el directorio existe
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        // Escribir contenido en el archivo .txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    public static void offerTxtDownload(String fileName, String content) throws IOException {
        // Crear un archivo temporal para descargar
        File tempFile = File.createTempFile(fileName, ".txt");
        
        // Escribir contenido en el archivo temporal
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(content);
        }

        // Mostrar diálogo para guardar el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(tempFile);
        fileChooser.setDialogTitle("Guardar archivo");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            tempFile.renameTo(fileToSave);
            JOptionPane.showMessageDialog(null, "Archivo guardado en: " + fileToSave.getAbsolutePath());
        }
    }
}
