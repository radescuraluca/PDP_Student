package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentCuNota extends Student {

    // camp nou
    double nota;

    // constructor

    public StudentCuNota(int numarMatricol,
                         String prenume,
                         String nume,
                         String formatieDeStudiu,
                         double nota) {

        // apelam constructorul din Student
        super(numarMatricol,
                prenume,
                nume,
                formatieDeStudiu);

        this.nota = nota;
    }

    // afisare obiect

    @Override
    public String toString() {

        return "StudentCuNota{" +
                "numarMatricol = " + numarMatricol + "; " +
                "prenume = " + prenume + "; " +
                "nume = " + nume + "; " +
                "formatieDeStudiu = " + formatieDeStudiu + "; " +
                "nota = " + nota +
                '}';
    }



    // scriere lista in fisier

    public static void outputStudentCuNota(
            List<StudentCuNota> lista) {

        try {

            FileWriter writer =
                    new FileWriter("studenti_note.txt");

            for (StudentCuNota s : lista) {

                writer.write(
                        s.numarMatricol + "," +
                                s.prenume + "," +
                                s.nume + "," +
                                s.formatieDeStudiu + "," +
                                s.nota + "\n"
                );
            }

            writer.close();

            System.out.println(
                    "Fisier studenti_note.txt scris."
            );

        } catch (IOException e) {

            System.out.println(
                    "Eroare la scriere."
            );
        }
    }
}