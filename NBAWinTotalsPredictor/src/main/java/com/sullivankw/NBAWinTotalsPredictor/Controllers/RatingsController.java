package com.sullivankw.NBAWinTotalsPredictor.Controllers;

import com.sullivankw.NBAWinTotalsPredictor.services.FileService;
import com.sullivankw.NBAWinTotalsPredictor.services.ProjectionsService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping(value="/ratings")
public class RatingsController {

    @Autowired
    private ProjectionsService projectionsService;

    @Autowired
    private FileService fileService;

    @GetMapping(value="/wins/{team}")
    public int getProjectedWinTotal(@PathVariable String team) {
        return projectionsService.getWinsByTeam(team);
    }

    @GetMapping(value="/load")
    public String loadData() throws ParseException, InvalidFormatException, IOException {
        return fileService.extractAllData();
    }


}
