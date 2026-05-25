package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

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

    public static void salveazaStudentiXlsx(
            ArrayList<StudentCuNota> lista,
            String numeFisier) {

        try {

            XSSFWorkbook workbook =
                    new XSSFWorkbook();

            XSSFSheet sheet =
                    workbook.createSheet("Studenti");


                            // header

                            Row header = sheet.createRow(0);

            header.createCell(0)
                    .setCellValue("NrMatricol");

                            header.createCell(1)
                                    .setCellValue("Prenume");

                                            header.createCell(2)
                                                    .setCellValue("Nume");

                                                            header.createCell(3)
                                                                    .setCellValue("Formatie");

                                                                            header.createCell(4)
                                                                                    .setCellValue("Nota");



                                                                                            // studenti

            int rowNumber = 1;

            for (StudentCuNota s : lista) {

                Row row =
                        sheet.createRow(rowNumber++);

                row.createCell(0)
                        .setCellValue(s.numarMatricol);

                row.createCell(1)
                        .setCellValue(s.prenume);

                row.createCell(2)
                        .setCellValue(s.nume);

                row.createCell(3)
                        .setCellValue(s.formatieDeStudiu);

                row.createCell(4)
                        .setCellValue(s.nota);
            }



            FileOutputStream out =
                    new FileOutputStream(numeFisier);

            workbook.write(out);

            out.close();
            workbook.close();

            System.out.println(
                    "Fisier Excel salvat."
            );

        } catch (Exception e) {

            System.out.println(
                    "Eroare la salvare Excel."
            );
        }
    }

    public static ArrayList<StudentCuNota>
    citesteStudentiXlsx(String numeFisier) {

        ArrayList<StudentCuNota> lista =
                new ArrayList<>();

        try {

            FileInputStream in =
                    new FileInputStream(numeFisier);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(in);

            XSSFSheet sheet =
                    workbook.getSheetAt(0);


            // incepem de la 1
            // ca sa sarim peste header

            for (int i = 1;
                 i <= sheet.getLastRowNum();
                 i++) {

                Row row = sheet.getRow(i);

                int nrMatricol =
                        (int) row.getCell(0)
                                .getNumericCellValue();

                String prenume =
                        row.getCell(1)
                                .getStringCellValue();

                String nume =
                        row.getCell(2)
                                .getStringCellValue();

                String formatie =
                        row.getCell(3)
                                .getStringCellValue();

                double nota =
                        row.getCell(4)
                                .getNumericCellValue();


                StudentCuNota s =
                        new StudentCuNota(
                                nrMatricol,
                                prenume,
                                nume,
                                formatie,
                                nota
                        );

                lista.add(s);
            }

            workbook.close();
            in.close();

        } catch (Exception e) {

            System.out.println(
                    "Eroare la citire Excel."
            );
        }

        return lista;
    }

    public static List<List<StudentCuNota>>
    imparteFormatii(
            List<StudentCuNota> lista) {

        // prima formatie

        List<StudentCuNota> grupa1 =
                new ArrayList<>();


        // a doua formatie

        List<StudentCuNota> grupa2 =
                new ArrayList<>();


        for (int i = 0;
             i < lista.size();
             i++) {

            // prima jumatate a studentilor

            if (i < (lista.size() + 1) / 2) {

                grupa1.add(lista.get(i));
            }

            // a doua jumatate

            else {

                grupa2.add(lista.get(i));
            }
        }


        // lista finala cu cele 2 formatii

        List<List<StudentCuNota>> rezultat =
                new ArrayList<>();

        rezultat.add(grupa1);
        rezultat.add(grupa2);

        return rezultat;
    }

}