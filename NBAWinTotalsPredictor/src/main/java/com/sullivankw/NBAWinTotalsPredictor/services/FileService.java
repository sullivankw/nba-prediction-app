package com.sullivankw.NBAWinTotalsPredictor.services;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface FileService {

    void extractSeasonSchedules() throws IOException, InvalidFormatException, ParseException;

    void extractRaptorPlayerRatings() throws FileNotFoundException;

    void extractPlayerProjections() throws FileNotFoundException;

    void extractDepthCharts() throws FileNotFoundException;

   String extractAllData() throws ParseException, InvalidFormatException, IOException;
}
