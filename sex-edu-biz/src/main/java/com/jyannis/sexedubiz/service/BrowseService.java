package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.browse.BriefBrowse;
import com.jyannis.sexeducommon.request.PageParamRequest;

public interface BrowseService {
    Page<BriefBrowse> getBrowseList(PageParamRequest request, Long user_id);
}
