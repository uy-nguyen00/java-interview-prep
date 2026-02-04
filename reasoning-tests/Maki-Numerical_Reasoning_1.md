# Guide d'Entraînement : Tests de Raisonnement Numérique

Ce document compile 15 exercices d'entraînement (10 de niveau intermédiaire et 5 de niveau avancé) avec leurs solutions détaillées et les méthodes de calcul associées.

---

## Partie 1 : Niveau Intermédiaire (Fondamentaux)

### Question 1 : Suite logique visuelle

**Question :** Trouvez le nombre manquant dans la séquence suivante :
`14 - 64 - 38 - 98 - 52 - ?`

* **Réponse :** 22
* **Explication :**
    Cette suite ne repose pas sur une opération mathématique classique (+ ou -), mais sur une **observation visuelle** des chiffres.
    Regardez les nombres par paires :
  * 1**4** et 6**4** se terminent par **4**.
  * 3**8** et 9**8** se terminent par **8**.
  * 5**2** se termine par **2**, donc le nombre suivant doit aussi se terminer par **2**.
  * Parmi les options logiques, **22** est la bonne réponse.

### Question 2 : Répartition des tâches (Proportions)

**Question :** Dans une équipe, Alice réalise 30% du travail, Bob en réalise 2/5, et Charlie s'occupe du reste. Si Charlie a traité 45 tâches, combien de tâches y avait-il au total ?

* **Réponse :** 150
* **Explication :**
    1. Convertissons tout en décimales ou pourcentages :
        * Alice = 30% = 0,3
        * Bob = 2/5 = 0,4 (40%)
    2. Calculons la part déjà effectuée : $0,3 + 0,4 = 0,7$ (soit 70%).
    3. La part de Charlie est donc le reste : $1 - 0,7 = 0,3$ (soit 30%).
    4. Nous savons que ces 30% correspondent à 45 tâches.
    5. Calcul du total ($T$) : $0,3 \times T = 45 \rightarrow T = 45 / 0,3 = 150$.

### Question 3 : Équilibre d'équation

**Question :** Équilibrez l'équation suivante : $(9/2 + 0,25) = 2,5 + ?$

* **Réponse :** 2,25
* **Explication :**
    1. Résolvons le côté gauche :
        * $9/2 = 4,5$
        * $4,5 + 0,25 = 4,75$
    2. Posons l'équation : $4,75 = 2,5 + ?$
    3. Isolons l'inconnue : $? = 4,75 - 2,5 = 2,25$.

### Question 4 : Progression géométrique

**Question :** Quel est le prochain nombre de la suite ? `3 - 6 - 12 - 24 - 48 - ?`

* **Réponse :** 96
* **Explication :**
    Il s'agit d'une suite géométrique simple où chaque terme est le **double** du précédent (multiplication par 2).
  * $48 \times 2 = 96$.

### Question 5 : Calcul budgétaire (Fractions)

**Question :** Un budget est réparti ainsi : 1/3 pour la TV, 25% pour le digital, et le reste pour l'événementiel (25 000 €). Quel est le budget total ?

* **Réponse :** 60 000 €
* **Explication :**
    1. Mettons les parts au même dénominateur (12 est idéal ici) :
        * TV : $1/3 = 4/12$
        * Digital : $25\% = 1/4 = 3/12$
    2. Total TV + Digital = $4/12 + 3/12 = 7/12$.
    3. La part restante (Événementiel) est donc : $12/12 - 7/12 = 5/12$.
    4. On sait que $5/12$ du total = 25 000 €.
    5. Pour trouver $1/12$, on divise par 5 : $25 000 / 5 = 5 000$.
    6. Pour trouver le total ($12/12$), on multiplie par 12 : $5 000 \times 12 = 60 000$.

### Question 6 : Opérations inversées

**Question :** Trouvez la valeur manquante : $12,6 \div 3 = ? - 1,8$

* **Réponse :** 6,0
* **Explication :**
    1. Calcul à gauche : $12,6 / 3 = 4,2$.
    2. Équation simplifiée : $4,2 = ? - 1,8$.
    3. Pour isoler le « ? », on inverse la soustraction par une addition :
        * $? = 4,2 + 1,8 = 6$.

### Question 7 : Suite à écart croissant

**Question :** Quelle est la suite logique : `100 - 97 - 92 - 85 - 76 - ?`

* **Réponse :** 65
* **Explication :**
    Calculons la différence entre chaque terme consécutif :
  * $100 - 97 = -3$
  * $97 - 92 = -5$
  * $92 - 85 = -7$
  * $85 - 76 = -9$
    La logique est de soustraire des nombres impairs croissants. Le prochain écart est donc **-11**.
    * $76 - 11 = 65$.

### Question 8 : Intérêts et Capital

**Question :** Un investissement rapporte 5% la première année. Le capital total (principal + intérêts) est de 21 000 €. Quel était le montant initial ?

* **Réponse :** 20 000 €
* **Explication :**
    Le montant final représente 105% du montant initial (100% de capital + 5% d'intérêts).
  * Soit $X$ le montant initial.
  * $X \times 1,05 = 21 000$
  * $X = 21 000 / 1,05 = 20 000$.

### Question 9 : Suite alternée

**Question :** Complétez la suite : `5 - 10 - 20 - 15 - 30 - 25 - 50 - ?`

* **Réponse :** 45
* **Explication :**
    Observez les transitions d'un nombre à l'autre :
  * $5 \rightarrow 10$ ($\times 2$)
  * $10 \rightarrow 20$ (erreur dans l'énoncé original, la suite corrigée pour la logique était $5 \rightarrow 10 \rightarrow 5 \rightarrow 10 \dots$ ou la logique fournie dans la solution : $\times 2$ puis $-5$).
    * Reprenons la logique validée dans le quiz (basée sur la fin de la suite) :
    * $15 \rightarrow 30$ ($\times 2$)
    * $30 \rightarrow 25$ ($-5$)
    * $25 \rightarrow 50$ ($\times 2$)
    * $50 \rightarrow ?$ ($-5$)
    * Résultat : $50 - 5 = 45$.

### Question 10 : Fraction d'un entier

**Question :** Équilibrez l'équation : $3/8$ de $64 = ? \times 12$

* **Réponse :** 2
* **Explication :**
    1. Calcul à gauche :
        * $64 / 8 = 8$
        * $8 \times 3 = 24$
    2. Équation : $24 = ? \times 12$
    3. $? = 24 / 12 = 2$.

---

## Partie 2 : Niveau Avancé (Complexité accrue)

### Question 11 : Double suite entrelacée

**Question :** Quel est le nombre manquant ? `5 - 50 - 7 - 48 - 10 - 44 - 14 - ?`

* **Réponse :** 38
* **Explication :**
    Il faut séparer la suite en deux séries distinctes :
  * Rangs impairs (1, 3, 5, 7) : 5, 7, 10, 14. Écarts : $+2, +3, +4$.
  * Rangs pairs (2, 4, 6, 8) : 50, 48, 44, ?. Écarts : $-2, -4$.
    La suite logique des écarts pairs double à chaque fois ($-2, -4, -6$ ou $-8$ ?). Ici, la logique arithmétique suggère une progression ($2, 4, 6$).
  * $44 - 6 = 38$.

### Question 12 : Rendement pondéré de portefeuille

**Question :** Répartition : 40% (rendement 10%), 1/4 (rendement 4%), Reste (0%). Gain total = 6 000 €. Capital total ?

* **Réponse :** 120 000 €
* **Explication :**
    Calculons le rendement moyen de chaque euro investi :
    1. Part 1 : $0,40 \times 0,10 = 0,04$ (4%)
    2. Part 2 : $0,25 \times 0,04 = 0,01$ (1%)
    3. Part 3 : Le reste $\times 0 = 0$.
    4. Rendement total combiné = $4\% + 1\% = 5\%$.
    5. Si $5\%$ du Capital = 6 000 €, alors $10\% = 12 000 €$, et $100\% = 120 000 €$.
  * Calcul direct : $6 000 / 0,05 = 120 000$.

### Question 13 : Proportionnalité (Débit)

**Question :** 3 imprimantes font 1 200 pages en 4h. Temps pour 5 imprimantes et 2 500 pages ?

* **Réponse :** 5 heures
* **Explication :**
    Utilisons la méthode unitaire (trouver la capacité d'une machine par heure).
    1. 3 imprimantes en 4h = 1 200 pages.
    2. 3 imprimantes en 1h = $1 200 / 4 = 300$ pages.
    3. 1 imprimante en 1h = $300 / 3 = 100$ pages (C'est la vitesse unitaire).
    4. Maintenant, prenons 5 imprimantes : Vitesse = $5 \times 100 = 500$ pages/heure.
    5. Objectif : 2 500 pages.
    6. Temps = $2 500 / 500 = 5$ heures.

### Question 14 : Équation avec racines et carrés

**Question :** Trouvez $x$ positif : $(7/4 \times 16) - \sqrt{81} = x^2 + 10$

* **Réponse :** 3
* **Explication :**
    1. Simplifions le terme de gauche :
        * $16 / 4 = 4$
        * $4 \times 7 = 28$
        * $\sqrt{81} = 9$
        * Gauche = $28 - 9 = 19$.
    2. Équation : $19 = x^2 + 10$.
    3. $x^2 = 19 - 10 = 9$.
    4. $x = \sqrt{9} = 3$.

### Question 15 : Suite à opération composée

**Question :** Complétez la suite : `3 - 10 - 31 - 94 - ?`

* **Réponse :** 283
* **Explication :**
    Il faut trouver une relation constante entre les termes.
  * $3 \rightarrow 10$ : $\times 3 + 1$ ($9 + 1 = 10$)
  * $10 \rightarrow 31$ : $\times 3 + 1$ ($30 + 1 = 31$)
  * $31 \rightarrow 94$ : $\times 3 + 1$ ($93 + 1 = 94$)
  * Calcul final : $94 \times 3 + 1$.
    * $90 \times 3 = 270$
    * $4 \times 3 = 12$
    * $270 + 12 = 282$
    * $282 + 1 = 283$.
