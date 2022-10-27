package org.example.callable;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.dto.EmployeeDataEntryDTO;

import java.io.FileReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class ParseEmployeeDataCSV implements Callable<List<EmployeeDataEntryDTO>> {
  private static final int EMPLOYEE_DATA_ID = 0;
  private static final int EMPLOYEE_DATA_NAME = 1;
  private static final int EMPLOYEE_DATA_AGE = 2;
  private static final int EMPLOYEE_DATA_DATE_OF_HIRE = 3;
  private static final int EMPLOYEE_DATA_DEPARTMENT_ID = 4;
  private final String filePath;

  public ParseEmployeeDataCSV(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public List<EmployeeDataEntryDTO> call() throws Exception {
    FileReader filereader = new FileReader(this.filePath);
    CSVReader csvReader = new CSVReaderBuilder(filereader)
        .withSkipLines(1)
        .build();

    return csvReader
        .readAll()
        .stream()
        .map((employeeDataEntry) -> new EmployeeDataEntryDTO(
            Integer.parseInt(employeeDataEntry[EMPLOYEE_DATA_ID]),
            employeeDataEntry[EMPLOYEE_DATA_NAME],
            Integer.parseInt(employeeDataEntry[EMPLOYEE_DATA_AGE]),
            employeeDataEntry[EMPLOYEE_DATA_DATE_OF_HIRE],
            Integer.parseInt(employeeDataEntry[EMPLOYEE_DATA_DEPARTMENT_ID])))
        .collect(Collectors.toList());
  }
}
