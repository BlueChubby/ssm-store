package itcast.Dao;

import itcast.Pojo.Ms;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface MsDao {

    //设置是否有秒杀活动
    @Update("update neuedu_ms set start=#{start},endtime=#{endtime} where id=1")
    public Integer msStart(Ms ms);

    //查询是否有秒杀活动
    @Select("select * from neuedu_ms where id=1")
    public Ms msFind();
}
