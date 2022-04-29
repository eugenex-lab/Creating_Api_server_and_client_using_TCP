package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");

        // try socket user
        try (Socket socket = new Socket("localhost", 8888)) {

            socket.setSoTimeout(10000);

            BufferedReader echo = new BufferedReader(
                    new java.io.InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response = "";

            do {
                System.out.println("Enter a string: ");
                echoString = scanner.nextLine();
            out.println(echoString);
            if (!echoString.equals("exit")) {
                response = echo.readLine();
                System.out.println("Server response: " + response);
            }
            }
            while (!echoString.equals("exit"));
        } catch (UnknownHostException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException" + e.getMessage());
        }
        // try socket user

    }
}