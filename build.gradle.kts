plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

tasks.register("preparePopup") {
    group = "extension"
    dependsOn(":extensionComponent:popup:clean")
    dependsOn(":extensionComponent:popup:wasmJsBrowserDistribution")
        .mustRunAfter(":extensionComponent:popup:clean")

    doLast {
        copy {
            from("extensionComponent/popup/build/dist/wasmJs/productionExecutable")
            into("distribution/popup/")
        }

        /** __IMPORTANT NOTE__
         * This is required for extension/popup to set body height manually to fixed pixel.
         * The height of popup can't be updated runtime.
         * Setting Modifier.height() to root composable doesn't work.
         */
        copy {
            from("extensionComponent/popup/src/wasmJsMain/resources/styles.css")
            into("distribution/popup/")
        }
    }
}

tasks.register("prepareOptions") {
    group = "extension"
    dependsOn(":extensionComponent:options:clean")
    dependsOn(":extensionComponent:options:wasmJsBrowserDistribution")
        .mustRunAfter(":extensionComponent:options:clean")

    doLast {
        copy {
            from("extensionComponent/options/build/dist/wasmJs/productionExecutable")
            into("distribution/options/")
        }
    }
}

tasks.register("copyDependencies") {
    group = "extension"

    doLast {
        copy {
            from("extensionComponent/manifest.json")
            into("distribution/")
        }

        copy {
            from("extensionComponent/background/background.js")
            into("distribution/scripts/")
        }

        copy {
            from("extensionComponent/content/content.js")
            into("distribution/scripts/")
        }

        copy {
            from("extensionComponent/resources")
            into("distribution/resources/")
        }
    }
}

tasks.register("bundleExtension") {
    group = "extension"
    doFirst {
        delete("distribution/*")
    }

    dependsOn("preparePopup")
    dependsOn("prepareOptions")
    dependsOn("copyDependencies")
}