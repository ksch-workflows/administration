import "package:flutter/material.dart";
import "package:registration_desk/context.dart";
import "package:registration_desk/util/test_bench.dart";
import "package:registration_desk/ui/register_patient/register_patient_page.dart";

void main() {
  createMockContext();

  runApp(
    TestBench(
      child: RegisterPatientPage(),
      isFullPage: true,
    ),
  );
}
