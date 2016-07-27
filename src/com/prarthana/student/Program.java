/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.student;

import com.prarthana.student.dao.StudentDAO;
import com.prarthana.student.dao.impl.StudentDAOImpl;
import com.prarthana.student.stud.Student;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        StudentDAO studDAO = new StudentDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("STUDENT RECORD MENU");
            System.out.println("........................................");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student By ID");
            System.out.println("3. Show all Student");
            System.out.println("4. Search Student By ID");
            System.out.println("5. Exit");
            System.out.println("Enter your choice[1-5]:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add Student");
                    Student s = new Student();
                    System.out.println("Enter ID: ");
                    s.setId(sc.nextInt());
                    System.out.println("Enter RollNumber: ");
                    s.setRoll(sc.nextInt());
                    System.out.println("Enter Name: ");
                    s.setName(sc.next());
                    System.out.println("Enter Faculty: ");
                    s.setFaculty(sc.next());
                    System.out.println("Enter Address: ");
                    s.setAddress(sc.next());
                    System.out.println("Enter Status: ");
                    s.setStatus(sc.nextBoolean());

                    if (studDAO.insert(s)) {
                        System.out.println("Inserted Successfully!!");
                    } else {
                        System.out.println("Can't add more Students. Data Full!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the ID of the student you want to delete: ");
                    int idd = sc.nextInt();
                    if (studDAO.delete(idd)) {
                        System.out.println("The student with ID no. :" + idd + " is deleted successfully.");
                    } else {
                        System.out.println("ID not found.");
                    }

                    break;
                case 3:
                    System.out.println("Students Enrolled");
                    System.out.println(".................................");
                    Student[] students = studDAO.getAll();
                    for (int i = 0; i < students.length; i++) {
                        Student student = students[i];
                        if (student != null) {
                            System.out.println("ID = " + student.getId());
                            System.out.println("RollNumber = " + student.getRoll());
                            System.out.println("Name = " + student.getName());
                            System.out.println("Fcaulty = " + student.getFaculty());
                            System.out.println("Address = " + student.getAddress());
                            System.out.println("Status = " + student.isStatus());

                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID of the student you want to search: ");
                    int id = sc.nextInt();
                    Student st = studDAO.getById(id);

                    System.out.println("ID = " + st.getId());
                    System.out.println("NAME = " + st.getName());
                    System.out.println("ROLL NUMBER = " + st.getRoll());
                    System.out.println("ADDRESS = " + st.getAddress());
                    System.out.println("FACULTY = " + st.getFaculty());

                    break;
                case 5:
                    System.out.println("Do you really want to exit [Y/N]");
                    if (sc.next().equalsIgnoreCase("y")) {
                        System.out.println("Thankyou, Visit Again.");
                        System.exit(0);
                    }
                    System.exit(0);
                    break;

            }

        }
    }

}
