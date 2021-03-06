package ru.gorobets24.covid.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.gorobets24.covid.models.LocationCases;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService {

    private static String COVID_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationCases> allStats = new ArrayList<>();

    public List<LocationCases> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public void extractCovidData() throws IOException, InterruptedException {
        List<LocationCases> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COVID_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationCases locationCase = new LocationCases();
            locationCase.setState(record.get("Province/State"));
            locationCase.setCountry(record.get("Country/Region"));
            locationCase.setLatestCasesTotal(Integer.parseInt(record.get(record.size() - 1)));
            locationCase.setNewLocalCases((Integer.parseInt(record.get(record.size() - 1))) -(Integer.parseInt(record.get(record.size() - 2))));
            newStats.add(locationCase);
        }
        this.allStats = newStats;
    }
}
