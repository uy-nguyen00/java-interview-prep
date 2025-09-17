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