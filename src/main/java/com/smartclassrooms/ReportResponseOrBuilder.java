// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartclassrooms.proto

package com.smartclassrooms;

public interface ReportResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ReportResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .StudentAttendance studentAttendances = 1;</code>
   */
  java.util.List<com.smartclassrooms.StudentAttendance> 
      getStudentAttendancesList();
  /**
   * <code>repeated .StudentAttendance studentAttendances = 1;</code>
   */
  com.smartclassrooms.StudentAttendance getStudentAttendances(int index);
  /**
   * <code>repeated .StudentAttendance studentAttendances = 1;</code>
   */
  int getStudentAttendancesCount();
  /**
   * <code>repeated .StudentAttendance studentAttendances = 1;</code>
   */
  java.util.List<? extends com.smartclassrooms.StudentAttendanceOrBuilder> 
      getStudentAttendancesOrBuilderList();
  /**
   * <code>repeated .StudentAttendance studentAttendances = 1;</code>
   */
  com.smartclassrooms.StudentAttendanceOrBuilder getStudentAttendancesOrBuilder(
      int index);
}