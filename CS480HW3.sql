create database CS480HW3;
use CS480HW3;
create table Department(DepartmentID integer primary key, DepartmentName varchar(20), DepartmentPhone varchar(10), DepartmentAddress varchar(50), FacultyID integer);
create table Course(CourseID integer primary key, CourseName varchar(15), Credit integer, DepartmentID integer);
create table Faculty(FacultyID integer primary key, FacultyName varchar(50), FacultyAddress varchar(50), FacultyDOB varchar(11), FacultyGender varchar(1), FacultyPhone varchar(10));
create table Student(StudentID integer primary key, StudentName varchar(50), StudentAddress varchar(50), StudentDOB varchar(11), StudentGender varchar(1), StudentPhone varchar(10));
create table CourseVsFaculty(FacultyID integer, CourseID integer);
create table CourseVsStudent(StudentID integer, CourseID integer);
create table Project(ProjectID integer, ProjectName varchar(30), FacultyID integer);