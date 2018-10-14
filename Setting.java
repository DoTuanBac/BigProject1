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
            if (temp.indexOf("@") == 0) {       //Nếu vị trí 0 = @ thì dòng đấy là từ mới
                if (i >= 0) //Add vào data đồng thời temp khởi tạo giá trị mới
                {
                    
                    Data.dict.add(temp2);      //Nhập temp2 vào data
                    temp2 = new Dict();     //temp2=null;
                }
                i++;
                j = 0;
                temp2.word = temp.substring(1);     //Nhập từ mới vào temp2
            } else {
                temp2.explain.add(temp);               //Nhập nghĩa vào temp2
                j++;
            }
        }
        
        //QuickSort(0,Data.dict.size()-1);
        br.close();
    }
   
    static public void swap(int i,int j)
    {
        Dict temp = new Dict();
        Dict temp2 = new Dict();
        temp2=Data.dict.get(j);
        temp=Data.dict.get(i);
        Data.dict.remove(i);
        Data.dict.add(i,temp2);
          Data.dict.remove(j);
        Data.dict.add(j,temp);
        
    }
      static public void QuickSort(int left,int right)
    {
         if (left >= right)  return;
          int middle = left + (right - left) / 2;
           Dict pivot = new Dict();
            pivot = Data.dict.get(middle);
            int i = left, j = right;
            
            while (i <= j) {
      while (Data.dict.get(i).word.compareTo(pivot.word)<0) {
        i++;
      }
   
      while (Data.dict.get(j).word.compareTo(pivot.word)>0) {
        j--;
      }
           if (i <= j)
           {
               swap(i,j);
               i++;
               j--;
           }
      
                             }
        if (left < j)
      QuickSort( left, j);

    if (right > i)
      QuickSort( i, right);
    }
    
  
     static void getHis(String file) throws IOException {		//Nhập từ tệp
        File input = new File(file);
        FileInputStream fis = new FileInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF8"));

        
        br.readLine();
        String temp;
      
        while ((temp = br.readLine()) != null) {
                 Data.hist.add(temp); 
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
    static public void saveHis(String file) throws Exception
    {
         File output = new File(file);
        FileOutputStream fis = new FileOutputStream(output);
         BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fis,"UTF8"));
          buffer.write("Bản quyền bởi Đỗ Tuấn Bắc");
         buffer.write("\n");
          for(int i=0;i<Data.hist.size();i++)
          {
              buffer.write(Data.hist.get(i));
               buffer.write("\n");
          }
        
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
     static public void clear2()
    {
        Data.hist.clear();
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
    
    static public int Lookup(String key)  // Tìm kiếm tuyệt đối
    {  
       int x=binarySearch(key);
         return x;
    }
       
    static public ArrayList<Integer> Search(String str) {  //Tìm kiếm tương đối
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

    static public String translate(String word)
    {
        String temp = new String();
        try {
            
            String fromLang = "en";
            String toLang = "vi";

            temp=Transale.translate(fromLang, toLang, word);
        } catch (Exception ex) {
            Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
      static public int binarySearch(String s)
      {
          int cuoi=Data.dict.size()-1;
          int dau=0;
          int mid=0; 
          int x=-1;
          while(dau<=cuoi)
          {
              mid=dau+(cuoi-dau)/2;
              if(Data.dict.get(mid).word.compareTo(s)==0)
              {
                  x=mid;
                  break;
                  
              }
              else
              {
                  if(Data.dict.get(mid).word.compareTo(s)<0)
                  {
                      dau=mid+1;
                  }
                  else if(Data.dict.get(mid).word.compareTo(s)>0)
                  {
                      cuoi=mid-1;
                  }
              }
          }
          
          return x;
          
      }
  
  }
          