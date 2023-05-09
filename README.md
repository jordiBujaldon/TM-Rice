# Codificació Rice

## Preguntes
**1. Quants bits son necessaris per codificar tots els enters entre -1023 i +1023 (en codificació binaria natural amb bit de signe)?**<br>

Per representar 1023 números en format binaris necessitem 10 bits ja que $2^{10}= 1024$. Aleshores per representar el signe positiu o negatiu hem d'afegir un bit a l'esquerra de tot sent el bit més significatiu determinant si és positiu (1) o negatiu (0).

**2. Calculeu el codi Rice de tots els enters N entre -1023 i +1023 amb M = 32.**<br>

El resultat sencer es podrà veure executant el codi que hi ha al fitxer [Main](https://github.com/jordiBujaldon/TM-Rice/blob/master/src/Main.java) del projecte. Un resum del resultat és el següent:
```
507 = 1 10 11111011 | total bits = 11
508 = 1 10 11111100 | total bits = 11
509 = 1 10 11111101 | total bits = 11
510 = 1 10 11111110 | total bits = 11
511 = 1 10 11111111 | total bits = 11
512 = 1 110 00000000 | total bits = 12
513 = 1 110 00000001 | total bits = 12
514 = 1 110 00000010 | total bits = 12
515 = 1 110 00000011 | total bits = 12
516 = 1 110 00000100 | total bits = 12
517 = 1 110 00000101 | total bits = 12
518 = 1 110 00000110 | total bits = 12
519 = 1 110 00000111 | total bits = 12
```
Els números 507-519 representen un petit rang dins del -1023 i +1023
