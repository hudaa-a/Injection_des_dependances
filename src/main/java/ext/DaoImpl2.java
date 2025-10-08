package ext;

import dao.iDao;

public class DaoImpl2 implements iDao {
    @Override
    public double getData(){
        System.out.println("Version capteurs");
        double temp=6000;
        return temp;
    }
}

