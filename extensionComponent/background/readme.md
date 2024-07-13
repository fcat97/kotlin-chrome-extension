### Background Service
This module will create the background script for the extension. Since we don't need Jetpack compose for UI work here,
we can make this a `kotlin/js` targeted module which will be lightweight than `kotlin/wasm`.

#### Build and Distribution
This can target either `kotlin/wasmJs` or `kotlin/js`. We choose `kotlin/js`.
To build this module and test, run `./gradlew :extensionComponent:background:jsBrowserDevelopmentRun`
For distribution, run `./gradlew :extensionComponent:background:jsBrowserDistribution`.
The generated files will be under `./build/dist/js/productionExecutable` directory.

#### One useful note
the `/src/jsMain/resources` contains a `index.html` file. Without this the `./gradlew :extensionComponent:background:jsBrowserDevelopmentRun` will load a sample html page into the browser.