# RAPPORT


## Présentation (Classe RocketPokemonFactory)

Rapport des observations importantes sur la classe RocketPokemonFactory.

La classe RocketPokemonFactory est une implémentation de l'interface IPokemonFactory,
responsable de la création de Pokémon.

## Mes Observations

- **UnmodifiableMap :** La classe utilise une liste non modifiable pour stocker les noms des Pokémon.
  - Avis:
    - éviter les modifications des pokémons.
    - La classe UnmodifiableMap n’est pas standard.

- **Méthode generateRandomStat :** La méthode generateRandomStat génère un nombre aléatoire entre 0 et 100. Cependant, elle utilise une boucle de 1 000 000 d'itérations pour générer ce nombre. C'est une approche inefficace et 
  - Avis: non conseillé car 1 000 000 d'itérations pour générer ce nombre peut causer des problèmes de performance.

- **Utilisation de Random :** La classe utilise Random pour générer des nombres aléatoires.
  - Avis: peut causer des problèmes de performances car elle crée une nouvelle instance de Random à chaque appel de la méthode generateRandomStat.
  
- **Méthode createPokemon :** La méthode createPokemon crée un nouveau Pokémon en fonction de l'index, des points de combat, des points de vie, de la poussière et des bonbons.
Cependant, elle utilise des valeurs par défaut pour les statistiques si l'index est inférieur à 0.


## Mes Recommandations

- La méthode generateRandomStat devrait être améliorée pour générer des nombres aléatoires de manière plus efficace.
  - Exemple:
    ```
      private static int generateRandomStat() {
        Random rn = new Random();
        return rn.nextInt(101); // Génère un entier entre 0 et 100
      }
    ```
- Utiliser une instance unique de Random.
- Mapper tous les Pokémon pour compléter la classe.