package itcast.Service;

import itcast.Dao.MsDao;
import itcast.Pojo.Ms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msservice")
public class MsServiceImpl implements MsService {

    @Autowired
    private MsDao msDao;
    @Override
    public Integer msStart(Ms ms) {
        Integer integer =msDao.msStart(ms);
        return integer;
    }

    @Override
    public Ms msFind() {
        Ms ms = msDao.msFind();
        return ms;
    }
}
