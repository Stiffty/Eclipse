package OverlayTests;

import java.io.*;
import java.util.Scanner;

public class Speicher {

	private static int counter = 99999;
	private static Scanner sc = new Scanner(System.in);

	public Speicher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			File file = new File("ausgabe.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(String.valueOf(counter));

			bw.flush();
			bw.close();
			System.out.println("gespeichert");
			// sc.next();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String line;

			FileReader fr = new FileReader("ausgabe.txt");
			BufferedReader br = new BufferedReader(fr);

			System.out.println(br.readLine());
			System.out.println("test");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
