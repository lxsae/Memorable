
package memoGame;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;


/**
 *
 * @author 
 */

public class ComoseJuega extends JFrame {
    
    private int anchoV = 700;
    private int largoV = 500;
 


    private String rutaAbsoluta;
    private int numVentana = 1;
    private JTextPane txtTexto;
    private double t = 0;
    
    private JLabel lblTexto;
    private JLabel lblFondo;
    private JLabel lblFlecha;
    private JLabel txtNumeroVentana;
    private JLabel lblImagen;

    private JButton btnSalir;
    private JButton btnSiguiente;
    private JButton btnAtras;
    
    private ImageIcon imgFondo;
    private ImageIcon iconoFlecha;
    private ImageIcon iconoSalir;
    private ImageIcon imgEjemplo;
    private ImageIcon iconoSiguiente;
    private ImageIcon iconoAtras;
 
    private Container contPrincipal;


    public ComoseJuega() throws IOException {
        iniciarVentana();
        iniciarComponentes();
    }

    private void iniciarVentana() {
        setSize(anchoV, largoV);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Memorabble");
        setResizable(false);
    }

    private void iniciarComponentes() throws IOException {


        rutaAbsoluta = new File("").getAbsolutePath();
        
        imgFondo = establecerIcon("/src/imagenes/fondoComoJugar.png", anchoV,largoV);
        imgEjemplo = establecerIcon("/src/imagenes/comoJugar1.png", 350, 270);
        iconoSiguiente = establecerIcon("/src/imagenes/siguiente.png", 130, 40);
        iconoAtras = establecerIcon("/src/imagenes/atras.png", 130, 40);
        iconoSalir = establecerIcon("/src/imagenes/salir.png", 70, 70);
        iconoFlecha = establecerIcon("/src/imagenes/flecha.png", 70, 70);
        
        //Lamamos Objects
        creaLbls();
        NumVentana();
        Muestra();
        Botnsiguiente();
        Botnatras();
        indicador();
        Botnsalir();
        textoGui();
        ContPrincipal();

        
    }

    private void creaLbls(){     
        lblFondo = new JLabel(imgFondo);
        lblFondo.setBounds(0, 0, anchoV, largoV);
        lblFondo.setLayout(null);

    }
    
    private void NumVentana(){
        txtNumeroVentana = new JLabel("1/4");
        txtNumeroVentana.setFont(new Font("cooper black", 2, 24));
        txtNumeroVentana.setForeground(Color.white);
        txtNumeroVentana.setBounds(35, 20, 50, 30);
        lblFondo.add(txtNumeroVentana);

    }
    
    private void Muestra(){
        lblImagen = new JLabel(imgEjemplo);
        lblImagen.setBounds(175, 20, 350, 270);
        lblFondo.add(lblImagen);
    
    }
    
    private void Botnsiguiente(){
        btnSiguiente = new BotonSinFondo();
        btnSiguiente.setIcon(iconoSiguiente);
        btnSiguiente.setBounds(536, 140, 130, 40);  
        btnSiguiente.addMouseListener(new ManejadorDeEventos());
        btnSiguiente.addKeyListener(new ManejadoraEventosTeclado());
        lblFondo.add(btnSiguiente);
    }
    
    private void Botnatras(){
        btnAtras = new BotonSinFondo();
        btnAtras.setIcon(iconoAtras);
        btnAtras.setBounds(20, 140, 130, 40);
        btnAtras.setVisible(false);  
        
        btnAtras.addMouseListener(new ManejadorDeEventos());
        btnAtras.addKeyListener(new ManejadoraEventosTeclado());
        lblFondo.add(btnAtras);
    }
    
    private void Botnsalir(){
        btnSalir = new BotonSinFondo();
        btnSalir.setIcon(iconoSalir);
        btnSalir.setBounds(600, 20, 70, 70);
        
        btnSalir.addMouseListener(new ManejadorDeEventos());
        btnSalir.addKeyListener(new ManejadoraEventosTeclado());
        btnSalir.requestFocus();
        lblFondo.add(btnSalir);
    
    }
    
    private void indicador(){
        lblFlecha = new JLabel(iconoFlecha);
        lblFlecha.setBounds(509, 200, 70, 70);
        lblFlecha.setVisible(false);
        lblFondo.add(lblFlecha);
       

    }
    
    private void textoGui(){
        lblTexto = new JLabel("<html>En memorable aparecera una serie de distintos colores sobre una fichas. \n Al cabo de unos segundos, las figuras desapareceran y tendras que responder unas preguntas.<html>");
        lblTexto.setBounds(10,220,670,300);
        lblTexto.setForeground(Color.white);
        lblTexto.setFont(new Font("cooper black",1,25));
        lblFondo.add(lblTexto);
           
    }
    
    private void ContPrincipal(){
        contPrincipal = getContentPane();
        contPrincipal.setLayout(null);
        contPrincipal.add(lblFondo);
        
    }

    private ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            throws IOException {
        BufferedImage bufferedImagen = ImageIO.read(new File(rutaAbsoluta.concat(rutaArchivo)));
        Image imagen = bufferedImagen.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        return new ImageIcon(imagen);
    }

    private class ManejadorDeEventos extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == btnSiguiente) {
                switch (numVentana) {
                    case 1 ->
                        iniciarVentana2();
                    case 2 ->
                        iniciarVentana3();
                    case 3 ->
                        iniciarVentana4();
                    default -> {
                    }
                }
            } else if (e.getSource() == btnSalir) {
                dispose();

                try {
                    menuinicio ventanaInicial = new menuinicio();
                } catch (IOException ex) {
                    Logger.getLogger(ComoseJuega.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == btnAtras) {
                switch (numVentana) {
                    case 2 ->
                        iniciarVentana1();
                    case 3 ->
                        iniciarVentana2();
                    case 4 ->
                        iniciarVentana3();
                    default -> {
                    }
                }
            }
        }

    }

    private class ManejadoraEventosTeclado implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getSource() == btnSalir || e.getSource() == btnAtras || e.getSource() == btnSiguiente) {
                switch (e.getKeyCode()) {
                    case 39 -> {
                        switch (numVentana) {
                            case 1 -> {
                                iniciarVentana2();
                            }
                            case 2 -> {
                                iniciarVentana3();
                            }
                            case 3 -> {
                                iniciarVentana4();
                            }

                            default -> {
                            }
                        }
                    }
                    case 10, 32 -> {
                        dispose();

                    try {
                        //     reproducirSonido(0);
                        menuinicio ventanaInicial = new menuinicio();
                    } catch (IOException ex) {
                        Logger.getLogger(ComoseJuega.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }

                    case 37 -> {
                        switch (numVentana) {
                            case 2 -> {
                                iniciarVentana1();
                            }
                            case 3 -> {
                                iniciarVentana2();
                            }
                            case 4 -> {
                                iniciarVentana3();
                            }

                            default -> {
                            }
                        }
                    }
                    default -> {
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }


    private void iniciarVentana1() {
        numVentana = 1;
        txtNumeroVentana.setText("1/4");
        txtNumeroVentana.setForeground(Color.white);

        t = 0;


        try {
            imgEjemplo = establecerIcon("/src/imagenes/comoJugar1.png", 350, 270);
            lblImagen.setIcon(imgEjemplo);
            lblFondo.add(lblImagen);
        } catch (IOException e) {
            System.out.println("No se encontro la imagen de fondo en Como Jugar");
        }

        lblFlecha.setVisible(false);
        btnAtras.setVisible(false);
        txtTexto.setText("<html>En memorable aparecera una serie de distintos colores sobre una fichas. \n Al cabo de unos segundos, las figuras desapareceran y tendras que responder unas preguntas..<html>");

    }

    private void iniciarVentana2() {
        numVentana = 2;
        txtNumeroVentana.setText("2/4");
        txtNumeroVentana.setForeground(Color.white);
        t = 0;
    

        try {
            imgEjemplo = establecerIcon("/src/imagenes/comoJugar2.png", 350, 270);
            lblImagen.setIcon(imgEjemplo);
            lblFondo.add(lblImagen);
        } catch (IOException e) {
            System.out.println("No se encontro la imagen de fondo en Como Jugar");
        }

        lblFlecha.setVisible(true);
        btnAtras.setVisible(true);
        lblTexto.setText("<html>La pregunta apareceran en la parte inferior cuando las figuras hayan desaparecido . Debes pulsar sobre la ficha que cumpla la condidcion expresada en la pregunta.<html>");
                         
    }

    private void iniciarVentana3() {
        numVentana = 3;
        txtNumeroVentana.setText("3/4");
        txtNumeroVentana.setForeground(Color.white);
        t = 0;
  

        try {
            imgEjemplo = establecerIcon("/src/imagenes/comoJugar3.png", 350, 270);
            lblImagen.setIcon(imgEjemplo);
            lblFondo.add(lblImagen);
        } catch (IOException e) {
            System.out.println("No se encontro la imagen de fondo en Como Jugar");
        }

        btnSiguiente.setVisible(true);
        lblFlecha.setVisible(false);
        lblTexto.setText("<html>¡¡OJO!! Es posible que haya que pulsar mas de una ficha.<html>");

    }

    private void iniciarVentana4() {
        numVentana = 4;
        txtNumeroVentana.setText("4/4");
        txtNumeroVentana.setForeground(Color.white);

        t = 0;
 

        try {
            imgEjemplo = establecerIcon("/src/imagenes/comoJugar4.png", 350, 270);
            lblImagen.setIcon(imgEjemplo);
            lblFondo.add(lblImagen);
        } catch (IOException e) {
            System.out.println("No se encontro la imagen de fondo en Como Jugar");
        }

        lblFlecha.setVisible(true);
        lblFlecha.setBounds(509, 20, 70, 70);
        lblFondo.add(lblFlecha);
        lblFondo.add(lblImagen);

        btnSiguiente.setVisible(false);

        lblTexto.setText("<html>Es importante que memrices formas, colores y posicion de cada ficha.<html>");

    }

    //Clase de boton sin fondo ni bordes
    private class BotonSinFondo extends JButton {

        public BotonSinFondo() {
            inicializar();
        }

        private void inicializar() {
            setRolloverEnabled(true);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
        }
    }

}
