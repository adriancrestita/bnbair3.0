/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

/**
 *
 * @author hugos
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveJFrameAsPDF {

    public static void main(String[] args) {
        // Crear un JFrame para la demostración
        JFrame frame = new JFrame("Factura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JLabel label = new JLabel("Esta es una factura de ejemplo");
        frame.getContentPane().add(label);

        frame.setVisible(true);

        // Guardar el JFrame como PDF en la ruta especificada
        try {
            saveFrameAsPDF(frame, "src/main/java/Pruebas/factura.pdf");
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void saveFrameAsPDF(JFrame frame, String filePath) throws IOException, DocumentException {
        // Crear una imagen del JFrame
        BufferedImage bufferedImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        frame.paint(g2d);
        g2d.dispose();

        // Asegurarse de que el directorio existe
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        // Crear un documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Convertir la imagen en un objeto Image de iText
        Image image = Image.getInstance(bufferedImage, null);
        document.add(image);

        // Cerrar el documento
        document.close();
    }
}
