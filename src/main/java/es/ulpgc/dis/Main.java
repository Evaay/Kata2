package es.ulpgc.dis;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File(".\\src\\main\\resources\\title.basics.tsv");
        List<Title> titles = new TSVTitleReader(file).read();
        Map<Title.TitleType, Integer> histogram = new HistogramGenerator().generate(titles);
        printHistogram(histogram);
    }

    private static void printHistogram(Map<Title.TitleType, Integer> histogram) {
        for (Title.TitleType titleType : histogram.keySet()) {
            System.out.println(titleType + ": " + histogram.get(titleType));
        }
    }
}
