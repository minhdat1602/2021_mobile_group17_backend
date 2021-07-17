package com.nlu;

import java.util.Scanner;

public class pickfile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String url = sc.nextLine();
		
		int begin, end;
		begin = url.indexOf("file/d/") + 7;
		System.out.println("begin: " + begin);
		end = url.indexOf("/view");
		System.out.println("end: " + end);
		
		String first = "https://drive.google.com/uc?export=view&id=";
		
		String result = first + url.substring(begin, end);
		System.out.println(result);
		sc.close();
	}
}
