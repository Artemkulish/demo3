import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs


version = "2019.2"

project {
    vcsRoot(Trip)
    buildType(Build)
}

object Build : BuildType({
    name = "Build"
    artifactRules = "target/*jar"

    vcs {
        root(Trip)
    }
    steps {
        maven {
            goals = "clean package"
        }
    }
    triggers {
        vcs {
            groupCheckinsByCommitter = true
        }
    }
})

object Trip : GitVcsRoot({
    name = "Trip"
    url = "https://github.com/Artemkulish/Demo_4/tree/master/trip"
})