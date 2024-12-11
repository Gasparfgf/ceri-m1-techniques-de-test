# UCE Génie Logiciel Avancé : Techniques de tests

## Informations Étudiantes

- **Nom et Prénoms** : FRANCISCO Gaspar da Rosa
- **Groupe** : Gr1-ALT
- **N° étudiant** : uapv2502991

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

## Structure

**.circle CI** :
  
  Contient le fichier config.yml responsable pour l'intégration continue.

**.github** :
  
  Contient les fichiers github actions.

**models** :
  
  Ce dossier contient les classes modèles qui se concentrent uniquement sur la structure des données et la logique métier de base..
    - Par exemple : la classe *Pokemon* est un modèle parce qu'elle contient les attributs et comportements fondamentaux d'un Pokémon.
  - Chemin : *src/main/java/fr/univavignon/pokedex/api/models*

**repositories** :
  
  Ce dossier contient l'architecture qui sépare la logique métier de l'accès aux données. C'est à dire, les interfaces.
    - Par exemple : les interfaces comme *IPokedexFactory* définissent les contrats pour interagir avec les données, mais elles ne contiennent pas d'implémentation.
  - Chemin :
    - implémentations : *src/main/java/fr/univavignon/pokedex/api/repositories*
    - tests : *src/test/java/fr/univavignon/pokedex/api/repositories*

**Service** :
  
  Ce dossier contient l'implémentation de la logique métier et gère les règles d'accès aux données via les repositories. Ainsi vous y trouverez toutes les implémentations.
    - Par exemple : l'interface IPokemonRepository définit une méthode getPokemonById(int id). La classe PokemonRepositoryService implémente cette méthode en effectuant des appels SQL ou en manipulant une collection en mémoire.
  - Chemin :
    - implémentations : *src/main/java/fr/univavignon/pokedex/api/services*
    -  tests : *src/main/java/fr/univavignon/pokedex/api/services*


## Avancement-TP4

À ce stade, le projet est bien avancé grâce à des bonnes pratiques de dévelopement qui contribuent à un projet sain et garantissent la fiabilité du code (et du logiciel par conséquent).

### Outils utilisés pour garantir la qualité et la fiabilité

1. **Code Coverage** : 
  utilisé pour surveiller la couverture des tests unitaires. Cela permet de nous assurer que la majorité du code est couvert par des tests, garantissant ainsi une meilleure fiabilité du projet.

3. **CircleCI** : 
  utilisé pour l'intégration continue. Il s'assure que chaque commit et pull request passe par un processus automatisé de build et de test afin de maintenir la qualité du code.

4. **Mockito** : 
  utilisé pour simuler des objets et interactions dans les tests unitaires. Cela permet de tester les fonctionnalités de manière isolée, en simulant les dépendances du système.

5. **POM (Project Object Model)** : 
  Le fichier `pom.xml` gère toutes les dépendances de ce projet Java via Maven, incluant les bibliothèques de test (JUnit, Mockito), et les plugins pour le build et la couverture de code.

## Avancement - TP5

6. **Checkstyle** :
   pour garantir la qualité et la cohérence du code selon les standards définis. Les règles Checkstyle utilisées dans ce projet sont définies dans le fichier .github/workflows/checkstyle.xml

8. **Javadoc** :
   La documentation du code est générée automatiquement à l'aide de Javadoc. Elle sera disponible dans le dossier target/site/apidocs/.


### Badges

- **Circle CI** :

  [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Gasparfgf/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Gasparfgf/ceri-m1-techniques-de-test/tree/master)

- **Code coverage** :

  [![codecov](https://codecov.io/github/Gasparfgf/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=8ONP5BCPJ6)](https://codecov.io/github/Gasparfgf/ceri-m1-techniques-de-test)

- **Code quality** :
  ![Checkstyle Status](https://github.com/Gasparfgf/ceri-m1-techniques-de-test/actions/workflows/checkstyle.yml/badge.svg)
