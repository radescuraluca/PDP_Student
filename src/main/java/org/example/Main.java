package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // HashSet + studentPrezent()
        HashSet<Student> studentiSet = new HashSet<>();

        studentiSet.add(
                new Student(1, "Ion", "Popescu", "Info")
        );

        studentiSet.add(
                new Student(99, "Ion", "Popescu", "Info")
        );

        System.out.println("HashSet:");
        System.out.println(studentiSet);



        ArrayList<Student> listaStudenti =
                new ArrayList<>();

        Student s1 =
                new Student(1, "Ion", "Popescu", "Info");

        Student s2 =
                new Student(2, "Maria", "Ionescu", "Mate");

        listaStudenti.add(s1);
        listaStudenti.add(s2);


        Student cautat =
                new Student(99, "Ion", "Popescu", "Info");

        System.out.println(
                "\nStudent prezent:"
        );

        System.out.println(
                cautat.studentPrezent(listaStudenti)
        );



        // sortari + output fisier
        ArrayList<Student> listaSortare =
                new ArrayList<>();

        listaSortare.add(
                new Student(1, "Ion", "Popescu", "Info")
        );

        listaSortare.add(
                new Student(2, "Maria", "Ionescu", "Mate")
        );

        listaSortare.add(
                new Student(3, "Alex", "Georgescu", "Info")
        );


        Student.sortByName(listaSortare);

        System.out.println(
                "\nSortare dupa nume:"
        );

        System.out.println(listaSortare);


        Student.sortStudents(listaSortare);

        System.out.println(
                "\nSortare dupa formatie + nume:"
        );

        System.out.println(listaSortare);


        Student.outputStudentList(listaSortare);

        // Map<Student, Integer>
        Map<Student, Integer> note =
                new HashMap<>();

        Student s3 =
                new Student(3, "Alex", "Georgescu", "Info");

        Student s4 =
                new Student(4, "Maria", "Ionescu", "Mate");


        note.put(s3, 10);
        note.put(s4, 8);


        System.out.println(
                "\nNota student:"
        );

        System.out.println(
                Student.notaStudent(s3, note)
        );

        // StudentCuNota
        ArrayList<StudentCuNota> listaNote =
                new ArrayList<>();

        listaNote.add(
                new StudentCuNota(
                        1,
                        "Ion",
                        "Popescu",
                        "Info",
                        10
                )
        );

        listaNote.add(
                new StudentCuNota(
                        2,
                        "Maria",
                        "Ionescu",
                        "Mate",
                        8.5
                )
        );


        System.out.println(
                "\nStudenti cu note:"
        );

        System.out.println(listaNote);


        StudentCuNota.outputStudentCuNota(
                listaNote
        );



        StudentCuNota.salveazaStudentiXlsx(
                listaNote,
                "studenti.xlsx"
        );


        ArrayList<StudentCuNota> cititi =
                StudentCuNota.citesteStudentiXlsx(
                        "studenti.xlsx"
                );


        System.out.println(cititi);

        List<List<StudentCuNota>> formatii =
                StudentCuNota.imparteFormatii(
                        listaNote
                );


// afisam prima formatie

        System.out.println("Formatia 1:");

        System.out.println(
                formatii.get(0)
        );


// afisam a doua formatie

        System.out.println("Formatia 2:");

        System.out.println(
                formatii.get(1)
        );
    }
}