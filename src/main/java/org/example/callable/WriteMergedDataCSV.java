package org.example.callable;

import com.opencsv.CSVWriter;
import org.example.dto.EmployeeDataEntryDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteMergedDataCSV implements Runnable {
  private static final String[] HEADER = { "Id", "Name", "Age", "Date of Hire", "Department Name" };

  private final List<EmployeeDataEntryDTO> employeeData;
  private final Map<Integer, String> departmentData;
  private final String filePath;

  public WriteMergedDataCSV(
      String filePath,
      List<EmployeeDataEntryDTO> employeeData,
      Map<Integer, String> departmentData
  ) {
    this.filePath = filePath;
    this.employeeData = employeeData;
    this.departmentData = departmentData;
  }

  @Override
  public void run() {
    File file = new File(this.filePath);

    try {
      FileWriter outputFile = new FileWriter(file);
      CSVWriter writer = new CSVWriter(outputFile);
      writer.writeNext(HEADER);

      this.employeeData
        .stream()
        .map((employeeDataEntry) -> new String[]{
            String.valueOf(employeeDataEntry.id()),
            employeeDataEntry.name(),
            String.valueOf(employeeDataEntry.age()),
            employeeDataEntry.dateOfHire(),
            this.departmentData.get(employeeDataEntry.departmentId())})
          .forEach(writer::writeNext);

      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
