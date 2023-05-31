/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graficosgh;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aleja
 */
public class AccionesGraficas2 {

    public static synchronized void pintarPlanoCartesiano(Graphics g) {
        //eje de la y
        g.setColor(Color.red);
        g.drawLine(250, 500, 250, 0);
        // letra Y

        // YYYY flecha abajo
        g.drawLine(250, 500, 260, 490);
        g.drawLine(250, 500, 240, 490);
        // YYYY flecha arriba
        g.drawLine(250, 0, 260, 10);
        g.drawLine(250, 0, 240, 10);
        //eje de la x
        g.setColor(Color.blue);
        g.drawLine(0, 250, 500, 250);
        // XXXX flecha derecha
        g.drawLine(500, 250, 490, 260);
        g.drawLine(500, 250, 490, 240);
        // XXXX flecha izquierda
        g.drawLine(0, 250, 10, 260);
        g.drawLine(0, 250, 10, 240);
    }

    public static void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        x1 = x1 + 250;
        y1 = 250 - y1;
        x2 = x2 + 250;
        y2 = 250 - y2;

        //diferenciaX y diferenciaY
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        //signo de la direccion Si x2 > x1, sx será igual a 1 y la línea se 
        //dicuja hacia la derecha. Si x2 < x1, sx será igual a -1 y la línea se dibuja hacia la izquierda.
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        //variable de desicion, para saber a donde moverse 
        int err = dx - dy;

        int contador = 0;
        while (true) {
            if (contador % 2 == 0) {
                g.drawLine(x1, y1, x1, y1);
            }
            contador++;

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public static void drawCircle(Graphics g, int xcentro, int ycentro, int radio) {
        int xCenter = 250 + xcentro;
        int yCenter = 250 - ycentro;

        int x = radio;
        int y = 0;

        int p = 1 - radio;

        while (x >= y) {
            // Dibujar los puntos del círculo en los cuatro cuadrantes
            g.drawLine(xCenter + x, yCenter + y, xCenter + x, yCenter + y);
            g.drawLine(xCenter - x, yCenter + y, xCenter - x, yCenter + y);
            g.drawLine(xCenter + x, yCenter - y, xCenter + x, yCenter - y);
            g.drawLine(xCenter - x, yCenter - y, xCenter - x, yCenter - y);

            g.drawLine(xCenter + y, yCenter + x, xCenter + y, yCenter + x);
            g.drawLine(xCenter - y, yCenter + x, xCenter - y, yCenter + x);
            g.drawLine(xCenter + y, yCenter - x, xCenter + y, yCenter - x);
            g.drawLine(xCenter - y, yCenter - x, xCenter - y, yCenter - x);

            y++;

            // Decisiones de Bresenham
            if (p < 0) {
                p = p + 2 * y + 1;
            } else {
                x--;
                p = p + 2 * (y - x) + 1;
            }
        }
    }

    public static void drawRectangle(Graphics g, int x, int y, int width, int height) {
        int xCenter = x + width / 2;
        int yCenter = y + height / 2;

        drawLine(g, x, y, x + width, y); // Borde superior
        drawLine(g, x + width, y, x + width, y + height); // Borde derecho
        drawLine(g, x + width, y + height, x, y + height); // Borde inferior
        drawLine(g, x, y + height, x, y); // Borde izquierdo

        // Guardar el centro 
    }

    public static void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        int xCenter = (x1 + x2 + x3) / 3;
        int yCenter = (y1 + y2 + y3) / 3;

        // Dibujar las líneas del triángulo
        drawLine(g, x1, y1, x2, y2);
        drawLine(g, x2, y2, x3, y3);
        drawLine(g, x3, y3, x1, y1);

        // Guardar el centro  
    }

    public static void drawEllipse(Graphics g, int x, int y, int width, int height) {

        int xCenter = (250) + (x + width / 2);
        int yCenter = (250) - (y + height / 2);

        int a = width / 2;
        int b = height / 2;

        int xSq = a * a;
        int ySq = b * b;

        int x0 = 0;
        int y0 = b;
        int p = 2 * ySq - 2 * b * xSq + xSq;

        drawEllipsePoints(g, xCenter, yCenter, x0, y0);

        while (xSq * (y0 - 0.5) > ySq * (x0 + 1)) {
            if (p < 0) {
                x0++;
                p += 2 * ySq * x0 + ySq;
            } else {
                x0++;
                y0--;
                p += 2 * ySq * x0 - 2 * xSq * y0 + ySq;
            }

            drawEllipsePoints(g, xCenter, yCenter, x0, y0);
        }

        p = (int) (ySq * (x0 + 0.5) * (x0 + 0.5) + xSq * (y0 - 1) * (y0 - 1) - xSq * ySq);

        while (y0 > 0) {
            if (p < 0) {
                y0--;
                x0++;
                p += 2 * ySq * x0 - 2 * xSq * y0 + xSq;
            } else {
                y0--;
                p -= 2 * xSq * y0 + xSq;
            }

            drawEllipsePoints(g, xCenter, yCenter, x0, y0);
        }
    }

    private static void drawEllipsePoints(Graphics g, int xCenter, int yCenter, int x, int y) {
        g.drawLine(xCenter + x, yCenter + y, xCenter + x, yCenter + y);
        g.drawLine(xCenter - x, yCenter + y, xCenter - x, yCenter + y);
        g.drawLine(xCenter + x, yCenter - y, xCenter + x, yCenter - y);
        g.drawLine(xCenter - x, yCenter - y, xCenter - x, yCenter - y);
    }

    public static void drawRotatedLine(Graphics g, int x1, int y1, int x2, int y2, double angle) {
        // Convertir a coordenadas polares    
        double x = x2 - x1;
        double y = y2 - y1;
        double radian = Math.toRadians(angle);
        double cosa = Math.cos(radian);
        double sina = Math.sin(radian);
        // Rotar usando transformada afín    
        int rx1 = (int) (x1 + x * cosa - y * sina);
        int ry1 = (int) (y1 + x * sina + y * cosa);
        int rx2 = (int) (x2 + x * cosa - y * sina);
        int ry2 = (int) (y2 + x * sina + y * cosa);
        // Trazar la línea rotada    
        

        x1 = rx1;
        y1 = ry1;
        x2 = rx2;
        y2 = ry2;
        
        drawLine(g, rx1, ry1, rx2, ry2);
    }
}
