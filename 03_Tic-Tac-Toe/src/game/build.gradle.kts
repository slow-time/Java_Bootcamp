plugins {
    id ("java")
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "game"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}


repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}