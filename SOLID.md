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