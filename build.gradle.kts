plugins {
    java
    `maven-publish`
}

group = "net.stormdev"
version = "1.16.2-R0.1-16"
description = "uPlanes"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    maven(uri("https://repo.dmulloy2.net/nexus/repository/public/")) //spigot, ProtocolLib
    maven(uri("https://jitpack.io")) //VaultAPI
    maven(uri("https://maven.enginehub.org/repo/")) //WorldGuard
}

dependencies {
    compileOnly("org.spigotmc", "spigot", "1.16.2-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol", "ProtocolLib", "4.6.0") {
        exclude("net.bytebuddy", "byte-buddy")
    }
    compileOnly("com.github.MilkBowl", "VaultAPI", "1.7") {
        exclude("org.bukkit", "bukkit")
    }
    compileOnly("com.sk89q.worldguard", "worldguard-bukkit", "7.0.4") {
        exclude("org.spigotmc", "spigot-api")
    }

    //temporary local dependency until uCars is published
    compileOnly(fileTree("libs") {
        include("*.jar")
    })
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
