loan-process-bonitaSoft
=======================

Simulation d'un processus de prêt bancaire avec un workflow et une composition de services

------------------------------
Organisation

Le workflow est organisé en 3 pools: 
- Pool "Portail Clients"
- Pool "Portail Services Financiers"
- Pool "Portail Services Partenaires"

------------------------------
Setup

- Serveur ODE 	        : port 8080
- Serveur Tomcat	: tomcat admin port: 8030
-   			: HTTP/1.1: 8091
-			: AJP/1.3: 8012
		
- Le Service Rest : ClientInfosRestService utilise le port 8182
- Les Services web ValidationWS et ProviderWS utilisent le port 8091
- Le service composite SCA utilise le port 8185
- Le service composite SCA a été développé sur deux projets java : ServicesBancairesSCA et ServicesBancairesSCAClient

------------------------------
Exécution

- Exécuter la classe RestDistributor du projet java ClientInfosRestService
- Exécuter les web servies : ValidationWS et ProviderWS
- Exécuter le BPEL 
