package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.ClassOnlineService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.classonline.BriefClassOnline;
import com.jyannis.sexeducommon.entity.Browse;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.enums.CommodityTypeEnum;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.BrowseMapper;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import com.jyannis.sexedudao.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassOnlineServiceImpl implements ClassOnlineService {
    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Autowired
    private BrowseMapper browseMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public ClassOnline getClassOnlineById (Long id, Long user_id){
        ClassOnline classonline = classOnlineMapper.getClassOnlineById(id);
        if(user_id != null){
            String create_time = TimeUtil.getCurrentTimestamp();
            createBrowse(user_id,id,create_time);
        }
        int browse = classOnlineMapper.getBrowse(id)+1;
        classOnlineMapper.addBrowse(browse,id);
        return classonline;
    }

    @Override
    public Page<BriefClassOnline> getBriefClassOnlineList(GetBriefListRequest request){
        if(request == null) return null;

        PageParam pageParam = request.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        if(request.getType().equals(CommodityTypeEnum.PARENTS.getName())){
            List<BriefClassOnline> briefClassOfflineList = classOnlineMapper.getBriefClassOnlineList(CommodityTypeEnum.PARENTS.getName());
            return new Page(new PageInfo<>(briefClassOfflineList));
        }else if(request.getType().equals(CommodityTypeEnum.TEACHER.getName())){
            List<BriefClassOnline> briefClassOfflineList = classOnlineMapper.getBriefClassOnlineList(CommodityTypeEnum.TEACHER.getName());
            return new Page(new PageInfo<>(briefClassOfflineList));
        }
        return null;
    }

    private Browse createBrowse(Long user_id, Long object_id, String create_time){
        String type = CommodityObjectTypeEnum.CLASS_ONLINE.getName();
        Browse browse = new Browse(null,user_id,type,object_id,create_time);
        browseMapper.insertBrowse(browse.getUser_id(), browse.getType(),browse.getObject_id(),browse.getCreate_time());
        return browse;
    }

    @Override
    public void giveLike(Long user_id,Long id){
        if(likeMapper.getLike(user_id,id)==null){
            int likes = classOnlineMapper.getLikes(id)+1;
            classOnlineMapper.giveLike(likes,id);
            String create_time = TimeUtil.getCurrentTimestamp();
            likeMapper.insertLike(user_id,CommodityObjectTypeEnum.CLASS_OFFLINE.getName(), id,create_time);
        }
    }

    @Override
    public void deleteClassOnline(Long id){
        classOnlineMapper.deleteClassOnline(id);
    }
}
