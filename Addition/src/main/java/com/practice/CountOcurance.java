package com.practice;

public class CountOcurance {

	public static void main(String[] args) {

		String str = "aaabbbccc";

		int count = 0;
		char serach = 'c';

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == serach) {

				count++;
				// System.out.print(serach);

			}

		}
		System.out.println(count);
	}

}
