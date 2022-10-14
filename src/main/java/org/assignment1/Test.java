package org.assignment1;

import org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        // Create three students for test purposes
        Student student1 = new Student("Conor Naughton", 21, 19489034);
        Student student2 = new Student("Conor Griffin", 18, 18902222);
        Student student3 = new Student("Lisa Smith", 26, 12653479);
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3));

        // Create three lecturers for test purposes
        Lecturer lecturer1 = new Lecturer("Paul Kingston", 43, 16803769);
        Lecturer lecturer2 = new Lecturer("Jack Black", 41, 13254687);
        Lecturer lecturer3 = new Lecturer("Sean Lally", 22, 19475968);
        ArrayList<Lecturer> lecturers = new ArrayList<>(Arrays.asList(lecturer1, lecturer2, lecturer3));

        // Create three modules for test purposes
        Module module1 = new Module("Machine Learning", "CT4101");
        Module module2 = new Module("Geometry", "Ma3101");
        Module module3 = new Module("Computer Systems","CS3215");
        ArrayList<Module> modules = new ArrayList<>(Arrays.asList(module1, module2, module3));

        // Create three course programmes for test purposes
        CourseProgramme courseProgramme1 = new CourseProgramme("BCT1", new ArrayList<>(),new ArrayList<>(), DateTime.parse("2021-09-02"), DateTime.parse("2023-04-30"));
        CourseProgramme courseProgramme2 = new CourseProgramme("ENG1", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2020-08-05"), DateTime.parse("2023-04-30"));
        CourseProgramme courseProgramme3 = new CourseProgramme("BA2", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2022-06-09"), DateTime.parse("2023-04-30"));
        ArrayList<CourseProgramme> courseProgrammes = new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2, courseProgramme3));

        // Add two courses to each student
        student1.setCourses(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme3)));
        student2.setCourses(new ArrayList<>(Arrays.asList(courseProgramme2, courseProgramme3)));
        student3.setCourses(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2)));

        // Add two modules to each student
        student1.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module1, module3)));
        student2.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module2, module3)));
        student3.setModulesRegisteredFor(new ArrayList<>(Arrays.asList(module1, module2)));

        // Add a module to each lecturer
        lecturer1.setModulesTeaching(new ArrayList<>(Arrays.asList(module1)));
        lecturer2.setModulesTeaching(new ArrayList<>(Arrays.asList(module2)));
        lecturer3.setModulesTeaching(new ArrayList<>(Arrays.asList(module3)));

        // Add two students to each module
        module1.setRegisteredStudents(new ArrayList<>(Arrays.asList(student1, student3)));
        module2.setRegisteredStudents(new ArrayList<>(Arrays.asList(student2, student3)));
        module3.setRegisteredStudents(new ArrayList<>(Arrays.asList(student1, student2)));

        // Add a lecturer to each module
        module1.setResponsibleLecturer(lecturer1);
        module2.setResponsibleLecturer(lecturer2);
        module3.setResponsibleLecturer(lecturer3);

        // Add an associated course to each module
        module1.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme3)));
        module2.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme2, courseProgramme3)));
        module3.setAssociatedProgrammes(new ArrayList<>(Arrays.asList(courseProgramme1, courseProgramme2)));

        // Add two students to each course
        courseProgramme1.setEnrolledStudents(new ArrayList<>(Arrays.asList(student1, student3)));
        courseProgramme2.setEnrolledStudents(new ArrayList<>(Arrays.asList(student2, student3)));
        courseProgramme3.setEnrolledStudents(new ArrayList<>(Arrays.asList(student1, student2)));

        // Add two modules to each course
        courseProgramme1.setModules(new ArrayList<>(Arrays.asList(module1, module3)));
        courseProgramme2.setModules(new ArrayList<>(Arrays.asList(module2, module3)));
        courseProgramme3.setModules(new ArrayList<>(Arrays.asList(module1, module2)));

        // Iterate through each Student, displaying details for each
        System.out.println("------------ Student Info ------------");
        for(Student s : students) {
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("ID: " + s.getId());
            System.out.println("Username: " + s.getUsername());
            System.out.println("Courses: ");

            for(CourseProgramme c : s.getCourses()) {
                System.out.println("    - " + c.getCourseName());
            }

            System.out.println("Modules: ");
            for(Module m : s.getModulesRegisteredFor()) {
                System.out.println("    - " + m.getModuleName());
            }

            System.out.println("");
        }

        // Iterate through each Lecturer, displaying details for each
        System.out.println("------------ Lecturer Info ------------");
        for(Lecturer l : lecturers) {
            System.out.println("Name: " + l.getName());
            System.out.println("Age: " + l.getAge());
            System.out.println("ID: " + l.getId());
            System.out.println("Username: " + l.getUsername());

            System.out.println("Modules Teaching: ");
            for(Module m : l.getModulesTeaching()) {
                System.out.println("    - " + m.getModuleName());
            }

            System.out.println("");
        }

        // Iterate through each Module, displaying details for each
        System.out.println("------------ Module Info ------------");
        for(Module m : modules) {
            System.out.println("Name: " + m.getModuleName());
            System.out.println("ID: " + m.getId());
            System.out.println("Responsible Lecturer: " + m.getResponsibleLecturer().getName());

            System.out.println("Registered Students: ");
            for(Student s : m.getRegisteredStudents()) {
                System.out.println("    - " + s.getName());
            }

            System.out.println("Associated Courses: ");
            for(CourseProgramme c : m.getAssociatedProgrammes()) {
                System.out.println("    - " + c.getCourseName());
            }

            System.out.println("");
        }

        // Iterate through each course program, displaying details for each
        System.out.println("------------ Course Programme Info ------------");
        for(CourseProgramme c : courseProgrammes) {
            System.out.println("Name: " + c.getCourseName());
            System.out.println("Academic Start Date: " + c.getAcademicStartDate().toString("yyyy-MM-dd"));
            System.out.println("Acdemic End Date: " + c.getAcademicEndDate().toString("yyyy-MM-dd"));

            System.out.println("List of Modules: ");
            for (Module m : c.getModules()) {
                System.out.println("    - " + m.getModuleName());
            }

            System.out.println("Enrolled Students: ");
            for (Student s : c.getEnrolledStudents()) {
                System.out.println("    - " + s.getName());
            }

            System.out.println("");
        }
    }
}
