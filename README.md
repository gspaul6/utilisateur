#Interface utilisateur

- liste des tickets
- création
- modification
- suppression
- total par mois
* contrainte : 1 seul ticket par jour


Packages:-
1. utilisateur
In this package, a class name App is constructed with a console for an Utilisateur.
here a scanner and TicketsMemDao private variables are used.

2. entite
In this Package, class Tickets is constructed, for use as a library to store data, with values
a. date
b. intitule
c. montant

3. exception
In this package, two new exceptions are constructed, which extend RuntimeException ,
benifits:
dont have to mention try catch.

4. persistence
In this package, one interface with all the functions are constructed, which are then implemented by the TicketsMemDao class. 

5. service
In this package, all the service related to their function are constructed, here is the real interaction between the console and the MemDao 
takes place, with the help of Menu service, an abstract class with a single abstract function , with Scanner and TicketsMemDao as parameters.

