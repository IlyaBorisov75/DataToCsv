package DataToFile.data_engineer_exercise.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class XrefDAO {
    public String id;
    public String name;
    public Date date;
}