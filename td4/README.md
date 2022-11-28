## TD 4

### Exercice 1 : Refactoring de code

Une librairie permettant d'envoyer des mails aux délégués des promotions d'une filière a été réalisée avant Java 8 (voir ```promowarn/version1```). Malheureusement, la (mauvaise) gestion de l'absence de valeurs conduit potentiellement à des exceptions à l'exécution. Une seconde version a été réalisée (voir ```promowarn/version2```) en modifiant l'une des méthodes pour (en théorie) traiter ce problème. Pourtant cette version ne marche toujours pas.

**Question 1 :**
Proposez un refactoring de cette librairie pour répondre aux problèmes d'absence de valeur (utiliser l'API Optional).
Si d'autres parties du code peuvent être améliorées par l'utilisation des principes et APIs vus en cours, procédez aussi à cette amélioration.
