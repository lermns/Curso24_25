pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "UT3_Desarrollo_Android"
include(":demo3_1")
include(":demo3_2")
include(":demo3_3")
include(":demo3_4")
include(":demo3_5")
include(":demo3_6")
include(":demo3_7")
include(":demo3_8")
