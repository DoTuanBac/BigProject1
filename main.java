package Dictionary;

import java.io.IOException;
import java.util.Scanner;
public class main {
    public static void main(String [] args) throws IOException
    {   Scanner cin=new Scanner (System.in);
        int n=0;
        DictionaryManagement.insertFromFile();
        while(n!=7)
        {   
            System.out.println("\n===========================================\n");
            System.out.println("Các chức năng của chương trình từ điển :");
            System.out.println("1.Tra cứu từ ");
            System.out.println("2.Tra cứu từ nâng cao");
            System.out.println("3.Thêm từ mới");
            System.out.println("4.In ra toàn bộ từ");
            System.out.println("5.Xóa từ");
            System.out.println("6.Sửa nghĩa của từ");
            System.out.println("7.Kết thúc chương trình");
            System.out.print("Nhập số thứ tự lệnh :");
                  n=cin.nextInt();
             switch(n){
                 case 1 :DictionaryManagement.dictionaryLookup();break;
                 case 2 :DictionaryCommandline.dictionarySearcher();break;
                 case 3 :DictionaryManagement.insertFromCommandline();break;
                 case 4 :DictionaryCommandline.showAllWords();break;
                 case 5 :DictionaryManagement.DeleteWord();break;
                 case 6 :DictionaryManagement.FixWord();break;
                 case 7 :System.out.println("Cảm ơn mọi người đã dùng thử");
             }
             
        }
        DictionaryManagement.dictionaryExportToFile();
    }
}
