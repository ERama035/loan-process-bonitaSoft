loan-process-bonitaSoft
=======================

Simulation d'un processus de prêt bancaire avec un workflow et une composition de services
------------------------------
Organisation

Le workflow est organisé en 3 pools: 
	-1.Pool "Portail Clients"
	-2.Pool "Portail Services Financiers"
	-3.Pool "Portail Services Partenaires"

------------------------------
Hypothèses

-Le montant maximal accepté pour une demande de prêt est fixé à 100,000
-Si le montant du prêt demandé >=100,000 la demande sera rejetée et le client reçeva une notification préliminaire de refus.
-Le niveau de risque associé à un client est calculé sur la base de son solde disponible
 
	-Si montantPrêt>=2*soldeDisponible alors risque = high
		si montantPrêt>20.000 alors refus
		sinon résultat positif de l’étude de risque

	-Si soldeDisponible<montantPrêt<2*soldeDisponible alors risque = medium et résultat positif de l’étude de risque		

	-Sinon risque = low et résultat positif de l’étude de risque

-Si le résultat de l'étude du risque est positive, on demande au client de déposer un chèque dont le montant sera déduit du 
montant du prêt qu'il demande.

-Le montant du chèque à déposer = 0.1*montantPrêt

-Si montantChèque > soldeDisponible du client, le chèque ne sera pas validé, la demande sera refusée et le client notifié du refus

-Le montant du prêt sera ajouté au solde disponible du client après déduction du montant du chèque

------------------------------
Setup

Serveur ODE 	: port 8080
Serveur Tomcat	: tomcat admin port	: 8030
		: HTTP/1.1		: 8091
		: AJP/1.3		: 8012
Le Service Rest : ClientInfosRestService utilise le port 8182
Les Services web ValidationWS et ProviderWS utilisent le port 8091
Le service composite SCA utilise le port 8185
Le service composite SCA a été développé sur deux projets java : ServicesBancairesSCA et ServicesBancairesSCAClient

------------------------------
Exécution

-Exécuter la classe RestDistributor du projet java ClientInfosRestService
-Exécuter les web servies : ValidationWS et ProviderWS
-Exécuter le BPEL 


EN TANT QUE CLIENT 

	- Démarrer un cas "Portail Clients"
	- Saisir son id (id acceptables: 111, 222, 333)
	- Le service REST se charge de la récupération des informations disponibles sur le client à partir de l'id fourni
	- Vérifier ses informations et saisir le montant du prêt, son type( commercial ou personnel) avec un brève desription
	- Attendre le résultat de vérification préliminaire
	
EN TANT QUE ADMIN

	- Démarrer un cas "Portail Services Partenaires"


Scénario1	: Si la vérification préliminaire n'aboutit pas
EN TANT QUE CLIENT 
	- Recevoir le résultat de vérification préliminaire avec une notification de refus et une explication de la cause
	- Arrêt

EN TANT QUE ADMIN
	- Arrêt

Scénario2	: Si la vérification préliminaire aboutit
EN TANT QUE ADMIN
	- Démarrer un cas "Services Partenaires"
	- Transférer le dossier aux services partenaires
	- Attendre le résultat de l'étude du risque
	- Vérifier le niveau du risque

==> lancement des scripts de vérification du niveau de risque

Scénario2.1	: 
- Si l'étude de risque n'aboutit pas
EN TANT QUE ADMIN
	- Refuser la demande suite à l'étude de risque
	- Arrêt

- EN TANT QUE CLIENT
	- Recevoir le résultat de l'étude de risque
	- Recevoir la cause de refus 1
	- Arrêt

Scénario 2.2	: 
- Si l'étude de risque aboutit
==> lancement du script de calcul du montant du chèque à déposer
EN TANT QUE ADMIN
	- Attendre le dépôt du chèque
	- Vérifier le résultat de vérification du chèque
	
EN TANT QUE CLIENT
	- Déposer le chèque
==> appel au process BPEL de validation

Scénario 2.2.1	:
- Si le chèque n'a pas été validé
EN TANT QUE ADMIN
	- Arrêt
	- 
EN TANT QUE CLIENT
	- Recevoir la cause de refus 2
	- Arrêt

Scénario 2.2.2	:
- Si le chèque a été validé
==> appel au service Web du Provider
EN TANT QUE ADMIN
	- Accord et versement 
	- Arrêt
	- 
EN TANT QUE CLIENT
	- Recevoir la notification de l'accord et du versement
	- Arrêt
