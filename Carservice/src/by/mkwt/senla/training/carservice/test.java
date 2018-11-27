package by.mkwt.senla.training.carservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.io.IOException;
public class test {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        System.out.println("What is your name ?");

        String name = br.readLine();

        System.out.println("What is your second name ?");

        String secName = br.readLine();

        System.out.println(name+" "+secName);
        System.out.println("This information will be transferred to MI6. Thank you for attention !!!");

    }
}
