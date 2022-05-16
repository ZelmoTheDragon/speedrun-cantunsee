# Speedrun Can't Unsee

> A speedrun of "Can't Unsee" web site

Ce projet est sous licence **CeCILL** (**CE**A **C**NRS **I**NRIA **L**ogiciel **L**ibre),
une licence de logiciel libre compatible avec **GNU GPL**.

> En savoir plus sur la licence [CeCILL](http://cecill.info/index.fr.html).

## Présentation

Ce projet est une automatisation du site [Can't Unsee](https://https://cantunsee.space).  
Il utilise l'outil **Selenium** avec le navigateur **Firefox**.  

## Mise en route

Récupération du projet : 
~~~
    git clone https://github.com/ZelmoTheDragon/speedrun-cantunsee.git
    cd speedrun-cantunsee
    mvn install
~~~

Pour fonctionner, vous avez besoin du programme **Firefox** installé sur votre système.  
Vous devez aussi récupérer le pilote du navigateur : [Gecko](https://github.com/mozilla/geckodriver/releases).
Le fichier pilote sera passé en argument sous la forme: '-Dwebdriver.gecko.driver=<geckodriverPath>'.  

Exécution de l'application : 
~~~
cd target
java -jar -Dwebdriver.gecko.driver=geckodriver speedrun-cantunsee-X.Y.Z.jar
~~~

> **Note :**
> Pour s'exécuter correctement, le JAR 'speedrun-cantunsee-X.Y.Z.jar' à besoin du répertoire 'libs' au même niveau.  





