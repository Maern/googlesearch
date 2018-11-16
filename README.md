Tools installation

JDK 10 (https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
Firefox
IntelliJ Idea (Community Edition will be enough - https://www.jetbrains.com/idea/download/#section=windows)
GeckoDriver (https://github.com/mozilla/geckodriver/releases)
Git for Windows (if you don't have one https://gitforwindows.org/)
Tools setup

To install GeckoDriver - put it to Windows\System32 folder
To install and run JDK to your PC - open Environment Variables and add Variable JAVA_HOME with path to JDK installation
folder (i.e. C:\Program Files\Java\jdk-10.0.2)
Project-related files explanation

To install Maven:
Download Apache Maven from official web site https://maven.apache.org/download.cgi
Extract it to c:/maven
Open Environment Variables, add both MAVEN_HOME and M2_HOME. Both variables should have value c:\maven\
Find PATH variable, click New button and add %M2_HOME%\bin


pom.xml - contains all dependencies required to run project. DO NOT DELETE

.gitignore - contains files and folders to be ignored by Git when commiting and pushing to repository

README.md - just README file ))))

HOW TO RUN

Clone repository from Git to Idea (VCS->Git->Clone)
Open cloned project files in Idea
Run GoogleSearchTest
OR
in Terminal type mvn clean install