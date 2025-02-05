plugins {
    java
    jacoco
}

group = "xyz.zalaya"
version = "1.0.0"

repositories {
    mavenCentral()
}

val lombokVersion = property("lombok.version")
val junitVersion = property("junit.version")
val mockitoVersion = property("mockito.version")

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        html.required = true
    }
}
