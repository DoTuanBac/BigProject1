package Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Setting {
    static int check =0;
    static void getData(String file) throws IOException {		//Nhập từ tệp
        File input = new File(file);
        FileInputStream fis = new FileInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF8"));
            
        int i = -1, j = 0;
        br.readLine();             //Bắt buộc bỏ dòng đầu tiên
        String temp;
        Dict temp2 = new Dict();
       int z=0;
        while ((temp = br.readLine()) != null) {
          
            if (temp.indexOf("@") == 0) {       //Nếu vị trí 0 = @ thì dòng đấy là từ mới
                if (i >= 0) //Add vào data đồng thời temp khởi tạo giá trị mới
                {
                    z=0;
                    Data.dict.add(temp2);      //Nhập temp2 vào data
                    temp2 = new Dict();     //temp2=null;
                }
                i++;
                j = 0;
               
                temp2.word = temp.substring(1);;     //Nhập từ mới vào temp2
               
            } else {
                z++;
                if(temp.indexOf("/")==0&& z==1) temp2.spelling=temp;
                else temp2.explain.add(temp);               //Nhập nghĩa vào temp2
                j++;
            }
        }
        
        //xoalap();
        //QuickSort(0,Data.dict.size()-1);
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
                if(Data.dict.get(i).spelling.compareTo("")!=0)
                {  buffer.write("\n");
                 buffer.write(Data.dict.get(i).spelling);
                }
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
    static void getN()throws IOException
    {
        
          File input = new File("n.txt");
        FileInputStream fis = new FileInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF8"));
        Data.nnn=Integer.parseInt(br.readLine());
  
        Data.nnn++;
          br.close();
    }
     static void saveN() throws Exception
     {
          File output = new File("n.txt");
        FileOutputStream fis = new FileOutputStream(output);
         BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fis,"UTF8"));
         
        buffer.write( Integer.toString(Data.nnn));
         buffer.close();
     }
   public static void xoalap()
   {
       for(int i=1;i<Data.dict.size();i++)
       {
           if(Data.dict.get(i).word.compareTo(Data.dict.get(i-1).word)==0)
           {
               delete(i);
               i--;
           }
       }
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
      while (Data.dict.get(i).word.toLowerCase().compareTo(pivot.word.toLowerCase())<0) {
        i++;
      }
   
      while (Data.dict.get(j).word.toLowerCase().compareTo(pivot.word.toLowerCase())>0) {
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
    
  
   
    static public void delete(int n) 
    {
        check=1;
        Dict temp2 = Data.dict.get(n);
        Data.temp.add(temp2);
        Data.dict.remove(n);
    }
    static public void clear()
    {
        if(check==1) check=3;
        else check=2;
      
        Data.temp3.addAll(Data.dict);
        Data.dict.clear();
    }
     static public void clear2()
    {
        Data.hist.clear();
    }
  
    static public void undo()
    {
       if(Data.temp.size()>0 || Data.temp3.size()>0)
       {
        if(check==1)
        {
         int x=Data.dict.size();
        Dict temp =Data.temp.get(Data.temp.size()-1);
 
        for(int i=0;i<Data.dict.size();i++)
          {
              if(temp.word.toLowerCase().compareTo(Data.dict.get(i).word.toLowerCase())<0)
              {
                  x=i;
               
                  break;
              }
              if(i==Data.dict.size()-1) break;
          }
        
          Data.dict.add(x,temp);
      Data.temp.remove(Data.temp.size()-1);

        }
        
        if(check==2)
        {
           Data.dict.addAll(Data.temp3);
         Data.temp3.clear();
     
        }  
        if(check==3)
        {
           Data.dict.addAll(Data.temp3);
         Data.temp3.clear();
        check=1;
        }
      
       }
    
    }
    
    static public int add(String a,String e)
    {   
    
      int x=Data.dict.size();
          Dict temp = new Dict();
          temp.word = a;
          String [] nn=e.split("\\n");
          for(int i=0;i<nn.length;i++)
          {
          temp.explain.add(nn[i]);
          if(nn[i].indexOf("@")==0) return -1;
          }
          for(int i=0;i<Data.dict.size();i++)
          {
              if(a.toLowerCase().compareTo(Data.dict.get(i).word.toLowerCase())<0)
              {
                  x=i;
                
                  break;
              }
              if(i==Data.dict.size()-1) break;
          }
          Data.dict.add(x,temp);
          
           return 0;
    }
  
    static public int repair(String a,String s)
    {
    
        int x=Lookup(a.toLowerCase());
      
        if(x!=-1)
        {
         Data.dict.get(x).explain.clear();
         String [] nn=s.split("\\n");
          for(int i=0;i<nn.length;i++)
          {
           if(nn[i].indexOf("@")==0) return -1;
          Data.dict.get(x).explain.add(nn[i]);
          }
        }
            return 0;
    }
    
    static public int Lookup(String key)  // Tìm kiếm tuyệt đối
    {  
       int x=binarySearch(key.toLowerCase());
         return x;
    }
       
    static public ArrayList<Integer> Search(String str) {  //Tìm kiếm tương đối
        ArrayList<Integer> arr = new ArrayList<Integer>();
     
        int find;
        int j = 0;
        for (int i = 0; i < Data.dict.size(); i++) {
            find = Data.dict.get(i).word.toLowerCase().indexOf(str);
            if (find == 0) {
                arr.add(i);
                
            }
       
        }
        return arr;
    }

    static public String translate(String word,String from,String to)
    {
        String temp = "";
         String fromLang = from;
            String toLang = to;
        try {
            String nn[]=word.split("\\n");
        
            for(int i=0;i<nn.length;i++)
            {
                 String nn2[]=nn[i].split("\\.");
                 if(nn2.length==1)    temp=temp+Translate.callUrlAndParseResult(fromLang, toLang, nn[i])+"";
                 else
                 for(int j=0;j<nn2.length;j++)
                 {
                      temp=temp+Translate.callUrlAndParseResult(fromLang, toLang, nn2[j])+".";
                 }
                 temp=temp+"\n";
            }
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
              if(Data.dict.get(mid).word.toLowerCase().compareTo(s)==0)
              {
                  x=mid;
                  break;
                  
              }
              else
              {
                  if(Data.dict.get(mid).word.toLowerCase().compareTo(s)<0)
                  {
                      dau=mid+1;
                  }
                  else if(Data.dict.get(mid).word.toLowerCase().compareTo(s)>0)
                  {
                      cuoi=mid-1;
                  }
              }
          }
          return x;
          
      }
      
  static public void xoa()
  {
      for(int i=0;i<Data.dict.size();i++)
      {
          if(Data.dict.get(i).word.length()>31)
          {
              Data.dict.remove(i);
          }
      }
  }
  }

  

          