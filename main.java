package Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    static public void main(String[] args) throws IOException, Exception {
        Setting.getData("dictionaries.txt");
        Setting.getHis("history.txt");
        Setting.getN();
        Setting.saveN();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
              
            }
        });
            
      
            }
    
}
