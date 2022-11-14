
package memoGame;


import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author 
 */
public class ParaQSirve extends JFrame {

    private String rutaAbsoluta;
    private int anchoV;
    private int largoV;
    private JButton btnSalir;
    private JLabel lblFondo;
    private JLabel lblParaQueSirveTexto;
    private Container contPrincipal;
    

    public ParaQSirve() throws IOException {
        iniciarComponentes();
        iniciarVentana();
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
        anchoV = 700;
        largoV = 500;
        lblFondo = new JLabel(establecerIcon("/src/imagenes/fondoComoJugar.png", anchoV, largoV));

        //Llamamos los Objects
        btnSalir();
        lblParaQSirve();
        contePrinc();
     
    }
    
    private void btnSalir(){
        btnSalir = new JButton("Back");
        btnSalir.setBounds(590,5,70,20);
        btnSalir.setForeground(Color.black);
        btnSalir.setFont(new Font("arial",3,10));
        btnSalir.addActionListener(new ParaQSirve.ManejadorDeEventos());
        lblFondo.add(btnSalir);

    }
    private void lblParaQSirve(){
        lblParaQueSirveTexto = new JLabel("<html>Este juego pone en acción la habilidad para comparar patrones visuales, entrenando ademas la atención a los detalles y la velocidad perceptiva. Estas capacidades son relevantes cuando hay que decidir entre estimulos semejantes y hay que hacerlo de forma rápida, por ejemplo al reconocer fotografias, caras, objetos cotidianos o palabras escritas.<html>");
        lblParaQueSirveTexto.setBounds(10,100,670,300);
        lblParaQueSirveTexto.setForeground(Color.white);
        lblParaQueSirveTexto.setFont(new Font("cooper black",1,20));
        lblFondo.add(lblParaQueSirveTexto);
    }
    private void contePrinc(){
        contPrincipal = getContentPane();
        contPrincipal.setLayout(new GridLayout(1, 1));
        contPrincipal.add(lblFondo);}
    


    private ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            throws IOException {
        BufferedImage bufferedImagen = ImageIO.read(new File(rutaAbsoluta.concat(rutaArchivo)));
        Image imagen = bufferedImagen. getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        return new ImageIcon(imagen);
    }



        private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                  menuinicio Inicio = new menuinicio();
            } catch (IOException ex) {
                Logger.getLogger(ParaQSirve.class.getName()).log(Level.SEVERE, null, ex);
            }
              dispose(); 
            }
        }

   
    
    
    
}




