package Dictionary;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    public static Scanner cin=new Scanner(System.in);
    static public void showAllWords() 
    {
        
        for(int i=0;i<Dictionary.str.size();i++)
        {
            System.out.println(i+1+" | "+Dictionary.str.get(i).word_target+" | "+ Dictionary.str.get(i).word_explain);
        }
    }
    public static void dictionaryBasic() throws IOException
    {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
    public static void dictionaryAdvanced() throws IOException
    {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }
    public static void dictionarySearcher()
    {
        System.out.print("Nhap tu can tra :");
        String a=cin.nextLine();
        int find;
        for(int i=0;i<Dictionary.str.size();i++)
        {
         find=Dictionary.str.get(i).word_target.indexOf(a);
         if(find==0) System.out.println(Dictionary.str.get(i).word_target);
        }
    }

}
