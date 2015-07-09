Bienvenu à l'application « Dahouet Régates »

Cette application a pour objectif de vous permettre l'inscription aux régates des propriétaires de voiliers, des voiliers et des équipiers dans une base de données.

Utilisation:
Pré requis:
- Vous devez installer Wamp Server et HeidiSQL
- Pour consulter le code source, vous devez installer Eclipse.

Premiers pas:
- Lancez Wamp Server
- Ouvrez HeidiSQL. Au démarrage, créez une nouvelle session avec le nom de votre choix. Dans l'onglet « Paramétres » créez un utilisateur « dahouet_user » avec le mot de passe « devsujetado ».
- Appuyez sur "ouvrir"
- Click droit sur le nom de la session, créez une nouvelle Base de Données sous le nom de « dahouet ». Sélectionnez-la.
- Appuyez sur l’onglet « Réquetes » et glisser le fichier « BDD SQL Final.sql » (qui se trouve dans le dossier « resources » à la racine du projet). Vous devez voir la fenêtre se remplir avec du code SQL.
- Appuyez sur « Exécuter » (Fleche bleu –play- au milieu de la barre menu). La base de données va se créer.
- Après le succès de la création, vous pouvez réduire HeidSQL.
- Cherchez le fichier « Dahouet.jar » et faites un double click sur l’icone de l’application.

Une fois dans l’application
Si tout se passe bien, vous pourrez accéder aux inscriptions dans l’onglet supérieur gauche. Une fois l’enregistrement réussi, vous pouvez consulter la base de données en HeidiSQL (dahouet – tables – propriétaire ou voilier ou équipier) pour vérifier la nouvelle entrée.
C’est tout.
Pour accéder au code-source, vous pouvez télécharger le projet sur le site : https://github.com/lneymet/Regates/tree/Dahouet_final
