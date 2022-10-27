package org.example.dto;

import java.util.Objects;

public final class EmployeeDataEntryDTO {
  private final int id;
  private final String name;
  private final int age;
  private final String dateOfHire;
  private final int departmentId;

  public EmployeeDataEntryDTO(
      int id,
      String name,
      int age,
      String dateOfHire,
      int departmentId
  ) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.dateOfHire = dateOfHire;
    this.departmentId = departmentId;
  }

  public int id() {
    return id;
  }

  public String name() {
    return name;
  }

  public int age() {
    return age;
  }

  public String dateOfHire() {
    return dateOfHire;
  }

  public int departmentId() {
    return departmentId;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (EmployeeDataEntryDTO) obj;
    return this.id == that.id &&
        Objects.equals(this.name, that.name) &&
        this.age == that.age &&
        Objects.equals(this.dateOfHire, that.dateOfHire) &&
        this.departmentId == that.departmentId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, dateOfHire, departmentId);
  }

  @Override
  public String toString() {
    return "EmployeeDataEntryDTO[" +
        "id=" + id + ", " +
        "name=" + name + ", " +
        "age=" + age + ", " +
        "dateOfHire=" + dateOfHire + ", " +
        "departmentId=" + departmentId + ']';
  }
}
