@echo off
echo === Nachalo avtomaticheskoy sborki proekta ===

:: Ochistka starih direktoriy
rmdir /s /q out 2>nul
mkdir out

:: Kompilyaciya vseh ishodnih kodov Java
dir /s /B src\*.java > sources.txt
javac -d out @sources.txt
del sources.txt

:: Sborka ispolnyaemogo JAR arhiva
jar cfm Lab1Project.jar manifest.mf -C out .

echo === Sborka uspeshno zavershena ===
echo Dlya zapuska ispolzuyte: java -jar Lab1Project.jar
pause
