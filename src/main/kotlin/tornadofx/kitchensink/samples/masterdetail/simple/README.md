## Scoped Master/Detail

This sample shows how to communicate between a master and a detail view with shared data. When the selected
item changes in the TableView, the form on the right begins to edit the item. Changes to the form inputs
will be flushed back into the model when you click the save button.

The phone numbers associated with a Person can be edited in an editable TableView inside the detail view.
Those changes are committed when you press enter in the TextField editor for the current column.

Both the master and detail View share the same PersonModel by injecting it:

```kotlin
val model : PersonModel by inject()
```

Since no scope is given to the inject function, they both fetch the PersonModel from the global/default
scope named `DefaultScope`. To open a new editor with a separate scope, you can find or inject a MainView
(the holder for both master and detail Views) with a unique scope:

```kotlin
val newEditor = find(MainView::class, Scope())
```

No state is shared in the Scope for this sample, but it would be a good alternative to subclass `Scope`
and put the shared view model in there instead of using injection.
