@echo off
SET ECHOCOLOR=[32m
SET ECHONC=[0m
SET SLIDESDIR=.\slides\
SET HANDOUTDIR=.\handout\
SET BUILDDIR=.\build\
set TEXINPUTS=.;.\sty;
pushd .
for /d %%i in (.\texfiles\*) do call :$Build "%%i"
popd

exit /B

:$Build
IF not exist %BUILDDIR% ( mkdir %BUILDDIR% )
call :$Build_slides %~n1
Rem call :$Build_handout %~n1
exit /B

:$Build_slides
IF not exist %SLIDESDIR% ( mkdir %SLIDESDIR% )
call :$PDF1 %1
call :$BIB %1
call :$PDF2 %1
exit /B

:$Build_handout
IF not exist %HANDOUTDIR% ( mkdir %HANDOUTDIR% )
call :$MAKEHANDOUT %1
call :$PDF1 %1
call :$BIB %1
call :$PDF2 %1
call :$MAKESLIDES %1
exit /B

:$PDF1
echo %ECHOCOLOR%=======================================================================
echo Building PDF: %1 (1/2)
echo =======================================================================%ECHONC%
pdflatex -file-line-error -interaction=batchmode -synctex=1 -output-directory=%BUILDDIR% -jobname=%1 .\texfiles\%1\main.tex
echo %ECHOCOLOR%=======================================================================
echo Done!!
echo =======================================================================%ECHONC%
exit /B

:$PDF2
echo %ECHOCOLOR%=======================================================================
echo Building PDF: %1 (2/2)
echo =======================================================================%ECHONC%
pdflatex -file-line-error -interaction=batchmode -synctex=1 -output-directory=%BUILDDIR% -jobname=%1 .\texfiles\%1\main.tex
echo %ECHOCOLOR%=======================================================================
echo Done!!
echo =======================================================================%ECHONC%
exit /B

:$BIB
echo %ECHOCOLOR%=======================================================================
echo Building bibliography...
echo =======================================================================%ECHONC%
biber %BUILDDIR%%1
echo %ECHOCOLOR%=======================================================================
echo Done!!
echo =======================================================================%ECHONC%
exit /B

:$MAKEHANDOUT
powershell -Command "(gc .\texfiles\%1\main.tex) -replace '%handout-PLACEHOLDER', 'handout%PLACEHOLDER' | Out-File .\texfiles\%1\main.tex"
exit /B

:$MAKESLIDES
powershell -Command "(gc .\texfiles\%1\main.tex) -replace 'handout%PLACEHOLDER', '%handout-PLACEHOLDER' | Out-File .\texfiles\%1\main.tex"
exit /B