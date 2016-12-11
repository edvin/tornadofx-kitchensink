## Scoped Master/Detail with ViewModel in custom scope

This sample shows how to communicate between a master and a detail view using scopes. When the user
double clicks an item in the TableView, a new Window is popped up to operate on the selected user.

The user is made available by putting a ViewModel inside a custom scope subclass called `PersonScope`:

```kotlin
class PersonScope : Scope() {
    val model = PersonModel()
}
```

The `edit` function in the list view takes care of
creating a new scope and associating the ViewModel item with the selected user before opening the editor in the context of our new scope.

```kotlin
fun editPerson(person: Person) {
    val editScope = PersonScope()
    editScope.model.item = person
    find(PersonEditor::class, editScope).openWindow()
}
```

Inside the `PersonEditor`, the ViewModel is looked up via the scope. We also make sure to
cast the scope to make it easier to work with.

```kotlin
// Cast scope
override val scope = super.scope as PersonScope
// Extract our view model from the scope
val model = scope.model
```

Changes to the form inputs will be flushed back into the model when you click the save button,
so you should see the table view in the background update when you hit save.