package DataToFile.data_engineer_exercise.persistence;

import DataToFile.data_engineer_exercise.models.XrefDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface XrefReposetory extends MongoRepository<XrefDAO, String> {
    List<XrefDAO> fiendByTimestampGreaterThan(Date date);
}
