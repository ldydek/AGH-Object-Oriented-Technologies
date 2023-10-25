package app;

import java.io.IOException;
import java.util.List;

public class CrawlerApp {

    public static final String SCRAPER_API_KEY = "de3a60cdd4c747020ca68e643b5f9180";

    private static final List<String> TOPICS = List.of("Agent Cooper", "Sherlock", "Poirot", "Detective Monk");

    public static void main(String[] args) throws IOException, InterruptedException {
        PhotoCrawler photoCrawler = new PhotoCrawler();
        photoCrawler.resetLibrary();
//        photoCrawler.downloadPhotoExamples();
//        photoCrawler.downloadPhotosForQuery(TOPICS.get(0));
        photoCrawler.downloadPhotosForMultipleQueries(TOPICS);
        Thread.sleep(10000);
    }
}