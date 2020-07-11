
package PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
        
public class Phone {
    
    static ArrayList<Contact> contacts = new ArrayList<>(); // array to save all objects
    
    
    public static void main(String[] args) throws IOException{
        get_From_File();
        Menu.menu(); // Go to menu for choice from manage contacts
    }
    
    
    static void get_From_File() throws IOException{ // Get Informations from file
        File file = new File("logs/file.txt");
        if(file.exists() == false){
            file.createNewFile();
        }
        Scanner reader = new Scanner(file);
        while (reader.hasNext()) {
            String name = reader.next();
            String phone = reader.next();
            String email = reader.next();
            String address = reader.next();
            contacts.add(new Contact(name, phone, email, address)); 
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print("");
            }
        }  
    }
    
    
    static void Put_In_File() throws IOException{
        File file = new File("logs/file.txt");
        if(file.exists() == false){
            file.createNewFile();
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            int lengh = contacts.size();
            for(int i=0;i<lengh;i++){
                writer.print(contacts.get(i).getName() + " ");
                writer.print(contacts.get(i).getPhone()+ " ");
                writer.print(contacts.get(i).getEmail()+ " ");
                writer.print(contacts.get(i).getAddress()+ "\n");
            }
        }
        System.exit(0);
    }
}
