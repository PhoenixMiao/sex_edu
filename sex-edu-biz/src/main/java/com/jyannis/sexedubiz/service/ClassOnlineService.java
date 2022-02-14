package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.classonline.BriefClassOnline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.request.GetBriefListRequest;

public interface ClassOnlineService {
    ClassOnline getClassOnlineById(Long id, Long user_id);
    Page<BriefClassOnline> getBriefClassOnlineList(GetBriefListRequest request);
    void giveLike(Long user_id,Long id);
    void deleteClassOnline(Long id);
}
