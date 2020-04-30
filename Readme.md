# Project - Joc RPG

**Tema proiectului** - un joc turn-based in care controlezi o echipa in cautarea unei comori. Mecanica bataliilor nu este inca implementata,
deci intr-o confruntare singurele optiuni valabile jucatorului sunt de a se preda(ceea ce duce la pierderea jocului) sau de a se lupta(optiune care elimina echipa adversa si permite jocului sa continue)
## Prima parte a proiectului - definire entitati, mosteniri

Proiectul este compus din 11 clase:
- **clasa Game** - clasa singleton care controleaza demersul jocului;

- **clasa Map** -  clasa care retine informatii despre harta si contine metode pentru mutarea prozitiilor grupurilor

- **clasa Battle** - clasa care controleaza batalia intre doua echipe

- **clasa Group** - clasa abstracta care contine informatii despre un grup, din care deriva clasele **Campaign** si **Mob**
                  - contine o lista sortata (TreeSet) de obiecte de tip **Creature**
                  
- **clasa Creature** - clasa abstracta(si cea mai complexa) care contine informatii si actiuni pe care la poate face fiecare membru al unui grup
                     - din aceasta clasa deriva clasele **Hunter**, **Warrior**, **Wizard** si **Goblin**
                     - obiectele acestei clase sunt comparabile in functie de hp
                     
- **clasa Effect** - clasa neimplementata, va descrie buffuri si debuffuri


## A doua parte a proiectului - fisiere CSV, serviciu de audit

Am introdus la acest proiect 3 fisiere CSV:
- **Classes.csv** - initializeaza valorile default ale atributelor fiecarei clase(**Warrior**, **Ranger**, **Wizard**, **Goblin**)
- **Campaign.csv** - initializeaza companionii default(numele si clasa) la inceperea jocului(implica **Campaign**)
- **Map.csv** - initializeaza harta jocului (implica **Map**)

De asemenea jucatorul are optiunea de a salva jocul, moemnt in care harta curenta se salveasa in fisierul **Map.csv**
La pornirea jocului, jucatorul are optiunea de a incepe un joc nou, sau de a continua progresul de la ultima salvare.
![img](https://raw.githubusercontent.com/stefzah/Project-PAO/master/b6cedbcae28ec078f362383d358512d6.png)

Toate datele din fisierele CSV sunt extrase si prelucrate cu ajutorul clasei **DataExtractor**

Pentru serviciul de audit am adaugat clasa Log, care este singleton.
![img](https://raw.githubusercontent.com/stefzah/Project-PAO/master/d32fce1ec29ea46ac90d2d49e339c46f.png)
