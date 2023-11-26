import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "jp.github.hinolab"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven ("https://papermc.io/repo/repository/maven-public/")
    maven ("https://oss.sonatype.org/content/groups/public/")
    maven ("https://repo.codemc.io/repository/maven-snapshots/")
    maven ("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.github.hazae41", "mc-kutils", "master-SNAPSHOT")
    implementation("dev.jorel", "commandapi-bukkit-shade", "9.2.0")
    implementation("dev.jorel", "commandapi-bukkit-kotlin", "9.2.0")
    compileOnly("dev.jorel:commandapi-bukkit-core:9.2.0")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

tasks {
    shadowJar {
        dependencies {
            include(dependency("dev.jorel:commandapi-bukkit-shade:9.2.0"))
            include(dependency("com.github.hazae41:mc-kutils:master-SNAPSHOT"))
            include(dependency("org.jetbrains.kotlin:kotlin-stdlib"))
        }

        archiveBaseName.set("TeamDeathmatch")
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("")

        mergeServiceFiles()

        manifest {
            attributes(mapOf("Main-Class" to "io.github.hinolab.teamdeathmatch.TeamDeathmatchKt"))
        }
    }

    processResources {
        filteringCharset = "UTF-8"
        from(sourceSets["main"].resources.srcDirs) {
            include("**/*.yml")
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
            filter<ReplaceTokens>("tokens" to mapOf("version" to project.version))
            filter<ReplaceTokens>("tokens" to mapOf("name" to "TeamDeathmatch"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}