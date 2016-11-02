# TornadoFX Kitchen Sink Samples

This project contains samples and best practices for the TornadoFX project. Each sample is
self contained in it's own package structure to make it easy to extract a sample for use in your own project.

Every sample comes with a description to help you understand what's going on and will highlight relevant parts of the code you might want to direct special attention towards.

A [runnable jar](http://tornadofx.tornado.no/kitchensink/fxlauncher.jar) is available that will launcher the kitchen sink automatically.
We also have a native installer for [Windows](http://tornadofx.tornado.no/kitchensink/tornadofx-kitchensink-1.0.exe) and [Mac](http://tornadofx.tornado.no/kitchensink/tornadofx-kitchensink-1.0.dmg).

## Contributing samples

- Clone the project (git clone https://github.com/edvin/tornadofx-kitchensink)
- Add a package inside `tornadofx.kitchensink.samples` for your sample
- Depending on your sample, add the relevant packages and files inside your sample package:
    - `controller` - For controllers
    - `view` - For views, fragments and other UI components
    - `model` - For model objects and view models
    - `README.md`- Description and helpful information about the sample
- Describe your sample in the [samples.json](tree/master/src/main/resources/samples.json) descriptor
    - Either pick an existing category or create a new under the `samples` node. Describe your sample like this:

```json
{
  "name": "Person Editor",
  "entrypoint": "tornadofx.kitchensink.samples.masterdetail.scoped"
}
```

The `entrypoint` should point to the sample package. This is the package where you'll add the `README.md` along with the other sub packages described above.

### Minimal requirement for new samples

You must include a `view/MainView.kt` with a `MainView` class. This class must extend `View` or `Fragment`.

Finally, create a PR and we'll be happy to add your sample!
