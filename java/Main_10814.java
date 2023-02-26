import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10814 { // 10814. 나이순 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> p = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(p);
		for (int i = 0; i < p.size(); i++) {
			sb.append(p.get(i).age).append(" ").append(p.get(i).name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

class Person implements Comparable<Person> {
	
	int no; // 가입순서
	int age;
	String name;
	
	public Person(int no, int age, String name) {
		this.no = no;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return this.no - o.no;
		}
		return this.age - o.age;
	}
	
}