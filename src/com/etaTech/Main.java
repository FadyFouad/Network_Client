package com.etaTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8081)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
            String echo ;
            String response ;
            do{
                System.out.println("Enter Text");
                echo = scanner.nextLine();
                writer.println(echo);

                if (!echo.equals("exit")){
                    response = reader.readLine();
                    System.out.println(response);
                }
            }
            while (!echo.equals("exit"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
