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
//        maven {
//            url = uri("https://maven.aliyun.com/repository/public/")
//        }
//        maven {
//            url  = uri("https://maven.aliyun.com/repository/central")
//        }
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // 添加 JitPack 仓库
//        maven {                                  // <-- Add this
//            url = uri("https://maven.google.com/")
//            name = "Google"
//        }
    }

}


rootProject.name = "DemoProject"
include(":app")
 