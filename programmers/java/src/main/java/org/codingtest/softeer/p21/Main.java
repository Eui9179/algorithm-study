package org.codingtest.softeer.p21;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String secret = sc.nextLine();
        String operation = sc.nextLine();

        String answer = operation.contains(secret) ? "secret": "normal";

        System.out.println(answer);
    }
}
