package org.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

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
}