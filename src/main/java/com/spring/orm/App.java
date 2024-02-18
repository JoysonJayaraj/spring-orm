package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Program Started...");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		System.out.println(studentDao);

//		Student student = new Student(2324, "Durgesh Tiwari", "Lucknow");
//		int result = studentDao.insert(student);
//		System.out.println("Done : " + result);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("1. Add new Student");
			System.out.println("2. Display all Students");
			System.out.println("3. To get Single Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Update Student");
			System.out.println("6. Exit");

			try {
				int input = Integer.parseInt(bufferedReader.readLine());
				switch (input) {
				case 1:
					// add new student
					Student student = new Student(123, "John", "Bangalore");
					int result = studentDao.insert(student);
					System.out.println(result + " insertion successful");
					break;
				case 2:
					// get all students
					List<Student> students = studentDao.getAllStudents();
					students.forEach(r -> System.out.println(r));
					break;
				case 3:
					// get single student
					Student stud = studentDao.getStudent(123);
					System.out.println(stud);
					break;
				case 4:
					// delete single student
					studentDao.deleteStudent(123);
					System.out.println("Successful");
					break;
				case 5:
					// update single student
					Student s = new Student();
					s.setStudentId(123);
					s.setStudentName("Jonna");
					s.setCityName("Mangalore");

					studentDao.updateStudent(s);
					System.out.println("Successful");
					break;
				case 6:
					// exit
					go = false;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input , try with another one...!");
			}
		}
		System.out.println("Thank you for using my application");
		System.out.println("See you soon");
	}
}
