package Class;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Cellule {
    
    //define matrice
    int x,y;
    
    //define button
    JButton btn;
    String msg;
    
    Cellule ref_a;
    Cellule ref_b;
    
    String calcule = null;
    

    

   
    
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
    
    public void actual(Cellule[][] cellule) {
        
    }
    

    


   
   public void setCalcule(String msg) {
       this.calcule = msg;
       
   }
   
   public String getCalcule() {
       return this.calcule;
   }
    
    
    public void add_button(Cellule cellule,JFrame jframe) {
         jframe.add(this.btn);
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
        this.btn.setText(this.msg);

    }
    
    public String getMsg() {
        return this.msg;

    }
    
    public void print_matrice() {
        System.out.println("(" + x + ";" + y + ")");
    }
    
}
