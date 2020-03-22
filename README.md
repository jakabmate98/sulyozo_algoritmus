# sulyozo_algoritmus
A szerver az egyes klienseket súlyozza aszerint, hogy a szerver által küldött tesztadatokat milyen százalékban találták el.



tesztadat:
1.sor: kliensek száma, s, örök száma
következő sorok: minden sorban a kliensek számának megfelelő oszlop leírjuk az egyes körökben elért teljesítményt százalékban

mellékelve van egy sulyozo_test1.txt nevű tesztadat

az algoritmus lényegi része (körönként a képlet szerint frissül az egyes modellek súlya):
  új_súly = előző_súly * e^(-s*ln((1-helyes)/helyes)) 

ahol
s: egy 0 és 1 között megválasztott szám (célszerű minél kisebb számot megadni) |
helyes: a modell által helyesen megjósolt tesztadatok aránya (százalékban megadva)
