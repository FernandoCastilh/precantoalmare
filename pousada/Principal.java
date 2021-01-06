package pousada;

import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        JanelaInicio jI = new JanelaInicio();
        JanelaLogin jL = new JanelaLogin();
        jI.setVisible(true);

        for(int x=0; x<101; x++){
            jI.Barra.setValue(x);
              
                  Thread.sleep(7);
          
        }
        jI.dispose();
        jL.setVisible(true);
    }
}
