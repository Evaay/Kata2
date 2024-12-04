package es.ulpgc.dis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramGenerator {
    public Map<Title.TitleType, Integer> generate(List<Title> titles) {
        Map<Title.TitleType, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            histogram.put(title.titleType(), histogram.getOrDefault(title.titleType(), 0) + 1);
        }
        return histogram;
    }
}
