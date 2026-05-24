package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu){
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenume, nume, formatieDeStudiu);
        // folosit de HashSet / HashMap
        // trebuie sa foloseasca aceleasi campuri ca equals()
    }

    public boolean equals(Object obj) {

        // daca obiectul NU este Student
        // atunci sigur nu sunt egale
        if (!(obj instanceof Student))
            return false;

        // convertim Object -> Student
        Student s = (Student) obj;

        // comparam campurile importante
        return prenume.equals(s.prenume)
                && nume.equals(s.nume)
                && formatieDeStudiu.equals(s.formatieDeStudiu);
    }

    public boolean studentPrezent(ArrayList<Student> lista) {

        // parcurgem toti studentii din lista
        for (Student s : lista) {

            // verificam daca studentul curent
            // este egal cu studentul care a apelat metoda
            if (this.equals(s))
                return true;
        }

        // daca nu am gasit studentul
        return false;
    }

    @Override
    public String toString (){
        return "Student{" +
                "numarMatricol= " + numarMatricol + "; " +
                "prenume= " + prenume + "; " +
                "nume= " + nume + "; " +
                "formatieDeStudiu= " + formatieDeStudiu +
                '}';
    }


    // sorteaza dupa nume
    public static List<Student> sortByName(List<Student> lista) {

        Collections.sort(lista,
                Comparator.comparing(s -> s.nume));

        return lista;
    }



    // sorteaza dupa formatie + nume
    public static List<Student> sortStudents(List<Student> lista) {

        Collections.sort(lista,
                Comparator.comparing((Student s) -> s.formatieDeStudiu)
                        .thenComparing(s -> s.nume));

        return lista;
    }



    // scrie studentii in fisier
    public static void outputStudentList(List<Student> lista) {

        try {

            FileWriter writer = new FileWriter("output.txt");

            for (Student s : lista) {

                writer.write(
                        s.numarMatricol + "," +
                                s.prenume + "," +
                                s.nume + "," +
                                s.formatieDeStudiu + "\n"
                );
            }

            writer.close();

            System.out.println("Fisier scris cu succes.");

        } catch (IOException e) {

            System.out.println("Eroare la scriere.");
        }


    }

    public static int notaStudent(Student s,
                                  Map<Student, Integer> note) {

        return note.get(s);
    }
}