# Speedrun Can't Unsee

> A speedrun of "Can't Unsee" web site

Ce projet est sous licence **MIT** *(Massachusetts Institute of Technology)*,
une licence de logiciel pour logiciels *libres* et *open source*.

## Présentation

Ce projet est une automatisation du site [Can't Unsee](https://https://cantunsee.space).  
Il utilise la bibliothèque **Selenium** avec le navigateur **Firefox**.  

## Mise en route

Récupération du projet : 
~~~
    git clone https://github.com/ZelmoTheDragon/speedrun-cantunsee.git
    cd speedrun-cantunsee
    mvn install
~~~

Pour fonctionner, vous avez besoin du programme **Firefox** installé sur votre système.  

Exécution de l'application : 
~~~
cd target
java -jar speedrun-cantunsee-X.Y.Z.jar -firefox
~~~

> **Note :**
> Pour s'exécuter correctement, le JAR `speedrun-cantunsee-X.Y.Z.jar` à besoin du répertoire `libs` au même niveau.

