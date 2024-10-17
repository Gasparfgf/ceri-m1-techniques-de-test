# UCE Génie Logiciel Avancé : Techniques de tests

## Informations Étudiantes

- **Nom et Prénoms** : FRANCISCO Gaspar da Rosa
- **Groupe** : Gr1-ALT

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

## Avancement-TP4

À ce stade, le projet est bien avancé grâce à des bonnes pratiques de dévelopement qui contribuent à un projet sain et garantissent la fiabilité du code (et du logiciel par conséquent).

### Outils utilisés pour garantir la qualité et la fiabilité

1. **Code Coverage** :

  Codecov est utilisé pour surveiller la couverture des tests unitaires. Cela permet de nous assurer que la majorité du code est couvert par des tests, garantissant ainsi une meilleure fiabilité du projet.

3. **CircleCI** :

  CircleCI est utilisé pour l'intégration continue. Il s'assure que chaque commit et pull request passe par un processus automatisé de build et de test afin de maintenir la qualité du code.

4. **Mockito** :

  Mockito est utilisé pour simuler des objets et interactions dans les tests unitaires. Cela permet de tester les fonctionnalités de manière isolée, en simulant les dépendances du système.

5. **POM (Project Object Model)** :

  Le fichier `pom.xml` gère toutes les dépendances de ce projet Java via Maven, incluant les bibliothèques de test (JUnit, Mockito), et les plugins pour le build et la couverture de code.


### Badges

- **Circle CI** :

  [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Gasparfgf/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Gasparfgf/ceri-m1-techniques-de-test/tree/master)

- **Code coverage** :

  [![codecov](https://codecov.io/github/Gasparfgf/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=8ONP5BCPJ6)](https://codecov.io/github/Gasparfgf/ceri-m1-techniques-de-test)
