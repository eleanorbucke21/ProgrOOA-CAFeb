/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progrooa.cafeb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * GitHub Repo://github.com/eleanorbucke21/ProgrOOA-CAFeb
 * 
 * @author rubyb
 */
public class ProgrOOACAFeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Student list
        List<String> studentInfo = new ArrayList<>();

        //Read student information from students.txt
        try (            
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rubyb\\Documents\\NetBeansProjects\\ProgrOOA-CAFeb\\students.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\rubyb\\Documents\\NetBeansProjects\\ProgrOOA-CAFeb\\status.txt"))){

            System.out.println("--- BufferedReader ---");
            String line;

            // Read each record (three lines per record)
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                // First line is the name
                String name = line.trim();

                // Split the name into first and last names
                String[] nameParts = name.split("\\s+", 2);
                String firstName = nameParts[0];
                String familyName = nameParts.length > 1 ? nameParts[1] : "";

                // Validate First Name and Surname 
                if (!isValidName(firstName) || !isValidName(familyName)) {
                    System.out.println("Invalid characters in the name");
                    continue;
                }

                // Second line is the workload
                int workLoad = Integer.parseInt(br.readLine().trim());

                // Third line is the student number
                String studentNumber = br.readLine().trim();

                // Writing valid information to status.txt
                bw.write(studentNumber + " - " + familyName + "\n");
                bw.write(workLoad + "\n");
                bw.newLine();

            }

            br.close();
        
        } catch (IOException | NumberFormatException e) {
        }
    }

    private static String getWorkLoadWords(int workLoad) {
        if (workLoad == 1) {
            return "Very Light";
        } else if (workLoad == 2) {
            return "Light";
        } else if (workLoad >= 3 && workLoad <= 5) {
            return "Part Time";
        } else if (workLoad >= 6) {
            return "Full Time";
        } else {
            return "Unknown Workload";
        }

    }
      private static boolean isValidName(String name) {
    if (!name.matches("[a-zA-Z]+")) {
        System.out.println("Invalid characters in the name: " + name);
        return false;
    }
    return true;
}
      
    private static boolean isValidStudentNumber(String studentNumber) {
        if (studentNumber.length() != 6) {
            System.out.println("Incorrect length");
            return false;
        } else {
            String firstTwoDigits = studentNumber.substring(0, 2);
            String middleTwoLetters = studentNumber.substring(2, 4);
            String lastTwoDigits = studentNumber.substring(4);

            if (!firstTwoDigits.matches("[0-9]+")) {
                System.out.println("First two characters are not numbers");
                return false;
            } else if (!middleTwoLetters.matches("[a-zA-Z]+")) {
                System.out.println("Middle two characters must be letters");
                return false;
            } else if (!lastTwoDigits.matches("[0-9]+")) {
                System.out.println("Last two characters are not numbers");
                return false;
            } else {
                System.out.println("Valid student number!");
                return true;
            }
        }
    }
      
}
