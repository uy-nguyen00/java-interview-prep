# SOLID + GOF + Design Patterns

## 1. Quel concept POO sert le patron de conception `Decorator` ?
**Composition**. Grâce à cela, le patron de conception Decorator fournit de nouvelles fonctionnalités sans modifier la classe d'origine.

![alt text](img/decorator-1.png)

## 2. Quand utiliser Singleton ?
- Quand on a besoion d'**une seule instance** d'une classe au niveau de l'appli.
- Cependant, cela augmente le **couplage entre les classes** &rarr; bottleneck lors du développement, tests et debug.
- Bonne utilisation : 
    - `enum` meilleure façon d'implémenter.
    - Configs globales (loggers, java.lang.Runtime).
    - Accès au matériel (hardware).
    - Connexions aux BDD.