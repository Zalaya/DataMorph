plugins {
    id("java")
}

group = "org.zalaya"
version = "1.0.0"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.0"
val mockitoVersion = "5.15.2"

dependencies {
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")

}

tasks.test {
    useJUnitPlatform()
}