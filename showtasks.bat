call runcrud.bat
if "%ERRORLEVEL%" == "0" goto showtasks
echo.
echo runcrud.bat has errors - breaking work
goto fail

:showtasks
start firefox.exe http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.