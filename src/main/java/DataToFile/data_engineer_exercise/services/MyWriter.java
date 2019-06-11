package DataToFile.data_engineer_exercise.services;

import DataToFile.data_engineer_exercise.models.XrefDAO;
import lombok.NonNull;

import java.util.List;

public interface MyWriter {

    public void write(@NonNull String fileName, List<XrefDAO> data);
}
