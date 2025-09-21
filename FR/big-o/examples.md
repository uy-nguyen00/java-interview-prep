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

# Exemple 4 - abandon des termes non dominants
![alt text](images/Figure_7.4_B15403.jpg)

- La première boucle est exécutée en O(n).
- La deuxième boucle est en O($n^2$).

&rarr; O(n) + O($n^2$) = O(n + $n^2$) ?

**Non!** 

- Le taux de croissance vient de $n^2$, tandis que n est terme **non dominant**.
- Si la taille du tableau augmente, alors $n^2$ affecte le taux de croissance bien plus que n &rarr; n n'est pas pertinent.

> Quelques exemples supplémentaires
- O($2^n + 2^n$) &rarr; abandonner les constantes et les termes non dominants &rarr; O($2^n$).
- O(n + log n) &rarr; abandonner les termes non dominants &rarr; O(n).
- O($3n^2 + n + 2n$) &rarr; abandonner les constantes et les termes non dominants &rarr; O($n^2$).

> [!NOTE] 
> Abandonner les termes non dominants.

# Exemple 5 - entrées différenes &rarr; variables différentes

*a et b sont des tableaux*
![alt text](images/Figure_7.5_B15403.jpg)

- **Snippet 1 :** 2 boucles parcourant le même tableau &rarr; O(n).
- **Snippet 2 :** 
    - 2 boucles
    - Mais 2 tableaux différents
    - **Big O != O(n)**
    - &rarr; Big O = O(a + b)

> [!NOTE]    
> Des entrées différentes &rarr; des variables différentes.

# Exemple 6 - Les différentes étapes sont additionnées ou multipliées
*a et b sont des tableaux*
![alt text](images/Figure_7.6_B15403.jpg)

- **Snippet 1 :** O(a + b)
- **Snippet 2 :** O(a * b)

# Exemple 7 - Temps d'exécution en log n
*Considérons les étapes de l'algo Binary Search: D'abord, nous comparons `x` avec le point central du tableau, `p`. Si `x > p`, nous cherchons la partie droite du tableau, et vice versa.*

![alt text](images/Figure_7.8_B15403.jpg)

- On commence avec 16 éléments et finit avec 1 élément.
- Après la 1ère étape, on n'a que 16 / 2 = 8 éléments.
- Après la 2ème étape, on n'a que 8 / 2 = 4 éléments.
- Après la 3ème étape, on n'a que 4 / 2 = 2 éléments.
- A la dernière étape, on trouve l'élément recherché, 17.

On peut traduire cet algo en pseudo-code:

    search 17 in {1, 4, 5, 7, 10, 16, 17, 18, 20, 23, 24, 25, 26, 30, 31, 33}

        compare 17 to 18 -> 17 < 18

        search 17 in {1, 4, 5, 7, 10, 16, 17, 18}

            compare 17 to 7 -> 17 > 7

            search 17 in {7, 10, 16, 17}

                compare 17 to 16 -> 17 > 16

                search 17 in {16, 17}

                    compare 17 to 17

                    return    

&rarr; L'algo consiste en une division continue par 2 jusqu'à ce qu'il reste qu'un seul élément.

&rarr; Temps d'exécution total dépend du nombre d'étapes nécessaires pour trouver un élément dans le tableau.

Dans l'exemple, on a 4 étapes (en divisant le tableau 4 fois). On peut l'exprimer comme suit :

$16 * \frac{1}{2} = 8; 8 * \frac{1}{2} = 4; 4 * \frac{1}{2} = 2; 2 * \frac{1}{2} = 1$ 

On peut le condenser comme suit :

$16 * (\frac{1}{2})^4 = 1$

On peut l'exprimer pour le cas général (où n est la taille du tableau, k est le nombre d'étapes pour atteindre la solution) :

$n * (\frac{1}{2})^k = 1$

=> $n * \frac{1}{2^k} = 1$

=> $2^k * \frac{n}{2^k} = 2^k$

=> $2^k = n$

$2^k = n$ est exactement ce que signifie le logarithme. On peut donc écrire :

$2^k = n $ &rarr; $log_2 n = k$

Dans notre cas, $2^k = n$ signifie $2^4 = 16$ donc $log_2 16 = 4$

> Le Big O pour l'algo Binary Search est O(log n). 

> Où est la base du log? &rarr; Pas nécessaire pour exprimer le Big O, car les logarithmes de bases différentes ne diffèrent que par un facteur constant. 

>[!NOTE]
> Lorsqu'on doit exprimer le Big O pour un algo qui divise son entrée par `2` à chaque étape/itération, il y a de grandes changes qu'il s'agisse d'un cas de O(log n).