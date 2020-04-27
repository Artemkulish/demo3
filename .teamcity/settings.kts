import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2019.2"

project {
    buildType(Trip)
    buildType(Gateway)
}

object Trip : BuildType({
    name = "Trip"
    artifactRules = "target/**jar"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean package"
            pomLocation = "trip/pom.xml"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})

object Gateway : BuildType({
    name = "Gateway"

    vcs {g
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean package"
            pomLocation = "gateway/pom.xml"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})
