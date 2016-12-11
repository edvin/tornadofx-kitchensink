## Scoped Master/Detail

This sample shows how to communicate between a master and a detail view using scopes. When the user
double clicks an item in the TableView, a new Window is popped up to operate on the selected user.

The user is available using injection only for that scope. The `edit` function in the list view takes care of
creating a new scope and associating a viewmodel for the selected user with that scope:

```kotlin
fun edit(person: Person) {
    val editScope = Scope()
    val model = PersonModel()
    model.item = person
    setInScope(model, editScope)
    find(PersonEditor::class, editScope).openWindow()
}
```

Inside the `PersonEditor`, the ViewModel is simply injected, since the default scope
for the editor will be the scope it was created with:

```kotlin
// Inject the PersonModel created in the edit function
val model : PersonModel by inject()
```

Changes to the form inputs will be flushed back into the model when you click the save button,
so you should see the table view in the background update when you hit save.