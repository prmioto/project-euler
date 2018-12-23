set JAVA_HOME=C:\Program Files\Java\jre1.8.0_161
set JAVA_CMD=%JAVA_HOME%\bin\java.exe
echo %JAVA_CMD%
call %* >out.log 2>err.log