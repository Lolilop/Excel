package excel;

import java.awt.Dimension;
import javax.swing.JFrame;

public class main {

 
    public static void main(String[] args) {
        
        JFrame sheet = new JFrame("Sheet");
        
        sheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the jframe size and location, and make it visible
        sheet.setPreferredSize(new Dimension(600, 500));
        sheet.pack();
        sheet.setLocationRelativeTo(null);
        sheet.setVisible(true);
        
    }
    
    
}
