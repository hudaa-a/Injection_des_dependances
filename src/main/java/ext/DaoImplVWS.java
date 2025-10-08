package ext;

import dao.iDao;

public class DaoImplVWS implements iDao {
    @Override
    public double getData() {
        System.out.println("Version capteurs");
        return 90;
    }
}
