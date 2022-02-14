package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.dto.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yannis
 * @version 2021/2/2 17:23
 */
@RestController
public class MyController {

    @Autowired
    private SessionUtils sessionUtils;

    @GetMapping("/get")
    @Deprecated
    public Object get(){
        sessionUtils.getUserId();
        SessionData sessionData = sessionUtils.getSessionData();
        return null;
    }

}
