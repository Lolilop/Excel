package Class;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class export de fichier excel
 * @author Johan
 */


public class Export {
    
    Cellule[][] cellule;
    
    
    
    public Export(Cellule[][] cellule) {
        this.cellule = cellule;
        export_data();
    }
    
    public Export() {
        export_data();
    }
    
    /**
     * Ecrit dans un fichier le fichier exel
     */
    
    private void export_data() {
        
        try {
            FileWriter fw = new FileWriter("Export.txt");
            
            for(int i = 0; i < cellule.length; i++) {
                for(int j = 0 ; j < cellule[i].length;j++) {
                    
                    if(cellule[i][j].getCalcule() != null) {
                        fw.write(cellule[i][j].getCalcule());
                    }else {
                        fw.write(" ");
                    }
                    
                    fw.write('&');
                }
                
                fw.write('\n');
            }

            fw.close();
            System.out.println("Le texte a été écrit avec succès");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
