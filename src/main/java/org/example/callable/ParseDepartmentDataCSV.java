package org.example.callable;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class ParseDepartmentDataCSV implements Callable<Map<Integer, String>> {
  private static final int DEPARTMENT_DATA_ID = 0;
  private static final int DEPARTMENT_DATA_NAME = 1;

  private final String filePath;

  public ParseDepartmentDataCSV(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public Map<Integer, String> call() throws Exception {
    FileReader filereader = new FileReader(this.filePath);
    CSVReader csvReader = new CSVReaderBuilder(filereader)
        .withSkipLines(1)
        .build();

    return csvReader
        .readAll()
        .stream()
        .collect(Collectors.toMap(
            (departmentDataEntry) -> Integer.parseInt(departmentDataEntry[DEPARTMENT_DATA_ID]),
            (departmentDataEntry) -> departmentDataEntry[DEPARTMENT_DATA_NAME]));
  }
}
