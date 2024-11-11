package es.ulpgc.dis;

import java.util.List;

public record Title(String id, es.ulpgc.dis.Title.TitleType titleType, String primaryTitle, String originalTitle,
                    boolean isAdult, List<Genres> genres) {

    public enum TitleType {
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode
    }

    public enum Genres {
        Action, Adult, Adventure, Animation, Biography, Comedy, Crime, Documentary, Drama, Family, Fantasy, FilmNoir, GameShow, genres, History, Horror, Music, Musical, Mystery, News, RealityTV, Romance, SciFi, Short, Sport, TalkShow, Thriller, War, Western
    }
}
