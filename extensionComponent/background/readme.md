### Background Service
This module will create the background script for the extension. To avoid complexity, we use the same 
target on every module i.e `kotlin/wasm`.

#### Build and Distribution
This can target either `kotlin/wasmJs` or `kotlin/js`. We choose `kotlin/wasm`.
To build this module and test, run `./gradlew :extensionComponent:background:wasmJsBrowserDevelopmentRun`
For distribution, run `./gradlew :extensionComponent:background:wasmJsBrowserDistribution`.
The generated files will be under `./build/dist/wasmJs/productionExecutable` directory.

#### One useful note
the `/src/wasmJsMain/resources` contains a `index.html` file. Without this the `./gradlew :extensionComponent:background:wasmJsBrowserDevelopmentRun` will load a sample html page into the browser.