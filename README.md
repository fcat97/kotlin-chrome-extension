This is a sample template for creating Chrome browser extension with Kotlin and Jetpack compose

#### Project Structure:
All the components are inside `./extensionComponent` directory.

- __`./background:`__ this directory consist of background services.
- __`./content:`__ this directory consist of content scripts which are injected into webpages.
- __`./option:`__ this directory holds the webpage for configuring the extension. The extensions home page.
- __`./popup:`__ this directory holds the webpage for extension popup. This page is shown when user clicks on the extension icon in toolbar.
- __`./resources:`__ directory for static assets like icon etc.
- __`./shared:`__ kotlin library module for common functionalities. This is not a part of the extension rather it's a regular gradle module.

#### Build and Distribute

##### Debugging
For popup run `./gradlew debugPopup`
For options run `./gradlew debugOptions`

##### Distribution
to distribute run `./gradlew bundleExtension`. The prepared output will be inside `./distribution` directory.

--- 

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

