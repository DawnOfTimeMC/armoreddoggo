# Armored Doggo
<a href="https://discord.gg/MrHu9MJ">
  <img alt="Discord" src="https://img.shields.io/discord/303974483591692289?color=informational&label=discord&logo=discord&style=flat-square&logoColor=white&labelColor=0d1117">
</a>

![Mod Loader: Forge](https://img.shields.io/badge/loader-forge-1976d2?style=flat-square&color=orange&logo=curseforge&labelColor=0d1117)

**Armored Doggo**  is a mod that adds stylish armor for your beloved Doggo !

### IntelliJ IDEA
This guide will show how to import the project into IntelliJ IDEA. The setup process is roughly equivalent to setting up the modloaders independently and should be very familiar to anyone who has worked with their MDKs.

1. Clone or download this repository to your computer.
2. Open the root folder as a new project in IDEA. This is the folder that contains this README file and the gradlew executable.
3. If your default JVM/JDK is not Java 21 you will encounter an error when opening the project. This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM` and changing the value to a valid Java 21 JVM. You will also need to set the Project SDK to Java 21. This can be done by going to `File > Project Structure > Project SDK`. Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
4. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Common > Tasks > vanilla gradle > decompile`. Run this task to decompile Minecraft.
6. Open your Run/Debug Configurations. Under the Application category there should now be options to run NeoForge and Fabric projects. Select one of the client options and try to run it.
7. Assuming you were able to run the game in step 6 your workspace should now be set up.