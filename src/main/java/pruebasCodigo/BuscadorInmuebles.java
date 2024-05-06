/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasCodigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class BuscadorInmuebles extends JFrame {
    private List<String> inmuebles; // Lista de inmuebles disponibles
    private JPanel panel; // Panel principal para mostrar los inmuebles
    private int currentPage; // Página actual de resultados
    private JTextField searchBar; // Campo de búsqueda de inmuebles

    public BuscadorInmuebles() {
        // Inicialización de la lista de inmuebles y la página actual
        this.inmuebles = Arrays.asList("Nueva York", "Londres", "París", "Tokio", "Roma", "Sídney", "Dubái", "Berlín", "Moscú", "Los Ángeles", "Barcelona", "Hong Kong", "Toronto", "San Francisco", "Singapur", "Venecia", "Río de Janeiro", "Bombay", "Florencia", "Ámsterdam", "Viena", "Praga", "Seúl", "Buenos Aires", "Ciudad de México", "Vancouver", "Madrid", "Bangkok", "Ciudad del Cabo", "Atenas");
        this.currentPage = 0;

        // Configuración de la ventana principal
        setTitle("Buscador de Inmuebles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de búsqueda de inmuebles
        searchBar = new JTextField();
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInmuebles(searchBar.getText());
            }
        });

        // Botones de navegación entre páginas
        JButton nextPageButton = new JButton("Página Siguiente");
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        JButton previousPageButton = new JButton("Página Anterior");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousPage();
            }
        });

        // Panel principal para mostrar los inmuebles
        panel = new JPanel(new GridLayout(1, 1));

        // Agregar componentes a la ventana principal
        add(searchBar, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(previousPageButton);
        buttonPanel.add(nextPageButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar los inmuebles al iniciar la ventana
        loadInmuebles();
    }

    // Método para cargar los inmuebles en la página actual
    private void loadInmuebles() {
        panel.removeAll();

        int startIndex = currentPage * 9; // Índice de inicio en la lista de inmuebles
        int endIndex = Math.min(startIndex + 9, inmuebles.size()); // Índice de fin en la lista de inmuebles

        // Panel para mostrar los inmuebles en una cuadrícula 3x3
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));

        // Agregar etiquetas con los nombres de los inmuebles al panel
        for (int i = startIndex; i < endIndex; i++) {
            JLabel label = new JLabel(inmuebles.get(i));
            label.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
            gridPanel.add(label);
        }

        // Agregar el panel de cuadrícula al panel principal
        panel.add(gridPanel);

        // Actualizar la ventana
        revalidate();
        repaint();
    }

    // Método para ir a la siguiente página de resultados
    private void nextPage() {
        int startIndex = (currentPage + 1) * 9;
        if (startIndex >= inmuebles.size()) {
            // Mostrar ventana emergente si no hay más páginas disponibles
            JOptionPane.showMessageDialog(this, "No hay más páginas disponibles.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            currentPage++;
            loadInmuebles(); // Cargar la siguiente página de resultados
        }
    }

    // Método para ir a la página anterior de resultados
    private void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            loadInmuebles(); // Cargar la página anterior de resultados
        }
    }

    // Método para buscar inmuebles por nombre
    private void searchInmuebles(String searchText) {
        panel.removeAll();

        if (searchText.isEmpty()) {
            // Si la búsqueda está vacía, mostrar todos los inmuebles en una cuadrícula 3x3
            loadInmuebles();
            return;
        }

        boolean encontrado = false;

        // Buscar el inmueble por nombre
        for (String inmueble : inmuebles) {
            if (inmueble.equalsIgnoreCase(searchText)) {
                // Mostrar el inmueble encontrado en el centro del panel
                JLabel resultLabel = new JLabel(inmueble);
                resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
                resultLabel.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(resultLabel);
                encontrado = true;
                break; // Si se encuentra el inmueble, no es necesario continuar buscando
            }
        }

        // Si no se encuentra ningún inmueble, mostrar un mensaje
        if (!encontrado) {
            JLabel noResultsLabel = new JLabel("No se encontraron resultados para: " + searchText);
            noResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noResultsLabel.setVerticalAlignment(SwingConstants.CENTER);
            panel.add(noResultsLabel);
        }

        // Actualizar la ventana
        revalidate();
        repaint();
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscadorInmuebles().setVisible(true); // Crear y mostrar la ventana principal
            }
        });
    }
}