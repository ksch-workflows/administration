import "package:flutter/material.dart";
import "package:registration_desk/util/test_bench.dart";
import "package:registration_desk/ui/register_patient/register_patient_dialog/visit_type.dart";
import "package:registration_desk/util/form_stepper/form_stepper.dart";

void main() {
  var contactInformationStep = VisitTypeFormStep(visitTypeSelection: FormValue<String>());

  runApp(
    TestBench(
      child: contactInformationStep.body,
    ),
  );
}
