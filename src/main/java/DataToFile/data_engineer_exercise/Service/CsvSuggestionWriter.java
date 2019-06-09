package DataToFile.data_engineer_exercise.Service;

import DataToFile.data_engineer_exercise.models.XrefDAO;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@Component
public class CsvSuggestionWriter implements MyWriter{

    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema schema = csvMapper
            .schemaFor(XrefDAO.class)
            .withHeader();

    @Override
    @SneakyThrows
    public void write(@NonNull String fileName, List<XrefDAO> data) {
        Writer writer = new PrintWriter(new FileWriter(fileName));
        doWrite(writer, data);
    }

    @SneakyThrows
    private void doWrite(@NonNull Writer writer, @NonNull List<XrefDAO> data) {
       csvMapper.writer().with(schema).writeValues(writer).writeAll(data);
    }
}
