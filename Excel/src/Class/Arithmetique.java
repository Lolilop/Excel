package Class;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Arithmetique {
    
    String msg;
    static Cellule[][] cellule;
    
    public Arithmetique(String msg) {
        this.msg = msg;
        
        if(this.msg != "" || this.msg != "?") {
            this.msg = search();
        }
       
        
        //actual();
        
        
    }
    
    public Arithmetique(Cellule cellule) {
        
        
        if(cellule.getCalcule() != null) {
            this.msg = cellule.getCalcule();
            cellule.setCalcule(search());
            cellule.setMsg(search());
            System.out.println(cellule.getCalcule());
        }
    }
    
    public Arithmetique(Cellule[][] cellule) {
        this.cellule = cellule;
    }
    

    
    
    
    public String getMsg() {
        return this.msg;
    }
    
    private String search() {
        
        String msg = "";
        
        try {
            
            if(this.msg.indexOf("somme") != -1) {
                
                try {
                    String[] key = this.msg.split("\\)");
                    key = key[0].split("\\(");
                    key = key[2].split(",");

                    String a = this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg();


                    key = this.msg.split("\\)");
       
                    key = key[1].split("\\(");
          
                    key = key[1].split(",");
                
                    String b = this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg();

                    float x = Float.parseFloat(a);
                    float y = Float.parseFloat(b);

                    return String.valueOf(x+y);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog",JOptionPane.ERROR_MESSAGE);
                    return "?";
                }
                
            }else if(this.msg.indexOf("moy") != -1){
                
                try{
                
                    String[] key = this.msg.split("\\)");
                   
                    key = key[0].split("\\(");
                 
                    key = key[2].split(",");

                    String a = this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg();


                    key = this.msg.split("\\)");
                 
                    key = key[1].split("\\(");
                   
                    key = key[1].split(",");
                  
                    String b = this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg();

                    float x = Float.parseFloat(a);
                    float y = Float.parseFloat(b);

                    return String.valueOf(x/y);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog",JOptionPane.ERROR_MESSAGE);
                    return "?";
                }
                
            } if(this.msg.indexOf("(") != -1 && this.msg.indexOf(")") != -1 ){
               
               float nb = 0;
               String[] key = this.msg.split("\\)");
               key = key[0].split("\\(");
               key = key[1].split(",");
               
               if(this.msg.split("-").length == 2) {
                   String[] word = this.msg.split("-");
                   
                   if(word[0].split(",").length == 1) {
                       System.err.println(word[0]);
                       nb = Float.parseFloat(word[0]) - Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                   }else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) - Float.parseFloat(word[1]);
                   }
                   
                   
                   return String.valueOf(nb);
               } else if(this.msg.split("\\+").length == 2) {
                   String[] word = this.msg.split("\\+");
                   
                   if(word[0].split(",").length == 1) {
                       nb = Float.parseFloat(word[0]) + Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                   }else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) + Float.parseFloat(word[1]);
                   }

                   return String.valueOf(nb);  
               } else if(this.msg.split("/").length == 2) {
                   String[] word = this.msg.split("/+");
                   
                   if(word[0].split(",").length == 1) {
                       nb = Float.parseFloat(word[0]) / Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                   }else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) / Float.parseFloat(word[1]);
                   }
                  
                   return String.valueOf(nb);  
               }
               
               

                
            }if(this.msg.split("-").length == 2) {
                return diff(Float.parseFloat(this.msg.split("-")[0]),Float.parseFloat(this.msg.split("-")[1]));
            }else if(this.msg.split("\\+").length == 2) {
                return somme(Float.parseFloat(this.msg.split("\\+")[0]),Float.parseFloat(this.msg.split("\\+")[1]));
            }else if(this.msg.split("/").length == 2) {
                return div(Float.parseFloat(this.msg.split("/")[0]),Float.parseFloat(this.msg.split("/")[1]));
            }else {
                return this.msg;
            }
            
            

            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog",JOptionPane.ERROR_MESSAGE);
            return "?";
        }
        
    
    }
    
    
    private String diff(float a, float b) {  
        return String.valueOf(a - b);
    }
    
    private String somme(float a, float b) {  
        return String.valueOf(a + b);
    }
    
    private String div(float a, float b) {  
        return String.valueOf(a / b);
    }

    
}
