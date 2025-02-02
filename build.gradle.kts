plugins {
    id("java")
}

group = "xyz.zalaya"
version = "1.0.0"

repositories {
    mavenCentral()
}

val lombokVersion = "1.18.36"
val junitVersion = "5.10.0"
val mockitoVersion = "5.15.2"

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")

}

tasks.test {
    useJUnitPlatform()
}