# Web-Serveur


## **Système de Gommette**

Rapport TP - Web Serveur Licence Informatique - L2
Université Clermont Auvergne


## **La Modélisation**

Les fonctionnalités :

- Enregistrer un élève ;
- Supprimer un élève ;
- Modifier un élève ;
- Créer une gommette ;
- Supprimer une gommette ;
- Modifier une gommette ;
- Donner une gommette à un élève ;
- Enlever une gommette d’un élève ;
- Authentification de professeur ;
- Enregistrer un professeur ;

Les principales classes :

- StudentEntity / StudentGUI / StudentDAO / StudentCore ;
- StickerEntity / StickerGUI / StickerDAO / StickerCore ;
- TeacherEntity / TeacherGUI / TeacherDAO / TeacherCore ;
- StudentStickerEntity / StudentStickerGUI / StudentStickerDAO / StudentStickerCore ;
- StartServer (routes) ;

Les tables de la base de données :

- students ;
- stickers ;
- teachers ;
- studentStickers ;

![](https://raw.githubusercontent.com/rafaelbenaion/project-gommet/master/src/Aspose.Words.75a00ed7-36e9-426f-9866-d5e41fd2a974.001.jpeg)

Solutions :

Dans la conception du projet de serveur web, nous avons fait l’utilisation de plusieurs technologies. Le framework opensource Java Spark a été utilisé pour la gestion du serveur. Comme système de gestion de base de données, nous avons utilisé le H2. Finalement, pour le moteur de templates nous avons fait appel à la bibliothèque Freemarker.

## **Les routes**

- GET
- /
- /students
- /students/:id
- /students/:id/delete
- /students/:id/edit
- /teachers
- /stickers
- /stickers/:id/edit
- /stickers/:id/delete
- /studentstickers/:id/delete/:idStudent
- /login
- POST
- /students
- /students/:id
- /students/:id/edit
- /teachers
- /stickers
- /stickers/:id/edit
- /login

