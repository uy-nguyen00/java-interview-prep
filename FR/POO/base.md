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
