package PhoneBook;

import java.io.IOException;
import java.util.Scanner;

public class ManageContact {
    static Scanner input = new Scanner(System.in);

    static void ShowContact() throws IOException{ // show all Contacts
        int lengh = Phone.contacts.size();
        if(lengh == 0){ // mean that there is no object in list
            System.out.println("There is no Contact\n\nPress the Enter to return to the menu ...");
            System.in.read();
            Menu.menu();
        }
        else{
            for(int i = 0; i < lengh; i++){
                System.out.print(String.valueOf(i + 1) + " : " + Phone.contacts.get(i).getName()); // This Three will Show the contact
                System.out.print("   " + Phone.contacts.get(i).getPhone() + "   ");
                System.out.println(Phone.contacts.get(i).getEmail() + "   " + Phone.contacts.get(i).getAddress());
            }
            System.out.println("\n\nPress the Enter to return to the menu ...");
            System.in.read();
            Menu.menu();
        }
    }
    
    
    static void AddContact() throws IOException{ // Get new contacct information and add it to the list of objects
        System.out.print("Enter the Name : ");
        String name = input.next();
        System.out.print("Enter the Phone number: ");
        String phone = input.next();
        System.out.print("Enter the Email : ");
        String email = input.next();
        System.out.print("Enter the Address: ");
        String address = input.next();
        Phone.contacts.add(new Contact(name,phone,email,address)); // Add new contact to the list
        System.out.println("\nThe Contact successfully added !!!\nPress the Enter to return to the menu ...\n");
        System.in.read(); // Get Emty input like Enter 
        Menu.menu(); // Go back to menu
    }
    
    
    static void RemoveContact() throws IOException{ // Remove the Contac object from the list 
        int number = FindContact(); // Get index of Contact in list
        System.out.print(String.valueOf(number + 1) + " : " + Phone.contacts.get(number).getName()); // This Three will Show the contact
        System.out.print("   " + Phone.contacts.get(number).getPhone() + "   ");
        System.out.println(Phone.contacts.get(number).getEmail() + "   " + Phone.contacts.get(number).getAddress());
        System.out.println("\nAre u Sure : \n1_Yes\n2_No");
        String choice = input.next();
        if(choice.equals("1")){
            Phone.contacts.remove(number); // Remove it
            System.out.println("The Contact successfully removed !!!\nPress the Enter to return to the menu ...");
            System.in.read(); // Get Emty input like Enter 
            Menu.menu(); // Go back to menu
        }
        else{
            Menu.menu(); // Go back to menu
        }
    }
    
    
    static void EditContact() throws IOException{ // Get the contact and can change all the informations
        int number = FindContact(); // Get index of Contact in list
        System.out.print(String.valueOf(number + 1) + " : " + Phone.contacts.get(number).getName()); // This Three will Show the contact
        System.out.print("   " + Phone.contacts.get(number).getPhone() + "   ");
        System.out.println(Phone.contacts.get(number).getEmail() + "   " + Phone.contacts.get(number).getAddress());
        System.out.print("Enter the new Name : ");
        Phone.contacts.get(number).setName(input.next()); // For change the valve of the objects use set()
        System.out.print("Enter the new Phone : ");
        Phone.contacts.get(number).setPhone(input.next());
        System.out.print("Enter the new Email : ");
        Phone.contacts.get(number).setEmail(input.next());
        System.out.print("Enter the new Address : ");
        Phone.contacts.get(number).setAddress(input.next());
        System.out.println("The Contact successfully updated !!!\nPress the Enter to return to the menu ...");
        System.in.read(); //Get Emty input like Enter 
        Menu.menu(); // Go back to menu
    }
    
    
    static void SearchContact() throws IOException{ // Search for contact by using name or phone number and call FindContact function
        int number = FindContact(); // Get index of Contact in list
        System.out.print(String.valueOf(number + 1) + " : " + Phone.contacts.get(number).getName()); // This Three will Show the contact
        System.out.print("   " + Phone.contacts.get(number).getPhone() + "   ");
        System.out.println(Phone.contacts.get(number).getEmail() + "   " + Phone.contacts.get(number).getAddress());
        System.out.println("Press the Enter to return to the menu ...");
        System.in.read(); //Get Emty input like Enter 
        Menu.menu(); // Go back to menu
        
    }
    
    
    static int FindContact() throws IOException{ // Helpfull function for find index of contact for another functions
        int lengh = Phone.contacts.size(); // Get the number of Contacts
        System.out.println("\n\nFind Contact by : \n1_Name : \n2_Phone Number : "); // choice between search by name or phone number
        while (true) { 
            String choice;
            choice = input.next();
            switch(choice){
                case "1" : {
                    while (true) {                        
                        System.out.print("Enter the Name of Contact : ");
                        String name = input.next();
                        for(int i = 0; i < lengh;i++){ // Search by compare with all of contacts
                            if(name.equals(Phone.contacts.get(i).getName())){
                                return i; // i = index of contact
                            }
                        }
                        System.out.println("No contact found\n1_Search Again : \n2_Cancel");
                        choice = input.next();
                        if(choice.equals("2")){ // And if it wasnt 2 it will go back and continue ask for search
                            Menu.menu(); // Go back to menu
                        }
                    }
                    
                }
                case "2" :{
                    while (true) {                        
                        System.out.print("Enter the Phone number of Contact : ");
                        String name = input.next();
                        for(int i = 0; i < lengh;i++){ // Search by compare with all of contacts
                            if(name.equals(Phone.contacts.get(i).getPhone())){
                                return i; // i = index of contact
                            }
                        }
                        System.out.println("No contact found\n1_Search Again : \n2_Cancel");
                        choice = input.next();
                        if(choice.equals("2")){ // And if it wasnt 2 it will go back and continue ask for search
                            Menu.menu(); // Go back to menu
                        }
                    }
                }
            }
        }
    }
}