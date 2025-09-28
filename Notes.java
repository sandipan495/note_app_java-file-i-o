import java.io.*;
import java.util.Scanner;

public class Notes{
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n--- Notes Menu ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
    
    private static void addNote(Scanner sc){
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            writer.write(note);
            writer.newLine();
            System.out.println("Note added successfully.");
        } catch (IOException e){
            System.out.println("An error occurred while adding the note.");
        }
    }

    private static void viewNotes(){
        System.out.println("\n--- Your Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e){
            System.out.println("No notes found.");
        } catch (IOException e){
            System.out.println("An error occurred while reading the notes.");
        }
    }
}