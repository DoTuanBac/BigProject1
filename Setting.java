package Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Setting {
  
    static void getData(String file) throws IOException {		//Nhập từ tệp
        File input = new File(file);
        FileInputStream fis = new FileInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF8"));

        int i = -1, j = 0;
        br.readLine();             //Bắt buộc bỏ dòng đầu tiên
        String temp;
        Dict temp2 = new Dict();
     
        while ((temp = br.readLine()) != null) {
            if (temp.indexOf("@") == 0) {       
                if (i >= 0) //Add vào data đồng thời temp khởi tạo giá trị mới
                {
                    
                    Data.dict.add(temp2);      
                    temp2 = new Dict();  
                }
                i++;
                j = 0;
                temp2.word = temp.substring(1);    
            } else {
                temp2.explain.add(temp);            
                j++;
            }
        }
        
   
        br.close();
    }
   
 
     
    
  
    
   
    static public void saveData(String file) throws Exception
    {
         File output = new File(file);
        FileOutputStream fis = new FileOutputStream(output);
         BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fis,"UTF8"));
         buffer.write("Bản quyền bởi Đỗ Tuấn Bắc");
         buffer.write("\n");
           for(int i=0;i<Data.dict.size();i++)
           {
                buffer.write("@");
                buffer.write(Data.dict.get(i).word);
                 buffer.write("\n");
                 for(int j=0;j<Data.dict.get(i).explain.size();j++)
                 {
                       buffer.write(Data.dict.get(i).explain.get(j));
                 buffer.write("\n");
                 }
           }
           buffer.write("@ZZZZZZZZZZZZZZZZZZZZZZZZ");
            buffer.close();
                
    }
   
    static public void delete(int n) 
    {
         Data.dict.remove(n);
    }
    static public void clear()
    {
        Data.dict.clear();
    }
  
    
    static public void add(String a,String e)
    {   
         Dict temp = new Dict();
          temp.word = a;
          String [] n=e.split("\\n");
          for(int i=0;i<n.length;i++)
          temp.explain.add(n[i]);
          Data.dict.add(temp);
           
    }
    
    static public int Lookup(String key)  
    {
       /*int number = -1;
        for (int i = 0; i < Data.dict.size(); i++) {
         
            if (Data.dict.get(i).word.equals(key)) {
                number = i;
                break;
            }
        }
         
        return number;
           
        */
        
       int x=binarySearch(key);
         return x;
    }
       
    static public ArrayList<Integer> Search(String str) { 
        ArrayList<Integer> arr = new ArrayList<Integer>();
     
        int find;
        int j = 0;
        for (int i = 0; i < Data.dict.size(); i++) {
            find = Data.dict.get(i).word.indexOf(str);
            if (find == 0) {
                arr.add(i);
                
            }
       
        }
        return arr;
    }

  
     
  }
          