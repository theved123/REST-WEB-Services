package com.practice;

public class RevString {

	public static void main(String[] args) {

		String str = "achyut";
		int l = str.length();
		String rev = "";
		for (int i = 0; i < l; i++) {

			rev = str.charAt(i) + rev;

		}
		System.out.print(rev);

	}

}
