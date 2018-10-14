package Dictionary;

import java.io.*;
import java.util.ArrayList;

public class main {

    static public void main(String[] args) throws IOException {
        
        Setting.getHis("history.txt");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
              
            }
        });
            
       
       
        
    }
    
}
