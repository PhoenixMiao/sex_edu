package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.BookService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.book.BriefBook;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("图书相关操作")
@RestController
@RequestMapping("/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private SessionUtils sessionUtils;

    @GetMapping("/{id}")
    @ApiOperation(value="查看图书详情",response = Book.class)
    public Object getBookById (@PathVariable("id") Long bookId){
        Long user_id = sessionUtils.getUserId();
        return bookService.getBookById(bookId,user_id);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取图书简要信息列表",response = BriefBook.class)
    public Object getBriefBookList(@NotNull @Valid @RequestBody GetBriefListRequest request) {
        return bookService.getBriefBookList(request);
    }

    @Auth
    @PostMapping("/like/{id}")
    @ApiOperation(value = "点赞",response = String.class)
    public Object giveLike(@PathVariable("id") Long bookId){
        bookService.giveLike(sessionUtils.getUserId(),bookId);
        return "操作成功";
    }

    @Auth
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除书（测试）",response = String.class)
    public Object deleteBook(@PathVariable("id")Long bookId){
        bookService.deleteBook(bookId);
        return "操作成功";
    }

}
