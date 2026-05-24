package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // HashSet = fara duplicate + cautare O(1)

        HashSet<Student> studentiSet = new HashSet<>();

        studentiSet.add(
                new Student(1, "Ion", "Popescu", "Info")
        );

        studentiSet.add(
                new Student(99, "Ion", "Popescu", "Info")
        );

        System.out.println("HashSet:");
        System.out.println(studentiSet);



        // ArrayList + studentPrezent()

        ArrayList<Student> lista = new ArrayList<>();

        Student s1 =
                new Student(1, "Ion", "Popescu", "Info");

        Student s2 =
                new Student(2, "Maria", "Ionescu", "Mate");

        lista.add(s1);
        lista.add(s2);


        // student cautat

        Student cautat =
                new Student(99, "Ion", "Popescu", "Info");


        // verificam daca exista in lista

        System.out.println("\nStudent prezent in lista:");
        System.out.println(
                cautat.studentPrezent(lista)
        );


    lista.add(new Student(1, "Ion", "Popescu", "Info"));
    lista.add(new Student(2, "Maria", "Ionescu", "Mate"));
    lista.add(new Student(3, "Alex", "Georgescu", "Info"));

    // sortare dupa nume

     Student.sortByName(lista);
     System.out.println(lista);

    // sortare dupa formatie + nume

     Student.sortStudents(lista);

     System.out.println(lista);

    // scriere in fisier

     Student.outputStudentList(lista);
}}
