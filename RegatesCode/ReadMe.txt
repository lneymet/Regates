Bienvenu � l'application � Dahouet R�gates �

Cette application a pour objectif de vous permettre l'inscription aux r�gates des propri�taires de voiliers, des voiliers et des �quipiers dans une base de donn�es.

Utilisation:
Pr� requis:
- Vous devez installer Wamp Server et HeidiSQL
- Pour consulter le code source, vous devez installer Eclipse.

Premiers pas:
- Lancez Wamp Server
- Ouvrez HeidiSQL. Au d�marrage, cr�ez une nouvelle session avec le nom de votre choix. Dans l'onglet � Param�tres � cr�ez un utilisateur � dahouet_user � avec le mot de passe � devsujetado �.
- Appuyez sur "ouvrir"
- Click droit sur le nom de la session, cr�ez une nouvelle Base de Donn�es sous le nom de � dahouet �. S�lectionnez-la.
- Appuyez sur l�onglet � R�quetes � et glisser le fichier � BDD SQL Final.sql � (qui se trouve dans le dossier � resources � � la racine du projet). Vous devez voir la fen�tre se remplir avec du code SQL.
- Appuyez sur � Ex�cuter � (Fleche bleu �play- au milieu de la barre menu). La base de donn�es va se cr�er.
- Apr�s le succ�s de la cr�ation, vous pouvez r�duire HeidSQL.
- Cherchez le fichier � Dahouet.jar � et faites un double click sur l�icone de l�application.

Une fois dans l�application
Si tout se passe bien, vous pourrez acc�der aux inscriptions dans l�onglet sup�rieur gauche. Une fois l�enregistrement r�ussi, vous pouvez consulter la base de donn�es en HeidiSQL (dahouet � tables � propri�taire ou voilier ou �quipier) pour v�rifier la nouvelle entr�e.
C�est tout.
Pour acc�der au code-source, vous pouvez t�l�charger le projet sur le site : https://github.com/lneymet/Regates/tree/Dahouet_final
