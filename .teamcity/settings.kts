import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2019.2"

project {
    vcsRoot(Test)
    buildType(Build)
}

object Build : BuildType({
    name = "Build"
    artifactRules = "target/*jar"

    vcs {
        root(Test)
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

object Test : GitVcsRoot({
    name = "Test"
    url = "https://github.com/Artemkulish/Demo_4"
})