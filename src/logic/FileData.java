package logic;

import java.io.*;

public class FileData {
    private String nombreArchivo = "src/logic/score.txt";
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    public void writeFile(String lastScore,String highestScore ){
        try {
            // Crear un FileWriter (abrir el archivo para escritura)
            fileWriter = new FileWriter(nombreArchivo);

            // Crear un BufferedWriter para escribir datos de forma más eficiente
            bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir el contenido en el archivo
            bufferedWriter.write(lastScore);
            bufferedWriter.newLine();
            bufferedWriter.write(highestScore);

            // Cerrar el BufferedWriter (esto también cierra el FileWriter)
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] readFile() {
        String[] data = new String[2];
        try {
            // Crear un FileReader (abrir el archivo para lectura)
            FileReader fileReader = new FileReader(nombreArchivo);

            // Crear un BufferedReader para leer datos de forma más eficiente
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String lastScore = bufferedReader.readLine(); // Leer la primera línea (lastScore)
            String highestScore = bufferedReader.readLine(); // Leer la segunda línea (highestScore)

            // Cerrar el BufferedReader
            bufferedReader.close();

            // guarda las variables en un array para devolverlas
            data[0] = lastScore;
            data[1] = highestScore;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
