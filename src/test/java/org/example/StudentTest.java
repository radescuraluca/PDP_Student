package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    // test equals()

    @Test
    public void testEquals() {

        Student s1 =
                new Student(1,
                        "Ion",
                        "Popescu",
                        "Info");

        Student s2 =
                new Student(99,
                        "Ion",
                        "Popescu",
                        "Info");

        assertEquals(s1, s2);
    }

    // test studentPrezent()

    @Test
    public void testStudentPrezent() {

        ArrayList<Student> lista =
                new ArrayList<>();

        Student s1 =
                new Student(1,
                        "Ion",
                        "Popescu",
                        "Info");

        Student cautat =
                new Student(99,
                        "Ion",
                        "Popescu",
                        "Info");

        lista.add(s1);

        assertTrue(
                cautat.studentPrezent(lista)
        );
    }

    // test sortare

    @Test
    public void testSortByName() {

        ArrayList<Student> lista =
                new ArrayList<>();

        lista.add(
                new Student(1,
                        "Ion",
                        "Zzz",
                        "Info")
        );

        lista.add(
                new Student(2,
                        "Maria",
                        "Aaa",
                        "Info")
        );


        Student.sortByName(lista);


        assertEquals(
                "Aaa",
                lista.get(0).nume
        );
    }

    // test HashMap

    @Test
    public void testNotaStudent() {

        HashMap<Student, Integer> note =
                new HashMap<>();

        Student s1 =
                new Student(1,
                        "Ion",
                        "Popescu",
                        "Info");

        note.put(s1, 10);


        int nota =
                Student.notaStudent(s1, note);


        assertEquals(10, nota);
    }

    // test StudentCuNota

    @Test
    public void testStudentCuNota() {

        StudentCuNota s =
                new StudentCuNota(1,
                        "Ion",
                        "Popescu",
                        "Info",
                        9.5);

        assertEquals(9.5, s.nota);
    }
}