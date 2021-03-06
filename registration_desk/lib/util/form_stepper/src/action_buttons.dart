import "package:flutter/material.dart";

class ActionButtons extends StatelessWidget {
  final Function onBack;
  final Function onCancel;
  final Function onContinue;
  final bool isLastStep;

  const ActionButtons({
    @required this.onBack,
    @required this.onCancel,
    @required this.onContinue,
    this.isLastStep = false,
  })  : assert(onBack != null),
        assert(onCancel != null),
        assert(onContinue != null);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(25, 0, 25, 0),
      child: FocusTraversalGroup(
        policy: OrderedTraversalPolicy(),
        child: Row(
          children: [
            FocusTraversalOrder(
              order: const NumericFocusOrder(2),
              child: Tooltip(
                message: "Go back to the previous step.",
                child: RaisedButton(
                  key: const ValueKey("backButton"),
                  child: const Text("Back"),
                  onPressed: onBack,
                ),
              ),
            ),
            Expanded(
              child: Container(),
            ),
            FocusTraversalOrder(
              order: const NumericFocusOrder(3),
              child: RaisedButton(
                key: const ValueKey("cancelButton"),
                child: const Text("Cancel"),
                onPressed: onCancel,
              ),
            ),
            const SizedBox(
              width: 20,
            ),
            FocusTraversalOrder(
              order: const NumericFocusOrder(1),
              child: Tooltip(
                message: "Go to the next step.",
                child: RaisedButton(
                  key: const ValueKey("continueButton"),
                  color: Theme.of(context).accentColor,
                  child: Text(
                    isLastStep ? "Save" : "Continue",
                    style: TextStyle(color: Theme.of(context).colorScheme.onSecondary),
                  ),
                  onPressed: onContinue,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
