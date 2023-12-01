package logic;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileData {

    public void writeFile(String lastScore, String highestScore) {
        try {
            // Obtener la ruta del escritorio del usuario
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

            // Crear una nueva carpeta en el escritorio
            Path folderPath = Paths.get(desktopPath, "ScoreFolder");
            Files.createDirectories(folderPath);

            // Crear el archivo score.txt dentro de la carpeta en el escritorio
            Path filePath = folderPath.resolve("score.txt");

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                // Escribir el contenido en el archivo
                bufferedWriter.write(lastScore);
                bufferedWriter.newLine();
                bufferedWriter.write(highestScore);
            }

            // Imprimir la ruta del archivo creado
            System.out.println("Archivo creado en: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] readFile() {
        String[] data = new String[2];
        try {
            // Obtener la ruta del escritorio del usuario
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

            // Obtener la ruta del archivo score.txt en la carpeta en el escritorio
            Path filePath = Paths.get(desktopPath, "ScoreFolder", "score.txt");

            // Verificar si el archivo existe
            if (!Files.exists(filePath)) {
                // Si el archivo no existe, escribe uno nuevo con valores 0
                writeFile("0","0");
                return data;
            }

            // Leer el archivo después de asegurarse de que existe
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()))) {
                String lastScore = bufferedReader.readLine(); // Leer la primera línea (lastScore)
                String highestScore = bufferedReader.readLine(); // Leer la segunda línea (highestScore)

                // Guardar las variables en un array para devolverlas
                data[0] = lastScore != null ? lastScore : "0";
                data[1] = highestScore != null ? highestScore : "0";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
