import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final File ROOT_DIR = new File("/home/aleksandr/Game");

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        String[] dirs = {"/savegame", "/temp", "/src/main", "/src/test", "/res/drawables",
                "/res/vectors", "/res/icons"};
        String[] files = {"/src/main/Main.java", "/src/main/Utils.java", "/temp/temp.txt"};

        for (int i = 0; i < dirs.length; i++) {
            File dir = new File(ROOT_DIR, dirs[i]);
            if (dir.mkdirs()) {
                sb.append("Директория ").append(dir.getAbsolutePath()).append(" создана\n");
            } else sb.append("Не удалось создать директорию, либо она уже существует\n");
        }

        for (int i = 0; i < files.length; i++) {
            File file = new File(ROOT_DIR, files[i]);
            try {
                if (file.createNewFile())
                    sb.append("Файл ").append(file.getAbsolutePath()).append(" создан\n");

            } catch (IOException e) {
                sb.append(e.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter("/home/aleksandr/Game/temp/temp.txt", true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
