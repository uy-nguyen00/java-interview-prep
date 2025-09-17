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