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
