package DataToFile.data_engineer_exercise.services;

import DataToFile.data_engineer_exercise.repositories.XrefReposetoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobSchedule {

    private CsvSuggestionWriter csvSuggestionWriter;
    private XrefReposetoryMongo xrefReposetoryMongo;
    private  String fileName;
    private  Date testDate;

    @Autowired
    public JobSchedule(CsvSuggestionWriter csvSuggestionWriter, XrefReposetoryMongo xrefReposetoryMongo, String fileName, Date testDate) {
        this.csvSuggestionWriter = csvSuggestionWriter;
        this.xrefReposetoryMongo = xrefReposetoryMongo;
        this.fileName = fileName;
        this.testDate = testDate;
    }

    @Scheduled(cron = "0 0 0/1 * * *")
    public void saveToCsv(){
        csvSuggestionWriter.write(fileName, xrefReposetoryMongo.fiendByTimestampGreaterThan(testDate));
    }
}
