package com.jyannis.sexedubiz.service;


import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.classoffline.BriefClassOffline;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.request.GetBriefListRequest;

public interface ClassOfflineService {
    ClassOffline getClassOfflineById(Long id, Long user_id);
    Page<BriefClassOffline> getBriefClassOfflineList(GetBriefListRequest request);
    void giveLike(Long user_id,Long id);
    void deleteClassOffline(Long id);
}
