package metier;

import dao.iDao;

public class MetierImpl implements IMetier {
    private iDao dao; //couplage faible
    @Override
    public double calcul() {
        double tmp = dao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI); //un algo compliqué
        return res;
    }

    //Set est une méthode qui permet d'injecter dans la var dao unn objet d'une classe qui implémente l'interface IDao
    public void setDao(iDao dao) {
        this.dao = dao;
    }
}
