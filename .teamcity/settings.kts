import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2019.2"

project {
    vcsRoot(Trip)
    buildType(Build)
}

object Build : BuildType({
    name = "Test"
    artifactRules = "target/*jar"

    vcs {
        root(Trip)g
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
    url = "https://github.com/Artemkulish/Demo_4"
})
