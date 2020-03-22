# sulyozo_algoritmus
A szerver az egyes klienseket súlyozza aszerint, hogy a szerver által küldött tesztadatokat milyen százalékban találták el.



tesztadat:
1.sor: kliensek száma, s, örök száma
következő sorok: minden sorban a kliensek számának megfelelő oszlop leírjuk az egyes körökben elért teljesítményt százalékban

tesztadat példa:
3 0.5 4
50 70 80
55 65 85
65 60 90
66 62 91

itt a kliensek száma 3, tehát a következő sorok 3 számadatból fognak állni (szóközzel elválasztva)
s=0.5, ez a lenti képlet működése miatt fontos (minél kisebb, annál kisebb módosításokat végez a súlyozóalgoritmus)
körök száma = 4, tehát még 4 sornak kell szerepelnie
a további soroknál az egyes oszlopokat megnézve láthatjuk, hogy egy adott modell a körök során hogy teljesített 

mellékelve van egy sulyozo_test1.txt nevű tesztadat

az algoritmus lényegi része (körönként a képlet szerint frissül az egyes modellek súlya):

új_súly = előző_súly * e^(-s*ln((1-helyes)/helyes)) 

ahol
s: egy 0 és 1 között megválasztott szám (célszerű minél kisebb számot megadni)
helyes: a modell által helyesen megjósolt tesztadatok aránya (százalékban megadva)
