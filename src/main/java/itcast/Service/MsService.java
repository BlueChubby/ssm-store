package itcast.Service;

import itcast.Pojo.Ms;

public interface MsService {

    //设置是否有秒杀活动
    public Integer msStart(Ms ms);

    //查询是否有秒杀活动
    public Ms msFind();
}
