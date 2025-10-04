# Quelques questions plus difficiles sur POO

## 1. C'est quoi "method overriding" (redéfinition de méthode) dans POO? 
- La redéfinition de méthode est une technique qui permet à une sous-classe de fournir une implémentation spécifique pour une méthode qui est déjà définie dans sa super-classe ou dans une interface qu'elle implémente
- Une forme de `Runtime Polymorphism` (polymorphisme d'exécution) / `Dynamic Method Dispatch`
- Permet à un objet de se comporter diff. selon sa classe réelle. *Exemple: Inteface `Shape` - méthode `draw()` - classes `Triangle`, `Rectangle` peuvent implémenter et redéfinir cette méthode*
- Objectif: Créer du code **flexible et extensible**

> Comment ça marche?
- JVM décide **au moment de l'exécution** quelle version de la méthode appelé, en se basant sur le type de l'objet &rarr; *dynamic / late binding*
- Technique utilisée dans **l'héritage**

> Règles et restrictions
- Même nom et signature
- Même type de retour ou sous-type
- Méthodes de types `private`, `static` ou `final` ne peuvent pas être redéfinies
- Visibilité: `public` ne peut pas être redéfinie en `protected`
- Exceptions: La méthode redéfnie ne peut pas lever de *checked exceptions* qui sont plus hautes dans la hiérarchie
- Annotation `@Override` fortement recommandé

```java
// L'héritage

public class Parent {

    public void execute() {
        System.out.println("Execute parent code ...");
    }
}

public class Child extends Parent {

    @Override
    public void execute() {
        // super.execute(); - if you want to execute the parent code first
        System.out.println("Execute child code ...");
    }
}
```

```java
// Polymorphisme

public interface Base {

    public void execute();
}

public class Concrete implements Base {

    @Override
    public void execute() {
        System.out.println("Execute concrete code ...");
    }

}
```

## 2. C'est quoi "method overloading" (surcharge de méthode) dans POO?
- Permet d'écrire plusieurs méthodes avec le même nom, mais avec des signatures différentes et des fonctionnalités distinctes
- Une forme de `Compile-Time Polymorphism` (polymorphisme de compilation)

> Points clés:
- Signature différente: Varie par le nombre, le type, l'ordre des arguments
- Type de retour: Ne fait pas partie: 2 méthodes - signatures identiques - types de retour différents &rarr; pas valide
- Liaison à la compilation: Le compilateur détermine quelle version appelée au moment de la compilation, en se basant sur les arguments
- Possible de surchager les méthodes `private`, `static` et `final`

*Exemple: Méthode `System.out.println()` possède plusieurs versions surchargées pour différents types de données*

```java
public class Foo {

    public void foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }

    // different number of arguments
    public void foozzy(String p, int q, int w) {
        System.out.println("Called foozzy(" + p + ", " + q + ", " + w + ")");
    }
    
    // different order of arguments
    public void foozzy(int q, String p) {
        System.out.println("Called foozzy(" + q + ", " + p + ")");
    }
    
    // different types of arguments
    public void foozzy(int p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }
    
    // not valid - different return type
    /* 
    public boolean foozzy(String p, int q) {
        System.out.println("Called foozzy(" + p + ", " + q + ")");
    }
    */
}
```

## 3. C'est quoi covariant method overriding (surcharge de méthode covariante)? 
- Introduit dans Java 5
- Permet à une méthode de surcharge de renvoyer un sous-type de son type de retour réel
- Avantage: éviter le `cast`

*Exemple: méthode `clone()` retourne un `Objet` &rarr; une méthode `clone()` surchargée peut retourner la sous-classe au lieu de `Object`.*

```java
public class Rectangle implements Cloneable {

    private final int height;
    private final int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }        

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {

        Rectangle clone = (Rectangle) super.clone();

        return clone;
    }

}

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Rectangle r = new Rectangle(4, 3);
        Rectangle clone = r.clone();

        System.out.println("Width: " + clone.getWidth());
        System.out.println("Height: " + clone.getHeight());
    }
}
```

## 4. Quelles sont les restrictions principales en travaillant la redéfinition (overriding) et la surcharge (overloading) de méthodes? 
> Restrictions pour la redéfinition de  méthode (method overriding)
- Utilisée dans l'**héritage** ou **polymorphisme à l'exécution** (Runtime Polymorphism)
- Règles principales:
    - **Signature identique** : Le nom + signature (y compris le type de retour ou son sous-type) doivent être les mêmes dans la super-class et sub-class
    - **Méthodes non-redéfinissables** : Méthodes `final`, `static` et `private` ne peuvent être réfinies
    - **Accessibilité** : Méthode `public` ne peut pas redéfinie en `protected`
    - **Exceptions** : Méthode de redéfinition ne peut pas lancer d'exceptions vérifiées (`checked exceptions`) qui sont plus hautes dans la hiérarchie. Acune restriction pour les exceptions non vérifiées (`unchecked exceptions`)
    - **Contexte** : Une méthode ne peut être redéfinie que dans une sous-classe

> Restrictions pour la surcharge de méthode (method overloading)    
- Permet d'avoir plusieurs méthodes avec le même nom mais des fonctionnalités différentes.
- Règles principales:
    - **Signature différente** : Cette technique est réalisée en changeant la signature de la méthode, cad le nombre, le type ou l'ordre des arguments
    - **Type de retour** : Le type de retour ne fait pas partie de la signature. Deux méthodes avec des signatures identiques mais des types de retour différents ne constituent pas une surcharge valide
    - **Méthodes surchargeables** : Les méthodes `private`, `static` ou `final`
    - **Exceptions** : Aucune restriction

> Exemple pour la redéfinition
```java
public class Parent {

    public void foo() throws SQLException {
        System.out.println("Executing Parent#foo() that throws SQLException");
        throw new SQLException("Parent#foo() did this!");
    }     
    
    public void buzz() {
        System.out.println("Executing Parent#buzz() that doesn't throw any exception");
    }
}


```

```java
public class Child extends Parent {

    // BatchUpdateException is subclass of SQLException      
    // of course, we can throw SQLException as well or other subclass of it
    @Override
    public void foo() throws BatchUpdateException { 
        System.out.println("Executing Child#foo() that throws BatchUpdateException");
        throw new BatchUpdateException("Child#foo() did this!", new int[0]);
    }        

    // we can throw and RuntimeException
    @Override
    public void buzz() {
        throw new RuntimeException("Child#buzz() did this!");
    }        
}
```

```java
public class Main {

    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();

        try {
            p.foo();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        System.out.println();
        
        try {
            c.foo();
        } catch (BatchUpdateException ex) {
            System.err.println(ex);
        }
        
        System.out.println();

        p.buzz();
        
        System.out.println();

        try {
            c.buzz();
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
    }
}
```

> Exemple pour la surcharge
```java
public class Clazz {

    public void foo(String foozzy) {
        System.out.println("Executing Clazz#foo() that doesn't throw any exception");
    }

    public void foo() throws SQLException {
        System.out.println("Executing Clazz#foo() that throws SQLException");
        throw new SQLException("Cazz#foo() did this!");
    }

    public void foo(int foozzy) {
        System.out.println("Executing Clazz#foo() that throws RuntimeException");
        throw new RuntimeException("Clazz#foo(int foozzy) did this!");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        Clazz clazz = new Clazz();

        clazz.foo("Foozzy");
        
        System.out.println();

        try {
            clazz.foo();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        System.out.println();

        try {
            clazz.foo(1);
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
    }
}
```

## 5. Peut-on redéfinir ou surcharger ma méthode main()?
- On peut surcharger la méthode `main()`, mais on ne peut pas la redéfinir
- **Surcharge** : Possible puisque c'est une méthode `static` (ainsi que les méthodes `private`, `final`)
- **Redéfinition** : Pas possible, puisque la méthode `main()` est `static`. Les méthodes `static` sont résolues à la compilation, tandis que les méthodes qui peuvent être redéfinies sont résolues à l'exécution en fonction du type de l'objet

## 6. Peut-on redéfinir une méthode non-statique en statique?
Non, et l'inverse non plus. Ces deux cas entraînent des erreurs de compilation

## 7. Dans Java, peut-on avoir des méthodes non-abstraites dans une interface?
- Oui, mais seulement depuis Java 8
- On peut donc ajouter des méthodes avec une implémentation directement dans les interfaces avec les mots-clé `default` et `static` :
    - `default` : Permet de faire évoluer les interfaces existantes dans casser le code qui les implémente, aussurant ainsi la rétrocompatibilité (backward compability)
    - `static` : Similaire aux méthodes `default`, mais ne peut pas être redéfinie (overriden) dans les classes qui implémentent l'interface

```java
public interface Vehicle {

    public void speedUp();

    public void slowDown();

    default double computeConsumption(int fuel, int distance, int horsePower) {        
        return Math.random() * 10d;
    }
    
    static void description() {
        System.out.println("This interface control steam, petrol and electric cars");
    }
}
```

```java
public class SteamCar implements Vehicle {

    private String name;

    public SteamCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void speedUp() {
        System.out.println("Speed up the steam car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the steam car ...");
    }
}
```

```java
public class ElectricCar implements Vehicle {

    private String name;
    private int horsePower;

    public ElectricCar(String name, int horsePower) {
        this.name = name;
        this.horsePower = horsePower;
    }

    public String getName() {
        return name;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public void speedUp() {
        System.out.println("Speed up the electric car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the electric car ...");
    }

    @Override
    public double computeConsumption(int fuel, int distance, int horsePower) {
        return Math.random() * 60d / Math.pow(Math.random(), 3);
    }     

}
```

```java
public class PetrolCar implements Vehicle {

    private String name;
    private int horsePower;

    public PetrolCar(String name, int horsePower) {
        this.name = name;
        this.horsePower = horsePower;
    }       

    public String getName() {
        return name;
    }

    public int getHorsePower() {
        return horsePower;
    }        
    
    @Override
    public void speedUp() {
        System.out.println("Speed up the petrol car ...");
    }

    @Override
    public void slowDown() {
        System.out.println("Slow down the petrol car ...");
    }    
}
```

```java
public class Main {

    public static void main(String[] args) {

        Vehicle.description();

        PetrolCar pc = new PetrolCar("Audi", 150);
        System.out.println("Petrol car consume: "
                + String.format("%.1f", pc.computeConsumption(250, 50, pc.getHorsePower()))
                + " l/100km");

        ElectricCar ec = new ElectricCar("Audi", 150);
        System.out.println("Electric car consume: "
                + String.format("%.1f", ec.computeConsumption(250, 50, ec.getHorsePower()))
                + " kW/h");
    }
}
```

## 8. Quelles sont les différences principales entre les interfaces avec les méthodes `default` et les classes abstraites?
- **Constructeur et état** : Une classe abstraite peut avoir un constructeur et un état (des variables d'instance). Par contre l'interface non
- **Objet et abstraction** : Classe abstraite - abstraction partielle. Interface - abstraction complète en spécifiant des contrats. Les méthodes `default` dans interfaces permettent d'ajouter des fonctionnalités sans modifier l'état ni casser le code client existant
- **Utilisation** :
    - Classe abstraite sans méthode abstraite &rarr; acceptable
    - Interface avec seulement les méthodes `default` &rarr; anti-pattern

## 9. Différences entre les classes abstraites et les interfaces?
- Classe abstraite peut contenir des méthodes non-abstraites
- Interface ne le peut pas
- Depuis Java 8, la différence principale: classe abstraite peut avoir les constructeurs et l'état. L'interface ne peut avoir aucun des deux

## 10. Peut-on avoir une classe abstraite sans aucune méthode abstraite?
Oui, on peut. En ajoutant le mot-clé `abstract`, une classe devient abstraite. Elle ne peut pas être instantié, pourtant elle peut avoir les constructeurs et seulement les méthodes non-abstraites

## 11. Une classe peut-elle être abstraite et finale en même temps?
Non, puisqu'une classe abstraite est censée d'être héritée, tandis qu'une classe finale ne l'est pas

## 12. Différences entre le polymorphisme, la redéfinition et la surcharge?
- **Surcharge** (Overloading) : 
    - Polymorphisme à la compilation (Compile-Time Polymorphism)
    - Utilise `static (early) binding`
    - 2 méthodes - même nom - signatures différentes
    - Peut se produire au sein de la même classe
- **Redéfinition** (Overriding) : 
    - Polymorphisme à l'exécution (Runtime Polymorphism) 
    - Utilise `dynamic (late) binding`
    - 2 méthodes - même nom + signature - comportements différents
    - Contexte de l'héritage / l'implémentation de l'interface

## 13. C'est quoi "method hiding" (masquage de méthode) dans Java?
- Se produit lorsque 2 méthodes static sont déclarées avec le même nom et la même signature - dans la super-class et la sub-class
- La méthode de sub-class masque donc celle de la super-class
- Points clés:
    - Ne s'applique qu'aux méthodes static
    - Nom de super-class &rarr; méthode de super-class. Nom de sub-class &rarr; méthode de sub-class
    - N'est pas la redéfinition (overriding), car méthodes static ne peuvent pas être polymorphes

```java
public class Vehicle {

    public static void move() {
        System.out.println("Moving a vehicle");
    }
}
```

```java
public class Car extends Vehicle {
    
    // this method hides Vehicle#move()
    public static void move() {
        System.out.println("Moving a car");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        Vehicle.move(); // call Vehicle#move()
        Car.move();     // call Car#move()
    }
}
```

## 14. Peut-on écrire des méthodes virtuelles en Java?
- Oui, c'est possible.
- En Java, par défaut, toutes méthodes sont virtuelles.
- Méthodes non-virtuelles :
    - `private` : car ne peut pas être héritée.
    - `static` : car ne peut pas être redéfinie.

## 15. Différences entre Polymorphisme et Abstraction?
- **Abstraction** : Solutions générales, réutilisables, personnalisables. Mise en oeuvre par `interfaces` + `classes abstraites`.
- **Polymorphisme** : Choix du code différé à l'exécution. Mise en oeuvre par `overriding` + `overloading`.

## 16. Considérez-vous la surcharge (overloading) comme une approche pour implémenter le polymorphisme?
- Sujet controversé.
- Surcharge &rarr; Compile-time polymorphism. 
- Est toujours considéré comme une forme de polymorphisme.

## 17. Classe abstraite <> Interface ?
| Points | Classe abstraite | Interface |
| ------ | ---------------- | --------- |
| Définition | Ne peut pas être instantié; contient les méthodes abstraites (sans impl.) et concrètes (avec impl.). | Ne peut pas être instantié; Possède les méthodes à impl. ; méthodes abstraites par défaut. |
| Manière d'implémentation | Peut avoir méthodes implémentées et abstraites. | Méthodes abstraites par défaut; Depuis Java 8, peut avoir méthodes `default` et `static`; Depuis Java 9, peut avoir méthodes `private`. |
| Héritage | Classe peut hériter **une seule** classe abstraite. | Classe peut implémenter **plusieurs** interfaces. |
| Modificateurs d'accès (méthodes + propriétés) | N'importe (`public`, `protected`, `private`). | Implicitement `public`. |
| Variables | `final`, `non-final`, `static`, `non-static`.| Implicitement `public`, `static`, `final` (constants). |