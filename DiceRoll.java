/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diceroll;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class DiceRoll {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter 'txt' or 'csv' to choose your file type");
        String file_type = s.nextLine();
        while(!file_type.equals("txt") && !file_type.equals("csv")){
            System.out.println("Please enter 'txt' or 'csv' to choose your file type");
            file_type = s.nextLine();
        }
        String file_name = "dicerolldata.".concat(file_type);
        System.out.println("Enter a sample size");
        int sample_size = s.nextInt();
        File data = new File(file_name);
        PrintWriter pw = new PrintWriter(data);
        int dice;
        int count = 1;
        ArrayList<Integer> roll_count = new ArrayList();
        while(roll_count.size() < sample_size){
            dice = (int)(Math.random()*6) + 1;
            if(dice == 6){
                roll_count.add(count);
                count = 0;
            }
            count++;
        }
        if(file_type.equals("txt")){
            for(Integer n: roll_count)
            pw.println(n);
        }
        else{
        for(Integer n: roll_count)
            pw.println(n + ",");
        }
        pw.close();
        
    }
    
}
