package com.school;

import java.util.List;

public class AttendanceServiceTest {
    public static void main(String[] args) {
        // --- Setup Services ---
        FileStorageService storage = new FileStorageService();
        RegistrationService registration = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, registration);

        // --- Register Students and Courses ---
        registration.registerStudent("Aryaman", "Grade 12");
        registration.registerStudent("Riya", "Grade 11");

        registration.createCourse("Java Programming", 2);
        registration.createCourse("Python Basics", 3);

        // --- Retrieve created data ---
        List<Student> students = registration.getStudents();
        List<Course> courses = registration.getCourses();

        // --- Test Attendance Marking ---
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(0), "Absent");

        // Using IDs (overloaded method)
        attendanceService.markAttendance(students.get(0).getId(), courses.get(1).getCourseId(), "Late");

        // --- Display Logs ---
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(students.get(0));
        attendanceService.displayAttendanceLog(courses.get(0));

        // --- Save data ---
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ AttendanceService test completed successfully!");
    }
}
