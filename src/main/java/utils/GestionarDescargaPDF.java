package utils;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class GestionarDescargaPDF {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GestionarDescargaPDF.class);

    private static final String RUTA_FILE ="src/test/resources/folderDescarga";

    public static boolean waitForDownload() {
        int timeoutInSeconds = 60;
        File dir = new File(RUTA_FILE);
        int elapsedSeconds = 0;
        int i = 1;
        while (elapsedSeconds < timeoutInSeconds) {
            File[] parquetFiles = dir.listFiles((d, name) -> name.contains("Presentación a la Ciudadania") &&name.endsWith(".pdf") && !name.endsWith(".crdownload") && !name.endsWith(".part"));
            if (parquetFiles != null && parquetFiles.length > 0) {
                return true;
            }
            try {
                Thread.sleep(1000);
                elapsedSeconds++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            log.info("Intento numero: {} de encontrar el archivo", i);
            i ++;
        }
        return false;
    }

    public static void limpiarFolder() throws IOException {
        Path folderPath = Paths.get(RUTA_FILE);

        if (Files.exists(folderPath) && Files.isDirectory(folderPath)) {

            try (Stream<Path> paths = Files.walk(folderPath)) {
                paths
                        .filter(path -> !path.equals(folderPath))
                        .sorted(Comparator.reverseOrder())
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                log.error("Error al eliminar: {} - {}", path, e.getMessage());
                            }
                        });
            }
        } else {
            log.info("La carpeta especificada no existe o no es una carpeta.");
        }
    }
}
