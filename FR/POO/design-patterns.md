# SOLID + GOF + Design Patterns

## 1. Quel concept POO sert le patron de conception `Decorator` ?
**Composition**. Grâce à cela, le patron de conception Decorator fournit de nouvelles fonctionnalités sans modifier la classe d'origine.

![alt text](img/decorator-1.png)

## 2. Quand utiliser Singleton ?
- Quand on a besoion d'**une seule instance** d'une classe au niveau de l'appli.
- Cependant, cela augmente le **couplage entre les classes** &rarr; bottleneck lors du développement, tests et debug.
- Bonne utilisation : 
    - `enum` meilleure façon d'implémenter.
    - Configs globales (loggers, java.lang.Runtime).
    - Accès au matériel (hardware).
    - Connexions aux BDD.

## 3. Diff. Strategy <> State design patterns ?

### Strategy
![alt text](img/strategy-1.png)

- Permet de basculer entre diff. algos.
- Les algos sont utilisés de manière ineterchangeable par le client via la composition et la délégation à l'exécution.
- Le client peut choisir l'algo qu'il souhaite, dans n'importe quel ordre. 
    - Par exemple, diff. stratégies pour livrer un colis.

### State
![alt text](img/state-1.png)

- Le comportement dépend de l'état.
- Affiche des comportements différents dans des états différents sans changer la classe.
- Possède un ordre clair de transition d'état, créant un flux en liant chaque état à un autre.
    - Par exemple, un colis peut passer de l'état *Commandé* &rarr; *Expédié* &rarr; *Livré*.

## 4. Diff. Proxy <> Decorator ?

### Proxy
![alt text](img/proxy-1.png)

- Fournit une passerelle pour contrôler l'accès à un objet.
- Crée des objets "proxy" qui se substituent à l'objet réel.
- Décide comment et quand transférer les requêtes à l'objet réel.
- Le chaînage des proxies n'est pas recommandé.

### Decorator
![alt text](img/decorator-1.png)

- Ne crée pas d'objets.
- Décore un objet existant avec de nouvelles fonctionnalités à l'exécution.
- Le chaînage de décorateurs dans un certain ordre est une manière correcte d'exploiter ce patron.

## 5. Diff. Facade <> Decorator ?

### Facade
![alt text](img/facade-1.png)

- N'ajoute pas de nouvelles fonctionnalités.
- Sert de "façade" aux fonctionanlités existantes en masquant la complexité du système.
- Expose une interface qui appelle des composants individuels pour accomplir des tâches complexes.

### Decorator
![alt text](img/decorator-1.png)

- Ajoute de nouvelles fonctionnalités à un objet existant (décorer l'objet).