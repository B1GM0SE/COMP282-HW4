@echo off
REM Data Structures Assignment Runner (Windows)
REM
REM Usage examples:
REM   run list    -> compile and run CSLinkedListDriver
REM   run stack   -> compile and run ListStackDriver
REM   run queue   -> compile and run ArrayQueueDriver
REM   run all     -> compile and run all three drivers
REM
REM Assumes:
REM   - All .java files are in the same folder as this .bat file
REM   - No package statements in the .java files

IF "%1"=="" GOTO usage

ECHO Compiling Java files...
javac *.java
IF ERRORLEVEL 1 GOTO end

IF /I "%1"=="list" GOTO runlist
IF /I "%1"=="stack" GOTO runstack
IF /I "%1"=="queue" GOTO runqueue
IF /I "%1"=="all" GOTO runall

GOTO usage

:runlist
ECHO.
ECHO === Running CSLinkedListDriver (linked list demos) ===
java CSLinkedListDriver
GOTO end

:runstack
ECHO.
ECHO === Running ListStackDriver (stack demos) ===
java ListStackDriver
GOTO end

:runqueue
ECHO.
ECHO === Running ArrayQueueDriver (queue demos) ===
java ArrayQueueDriver
GOTO end

:runall
ECHO.
ECHO === Running CSLinkedListDriver (linked list demos) ===
java CSLinkedListDriver
ECHO.
ECHO === Running ListStackDriver (stack demos) ===
java ListStackDriver
ECHO.
ECHO === Running ArrayQueueDriver (queue demos) ===
java ArrayQueueDriver
GOTO end

:usage
ECHO Usage: run list^|stack^|queue^|all
GOTO end

:end
