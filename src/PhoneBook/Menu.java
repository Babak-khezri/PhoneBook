package PhoneBook;

import java.io.IOException;
import java.util.Scanner;


public class Menu {
    
    
    static void menu() throws IOException{ // Make menu
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("1 : Show Contacts");
        System.out.println("2 : Add Contact");
        System.out.println("3 : Delete Contact");
        System.out.println("4 : Search Contact");
        System.out.println("5 : Edit Contact");
        System.out.println("6 : Exit");
        while (true) {
            String choice;
            choice = input.next();
            switch(choice){
                case "1": ManageContact.ShowContact();
                    break;
                case "2": ManageContact.AddContact();
                    break;
                case "3": ManageContact.RemoveContact();
                    break;
                case "4": ManageContact.SearchContact();
                    break;
                case "5": ManageContact.EditContact();
                    break;
                case "6": Phone.Put_In_File();
            }
        }  
    }
    
    
    public static void clearScreen() {  
        for(int i = 0;i<20;i++){
            System.out.println();
        } 
    }  
}
