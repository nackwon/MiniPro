package com.jimmy.project01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneApp {

	static String FILE = "phoneDB.txt";
	static List<Person> list;

	public static void main(String[] args) throws IOException {

		sc.init();
		list = store();
		int number = 0;

		while (true) {
			show();
			number = sc.nextInt();

			switch (number) {
			case 1:
				print();
				break;
			case 2:
				insert();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			default:
				System.exit(0);
			}
		}

	}

	public static void show() {
		System.out.println("================================");
		System.out.println("========전화번호 관리 프로그램========");
		System.out.println("================================");
		System.out.println(" 1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
		System.out.println("--------------------------------");
		System.out.print("> 메뉴 번호: ");
	}

	// 저장소
	public static List<Person> store() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF-8"));
		list = new ArrayList<Person>();

		String line = "";
		while (true) {
			line = br.readLine();

			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line, ",");
			Person person = new Person(st.nextToken(), st.nextToken(), st.nextToken());
			list.add(person);
		}
		return list;
	}

	// 리스트
	public static void print() throws IOException {
		System.out.println("<1.리스트 >");
		System.out.println();

		for (int i = 0; i < store().size(); i++) {
			System.out.print(i + 1 + " ");
			store().get(i).showInfo();
		}
		System.out.println();
	}

	public static void insert() throws IOException {
		Writer fw = new FileWriter(FILE, true);
		BufferedWriter bw = new BufferedWriter(fw);

		System.out.println("<2.등록>");
		System.out.print(">이름 : ");
		String str = sc.readLine();
		bw.write(str + ",");
		System.out.print(">휴대전화: ");
		str = sc.readLine();
		bw.write(str + ",");
		System.out.print(">회사전화: ");
		str = sc.readLine();
		bw.write(str);
		bw.newLine();
		System.out.println("[등록 했습니다.]");
		System.out.println();
		bw.close();
	}

	public static void delete() throws IOException {
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");

		int number = sc.nextInt();
		list.remove(number - 1);

		Writer fw = new FileWriter(FILE);
		BufferedWriter bw = new BufferedWriter(fw);

		String line = "";
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).getName() + "," + list.get(i).getPhone() + "," + list.get(i).getCompany());
			bw.newLine();
		}
		System.out.println("[" + list.get(number - 1).getName() + "(을)를 삭제 했습니다.]");
		System.out.println();
		bw.close();
	}
	
	
	// 검색
	public static void search() {
		System.out.println("<4.검색");
		System.out.print(">이름: ");
		String name = sc.readLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(name))
				list.get(i).showInfo();
		}
		System.out.println();
	}

	// 입력 받기
	static class sc {

		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replace("\\+s", "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		static Long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
