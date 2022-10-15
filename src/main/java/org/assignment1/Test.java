package org.assignment1;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Here we create some students to be used for test purposes
        var student1 = new Student("Conor Naughton", 21, 19489034);
        var student2 = new Student("Conor Griffin", 18, 18902222);
        var student3 = new Student("Lisa Smith", 26, 12653479);
        var students = new ArrayList<>(Arrays.asList(student1, student2, student3));

        // Creating lecturers...
        var lecturer1 = new Lecturer("Paul Kingston", 43, 16803769);
        var lecturer2 = new Lecturer("Jack Black", 41, 13254687);
        var lecturer3 = new Lecturer("Sean Lally", 22, 19475968);
        var lecturers = new ArrayList<>(Arrays.asList(lecturer1, lecturer2, lecturer3));

        // Creating modules...
        var module1 = new Module("Machine Learning", "CT4101");
        var module2 = new Module("Geometry", "Ma3101");
        var module3 = new Module("Computer Systems", "CS3215");
        var modules = new ArrayList<>(Arrays.asList(module1, module2, module3));

        // Creating Course Programmes...
        var courseProgramme1 = new CourseProgramme("BCT1", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2021-09-02"), DateTime.parse("2022-03-17"));
        var courseProgramme2 = new CourseProgramme("ENG1", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2020-08-05"), DateTime.parse("2021-01-29"));
        var courseProgramme3 = new CourseProgramme("BA2", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-06-09"), DateTime.parse("2023-05-05"));
        var courseProgrammes = new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2, courseProgramme3));

        //Here we are adding 2 course choices for each student...
        student1.setCourses(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme3)));
        student2.setCourses(new ArrayList<>(Arrays.asList(courseProgramme2, courseProgramme3)));
        student3.setCourses(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2)));

        //Here we are adding 2 Modules for each student...
        student1.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module1, module3)));
        student2.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module2, module3)));
        student3.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module1, module2)));

        // We assign a module for each lecturer to teach...
        lecturer1.setModulesTeaching(new ArrayList<>(List.of(module1)));
        lecturer2.setModulesTeaching(new ArrayList<>(List.of(module2)));
        lecturer3.setModulesTeaching(new ArrayList<>(List.of(module3)));

        // Assigning 2 different students to each module...
        module1.setRegisteredStudents(new ArrayList<>(Arrays.asList(student1, student3)));
        module2.setRegisteredStudents(new ArrayList<>(Arrays.asList(student2, student3)));
        module3.setRegisteredStudents(new ArrayList<>(Arrays.asList(student1, student2)));

        // Adding lecturer to every module...
        module1.setResponsibleLecturer(lecturer1);
        module2.setResponsibleLecturer(lecturer2);
        module3.setResponsibleLecturer(lecturer3);

        // Linking a course to a module...
        module1.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2)));
        module2.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme2, courseProgramme3)));
        module3.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme3)));

        // Adding multiple students to each course...
        courseProgramme1.setEnrolledStudents(new ArrayList<>(Arrays.asList(student1, student2)));
        courseProgramme2.setEnrolledStudents(new ArrayList<>(Arrays.asList(student2, student3)));
        courseProgramme3.setEnrolledStudents(new ArrayList<>(Arrays.asList(student1, student3)));

        // Adding multiple modules to each course...
        courseProgramme1.setModules(new ArrayList<>(Arrays.asList(module1, module2)));
        courseProgramme2.setModules(new ArrayList<>(Arrays.asList(module2, module3)));
        courseProgramme3.setModules(new ArrayList<>(Arrays.asList(module1, module3)));

        // Each Students Information is printed out in console
        System.out.println("********** Student Information **********");
        for (Student s : students) {
            for (String s1 : Arrays.asList("Name: " + s.getName(), "Age: " + s.getAge(), "ID: " + s.getId(), "Username: " + s.getUsername(), "Courses: ")) {
                System.out.println(s1);
            }

            for (var c : s.getCourses()) {
                System.out.printf("    - %s%n", c.getCourseName());
            }

            System.out.println("Modules: ");
            for (var m : s.getModulesRegisteredFor()) {
                System.out.printf("    - %s%n", m.getModuleName());
            }

        }

        // Each Lecturers Information is printed out in console
        System.out.println("********** Lecturer Information **********");
        for (Lecturer l : lecturers) {
            for (String s : Arrays.asList("Name: " + l.getName(), "Age: " + l.getAge(), "ID: " + l.getId(), "Username: " + l.getUsername(), "Modules Teaching: ")) {
                System.out.println(s);
            }

            for (Module m : l.getModulesTeaching()) {
                System.out.println("    - " + m.getModuleName());
            }

            System.out.println();
        }

        // Each Modules Information is printed out in console
        System.out.println("********** Module Information **********");
        for (Module m : modules) {
            for (String s1 : Arrays.asList("Name: " + m.getModuleName(), "ID: " + m.getId(), "Responsible Lecturer: " + m.getResponsibleLecturer().getName(), "Registered Students: ")) {
                System.out.println(s1);
            }

            for (Student s : m.getRegisteredStudents()) {
                System.out.println("    - " + s.getName());
            }

            System.out.println("Associated Courses: ");
            for (CourseProgramme c : m.getAssociatedProgrammes()) {
                System.out.println("    - " + c.getCourseName());
            }

            System.out.println();
        }

        // Each Course Programme's Information is printed out in console
        System.out.println("********** Course-Programme Information **********");
        for (CourseProgramme c : courseProgrammes) {
            for (String s1 : Arrays.asList("Name: " + c.getCourseName(), "Academic Start Date: " + c.getAcademicStartDate().toString("yyyy-MM-dd"), "Acdemic End Date: " + c.getAcademicEndDate().toString("yyyy-MM-dd"), "List of Modules: ")) {
                System.out.println(s1);
            }

            for (Module m : c.getModules()) {
                System.out.println("    - " + m.getModuleName());
            }

            System.out.println("Enrolled Students: ");
            for (Student s : c.getEnrolledStudents()) {
                System.out.println("    - " + s.getName());
            }

            System.out.println();
        }
    }
}
