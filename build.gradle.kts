plugins {
    kotlin("jvm") version "1.3.72"
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

application {
    mainClassName = "com.example.Start"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-mustache:2.3.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.5.RELEASE")
    implementation("org.springframework.session:spring-session-core:2.4.1")
    implementation("khttp:khttp:1.0.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}