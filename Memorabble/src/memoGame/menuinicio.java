
package memoGame;

//librerias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class menuinicio extends JFrame implements ActionListener {
    JLabel nomjudador,etiqueta, lblFondo;
    JButton btnAyuda,btnJuega,btnsalir,btnParaqSirve;
    ImageIcon imgFondo;
    JTextField txtplayer;
    int anchoV = 1010;
    int largoV = 720;
   String rutaAbsoluta;
   
    public menuinicio() throws IOException{
        this.setTitle("Menu");
        this.setSize(anchoV, largoV);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
         
        
        rutaAbsoluta = new File("").getAbsolutePath();
        imgFondo = establecerIcon("/src/imagenes/fondoMenu.png",anchoV, largoV);
        componentes();
    }


    
    //metodo que contiene todos los compoenentes de la ventana
    
    public void componentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
   
        //texto donde se coloca el nombre de jugador
        txtplayer = new JTextField();
        txtplayer.setBounds(300,400,400,40);
        txtplayer.setBackground(Color.black);
        txtplayer.setForeground(Color.white);
        txtplayer.setHorizontalAlignment(JTextField.CENTER);
        txtplayer.setFont(new Font("cooper black",1,25));
        panel.add(txtplayer);
        
        //boton iniciar juego, este mandara directamente a iniciar el juego 
        btnJuega = new JButton("JUGAR");
        btnJuega.setBounds(370,515,250,80);
        btnJuega.setFont(new Font("cooper black",1,25));
        btnJuega.setForeground(Color.white);
        btnJuega.setBackground(Color.BLACK);
        btnJuega.addActionListener(this);
        btnJuega.addMouseListener(new ManejadoraDeMouse());
        panel.add(btnJuega);
        
        
        //este boton va a mostrar los datos del creador de la aplicación
       
        btnAyuda = new JButton("COMO JUGAR");
        btnAyuda.setBounds(55,520,250,80);
        btnAyuda.setFont(new Font("cooper black",1,25));
        btnAyuda.setForeground(Color.white);
        btnAyuda.setBackground(Color.black);
        btnAyuda.addActionListener(this);
        btnAyuda.addMouseListener(new ManejadoraDeMouse());
        panel.add(btnAyuda);
       // panel.addMouseListener(new ManejadoraDeMouse());
        
        
        
        
        //Boton salir
        btnsalir = new JButton("Salir");
        btnsalir.setBounds(820,20,150,40);
        btnsalir.setFont(new Font("cooper black",1,25));
        btnsalir.setForeground(Color.white);
        btnsalir.setBackground(Color.black);
        btnsalir.addActionListener(this);
        btnsalir.addMouseListener(new ManejadoraDeMouse());
        panel.add(btnsalir);
        
        //Boton btnParaqSirve
        btnParaqSirve = new JButton("SIRVE");
        btnParaqSirve.setBounds(720,520,250,80);
        btnParaqSirve.setFont(new Font("cooper black",1,25));
        btnParaqSirve.setForeground(Color.white);
        btnParaqSirve.setBackground(Color.black);
        btnParaqSirve.addActionListener(this);
        btnParaqSirve.addMouseListener(new ManejadoraDeMouse());
        panel.add(btnParaqSirve);
        
        
                
        lblFondo = new JLabel(imgFondo);
        lblFondo.setBounds(0, 0, anchoV, largoV);
        panel.add(lblFondo);
    }
    
    

    
    //eventos de acción

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //este evento realiza la acción del boton iniciar juego
       if(e.getSource() == btnJuega){
           
           //se coloca un if para colocar una excepcion a la hora de iniciar el juego 
             if(txtplayer.getText().equals("")){
                 //si en el txtnomjugador no se encuentra ningun valor
             JOptionPane.showMessageDialog(null, "Para jugar debes ingresar un nombre");
             //mandara un mensaje diciendo que tiene que colocar algun nombre
            }else{
                 //de lo contrario, se inicializara el juego de memoria
                 //se manda a llamar la clase JuegoMemoria
                 JuegoMemoria ventana = null;
                 try {
                     ventana = new JuegoMemoria();
                 } catch (IOException ex) {
                     Logger.getLogger(menuinicio.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 //decimos que nombreju de la clase JuegoMemoria 
                 //va a obtener el valor que se coloco en el txtnomjugador
                 ventana.playerX.setText(txtplayer.getText());
                 //esto se coloca para inicializar el tiempo de la clase JuegoMemoria
                 ventana.tiempo.start();
                 //mostramos la ventana de la clase JuegoMemoria
                 ventana.setVisible(true);
                 //ocultamos la ventana de menuinicial
                 this.setVisible(false);
                 
                 
             }
        }
       

        
       
       
       
       //este es el evento de el boton creditos
       if(e.getSource() == btnAyuda){
           //se manda a llamar una imagen 
          /* Icon g=new ImageIcon(getClass().getResource("/imagenes/comoJugar1.png"));
            //se implementa que a la hora de apachar el boton creditos este mostrara una ventana
            //donde se mostraran algun datos del creador del programa
         JOptionPane.showMessageDialog(null," INGENIERIA SISTEMAS UNIVALLE\n"
                 + " Estudiantes:\n IVAN NORIEGA - HANNER SINISTERRA.\n "
                 + "\n Mini-Proyecto2: Memorabble ."
                 + "\n "
                 + "\n "
                 + "¿COMO JUGAR?"
                 + "\n En memorable aparecera una serie de distintos colores sobre una fichas. "
                 + "\n Al cabo de unos segundos, las figuras desapareceran y tendras que responder unas preguntas."
                 + "\nLa pregunta apareceran en la parte inferior cuando las figuras hayan desaparecido . "
                 + "\nDebes pulsar sobre la ficha que cumpla la condidcion expresada en la pregunta."
                 + "\n¡¡OJO!! Es posible que haya que pulsar mas de una ficha."
                 + "\n Este juego fue creado solo con codigo.   "
                 //al final mandamos a llamar a la imagen para que se coloque en la ventana
                , "Consejo",JOptionPane.INFORMATION_MESSAGE, g);*/
         
         // if (e.getSource() == btnAyuda) {
                //dispose();
                //    else if (e.getSource() == btnComoJugar) {
               // dispose();
               
               ComoseJuega ventana = null;
                 try {
                     ventana = new ComoseJuega();
                 } catch (IOException ex) {
                     Logger.getLogger(menuinicio.class.getName()).log(Level.SEVERE, null, ex);
                 }      
       }
       
       
              if(e.getSource() == btnParaqSirve){
           //se manda a llamar una imagen 
         /*   Icon g=new ImageIcon(getClass().getResource("/imagenes/comoJugar2.png"));
            //se implementa que a la hora de apachar el boton creditos este mostrara una ventana
            //donde se mostraran algun datos del creador del programa
         JOptionPane.showMessageDialog(null," INGENIERIA SISTEMAS UNIVALLE\n"
                 + " Estudiantes:\n IVAN NORIEGA - HANNER SINISTERRA.\n "
                 + "\n Mini-Proyecto2: Memorabble ."
                 + "\n "
                 + "\n "
                 + "\n¿PARA QUE SIRVE? "
                 + "\n"
                 + "\nEste juego pone en acción la habilidad para comparar patrones visuales, "
                 + "\nentrenando ademas la atención a los detalles y la velocidad perceptiva. "
                 + "\nEstas capacidades son relevantes cuando hay que decidir entre estimulos semejantes "
                 + "\ny hay que hacerlo de forma rápida, por ejemplo al reconocer fotografias, caras, objetos cotidianos "
                 + "\no palabras escritas"
                 + "\n"
                 + "\n"
                 + "\n"
                 + "\n"
                 //al final mandamos a llamar a la imagen para que se coloque en la ventana
                , "Consejo",JOptionPane.INFORMATION_MESSAGE, g);
         */
         
         
                        ParaQSirve ventana = null;
                 try {
                     ventana = new ParaQSirve();
                 } catch (IOException ex) {
                     Logger.getLogger(menuinicio.class.getName()).log(Level.SEVERE, null, ex);
                 }   
         
         
       }
       
       
       
       
       //este es el evento del boton salir 
       if(e.getSource() == btnsalir){
           //se mostrara una ventana donde hace una pregunta y tiene las opciones de salir o no
           if (JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de querer salir de la aplicacion?",
                "Salir de la Calculadora", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
                System.exit(0);
       }
      
    }

    private ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            throws IOException {
        BufferedImage bufferedImagen = ImageIO.read(new File(rutaAbsoluta.concat(rutaArchivo)));
        Image imagen = bufferedImagen.
                getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        return new ImageIcon(imagen);
    }
    
        class ManejadoraDeMouse extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           btnAyuda.setBackground(Color.cyan);
            btnJuega.setBackground(Color.green);
            btnsalir.setBackground(Color.red);
            btnParaqSirve.setBackground(Color.cyan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnAyuda.setBackground(Color.black);
            btnJuega.setBackground(Color.black);
            btnsalir.setBackground(Color.black);
            btnParaqSirve.setBackground(Color.black);
        }       
    }
  
        
        
        
  



}
