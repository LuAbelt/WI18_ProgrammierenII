# Über dieses Verzeichnis

Dieses Verzeichnis enthält alle Dateien die benötigt werden, um das in der Vorlesung
verwendete Skript zu erstellen. Außerdem beinhaltet es auch die bereits komplett kompilierten
PDF Dateien für Handout und Präsentation.

# Struktur des Verzeichnisses

## graph

Der `graph` Ordner enthält alle im Skript eingebetteten Abbildungsdateien.

## handout

Der `handout` Ordner enthält das Handout der einzelnen Themenblöcke im PDF Format.
Das Handout unterscheidet sich von der Präsentation in sofern, dass Zwischenfolien
(zum Beispiel aufdecken von Punkten einer Aufzählung) nicht angezeigt werden. Lediglich
die kompletten Folien sind abgebildet.

## slides

Der `slides` Ordner enthält die Präsentationen der einzelnen Themenblöcke im PDF Format.
Die Präsentation unterscheidet sich vom Handout in sofern, dass Zwischenfolien
(zum Beispiel das aufdecken von Punkten einer Aufzählung) explizit als einzelne Folien
vorhanden sind. Somit sind alle "Zwischenschritte" ersichtlich

##sty

Der `sty` Ordner enthält die Style Dateien, die für dieses LaTeX Skript verwendet
werden.

## texfiles

Der `texfiles` Ordner enthält alle LaTeX Dateien des Skripts. Die einzelnen Unterordner
dieses Ordners repräsentieren die einzelnen Themenblöcke. Jeder Unterordner enthält 
eine `main.tex` Datei, die Hauptdatei des entsprechenden Skripts, das auch für den Build-Vorgang
verwendet wird. In allen Skripten gemeinsam genutzte Dateien werden direkt im `texfiles` Ordner
abgelegt.

# Selbst kompilieren des Skripts

## Linux

### Benötigte Pakete
Zum erstellen der Skripte werden folgende Pakete benötigt:
* pdflatex
* biber

Emfpohlen wird die Installation des texlive Pakets, damit die benötigten LaTeX
Pakete direkt mitinstalliert werden.

### Make
Für diese Variante muss das Paket "make" installiert sein.

Der Buildvorgang wird durch die hinterlegte Makefile automatisiert. Über das ausführen
des `make` Befehls werden automatisch alle Skripts, die nicht auf dem neuesten Stand
sind erstellt. Alle verfügbaren Make Regeln werden im folgenden aufgeführt.

#### all
Erstellt alle PDF Dateien

#### listfiles
Listet alle zu erstellenden Themenblöcke in der Konsole auf.

#### view
Öffnet alle PDF Dateien im definierten Viewer (Standard: Firefox)

#### %-view
Öffnet die im Platzhalter `%` spezifizierte PDF Datei im definierten Viewer (Standard: Firefox)

#### viewlog
Zeigt alle Warnungen und Errors der im LaTeX Buildprozess generierten Logdateien an.
Hilfreich, wenn während dem erstellen Fehler auftreten.

### Bash Script
Über das Skript `build_linux.sh` werden automatisch alle Skripte als Handout und Präsentation erstellt.

### Hinweise
Getestet wurden beide Buildvarianten lediglich über das Windows Subsystem für Linux. Dort wurden folgende 
Versionen verwendet:

* Distribution: Ubuntu
* Distribution Version: 14.04
* pdflatex Version: pdfTeX 3.1415926-2.5-1.40.14 (TeX Live 2013/Debian)
* biber Version: 1.8
* Make Version: 3.81

## Windows

Aktuell ist leider kein Build Script speziell für Windows vorhanden. Windows 10
Nutzer können jedoch alternativ die unter Linux aufgelisteten Varianten in Kombination
mit dem [Windows Subsystem für Linux](https://docs.microsoft.com/en-us/windows/wsl/install-win10)
verwendet werden.