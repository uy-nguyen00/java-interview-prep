# Indices clés à rechercher lors d'un entretien

**Stratégie principale** : Construire des cas concrets pour visualiser le temps d'exécution &rarr; comprendre détails du code + idenitifer les parties statiques et dynamiques.

> [!NOTE]
>
> **Stratégie principale** : Construire des cas concrets pour visualiser le temps d'exécution. 
>
> &rarr; Comprendre détails du code + Idenitifer les parties statiques et dynamiques.

**Indices clés** :
- **Travail constant** : Si un algo effectue une quantité de travail constante, indépendamment de la taille des inputs, sa complexité est $O(1)$.
- **Parcours d'une collection (tableau, liste, ...) entière** : Une complexité de $O(n)$ est comptée dans la valeur totale. Même la présene d'un `break` ne change généralement pas cette complexité.
- **Divison des inputs par 2** : Par exemple, recherche binaire. Complexité en $O(\log{n})$.
- **Récursion avec les branches** : Un problème récursif qui se divise en plusieurs branches est un bon signe que $O(branches^{profondeur})$ fait partie de la valeur totale. 
    - **Arbre binaire** : $O(2^{profondeur})$.
    - **Exemple 9** : Le profondeur peut influencer le résultat final. Dans ce cas, $O(2^{\log{n}})$ a été réduit à $O(n)$.
- **Récursion utilisant `Memoization` ou `Tabulation`** : Complexité réduite de $O(2^n)$ à $O(n)$.
- **Algos de tri** : De nombreux algos de tri courants (Heap Sort, Merge Sort, ...) ont une complexité de $O(n * \log{n})$.