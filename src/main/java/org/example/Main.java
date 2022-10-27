package org.example;

import org.example.callable.ParseDepartmentDataCSV;
import org.example.callable.ParseEmployeeDataCSV;
import org.example.callable.WriteMergedDataCSV;
import org.example.dto.CommandLineArgsDTO;
import org.example.dto.EmployeeDataEntryDTO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    long startTime = System.nanoTime();
    System.out.printf("Start: %dms%n", startTime / 1000000);

    CommandLineArgsDTO commandLineArgs = CommandLineArgs.getCommandLineArgs(args);
    String employeeDataFileName = commandLineArgs.employeeDataFileName();
    String departmentDataFileName = commandLineArgs.departmentDataFileName();
    String outputFileName = commandLineArgs.outputFileName();

    ParseEmployeeDataCSV parseEmployeeDataCSV = new ParseEmployeeDataCSV(employeeDataFileName);
    ParseDepartmentDataCSV parseDepartmentDataCSV = new ParseDepartmentDataCSV(departmentDataFileName);

    FutureTask<List<EmployeeDataEntryDTO>> futureEmployeeData = new FutureTask<>(parseEmployeeDataCSV);
    FutureTask<Map<Integer, String>> futureDepartmentData = new FutureTask<>(parseDepartmentDataCSV);

    Thread threadEmployeeData = new Thread(futureEmployeeData);
    Thread threadDepartmentData = new Thread(futureDepartmentData);

    threadEmployeeData.start();
    threadDepartmentData.start();

    WriteMergedDataCSV writeMergedDataCSV = new WriteMergedDataCSV(
        outputFileName,
        futureEmployeeData.get(),
        futureDepartmentData.get());

    Thread threadWriteMergedData = new Thread(writeMergedDataCSV);
    threadWriteMergedData.start();
    threadWriteMergedData.join();

    long endTime = System.nanoTime();
    System.out.printf("End: %dms%n", endTime / 1000000);

    long timeElapsed = endTime - startTime;
    System.out.printf("Execution Time: %dms%n", timeElapsed / 1000000);
  }
}
