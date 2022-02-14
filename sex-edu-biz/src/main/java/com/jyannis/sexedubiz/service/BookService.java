package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.book.BriefBook;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.request.GetBriefListRequest;


public interface BookService {
    Book getBookById(Long id, Long user_id);
    Page<BriefBook> getBriefBookList(GetBriefListRequest request);
    void giveLike(Long user_id,Long id);
    void deleteBook(Long id);
}
