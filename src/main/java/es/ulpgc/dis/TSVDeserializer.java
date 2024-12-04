package es.ulpgc.dis;

import java.util.ArrayList;
import java.util.List;

public class TSVDeserializer implements Deserializer{
    @Override
    public Title deserialize(String line) {
        String[] fields = line.split("\t");
        return new Title(fields[0],
                toTitleType(fields[1]),
                fields[2],
                fields[3],
                toBoolean(fields[4]),
                toGenres(fields[8]));
    }

    private List<Title.Genres> toGenres(String field) {
        if (field.equals("\\N")) return null;
        List<Title.Genres> genresResult = new ArrayList<>();
        String[] fields = field.split(",");
        for (String s : fields) {
            genresResult.add(Title.Genres.valueOf((s)));
        }
        return genresResult;
    }

    private boolean toBoolean(String field) {
        return field.equals("1");
    }

    private Title.TitleType toTitleType(String field) {
        return Title.TitleType.valueOf(toCapitalize(field));
    }

    private String toCapitalize(String field) {
        return field.toUpperCase().charAt(0) + field.substring(1);
    }
}
