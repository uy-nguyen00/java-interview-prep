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