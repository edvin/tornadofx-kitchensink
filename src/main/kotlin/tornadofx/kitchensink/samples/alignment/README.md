## Alignment

Demonstrating alignment builder syntax. A `TilePane` is used to wrap 9 `VBox` instances. Each `VBox` has a different configured `alignment` for its children. The only child of each `VBox` is a `Label`, which is also configured with a `margin`.

Instead of using the static JavaFX margin syntax of `VBox.setMargin(label, insets)` we use the TornadoFX Node property `margin` directly:

```kotlin
label("Position") {
    margin = Insets(5.0)
}
```

It looks like we are setting a property on the `Label` while infact the static `VBox.setMargin` call is applied for us. This makes the ui code much leaner.

To apply styles to each `VBox`, the `style` helper is used so we don't need to iterate over all the children manually to apply the styles:

```kotlin
children.style {
    backgroundColor += Color.TAN
    effect = DropShadow()
    prefWidth = 150.px
    prefHeight = 150.px
    padding = box(10.px)
}
```

An alternative here would be to apply a style class to each `VBox` and configure this in a Stylesheet instead. 