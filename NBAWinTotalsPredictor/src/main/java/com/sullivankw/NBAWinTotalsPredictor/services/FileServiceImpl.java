package com.sullivankw.NBAWinTotalsPredictor.services;

import com.sullivankw.NBAWinTotalsPredictor.FileType;
import com.sullivankw.NBAWinTotalsPredictor.Location;
import com.sullivankw.NBAWinTotalsPredictor.Team;
import com.sullivankw.NBAWinTotalsPredictor.entities.FiveThirtyEightRaptorPlayerRating;
import com.sullivankw.NBAWinTotalsPredictor.entities.PlayerProjections;
import com.sullivankw.NBAWinTotalsPredictor.entities.PlayerRotationRanking;
import com.sullivankw.NBAWinTotalsPredictor.entities.TeamSchedule;
import com.sullivankw.NBAWinTotalsPredictor.repos.FiveThirtyEightRaptorPlayerRatingRepo;
import com.sullivankw.NBAWinTotalsPredictor.repos.PlayerProjectionsRepo;
import com.sullivankw.NBAWinTotalsPredictor.repos.PlayerRotationRankingRepo;
import com.sullivankw.NBAWinTotalsPredictor.repos.TeamScheduleRepo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private TeamScheduleRepo teamScheduleRepo;

    @Autowired
    private FiveThirtyEightRaptorPlayerRatingRepo fiveThirtyEightRaptorPlayerRatingRepo;

    @Autowired
    private PlayerRotationRankingRepo playerRotationRankingRepo;

    @Autowired
    private PlayerProjectionsRepo playerProjectionsRepo;

    @Override
    public String extractAllData() throws ParseException, InvalidFormatException, IOException {
        try {
            extractSeasonSchedules();
            extractRaptorPlayerRatings();
            extractPlayerProjections();
            extractDepthCharts();
            return "SUCCESS";
        } catch (Exception e) {
            return "FAILED";
        }

    }

    @Override
    public void extractSeasonSchedules() throws IOException, InvalidFormatException, ParseException {

        File file = ResourceUtils.getFile("classpath:NBA-2019-2020.xls");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        for(Team team : Team.getTeams()) {
            int cellPosition = getTeamCellPosition(sheet, dataFormatter, team);
            getTeamSchedule(sheet, dataFormatter, team, cellPosition);

        }
    }

    @Override
    public void extractRaptorPlayerRatings() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:modern_RAPTOR_by_team.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean readFile = true;

        try {

            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int counter = 0;
            while (readFile) {
                try {
                    if (!((line = br.readLine()) != null))
                        readFile = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (counter > 0) {
                    String[] row = line.split(cvsSplitBy);
                    insertPlayerIntoDB(row, FileType.CSV_PLAYER_RATINGS);

                }

                counter++;

            }
        } catch (Exception e) {

        }

    }

    @Override
    public void extractPlayerProjections() throws FileNotFoundException {
        //reads from the file i am creating
        //2020_reg_season_war_projections_per_82.csv
        File file = ResourceUtils.getFile("classpath:2020_reg_season_war_projections_per_82.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean readFile = true;

        try {

            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int counter = 0;
            while (readFile) {
                try {
                    if (!((line = br.readLine()) != null))
                        readFile = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (counter > 0) {
                    String[] row = line.split(cvsSplitBy);
                    PlayerProjections playerProjections = new PlayerProjections(row);
                    playerProjectionsRepo.save(playerProjections);
                }
                counter++;
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void extractDepthCharts() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:depth_charts.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        boolean readFile = true;
        boolean nextLineIsTeam = false;
        String team = "";

        try {

            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int counter = 0;
            while (readFile) {
                try {
                    if (!((line = br.readLine()) != null))
                        readFile = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (counter > 0) {
                    String[] row = line.split(cvsSplitBy);
                    PlayerRotationRanking playerRotationRanking = null;
                    for (String value : row) {
                        if (value.equalsIgnoreCase("START")) {
                            //then we want the team name from next line
                            nextLineIsTeam = true;
                            continue;
                        }
                        if (nextLineIsTeam) {
                            team = value;
                            nextLineIsTeam = false;
                            continue;
                        }
                        playerRotationRanking = new PlayerRotationRanking(Team.getEnumByName(team), row);
                        playerRotationRankingRepo.save(playerRotationRanking);
                        break;
                    }
                }
                counter++;
            }
        } catch (Exception e) {

        }

    }

    private void insertPlayerIntoDB(String[] row, FileType type) {
        FiveThirtyEightRaptorPlayerRating player = new FiveThirtyEightRaptorPlayerRating(row, type);
        fiveThirtyEightRaptorPlayerRatingRepo.save(player);
    }

    private void getTeamSchedule(Sheet sheet, DataFormatter dataFormatter, Team team, int cellPosition) throws ParseException {
        Location loc = null;
        String cleanedOpponent, cleanedGameTime, opponent, gameTime, cleanedOpponentNoAts = "";
        char firstCharOfDate = '9';
        char secondCharOfDate = '9';
        for (Row row : sheet) {
            gameTime = dataFormatter.formatCellValue(row.getCell(0)).replace("/", "-");
            cleanedGameTime = gameTime.trim().toUpperCase().substring(3, gameTime.length());
            opponent = dataFormatter.formatCellValue(row.getCell(cellPosition));
            cleanedOpponent = opponent.trim().toUpperCase();
            if (cleanedOpponent.equalsIgnoreCase("@ NY")) {
                cleanedOpponent = "@ NYK";
            } else if (cleanedOpponent.equalsIgnoreCase("@ UTH")) {
                cleanedOpponent = "@ UTA";
            } else if (cleanedOpponent.equalsIgnoreCase("@ SA")) {
                cleanedOpponent = "@ SAS";
            } else if (cleanedOpponent.equalsIgnoreCase("@ NOR")) {
                cleanedOpponent = "@ NOP";
            }

            if (gameTime.equalsIgnoreCase("DATE")) {
                continue;
            }

            firstCharOfDate = cleanedGameTime.charAt(0);
            secondCharOfDate = cleanedGameTime.charAt(1);
              switch (firstCharOfDate) {
                  case '1' :
                      if (secondCharOfDate == '-') {
                          cleanedGameTime = "0" + cleanedGameTime + "-2020";
                      } else {
                          cleanedGameTime = cleanedGameTime + "-2019";
                      }
                      break;
                  case '2' :
                      cleanedGameTime = "0" + cleanedGameTime + "-2020";
                      break;
                  case '3' :
                      cleanedGameTime = "0" + cleanedGameTime + "-2020";
                      break;
                  case '4' :
                      cleanedGameTime = "0" + cleanedGameTime + "-2020";
                      break;

                      default:
                      cleanedGameTime = cleanedGameTime + "-2019";
                      break;

            }

            System.out.println(cleanedGameTime + " " + cleanedOpponent);
            TeamSchedule teamSchedule = new TeamSchedule();
            teamSchedule.setTeam(team);

            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
            Date date = sdf1.parse(cleanedGameTime);
            teamSchedule.setGameTime(date);
            teamSchedule.setOpponent(cleanedOpponent);
            teamScheduleRepo.save(teamSchedule);
        }

    }

    private int getTeamCellPosition(Sheet sheet, DataFormatter dataFormatter, Team team) {
        String excelTeamNameVersion = Team.getAlternativeTeamAbbrev(team);
        String teamNameToCheck;
        if (StringUtils.isEmpty(excelTeamNameVersion)) {
            teamNameToCheck = team.name();
        } else {
            teamNameToCheck = excelTeamNameVersion;
        }
        int cellCount = 0;
        String cellValue = null;
        for (Cell cell : sheet.getRow(0)) {
            cellValue = dataFormatter.formatCellValue(cell);
            if (cellValue.equalsIgnoreCase(teamNameToCheck)) {
                break;
            }
            cellCount++;
        }
        return cellCount;
    }
}
