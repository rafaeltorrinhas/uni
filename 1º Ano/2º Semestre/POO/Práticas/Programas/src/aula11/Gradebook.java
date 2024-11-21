package aula11;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Gradebook {
  private Map<String, List<Double>> studentGrades;

  public Gradebook() {
    studentGrades = new HashMap<>();
  }

  public void load(String fileName) {
    try {
      Scanner scanner = new Scanner(new FileReader(fileName));

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split("\\|");
        String studentName = parts[0].trim();
        double grade1 = Double.parseDouble(parts[1].trim());
        double grade2 = Double.parseDouble(parts[2].trim());
        double grade3 = Double.parseDouble(parts[3].trim());

        List<Double> grades = studentGrades.getOrDefault(studentName, new ArrayList<>());
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);

        studentGrades.put(studentName, grades);
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + fileName);
    }
  }

  public void addStudent(Student newStudent) {
    String studentName = newStudent.getName();
    List<Double> grades = newStudent.getGrades();
    studentGrades.put(studentName, grades);
  }

  public void removeStudent(String studentName) {
    studentGrades.remove(studentName);
  }

  public Student getStudent(String studentName) {
    List<Double> grades = studentGrades.get(studentName);
    if (grades != null) {
      return new Student(studentName, grades);
    }
    return null;
  }

  public double calculateAverageGrade(String studentName) {
    List<Double> grades = studentGrades.get(studentName);
    if (grades != null) {
      double sum = 0.0;
      for (double grade : grades) {
        sum += grade;
      }
      double average = sum / grades.size();
      return average;
    }
    return 0.0;
  }

  public void printAllStudents() {
    for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
      String studentName = entry.getKey();
      List<Double> grades = entry.getValue();
      System.out.println("Student: " + studentName);
      System.out.println("Grades: " + grades);
    }
  }
}
