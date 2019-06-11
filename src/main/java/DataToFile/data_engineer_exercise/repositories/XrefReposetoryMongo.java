package DataToFile.data_engineer_exercise.repositories;

import DataToFile.data_engineer_exercise.models.XrefDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface XrefReposetoryMongo extends CrudRepository<XrefDAO, String> {
    List<XrefDAO> fiendByTimestampGreaterThan(Date timestamp);
}
