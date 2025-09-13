# Programmation orientée objet

## 1. C'est quoi un objet? 
- Concept core de POO
- Entité du monde réel. Exemple: une voiture, une table, un chat
- Au cours de son cycle de vie, un objet possède un état et des comportements
    - État stocké dans ses champs (attributs). Ex: chat - couleur, nom, race
    - Comportements exposés par méthodes. Ex: jouer, manger, dormir
- C’est une instance d’une classe. Objet généré par “new”
- Occupe de l’espace dans la mémoire
- Peut communiquer avec d’autres objets. Ex: garçon caresse chat, chat dort

*Avoir modificateurs d’accès, visibilité, mutable, non modifiable / immutable, géré par garbage-collector.*

## 2. C'est quoi une classe? 
- Concept core de POO
- Modèle pour créer des objets, sorte de recette
- Ne consomme pas de mémoire
- Peut être instanciée plusieurs fois
- Faire **une seule chose** (Single Responsibility Principle)

*Avoir modificateurs d'accès, visibilité, prend en charge différentes types de variables (local, class, instances), déclarée `abstract, final, private`, peut être classe interne*


## 3. C'est quoi l'abstraction?
- Concept core de POO
- Exposer à l'utilisateur uniquement ce qui lui est pertinent, masquer les détails internes
- Réduire la complexité, réutiliser le code, éviter duplications --> faible couplage, forte cohésion

*Exemple: Homme qui conduit la voiture. Ne connait ce que les pédales et le volant font. No need comprendre mécanique interne.*

En Java, l'abstraction réalisée via les classes abstraites + interfaces.

## 4. C'est quoi l'encapsulation? 
- Concept core de POO
- Lier le code et les données dans une seule unité de travail (une classe)
- Cacher l'état de l'objet
- Exposer méthodes publiques
- Mécanisme data-hiding
- Faible couplage, réutilisable, sécurisé, facile à tester
- Implémenté par `public, private, protected` (modificateurs d'accès)

## 5. C'est quoi le polymorphisme?
- Concept core de POO
- Objet peut se comporter différemment dans certains cas
- Se manifester de 2 manières: 
    - Compile-Time Polymorphism / Surcharge de méthode (method overloading):
        - Plusieurs méthodes - même nom - signatures diff. (nombre, type, ordre des arguments)
        - Compilateur identifie quelle forme de méthode utiliser au moment de compilation
        - *Exemple: classe `Triangle` - plusieurs méthodes `draw()` avec plusieurs arguments diff.* 
    - Runtime Polymorphism / Method overriding:
        - Le plus courant -- relation **"IS-A"**, via l'héritage ou interfaces
        - Interface avec un ensemble de méthodes à redéfinir à l'implémentation / sous-classe
        - Exemple: Interface `Shape` - méthode `draw()`. Classes `Triangle`, `Rectangle`, `Circle` implémentent l'interface