package Class;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Class Cellule
 * @author Johan
 * Intisialise une cellule du fichier excel
 */

public class Cellule {
    
    //define matrice
    int x,y;
    
    //define button
    JButton btn;
    String msg;
    
    Cellule ref_a;
    Cellule ref_b;
    
    String calcule = null;
    
    /**
     * Crée les bouton et ajoute un listener
     * @param x
     * @param y
     * @param interval_x
     * @param interval_y
     * @param msg 
     */
   
    
    public Cellule(int x, int y, int interval_x, int interval_y, String msg) {
        
  
        ref_a = null;
        ref_b = null;
        //matrice
        this.x = x;
        this.y = y;
        
        //button
        this.btn  = new JButton();
        this.btn.setBounds(interval_x, interval_y, 41, 25);
        this.btn.setBackground(Color.WHITE);
        this.btn.setBorder(new LineBorder(Color.BLACK));
        this.msg = msg;
        JTextField txt = new JTextField();
        
        
        this.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = JOptionPane.showInputDialog("enter value");
                
                if(txt == null) {
                    txt = "";
                }
                
                Arithmetique arithmetique = new Arithmetique(txt.toLowerCase());
                setMsg(arithmetique.getMsg());
                
                setCalcule(txt);
                
            }
        });
        
  
        
    }

    /**
     * Modifie la valeur du calcule
     * @param msg 
     */   
     
    public void setCalcule(String msg) {
       this.calcule = msg;   
    }
    /**
     * retourne la valeur du calcule
     * @return calule
     */
   
    public String getCalcule() {
       return this.calcule;
    }
    
    /**
     * Ajoute les button au JFrame
     * @param cellule
     * @param jframe 
     */
    
    public void add_button(Cellule cellule,JFrame jframe) {
        jframe.add(this.btn);
    }
    
    /**
     * Modifie la valeur du message et du texte du boutton
     * @param msg message de la cellule
     */
    
    public void setMsg(String msg) {
        this.msg = msg;
        this.btn.setText(this.msg);
    }
    
    /**
     * recupere le message
     * @return le message 
     */
    
    public String getMsg() {
        return this.msg;
    }
    
    /**
     * Affiche une matrice
     */
    
    public void print_matrice() {
        System.out.println("(" + x + ";" + y + ")");
    }
    
}
