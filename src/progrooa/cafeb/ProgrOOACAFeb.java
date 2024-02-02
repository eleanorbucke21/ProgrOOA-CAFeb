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

            //print each line to terminal
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
        }
        
        
        
    }
    
}
