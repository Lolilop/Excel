package Class;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
* class arithmétique 
* somme
* moyenne
* divion
*/

public class Arithmetique {

    String msg;
    static Cellule[][] cellule;
    
    /**
     * verfie si le message est null ou pas ne correpsond à rien
     * @param msg message de la cellule
     */

    public Arithmetique(String msg) {
        this.msg = msg;

        if (this.msg != "" || this.msg != "?") {
            this.msg = search();
        }

        //actual();
    }
    
    /**
     * Verifie la cellule et fait les opération
     * @param cellule 
     */
    
    public Arithmetique(Cellule cellule) {

        if (cellule.getCalcule() != null) {
            this.msg = cellule.getCalcule();
            cellule.setCalcule(search());
            cellule.setMsg(search());
            System.out.println(cellule.getCalcule());
        }
    }
    
    /**
     * Initialisation d'un tableau de cellule
     * @param cellule 
     */

    public Arithmetique(Cellule[][] cellule) {
        this.cellule = cellule;
    }
    
    /**
     * Returne le message
     * @return message
     */

    public String getMsg() {
        return this.msg;
    }
    
    /**
     * Recherche une concordance (+,*,/,-,somme,moyenne
     * @return valeur du boutton
     */

    private String search() {

        String msg = "";

        try {

            if (this.msg.indexOf("somme") != -1) {
               return this.msg_somme();
            } else if (this.msg.indexOf("moy") != -1) {
                return this.msg_moyenne();
            }
            
            if (this.msg.indexOf("(") != -1 && this.msg.indexOf(")") != -1) {

                float nb = 0;
                String[] key = this.msg.split("\\)");
                key = key[0].split("\\(");
                key = key[1].split(",");

                if (this.msg.split("-").length == 2) {
                    String[] word = this.msg.split("-");

                    if (word[0].split(",").length == 1) {
                        System.err.println(word[0]);
                        nb = Float.parseFloat(word[0]) - Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                    } else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) - Float.parseFloat(word[1]);
                    }

                    return String.valueOf(nb);
                } else if (this.msg.split("\\+").length == 2) {
                    String[] word = this.msg.split("\\+");

                    if (word[0].split(",").length == 1) {
                        nb = Float.parseFloat(word[0]) + Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                    } else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) + Float.parseFloat(word[1]);
                    }

                    return String.valueOf(nb);
                } else if (this.msg.split("/").length == 2) {
                    String[] word = this.msg.split("/+");

                    if (word[0].split(",").length == 1) {
                        nb = Float.parseFloat(word[0]) / Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg());
                    } else {
                        nb = Float.parseFloat(this.cellule[Integer.parseInt(key[0])][Integer.parseInt(key[1])].getMsg()) / Float.parseFloat(word[1]);
                    }

                    return String.valueOf(nb);
                }

            }
            if (this.msg.split("-").length == 2) {
                return diff(Float.parseFloat(this.msg.split("-")[0]), Float.parseFloat(this.msg.split("-")[1]));
            } else if (this.msg.split("\\+").length == 2) {
                return somme(Float.parseFloat(this.msg.split("\\+")[0]), Float.parseFloat(this.msg.split("\\+")[1]));
            } else if (this.msg.split("/").length == 2) {
                return div(Float.parseFloat(this.msg.split("/")[0]), Float.parseFloat(this.msg.split("/")[1]));
            } else {
                return this.msg;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog", JOptionPane.ERROR_MESSAGE);
            return "?";
        }

    }

    /**
     * calcule la différence entre 2 nombres
     * @param a
     * @param b
     * @return a-b
     */
    
    private String diff(float a, float b) {
        return String.valueOf(a - b);
    }
    
    /**
     * calcule la somme entre 2 nombres
     * @param a
     * @param b
     * @return a+b
     */

    private String somme(float a, float b) {
        return String.valueOf(a + b);
    }
    
    /**
     * calcule la divion entre 2 nombres
     * @param a
     * @param b
     * @return a/b
     */

    private String div(float a, float b) {
        return String.valueOf(a / b);
    }
    
    /**
     * verifie le message d'une somme
     * @return ? ou msg
     */
    
    private String msg_somme() {
        
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

            return String.valueOf(x + y);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog", JOptionPane.ERROR_MESSAGE);
            return "?";
        }
    }
    
    /**
     * Verifie la moyenne
     * @return 
     */
    
    private String msg_moyenne() {
        
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

            return String.valueOf(x / y);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "error type", "Dialog", JOptionPane.ERROR_MESSAGE);
            return "?";
        }
    }

}
