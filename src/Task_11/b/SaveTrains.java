/**
 * 11b. Sichere Eisenbahnzüge
 * In Aufgabe 4f haben Sie Eisenbahnzüge modelliert. Verbessern
 * Sie diese erste Lösung mit Assertions und Exceptions:
 * Entscheiden Sie, welche Exceptionklassen benötigt werden.
 * Suchen Sie nach Klassen-Invarianten und sichern Sie diese mit Assertions
 * ab. Ein Beispiel: Jeder Zug enthält immer eine Lokomotive.
 * Gehen Sie alle Methoden durch und prüfen Sie den zulässigen Wertebereich
 * jedes Parameters. Fangen Sie alle unzulässigen Parameterwerte ab.
 * Schreiben Sie ein Testprogramm, das gezielt Fehler provoziert und die
 * korrekte Reaktion abprüft. Einige Beispiele:
 * Aufruf des Train-Konstruktors mit null;
 * Aufruf des Train-Konstruktors mit einer Lokomotive, an der schon Wagen
 * hängen;
 * Einhängen eines Wagens null mit add;
 * Einhängen eines Wagens mit add, der bereits Teil dieses Zuges ist;
 * Umhängen von Wagen mit relink mit demselben Zug als Parameter;
 * Einhängen eines Wagens in zwei verschiedene Züge.
 */
