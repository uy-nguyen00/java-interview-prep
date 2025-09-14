# Principes SOLID
**S:** Single Responsibility Principle

**O:** Open Closed Principle

**L:** Liskov's Substitution Principle

**I:** Interface Segregation Principle

**D:** Dependency Inversion Principle

## 1. C'est quoi S?
- Single Responsibility Principle (SRP)
- Un des 5 principes de Object-Oriented Design (OOD)
- Une classe ne devrait avoir qu'une seule, et une seule, responsabilité
- Avantages:
    - Grande maintenabilité
    - Contrôle de la visibilité à travers les modules de l'application
    - Contribuer à l'encapsulation
- Une classe viole le principe SRP lorsqu'on utilise le mot **"et"** pour décrire ce qu'elle fait

*Exemple: Classe `RectangleAreaCalculator` dont la responsabilité est de calculer l'aire d'un rectangle. Si cette classe inclut une méthode `metersToInches()` pour convertir l'aire en pouces, elle enfreint le SRP.*

*Pour respecter le SRP, la solution consiste à:*
- Laisser la classe `RectangleAreaCalculator` se concentrer uniquement sur le calcul de l'aire `area()`
- Extraire la conversion dans une classe séparée, par exemple `AreaConverter`

## 2. C'est quoi O?
- Open Closed Principle
- Un des 5 principes de OOD
- Ouvert à l'extension, fermé à la modification
- Classes conçues de manière à ce que d'autres dev puissement modifier leur comportement en les étendant, sans avoir à modifier le code original de ces classes

*Exemple: Calcul de la somme des aires de différentes formes géométriques (rectangles, cercles, triangles...)*
> Non-conformité à l'OCP:
> - Interface `Shape` - Classes `Rectangle`, `Circle` l'implémentent
> - Class `AreaCalculator` - méthode `sum()` utilisant `if-else` pour déterminer le type de chaque forme et calculer leurs aires

> Conformité à l'OCP:
> - Méthode `area()` ajoutée à `Shape`
> - Classes `Rectangle`, `Circle` l'implémentent
> - Classe `AreaCalculator`: méthode `sum()` itère sur la liste des objets de type `Shape` + appelle `area()` de chaque forme