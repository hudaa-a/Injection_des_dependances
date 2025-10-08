package pres;

import dao.iDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres22 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException
    //InstantiationException : si on a pas de constructeur par défaut
    public static void main(String[] args) throws Exception {
        //Instanciation dynamique et pas statique
        Scanner scanner = new Scanner(System.in);//Il va lire le fichier txt afin de savoir les diff classes qu'on va utiliser
        System.out.printf("donner la classe de la couche Dao:");
        /* Pour instanciation dynamique :
        Il faut connaitre le nom de la classe
        Il faut charger classe au mémoire
        et puis instancier la classe
         */
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);//On a chargé la classe dans mémoire
        iDao dao = (iDao) cDao.newInstance();//instancier une classe qui n'est pas de type idao (class cast exception)

        System.out.printf("donner la classe de la couche Dao:");
        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName("metier.MetierImpl");
        IMetier metier = (IMetier) cMetier.newInstance();

        Method setDao = cMetier.getMethod("setDao", iDao.class);
        //metier.set(dao) =>statique
        setDao.invoke(metier, dao); //invoke cad j'éxecute la methode method sur l'objet metier avec transmission de parametres dao
        System.out.println("Résultat est : " +metier.calcul());
    }
}

