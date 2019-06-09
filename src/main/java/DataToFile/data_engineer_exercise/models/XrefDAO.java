package DataToFile.data_engineer_exercise.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class XrefDAO {
    public static int id;
    public static String name;
    public static Date date;
}