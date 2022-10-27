# Threading Assignment

## Problem

- Read data from employee csv and department csv.
- Merge data on department id and write to new csv

## How to Install

```bash
mvn clean install conpile package
```

## How to Run
```bash
java -jar target/threading-assignment-1.0-SNAPSHOT.jar --employee-data={EMPLOYEE_DATA_FILE_PATH} --department-data={DEPARTMENT_DATA_FILE_PATH} --output={OUTPUT_FILE_PATH}
```

- Command line args:
  - `--employee-data`
  - `--department-data`
  - `--output`

- If the command line args are not provided, the default parameters are pointing to the files in the `src/main/resources`.
  - This was done during the testing phase when I was running the project within the project folder.
- Please note the app assumes that the structure of the csv provided need to match the number of columns and column type.

## Data Types

- Employee
- Department
- Merged on Department Id

### Employee

| Name         | Type   |
|--------------|--------|
| ID           | int    |
| Name         | String |
| Age          | int    |
| Date of Hire | String |
| Department   | int    |

### Department

| Name             | Type    |
|------------------|---------|
| Department Id    | int     |
| Department Name  | String  |

### Merged on Department Id

| Name            | Type   |
|-----------------|--------|
| Id              | int    |
| Name            | String |
| Age             | Int    |
| Date of Hire    | String |
| Department Name | String |

## Sample Data

- Employee CSV
- Department CSV
- Merged CSV

### Employee CSV:

|   Id  |   Name    |   Age  |   Date of Hire  |   Department Id  |
|-------|-----------|--------|-----------------|------------------|
|   1   |   Name1   |   10   |   9/1/2022      |   1              |
|   2   |   Name2   |   11   |   9/2/2022      |   2              |
|   3   |   Name3   |   12   |   9/3/2022      |   3              |
|   4   |   Name4   |   13   |   9/4/2022      |   4              |
|   5   |   Name5   |   14   |   9/5/2022      |   5              |
|   6   |   Name6   |   15   |   9/6/2022      |   6              |
|   7   |   Name7   |   16   |   9/7/2022      |   7              |
|   8   |   Name8   |   17   |   9/8/2022      |   8              |
|   9   |   Name9   |   18   |   9/9/2022      |   9              |
|   10  |   Name10  |   19   |   9/10/2022     |   10             |
|   11  |   Name11  |   20   |   9/11/2022     |   1              |
|   12  |   Name12  |   21   |   9/12/2022     |   2              |
|   13  |   Name13  |   22   |   9/13/2022     |   3              |
|   14  |   Name14  |   23   |   9/14/2022     |   4              |
|   15  |   Name15  |   24   |   9/15/2022     |   5              |
|   16  |   Name16  |   25   |   9/16/2022     |   6              |
|   17  |   Name17  |   26   |   9/17/2022     |   7              |
|   18  |   Name18  |   27   |   9/18/2022     |   8              |
|   19  |   Name19  |   28   |   9/19/2022     |   9              |
|   20  |   Name20  |   29   |   9/20/2022     |   10             |

### Department CSV:

|   Department Id  |   Department Name  |
|------------------|--------------------|
|   1              |   Dept1            |
|   2              |   Dept2            |
|   3              |   Dept3            |
|   4              |   Dept4            |
|   5              |   Dept5            |
|   6              |   Dept6            |
|   7              |   Dept7            |
|   8              |   Dept8            |
|   9              |   Dept9            |
|   10             |   Dept10           |

### Merged on Department Id CSV:

|   Id  |   Name    |   Age  |   Date of Hire  |   Department Name  |
|-------|-----------|--------|-----------------|--------------------|
|   1   |   Name1   |   10   |   9/1/2022      |   Dept1            |
|   2   |   Name2   |   11   |   9/2/2022      |   Dept2            |
|   3   |   Name3   |   12   |   9/3/2022      |   Dept3            |
|   4   |   Name4   |   13   |   9/4/2022      |   Dept4            |
|   5   |   Name5   |   14   |   9/5/2022      |   Dept5            |
|   6   |   Name6   |   15   |   9/6/2022      |   Dept6            |
|   7   |   Name7   |   16   |   9/7/2022      |   Dept7            |
|   8   |   Name8   |   17   |   9/8/2022      |   Dept8            |
|   9   |   Name9   |   18   |   9/9/2022      |   Dept9            |
|   10  |   Name10  |   19   |   9/10/2022     |   Dept10           |
|   11  |   Name11  |   20   |   9/11/2022     |   Dept1            |
|   12  |   Name12  |   21   |   9/12/2022     |   Dept2            |
|   13  |   Name13  |   22   |   9/13/2022     |   Dept3            |
|   14  |   Name14  |   23   |   9/14/2022     |   Dept4            |
|   15  |   Name15  |   24   |   9/15/2022     |   Dept5            |
|   16  |   Name16  |   25   |   9/16/2022     |   Dept6            |
|   17  |   Name17  |   26   |   9/17/2022     |   Dept7            |
|   18  |   Name18  |   27   |   9/18/2022     |   Dept8            |
|   19  |   Name19  |   28   |   9/19/2022     |   Dept9            |
|   20  |   Name20  |   29   |   9/20/2022     |   Dept10           |
