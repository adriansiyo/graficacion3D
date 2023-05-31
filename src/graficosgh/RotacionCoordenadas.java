/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficosgh;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class RotacionCoordenadas {
    private static double x = 3; // Coordenada x original
    private static double y = 4; // Coordenada y original
    private static double angulo = 0; // Ángulo de rotación inicial (en radianes)
    private static JLabel coordenadasLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotación de Coordenadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un JSlider para controlar el ángulo de rotación
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        slider.setMajorTickSpacing(90);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                angulo = Math.toRadians(source.getValue());
                updateRotatedCoordinates();
            }
        });
        
        // Crear un JLabel para mostrar las coordenadas rotadas
        coordenadasLabel = new JLabel();
        
        // Crear un JPanel para agregar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(slider);
        panel.add(coordenadasLabel);
        
        // Agregar el panel al frame
        frame.getContentPane().add(panel);
        
        // Configurar el tamaño del frame y hacerlo visible
        frame.setSize(300, 150);
        frame.setVisible(true);
        
        // Actualizar las coordenadas rotadas inicialmente
        updateRotatedCoordinates();
    }

    private static void updateRotatedCoordinates() {
        // Aplicar la rotación
        double xRotado = x * Math.cos(angulo) + y * Math.sin(angulo);
        double yRotado = -x * Math.sin(angulo) + y * Math.cos(angulo);
        
        // Actualizar el texto del JLabel con las coordenadas rotadas
        coordenadasLabel.setText("Coordenadas rotadas: (" + xRotado + ", " + yRotado + ")");
    }
}
