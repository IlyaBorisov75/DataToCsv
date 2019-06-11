package DataToFile.data_engineer_exercise.services;

import DataToFile.data_engineer_exercise.repositories.XrefReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobSchedule {

    private CsvSuggestionWriter csvSuggestionWriter;
    private XrefReposetory xrefReposetory;
    private  String fileName;
    private  Date testDate;

    @Autowired
    public JobSchedule(CsvSuggestionWriter csvSuggestionWriter, XrefReposetory xrefReposetory, String fileName, Date testDate) {
        this.csvSuggestionWriter = csvSuggestionWriter;
        this.xrefReposetory = xrefReposetory;
        this.fileName = fileName;
        this.testDate = testDate;
    }

    @Scheduled(cron = "0 0 0/1 * * *")
    public void saveToCsv(){
        csvSuggestionWriter.write(fileName, xrefReposetory.fiendByTimestampGreaterThan(testDate));
    }
}
