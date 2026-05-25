package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


        // ================= STREAMS / LAMBDA =================


// 1. studenti cu nota 10

        System.out.println("Studenti cu nota 10:");

        listaNote.stream()

                // pastram doar studentii cu nota 10

                .filter(s -> s.nota == 10)

                // afisam fiecare student

                .forEach(System.out::println);




// 2. studenti cu nota sub 5

        System.out.println("\nStudenti cu nota sub 5:");

        listaNote.stream()

                // pastram doar studentii cu nota < 5

                .filter(s -> s.nota < 5)

                // afisam studentii

                .forEach(System.out::println);




// 3. transformam lista
// notele sub 4 devin 4

        System.out.println("\nLista modificata:");


        List<StudentCuNota> listaNoua =

                listaNote.stream()

                        // transformam studentii

                        .map(s -> {

                            // daca nota este sub 4

                            if (s.nota < 4) {

                                // cream student nou cu nota 4

                                return new StudentCuNota(
                                        s.numarMatricol,
                                        s.prenume,
                                        s.nume,
                                        s.formatieDeStudiu,
                                        4
                                );
                            }

                            // altfel ramane neschimbat

                            return s;
                        })

                        // transformam stream -> lista

                        .toList();


// afisam lista noua

        System.out.println(listaNoua);




// 4. calculam suma notelor

        double suma =

                listaNote.stream()

                        // luam doar notele

                        .map(s -> s.nota)

                        // adunam toate notele

                        .reduce(0.0, Double::sum);


        System.out.println("\nSuma notelor:");

        System.out.println(suma);




// 5. calculam media

        double media = suma / listaNote.size();


        System.out.println("\nMedia notelor:");

        System.out.println(media);


// separare in 2 formatii

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

        //C23/2 - 1
        ExportDecorator.exportCuTimp(
                listaNote
        );

        //C23/2 - 2

        Thread threadPicati = new Thread(() -> {

            try {

                java.io.FileWriter writer =
                        new java.io.FileWriter(
                                "studenti_picati.txt"
                        );


                // filtram studentii sub 5

                listaNote.stream()

                        .filter(s -> s.nota < 5)

                        .forEach(s -> {

                            try {

                                writer.write(
                                        s.toString() + "\n"
                                );

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        });


                writer.close();

                System.out.println(
                        "Fisier studenti_picati.txt creat."
                );

            } catch (Exception e) {

                e.printStackTrace();
            }
        });




// thread pentru studenti promovati

        Thread threadPromovati = new Thread(() -> {

            try {

                java.io.FileWriter writer =
                        new java.io.FileWriter(
                                "studenti_promovati.txt"
                        );


                // filtram studentii >= 5

                listaNote.stream()

                        .filter(s -> s.nota >= 5)

                        .forEach(s -> {

                            try {

                                writer.write(
                                        s.toString() + "\n"
                                );

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        });


                writer.close();

                System.out.println(
                        "Fisier studenti_promovati.txt creat."
                );

            } catch (Exception e) {

                e.printStackTrace();
            }
        });

// pornim threadurile

        threadPicati.start();

        threadPromovati.start();



        //C23/1 - ex 1
        ExportCuHeaderDecorator.exportCuHeader(
                listaNote
        );

        ///C23/1 - ex 2

        // ================= CITIRE PARALELA CSV + XLSX =================


// colectia comuna

        ArrayList<Object> FStudenti =
                new ArrayList<>();




// thread pentru CSV

        Thread tCitire1 = new Thread(() -> {

            ArrayList<Student> studentiCsv =

                    Student.citesteStudentiCsv(
                            "output.txt"
                    );


            // adaugam sincronizat

            synchronized (FStudenti) {

                FStudenti.addAll(studentiCsv);
            }

            System.out.println(
                    "Fisier CSV citit."
            );
        });




// thread pentru XLSX

        Thread tCitire2 = new Thread(() -> {

            ArrayList<StudentCuNota> studentiXlsx =

                    StudentCuNota.citesteStudentiXlsx(
                            "studenti.xlsx"
                    );


            synchronized (FStudenti) {

                FStudenti.addAll(studentiXlsx);
            }

            System.out.println(
                    "Fisier XLSX citit."
            );
        });




// pornim threadurile

        tCitire1.start();

        tCitire2.start();




// asteptam terminarea lor

        try {

            tCitire1.join();

            tCitire2.join();

        } catch (Exception e) {

            e.printStackTrace();
        }




// afisam colectia finala

        System.out.println(
                "\nColectie finala:"
        );

        System.out.println(FStudenti);

    }


}