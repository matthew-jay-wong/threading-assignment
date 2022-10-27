package org.example;

import org.apache.commons.cli.*;
import org.example.dto.CommandLineArgsDTO;

import java.util.Optional;

public class CommandLineArgs {
  private static final Options options = new Options();
  private static final CommandLineParser parser;
  private static final HelpFormatter formatter;
  private static CommandLine cmd;

  static {
    Option employeeData = new Option("e", "employee-data", true, "input file path");
    employeeData.setRequired(false);
    options.addOption(employeeData);

    Option departmentData = new Option("d", "department-data", true, "input file path");
    departmentData.setRequired(false);
    options.addOption(departmentData);

    Option output = new Option("o", "output", true, "output file");
    output.setRequired(false);
    options.addOption(output);

    parser = new DefaultParser();
    formatter = new HelpFormatter();
  }

  public static CommandLineArgsDTO getCommandLineArgs(String[] args) {
    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("utility-name", options);

      System.exit(1);
    }

    String employeeDataFilePath =
        Optional
            .ofNullable(cmd.getOptionValue("employee-data"))
            .orElse("src/main/resources/sample_employee_data.csv");

    String departmentDataFilePath =
        Optional
            .ofNullable(cmd.getOptionValue("department-data"))
            .orElse("src/main/resources/sample_department_data.csv");

    String outputFileName =
        Optional
            .ofNullable(cmd.getOptionValue("output"))
            .orElse("src/main/resources/merged_by_department_id_data.csv");

    return new CommandLineArgsDTO(
        employeeDataFilePath,
        departmentDataFilePath,
        outputFileName
    );
  }
}
