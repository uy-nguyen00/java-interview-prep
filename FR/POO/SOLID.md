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

## 3. C'est quoi L?
- Liskov's Substitution Principle
- Un des 5 principes de OOD
- Les types dérivées doivent être entièrement substituables à leurs types de base: 
    - Objets des sous-classes se comportent comme les objets des super-classes
- Utile pour **runtime-type identification** suivie d'un `cast`

*Exemple: Club d'échecs avec diff types de membres: `PremiumMember`, `VipMember` et `FreeMember`. Classe abstraite de base `Member`.*

> Non-conformité au LSP:
> - `Member`: méthodes `joinTournament()` et `organizeTournament()`
> - Classes `PremiumMember` et `VipMember` peuvent implémenter ces 2 méthodes
> - Classe `FreeMember` implémente `joinTournament()`, mais affiche un message d'erreur pour `organizeTournament()`
> - Donc `FreeMember` ne peut pas substituer la classe de base `Member()`

> Conformité au LSP:
> - 2 interfaces: `TournamentJoiner` et `TournamentOrganizer`
> - Classe abstraite `Member` implémente ces 2 interfaces
> - Classes `PremiumMember` et `VipMember` étendent `Member`
> - Classe `FreeMember` n'étend pas `Member`, mais implémente **uniquement** `TournamentJoiner`
> - Donc: une liste de `TournamentJoiner` peut contenir tous les types de membres, tandis qu'une liste de `TournamentOrganizer` ne contient que `PremiumMember` et `VipMember`

## 4. C'est quoi I?
- Interface Segregation Principle
- Les clients ne doivent pas être contraints d'implémenter des méthodes initules qu'ils n'utiliseront pas
    - Faut donc diviser les interfaces volumineuses en plusieurs intefaces plus petites et plus spécifiques
    - L'objectif: clients n'implémentent que les méthodes pertinentes, évitant des implémentations vides des méthodes inutiles

*Exemple: La gestion de différents types de connexions réseau*

> Non-conformité à l'ISP:
> - Interface `Connection` - méthodes pour tous types de connexion `socket()`, `http()` et `connect()`
> - Classe cliente `WwwPingConnection` ne gère que les connexions HTTP. Il est donc obligé d'implémenter l'interface `Connection` complète
> - Cette classe fournit une implémentation utile pour `http()` et `connect()`, mais est forcée d'implémenter `socket()` vide ou qui lève une exception

> Conformité à l'ISP:
> - Faut donc séparer ("ségréger") l'interface `Connection`:
    > - Interface `Connection` - méthode `connect()`
    > - Interfaces enfants `HttpConnection` et `SocketConnection` - méthodes `http()` et `socket()`
> - Classe `WwwPingConnection` n'implémente que l'interface `HttpConnection`

## 5. C'est quoi D?
- Dependency Inversion Principle
- Un des 5 principes de OOD
- Dépendre des abstractions, et non des implémentations concrètes:
    - Appuyer sur des couches abstraites pour lier des modules entre eux
    - &rarr; Tous les modules concrets doivent exposer uniquement des abstractions
    - &rarr; Modules concrets permettent l'extension des fonctionnalités ou l'intégration d'un autre module concret - tout en maintenant **le découplage**   

*Exemple: Classe de haut niveau `ConnectToDatabase`, qui a besoin d'une URL JDBC de bas niveau pour se connecter à une BDD.*

> Non-conformité au DIP:
> - Si `connect()` de la classe `ConnectToDatabase` prend un argument de type `PostgreSQLJdbcUrl`, elle dépend d'une implémentation concrète
> - Si on veut utiliser `MySQLJdbcUrl`, on peut pas utiliser la méthode `connect()` existant

> Conformité au DIP:
> - Faut donc créer une **abstraction**: interface `JdbcUrl`
> - Classe `PostgreSQLJdbcUrl` l'implémente - ainsi que la classe `MySQLJdbcUrl` ou `OracleJdbcUrl`
- `connect()` dépend donc de l'abstraction `JdbcUrl` &rarr; permets de se connecter à n'importe quelle BDD pour laquelle une implémentation `JdbcUrl` existe