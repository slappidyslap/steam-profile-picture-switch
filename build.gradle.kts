plugins {
    java
    application
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
//    id("org.javamodularity.moduleplugin") version "1.8.15"
//    id("org.openjfx.javafxplugin") version "0.0.13"
//    id("org.beryx.jlink") version "3.2.1"
    id("com.gradleup.shadow") version "9.3.1"
    id("org.graalvm.buildtools.native") version "0.11.1"
}

group = "kg.musabaev"
version = "0.0.1"

repositories {
    mavenCentral()
}

val junitVersion = "5.12.1"


tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
//    mainModule.set("kg.musabaev.steamprofilepictureswitch")
    mainClass.set("kg.musabaev.steamprofilepictureswitch.AppKt")
}

kotlin {
    jvmToolchain(21)
}

/*javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls")
}*/

dependencies {
    implementation("com.github.ajalt.clikt:clikt:5.0.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

/*jlink {
    options.set(listOf(
        "--strip-debug",
        "--compress", "zip-6",
        "--no-header-files",
        "--no-man-pages"))
    launcher {
        name = name
    }
//    addExtraDependencies("kotlin")

//    forceMerge("kotlin")

//    mergedModule {
//        excludeRequires(
//            "kotlin.stdlib"
//        )
//    }
}*/
