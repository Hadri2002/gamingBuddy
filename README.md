# Gaming Buddy
Webes program, ami segítségével el tudod tárolni a már általad befejezett videójátékok adatait

## Játékokról eltárolt adatok

* Játék neve (title)
* Játék értékelése 1-5-ig, illetve szavakkal (rating)
* Játék elkezdésének időpontja (startingDate)
* Játék befejezésének időpontja (endDate)

## RatingEnum
* Awful - 1
* Bad - 2
* Mid - 3
* Good - 4
* Amazing - 5

## Funkciók / Endpointok

* getAllGames - GET
    *  Kiiratja az eddigi összes letárolt játék minden adatát
* getGameRating - GET
    * Query paraméterként szükséges a kívánt játék címének a megadása
    * Visszaadja a keresett játék értékelését (amennyiben a játékot már eltároltuk)
```example
/gamingbuddy/application/getGameRating?game=Oxenfree
```
* addGame - POST
    * Új játék hozzáadása az xml adatbázisunkhoz
    * JSON-t fogad el bemeneti paraméterként
    * Amennyiben ilyen néven már létezik játék, nem adja hozzá megint az adatbázishoz
    * Ha nem adunk meg befejezési dátumot, vagy a kezdet előtti dátumot adunk meg, akkor automatikusan a mai dátumot állítja be
```example
{
    "title" : "Red Dead Redemption",
    "rating" : "Amazing",
    "startingDate": "2020-03-01",
    "endDate": "2022-05-06"
}
```


