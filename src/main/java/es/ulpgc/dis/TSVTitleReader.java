package es.ulpgc.dis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TSVTitleReader implements  TitleReader{
    private final File file;

    public TSVTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            readHeader(reader);
            List<Title> titles = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                Title title = new TSVDeserializer().deserialize(line);
                titles.add(title);
            }
            return titles;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
