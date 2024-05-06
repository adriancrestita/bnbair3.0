/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasCodigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuscadorInmuebles extends JFrame {
    private List<String> inmuebles;
    private List<JLabel> labels;
    private JPanel panel;
    private int currentPage;
    private JTextField searchBar;

    public BuscadorInmuebles() {
        this.inmuebles = Arrays.asList("New York", "London", "Paris", "Tokyo", "Rome", "Sydney", "Dubai", "Berlin", "Moscow", "Los Angeles", "Barcelona", "Hong Kong", "Toronto", "San Francisco", "Singapore", "Venice", "Rio de Janeiro", "Mumbai", "Florence", "Amsterdam", "Vienna", "Prague", "Seoul", "Buenos Aires", "Mexico City", "Vancouver", "Madrid", "Bangkok", "Cape Town", "Athens");
        this.labels = new ArrayList<>();
        this.currentPage = 0;

        setTitle("Buscador de Inmuebles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        searchBar = new JTextField();
        searchBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchInmuebles(searchBar.getText());
            }
        });

        JButton nextPageButton = new JButton("Next Page");
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage();
            }
        });

        JButton previousPageButton = new JButton("Previous Page");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousPage();
            }
        });

        panel = new JPanel(new GridLayout(3, 3));

        add(searchBar, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(previousPageButton);
        buttonPanel.add(nextPageButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadInmuebles();
    }

    private void loadInmuebles() {
        panel.removeAll();
        labels.clear();

        int startIndex = currentPage * 9;
        int endIndex = Math.min(startIndex + 9, inmuebles.size());

        for (int i = startIndex; i < endIndex; i++) {
            JLabel label = new JLabel(inmuebles.get(i));
            labels.add(label);
            panel.add(label);
        }

        // Restablecer el diseño de la cuadrícula a 3x3
        panel.setLayout(new GridLayout(3, 3));

        revalidate();
        repaint();
    }

    private void nextPage() {
        currentPage++;
        loadInmuebles();
    }

    private void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            loadInmuebles();
        }
    }

    private void searchInmuebles(String searchText) {
        panel.removeAll();
        labels.clear();

        for (String inmueble : inmuebles) {
            if (inmueble.toLowerCase().contains(searchText.toLowerCase())) {
                JLabel label = new JLabel(inmueble);
                labels.add(label);
                panel.add(label);
            }
        }

        if (labels.isEmpty()) {
            JLabel noResultsLabel = new JLabel("No se encontraron resultados para: " + searchText);
            panel.add(noResultsLabel);
        }

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscadorInmuebles().setVisible(true);
            }
        });
    }
}
