/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graficosgh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;


public class GraficosGH extends JFrame {

    private JPanel lienzo2;
    private JButton btnPintarLinea;
    private JButton btnPintarCuadrado;
    private JButton btnPintarCirculo;
    private JButton btnPintarTriangulo;
    private JButton btnPintarElipse;
    private JButton btnLimpiar;
    private boolean limpiarActivo = false;
    private JLabel labelX;
    private JLabel labelY;
         private JLabel labelro;
    private JSpinner spinnerMovimientoHorizontal;
    private JSpinner spinnerMovimientoVertical;
    private JSpinner spinnerRotacion;

    int x1, y1, x2, y2, x3, y3, radio, ejemayor, ejemenor, alto1, ancho1;
    String figuraActual = "";
    int valorspinnerx = 0;
    int valorspinnery = 0;
    int x1Original, y1Original, x2Original, y2Original, x3Original, y3Original, radioOriginal, ejemayorOriginal, ejemenorOriginal;

    public GraficosGH() {
        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aqui se agregan los componentes
        this.add(getLienzo());
        this.add(getBtnPintarLinea());
        this.add(getBtnPintarCuadrado());
        this.add(getBtnPintarCirculo());
        this.add(getBtnPintarTriangulo());
        this.add(getBtnPintarElipse());
        this.add(getBtnLimpiar());
        this.add(getlabelX());
        this.add(getlabelY());
        this.add(getSpinnerMovimientoHorizontal());
        this.add(getSpinnerMovimientoVertical());
        this.add(getspinnerRotacion());
        this.setVisible(true);

    }

    public JButton getBtnPintarLinea() {
        if (btnPintarLinea == null) {
            btnPintarLinea = new JButton("Pintar Linea");
        }

        btnPintarLinea.setBounds(25, 50, 200, 50);
        btnPintarLinea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String valor1x = JOptionPane.showInputDialog("Coordenada 1 ingrese X:");
                String valor1y = JOptionPane.showInputDialog("Coordenada 1 ingrese Y:");
                String valor2x = JOptionPane.showInputDialog("Coordenada 2 ingrese X:");
                String valor2y = JOptionPane.showInputDialog("Coordenada 2 ingrese Y:");
                x1Original = Integer.parseInt(valor1x);
                y1Original = Integer.parseInt(valor1y);
                x2Original = Integer.parseInt(valor2x);
                y2Original = Integer.parseInt(valor2y);
                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original);
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + x2Original + " y2=" + y2Original);
                figuraActual = "linea";
            }
        });
        return btnPintarLinea;
    }

    public JButton getBtnPintarCuadrado() {
        if (btnPintarCuadrado == null) {
            btnPintarCuadrado = new JButton("Pintar Cuadrado/Rectangulo");
        }
        btnPintarCuadrado.setBounds(25, 250, 200, 50);
        btnPintarCuadrado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String ancho = JOptionPane.showInputDialog("Ancho:");
                String alto = JOptionPane.showInputDialog("Alto:");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                alto1 = Integer.parseInt(ancho);
                ancho1 = Integer.parseInt(alto);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas2.drawRectangle(getLienzo().getGraphics(), x1Original, y1Original, alto1, ancho1);
                figuraActual = "cuadrado";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + x2Original + " y2=" + y2Original);
            }
        });

        return btnPintarCuadrado;
    }

    public JButton getBtnPintarCirculo() {
        if (btnPintarCirculo == null) {
            btnPintarCirculo = new JButton("Pintar circulo");
        }
        btnPintarCirculo.setBounds(25, 100, 200, 50);
        btnPintarCirculo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String radio1 = JOptionPane.showInputDialog("radio del Circulo:");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                radioOriginal = Integer.parseInt(radio1);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas2.drawCircle(getLienzo().getGraphics(), x1Original, y1Original, radioOriginal);
                figuraActual = "circulo";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " radio=" + radioOriginal);
            }
        });
        return btnPintarCirculo;
    }

    public JButton getBtnPintarTriangulo() {
        if (btnPintarTriangulo == null) {
            btnPintarTriangulo = new JButton("Pintar triangulo");
        }
        btnPintarTriangulo.setBounds(25, 150, 200, 50);
        btnPintarTriangulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx1 = JOptionPane.showInputDialog("Coordenada 1 ingrese X1:");
                String valory1 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y1:");
                String valorx2 = JOptionPane.showInputDialog("Coordenada 1 ingrese X2:");
                String valory2 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y2:");
                String valorx3 = JOptionPane.showInputDialog("Coordenada 1 ingrese X3:");
                String valory3 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y3:");

                x1Original = Integer.parseInt(valorx1);
                y1Original = Integer.parseInt(valory1);
                x2Original = Integer.parseInt(valorx2);
                y2Original = Integer.parseInt(valory2);
                x3Original = Integer.parseInt(valorx3);
                y3Original = Integer.parseInt(valory3);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas2.drawTriangle(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, x3Original, y3Original);
                figuraActual = "triangulo";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + x2Original + " y2=" + y2Original + " x3=" + x3Original + " y3=" + y3Original);

            }
        });
        return btnPintarTriangulo;
    }

    public JButton getBtnPintarElipse() {
        if (btnPintarElipse == null) {
            btnPintarElipse = new JButton("Pintar Elipse");
        }
        btnPintarElipse.setBounds(25, 200, 200, 50);
        btnPintarElipse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String valora = JOptionPane.showInputDialog("Tamaño semieje mayor");
                String valorb = JOptionPane.showInputDialog("Tamaño semieje menor");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                ejemayorOriginal = Integer.parseInt(valora);
                ejemenorOriginal = Integer.parseInt(valorb);

                limpiarActivo = true;
                actualizarEstadoBotones();

                //AccionesGraficas.pintarElipse(getLienzo().getGraphics(), Integer.parseInt(valorx), Integer.parseInt(valory), Integer.parseInt(valora), Integer.parseInt(valorb));
                AccionesGraficas2.drawEllipse(getLienzo().getGraphics(), x1Original, y1Original, ejemayorOriginal, ejemenorOriginal);
                figuraActual = "elipse";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + ejemayorOriginal + " y2=" + ejemenorOriginal);
            }
        });
        return btnPintarElipse;
    }

    public JButton getBtnLimpiar() {
        if (btnLimpiar == null) {
            btnLimpiar = new JButton("Limpiar");
        }
        btnLimpiar.setBounds(25, 300, 200, 50);
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas2.pintarPlanoCartesiano(g);
                limpiarActivo = false;
                actualizarEstadoBotones();
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                x3 = 0;
                y3 = 0;
                radio = 0;
                x1Original = 0;
                y1Original = 0;
                x2Original = 0;
                y2Original = 0;
                x3Original = 0;
                y3Original = 0;
                radioOriginal = 0;
                figuraActual = "";
            }
        });
        return btnLimpiar;
    }

    public JPanel getLienzo() {
        if (lienzo2 == null) {
            lienzo2 = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    AccionesGraficas2.pintarPlanoCartesiano(g);
                }
            };
            //configuracion del lienzo
            lienzo2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    System.out.println(e.getX() + " - " + e.getY());
                }
            });
            lienzo2.setBounds(250, 25, 500, 500);
            lienzo2.setBackground(Color.LIGHT_GRAY);
        }
        return lienzo2;
    }

    public JLabel getlabelX() {
        if (labelX == null) {
            labelX = new JLabel();
        }
        labelX.setText("Movimiento en X");
        labelX.setBounds(75, 340, 200, 50);
        return labelX;
    }

    public JSpinner getSpinnerMovimientoHorizontal() {
        if (spinnerMovimientoHorizontal == null) {
            spinnerMovimientoHorizontal = new JSpinner();
            spinnerMovimientoHorizontal.setBounds(25, 375, 200, 30);
            spinnerMovimientoHorizontal.setValue(valorspinnerx);
            spinnerMovimientoHorizontal.addChangeListener(e -> {
                int movimiento = (int) spinnerMovimientoHorizontal.getValue();
                if (movimiento > valorspinnerx) {
                    // Mover hacia la derecha sumando el valor de "movimiento" a las coordenadas X globales
                    x1 = x1Original + 1;
                    x2 = x2Original + 1;
                    x3 = x3Original + 1;
                    valorspinnerx = valorspinnerx + 1;
                } else if (movimiento < valorspinnerx) {
                    // Mover hacia la izquierda restando el valor absoluto de "movimiento" a las coordenadas X globales
                    x1 = x1Original - 1;
                    x2 = x2Original - 1;
                    x3 = x3Original - 1;
                    valorspinnerx = valorspinnerx - 1;
                }

                System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2 + " x3=" + x3 + " y3=" + y3);

                // Actualizar los valores originales
                x1Original = x1;
                x2Original = x2;
                x3Original = x3;

                //borrar lo anterior
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas2.pintarPlanoCartesiano(g);

                //verificar cual esta activo para proceder a dibujar
                if (figuraActual == "linea") {
                    AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1, y1Original, x2, y2Original);
                }
                if (figuraActual == "triangulo") {
                    AccionesGraficas2.drawTriangle(getLienzo().getGraphics(), x1, y1Original, x2, y2Original, x3, y3Original);
                }
                if (figuraActual == "cuadrado") {
                    AccionesGraficas2.drawRectangle(getLienzo().getGraphics(), x1, y1Original, alto1, ancho1);
                }
                if (figuraActual == "circulo") {
                    AccionesGraficas2.drawCircle(getLienzo().getGraphics(), x1, y1Original, radioOriginal);
                }
                if (figuraActual == "elipse") {
                    AccionesGraficas2.drawEllipse(getLienzo().getGraphics(), x1, y1Original, ejemayorOriginal, ejemenorOriginal);
                }

                // Dibujar la línea actualizada en la nueva posición
                //AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1, y1Original, x2, y2Original);
            });
        }
        return spinnerMovimientoHorizontal;
    }

    public JLabel getlabelY() {
        if (labelY == null) {
            labelY = new JLabel();
        }
        labelY.setText("Movimiento en Y");
        labelY.setBounds(75, 400, 200, 50);
        return labelY;
    }

    public JSpinner getSpinnerMovimientoVertical() {
        if (spinnerMovimientoVertical == null) {
            spinnerMovimientoVertical = new JSpinner();
            spinnerMovimientoVertical.setBounds(25, 435, 200, 30);
            spinnerMovimientoVertical.setValue(valorspinnery);
            spinnerMovimientoVertical.addChangeListener(e -> {
                int movimiento = (int) spinnerMovimientoVertical.getValue();
                if (movimiento > valorspinnery) {
                    // Mover hacia la derecha sumando el valor de "movimiento" a las coordenadas Y globales
                    y1 = y1Original + 1;
                    y2 = y2Original + 1;
                    y3 = y3Original + 1;
                    valorspinnery = valorspinnery + 1;
                } else if (movimiento < valorspinnery) {
                    // Mover hacia la izquierda restando el valor absoluto de "movimiento" a las coordenadas Y globales
                    y1 = y1Original - 1;
                    y2 = y2Original - 1;
                    y3 = y3Original - 1;
                    valorspinnery = valorspinnery - 1;
                }

                System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2 + " x3=" + x3 + " y3=" + y3);

                // Actualizar los valores originales
                y1Original = y1;
                y2Original = y2;
                y3Original = y3;

                //borrar lo anterior
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas2.pintarPlanoCartesiano(g);
                    
                //verificar cual esta activo para proceder a dibujar
                if (figuraActual == "linea") {
                    AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1Original, y1, x2Original, y2);
                }
                if (figuraActual == "triangulo") {
                    AccionesGraficas2.drawTriangle(getLienzo().getGraphics(), x1Original, y1, x2Original, y2, x3Original, y3);
                }
                if (figuraActual == "cuadrado") {
                    AccionesGraficas2.drawRectangle(getLienzo().getGraphics(), x1Original, y1, alto1, ancho1);
                }
                if (figuraActual == "circulo") {
                    AccionesGraficas2.drawCircle(getLienzo().getGraphics(), x1Original, y1, radioOriginal);
                }
                if (figuraActual == "elipse") {
                    AccionesGraficas2.drawEllipse(getLienzo().getGraphics(), x1Original, y1, ejemayorOriginal, ejemenorOriginal);
                }

                // Dibujar la línea actualizada en la nueva posición
                //AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1, y1Original, x2, y2Original);
            });
        }
        return spinnerMovimientoVertical;
    }

    public JSpinner getspinnerRotacion() {
    if (spinnerRotacion == null) {
        spinnerRotacion = new JSpinner();
        spinnerRotacion.setBounds(25, 485, 200, 30);
        spinnerRotacion.setValue(0);
        spinnerRotacion.addChangeListener(e -> {
            int value = (int) spinnerRotacion.getValue();
            double angle = Math.toRadians(value);

              // Actualizar los valores originales
                x1Original = x1;
                x2Original = x2;
                x3Original = x3;
            
            Graphics2D g2d = (Graphics2D) getLienzo().getGraphics();
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
            AccionesGraficas2.
                    pintarPlanoCartesiano(g2d);

            AffineTransform transform = new AffineTransform();

            Shape figura;

            if (figuraActual.equals("linea")) {
                figura = new Line2D.Double(x1Original, y1Original, x2Original, y2Original);
            } else if (figuraActual.equals("triangulo")) {
                figura = new Polygon(
                        new int[]{(int) x1Original, (int) x2Original, (int) x3Original},
                        new int[]{(int) y1Original, (int) y2Original, (int) y3Original},
                        3
                );
            } else if (figuraActual.equals("cuadrado")) {
                figura = new Rectangle2D.Double(x1Original, y1Original, ancho1, alto1);
            } else if (figuraActual.equals("circulo")) {
                figura = new Ellipse2D.Double(x1Original, y1Original, radioOriginal * 2, radioOriginal * 2);
            } else if (figuraActual.equals("elipse")) {
                figura = new Ellipse2D.Double(x1, y1Original, ejemayorOriginal, ejemenorOriginal);
            } else {
                figura = null;
            }

            if (figura != null) {
                // Obtener el centro del panel
                double centroPanelX = getLienzo().getWidth() / 2.0;
                double centroPanelY = getLienzo().getHeight() / 2.0;

                // Obtener el centro de la figura
                Rectangle2D bounds = figura.getBounds2D();
                double centroFiguraX = bounds.getCenterX();
                double centroFiguraY = bounds.getCenterY();

                // Trasladar al centro del panel
                transform.translate(centroPanelX, centroPanelY);

                // Rotar la figura alrededor del centro del panel
                transform.rotate(angle, centroFiguraX - centroPanelX, centroFiguraY - centroPanelY);

                // Regresar al origen del panel
                transform.translate(-centroPanelX, -centroPanelY);

                // Dibujar la figura rotada
                Shape figuraRotada = transform.createTransformedShape(figura);
                g2d.draw(figuraRotada);
            }

            g2d.dispose();
        });
    }
    return spinnerRotacion;
}




    public static void main(String[] args) {
        new GraficosGH();
    }

    private void actualizarEstadoBotones() {
        btnPintarLinea.setEnabled(!limpiarActivo);
        btnPintarCuadrado.setEnabled(!limpiarActivo);
        btnPintarCirculo.setEnabled(!limpiarActivo);
        btnPintarTriangulo.setEnabled(!limpiarActivo);
        btnPintarElipse.setEnabled(!limpiarActivo);
        spinnerMovimientoHorizontal.setValue(0);

    }

}
