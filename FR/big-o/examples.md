# Exemple 1 - O(1)

```java
return 23;
```
&rarr; O(1)

```java
// cars est un tableau
int thirdCar = cars[3];
```
&rarr; O(1). Quel que soit le nombre d'éléments dans le tableau, obtenir un élément à partir de l'index est une opération constante.

```java
// 'cars' est un java.util.Queue
Car car = cars.peek();
```
- La méthode `Queue#peek()` récupère, mais ne supprime pas, la tête (1er élément) de cette file d'attente. 
- Nombre d'éléments qui suivent la tête n'a pas d'importance.
- Le temps de la méthode `peek()` est de O(1).

# Exemple 2 - O(n) - algo en temps linéaire
```java
// 'a' est un tableau
for (int i = 0; i < a.length; i++>) {
    System.out.println(a[i]);
}
```
- Combien de fois la boucle itère? &rarr; a.length fois.
- Le temps augmente de manière linéaire avec la taille du tableau.
- Temps de O(a.length) = O(n)

# Exemple 3 - O(n) - abandon des constants (dropping the constants)
```java
// 'a' est un tableau
for (int i = 0; i < a.length; i ++) {
    System.out.println("Current element:");

    System.out.println(a[i]);

    System.out.println("Current element + 1:");

    System.out.println(a[i] + 1);
}
```
&rarr; O(n)

![alt text](images/Figure_7.3_B15403.jpg)

&rarr; Le cas 2 a un temps de O(2n) = O(n)