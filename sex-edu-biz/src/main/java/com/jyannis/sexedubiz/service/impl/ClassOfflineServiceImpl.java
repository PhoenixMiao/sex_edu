package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.ClassOfflineService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.classoffline.BriefClassOffline;
import com.jyannis.sexeducommon.entity.Browse;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.enums.CommodityTypeEnum;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.BrowseMapper;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassOfflineServiceImpl implements ClassOfflineService {

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Autowired
    private BrowseMapper browseMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public ClassOffline getClassOfflineById (Long id, Long user_id){
        ClassOffline classoffline = classOfflineMapper.getClassOfflineById(id);
        if(user_id != null){
            String create_time = TimeUtil.getCurrentTimestamp();
            createBrowse(user_id,id,create_time);
        }
        int browse = classOfflineMapper.getBrowse(id)+1;
        classOfflineMapper.addBrowse(browse,id);
        return classoffline;
    }

    @Override
    public Page<BriefClassOffline> getBriefClassOfflineList(GetBriefListRequest request){
        if(request == null) return null;

        PageParam pageParam = request.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        if(request.getType().equals(CommodityTypeEnum.PARENTS.getName())){
            List<BriefClassOffline> briefClassOfflineList = classOfflineMapper.getBriefClassOfflineList(CommodityTypeEnum.PARENTS.getName());
            return new Page(new PageInfo<>(briefClassOfflineList));
        }else if(request.getType().equals(CommodityTypeEnum.TEACHER.getName())){
            List<BriefClassOffline> briefClassOfflineList = classOfflineMapper.getBriefClassOfflineList(CommodityTypeEnum.TEACHER.getName());
            return new Page(new PageInfo<>(briefClassOfflineList));
        }
        return null;
    }

    private Browse createBrowse(Long user_id, Long object_id, String create_time){
        String type = CommodityObjectTypeEnum.CLASS_OFFLINE.getName();
        Browse browse = new Browse(null,user_id,type,object_id,create_time);
        browseMapper.insertBrowse(browse.getUser_id(), browse.getType(),browse.getObject_id(),browse.getCreate_time());
        return browse;
    }

   @Override
    public void giveLike(Long user_id,Long id){
        if(likeMapper.getLike(user_id,id)==null){
            int likes = classOfflineMapper.getLikes(id)+1;
            classOfflineMapper.giveLike(likes,id);
            String create_time = TimeUtil.getCurrentTimestamp();
            likeMapper.insertLike(user_id,CommodityObjectTypeEnum.CLASS_OFFLINE.getName(), id,create_time);
        }
   }

   @Override
    public void deleteClassOffline(Long id){
        classOfflineMapper.deleteClassOffline(id);
   }

}
