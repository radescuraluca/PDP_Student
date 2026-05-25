package org.example;

public class ExportDecorator {

    // metoda care masoara timpul

    public static void exportCuTimp(
            java.util.List<StudentCuNota> lista) {

        // timpul de start

        long start =
                System.currentTimeMillis();


        // apelam exportul existent

        StudentCuNota.outputStudentCuNota(
                lista
        );


        // timpul de final

        long finish =
                System.currentTimeMillis();


        // diferenta

        long durata =
                finish - start;


        System.out.println(
                "Exportul a durat: "
                        + durata +
                        " ms"
        );
    }
}