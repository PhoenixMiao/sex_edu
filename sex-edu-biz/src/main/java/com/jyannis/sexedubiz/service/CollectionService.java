package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.collection.BriefCollection;
import com.jyannis.sexeducommon.request.GetCollectionRequest;

public interface CollectionService {
    void addToCollection(Long user_id, String type, Long object_id);
    void cancelCollection(Long id);
    Page<BriefCollection> getBriefCollectionList(GetCollectionRequest getCollectionRequest, Long user_id);
}

