package org.example.dto;

import java.util.Objects;

public final class CommandLineArgsDTO {
  private final String employeeDataFileName;
  private final String departmentDataFileName;
  private final String outputFileName;

  public CommandLineArgsDTO(
      String employeeDataFileName,
      String departmentDataFileName,
      String outputFileName
  ) {
    this.employeeDataFileName = employeeDataFileName;
    this.departmentDataFileName = departmentDataFileName;
    this.outputFileName = outputFileName;
  }

  public String employeeDataFileName() {
    return employeeDataFileName;
  }

  public String departmentDataFileName() {
    return departmentDataFileName;
  }

  public String outputFileName() {
    return outputFileName;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (CommandLineArgsDTO) obj;
    return Objects.equals(this.employeeDataFileName, that.employeeDataFileName) &&
        Objects.equals(this.departmentDataFileName, that.departmentDataFileName) &&
        Objects.equals(this.outputFileName, that.outputFileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeDataFileName, departmentDataFileName, outputFileName);
  }

  @Override
  public String toString() {
    return "CommandLineArgsDTO[" +
        "employeeDataFileName=" + employeeDataFileName + ", " +
        "departmentDataFileName=" + departmentDataFileName + ", " +
        "outputFileName=" + outputFileName + ']';
  }
}
