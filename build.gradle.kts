/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://oss.sonatype.org/content/groups/public/") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://bitbucket.org/kangarko/libraries/src/master/") }
}

dependencies {
    // spigot-API
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")
    // foundation
    implementation("com.github.kangarko:Foundation:6.2.8") {
        exclude(group = "org.mineacademy.plugin", module = "AuthMe")
        exclude(group = "org.mineacademy.plugin", module = "BentoBox")
        exclude(group = "org.mineacademy.plugin", module = "CitizensAPI")
        exclude(group = "org.mineacademy.plugin", module = "CMI-API")
        exclude(group = "org.mineacademy.plugin", module = "DiscordSRV")
        exclude(group = "org.mineacademy.plugin", module = "EssentialsX")
        exclude(group = "org.mineacademy.plugin", module = "Factions")
        exclude(group = "org.mineacademy.plugin", module = "FactionsUUID")
        exclude(group = "org.mineacademy.plugin", module = "Jobs")
        exclude(group = "org.mineacademy.plugin", module = "LandsAPI")
        exclude(group = "org.mineacademy.plugin", module = "LWC")
        exclude(group = "org.mineacademy.plugin", module = "mcMMO")
        exclude(group = "org.mineacademy.plugin", module = "MassiveCore")
        exclude(group = "org.mineacademy.plugin", module = "Multiverse-Core")
        exclude(group = "org.mineacademy.plugin", module = "NuVotifier")
        exclude(group = "org.mineacademy.plugin", module = "PlaceholderAPI")
        exclude(group = "org.mineacademy.plugin", module = "ProtocolLib")
        exclude(group = "org.mineacademy.plugin", module = "Residence")
        exclude(group = "org.mineacademy.plugin", module = "SimpleClans")
        exclude(group = "org.mineacademy.plugin", module = "StackMob")
        exclude(group = "org.mineacademy.plugin", module = "Towny")
        exclude(group = "org.mineacademy.plugin", module = "TownyChat")
        exclude(group = "org.mineacademy.plugin", module = "Vault")
        exclude(group = "org.mineacademy.plugin", module = "WorldEdit")
        exclude(group = "org.mineacademy.plugin", module = "WorldGuard")
    }

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

}
group = "xyz.jakubk15"
version = "2.2-ALPHA"

apply(plugin = "java")
apply(plugin = "com.github.johnrengelman.shadow")

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}


tasks {
    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        archiveBaseName.set("casedrop-core")
        archiveClassifier.set("ALPHA")
        archiveVersion.set("2.2")
    }
}
