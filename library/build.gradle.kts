plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.pixix4"
version = "1.0.0-beta"

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), "KObserve", version.toString())

    pom {
        name = "KObserve"
        description = "An easy to use kotlin library for observable properties."
        inceptionYear = "2025"
        url = "https://github.com/pixix4/KObserve"
        licenses {
            license {
                name = "MIT"
                url = "https://github.com/pixix4/KObserve/blob/master/LICENSE"
            }
        }
        developers {
            developer {
                id = "pixix4"
                name = "Lars Westermann"
                email = "maven@lars-westermann.de"
                organization = ""
                organizationUrl = "https://github.com/pixix4"
            }
        }
        scm {
            url = "https://github.com/pixix4/KObserve"
            connection = "scm:git:git://github.com/pixix4/KObserve.git"
            developerConnection = "scm:git:ssh://github.com/pixix4/KObserve.git"
        }
    }
}
