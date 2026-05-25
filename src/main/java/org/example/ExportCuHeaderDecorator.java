package org.example;

import java.io.FileWriter;
import java.util.List;

public class ExportCuHeaderDecorator {

    // export cu header

    public static void exportCuHeader(
            List<StudentCuNota> lista) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "studenti_header.txt"
                    );


            // scriem headerul

            writer.write(
                    "NUME,PRENUME,FORMATIE\n"
            );


            // scriem studentii

            for (StudentCuNota s : lista) {

                writer.write(
                        s.nume + "," +
                                s.prenume + "," +
                                s.formatieDeStudiu +
                                "\n"
                );
            }


            writer.close();

            System.out.println(
                    "Fisier cu header creat."
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}