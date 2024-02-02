/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progrooa.cafeb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
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
       try {
            System.out.println("--- BufferedReader ---");
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rubyb\\Documents\\NetBeansProjects\\ProgrOOA-CAFeb\\students.txt"));
            String line;

            // Read each record (three lines per record)
            while ((line = br.readLine()) != null) {
            // First line is the name
            String name = line.trim();

            // Split the name into first and last names
            String[] nameParts = name.split("\\s+", 2);
            String firstName = nameParts[0];
            String familyName = nameParts.length > 1 ? nameParts[1] : "";

            // Second line is the workload
            int workLoad = Integer.parseInt(br.readLine().trim());

            // Third line is the student number
            String studentNumber = br.readLine().trim();

            // Printing out name, student number, and workload
            System.out.println("First Name: " + firstName);
            System.out.println("Family Name: " + familyName);
            System.out.println("Student Number: " + studentNumber);
            System.out.println("Workload: " + getWorkLoadWords(workLoad));

            // Skip the empty line between records
            br.readLine();
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
    }
