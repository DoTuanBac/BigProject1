package Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DictionaryManagement {
  
public static Scanner cin=new Scanner(System.in);
  public static void insertFromFile() throws IOException
  {    
        File input = new File("dictionaries.txt");
        FileInputStream fis = new FileInputStream(input);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF8"));
        br.readLine();
        String temp="";
        
        Word temp2 = new Word();
        while((temp=br.readLine())!=null)
        {
            
            String t[]=temp.split("\t");  
            
           temp2.word_target=t[0];
           temp2.word_explain=t[1];
           Dictionary.str.add(temp2);
           temp2= new Word();
        
        }
        br.close();
  }
  public static void insertFromCommandline()
  {
            Word temp = new Word();
         System.out.print("Nhập từ cần thêm : ");
           temp.word_target=cin.nextLine();
           int n=tim(temp.word_target);
           if(n>=0)
           {
               System.out.println("Từ này đã có rồi !!!");
               return;
           }
           else
           {
               System.out.print("Nhập nghĩa từ thêm : ");
           temp.word_explain=cin.nextLine();
           Dictionary.str.add(temp);
           }
           
      
  }
  public static void dictionaryLookup()
  {    
      System.out.print("Nhập từ cần tìm :");
      String a=cin.nextLine();
      if(tim(a)>=0)
      System.out.println("Nghĩa của từ là :"+Dictionary.str.get(tim(a)).word_explain);  
      else  System.out.println("Không tìm thấy từ cần tìm");
  }
   public static int tim(String a)
  {     
      for(int i=0;i<Dictionary.str.size();i++)
      {
          if(a.equals(Dictionary.str.get(i).word_target))
          {
          return i;
          }
          
      }
      return -1;
  }
  public static void DeleteWord()
  { 
      System.out.print("Nhập từ cần xóa :");
      String a=cin.nextLine();
        int i=tim(a);
        if(i>=0)
        {Dictionary.str.remove(i);}
        else System.out.println("Không tìm thấy từ cần xóa");
       
  }
  public static void dictionaryExportToFile() throws IOException
  {
      File out = new File("dictionaries.txt");
        FileOutputStream fis = new FileOutputStream(out);
        BufferedWriter viet      = new BufferedWriter(new OutputStreamWriter(fis,"UTF8"));
        
     
      viet.write("Bản Quyền By Team Cá Độ\n");
      for(int i=0;i<Dictionary.str.size();i++)
      {
          viet.write(Dictionary.str.get(i).word_target+"\t");
          viet.write(Dictionary.str.get(i).word_explain+"\n");
      }
      viet.close();
  }
  public static void FixWord()
  {
      System.out.print("Nhập từ cần sửa :");
      String a=cin.nextLine();
      int i=tim(a);
        Dictionary.str.remove(i);
        Word temp = new Word();
       System.out.print("Nhập nghĩa muốn sửa : ");
           temp.word_explain=cin.nextLine();
           temp.word_target=a;
           Dictionary.str.add(i,temp);
      
  }
}
