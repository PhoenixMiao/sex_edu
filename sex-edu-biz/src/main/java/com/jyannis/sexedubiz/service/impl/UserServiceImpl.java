package com.jyannis.sexedubiz.service.impl;

import com.jyannis.sexedubiz.service.UserService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.YmlConfig;
import com.jyannis.sexeducommon.common.CommonConstants;
import com.jyannis.sexeducommon.common.CommonErrorCode;
import com.jyannis.sexeducommon.dto.SessionData;
import com.jyannis.sexeducommon.dto.WxSession;
import com.jyannis.sexeducommon.entity.User;
import com.jyannis.sexeducommon.request.UpdateUserByIdRequest;
import com.jyannis.sexeducommon.response.UserResponse;
import com.jyannis.sexeducommon.util.AssertUtil;
import com.jyannis.sexeducommon.util.HttpUtil;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SessionUtils sessionUtils;

    @Autowired
    private YmlConfig ymlConfig;

    @Override
    public UserResponse getUserById(Long id){
        UserResponse userResponse = userMapper.getUserById(id);
        return userResponse;
    }

    @Override
    public void updateUserById(UpdateUserByIdRequest updateUserByIdRequest,Long id){
          userMapper.updateUserById(updateUserByIdRequest.getNickname(),updateUserByIdRequest.getGender(),updateUserByIdRequest.getPortrait(),updateUserByIdRequest.getAddress(),updateUserByIdRequest.getTelephone(),id);
    }


    @Override
    public SessionData login(String code) {

        //shadow test
        if(CommonConstants.SHADOW_TEST.equals(code)){
            sessionUtils.setSessionId(CommonConstants.SHADOW_TEST);
            return new SessionData();
        }

        WxSession wxSession = Optional.ofNullable(
                getWxSessionByCode(code))
                .orElse(new WxSession());

        checkWxSession(wxSession);

        String sessionId = sessionUtils.generateSessionId();

        User user = User.builder()
                .openid(wxSession.getOpenid())
                .build();
        user = userMapper.selectOne(user);

        if(user != null){
            sessionUtils.setSessionId(user.getSession_id());
            return new SessionData(user);
        }


        user = User.builder()
                .create_time(TimeUtil.getCurrentTimestamp())
                .openid(wxSession.getOpenid())
                .unionid(wxSession.getUnionid())
                .session_key(wxSession.getSession_key())
                .session_id(sessionId)
                .build();

        userMapper.insert(user);

        return new SessionData(user);
    }


    private WxSession getWxSessionByCode(String code){
        Map<String, String> requestUrlParam = new HashMap<>();
        //小程序appId
        requestUrlParam.put("appid", ymlConfig.getAppId());
//        requestUrlParam.put("appid", "wx22fa1182d4e66c4a");
        //小程序secret
        requestUrlParam.put("secret", ymlConfig.getAppSecret());
//        requestUrlParam.put("secret", "200e82982f7ec2a2812fc3ae9f2d5f15");
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数：授权类型
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        String result = HttpUtil.get(CommonConstants.WX_SESSION_REQUEST_URL, requestUrlParam);
//        String result = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", requestUrlParam);

        return JsonUtil.toObject(result, WxSession.class);
    }

    private void checkWxSession(WxSession wxSession){
        if(wxSession.getErrcode() != null) {
            AssertUtil.isFalse(-1 == wxSession.getErrcode(), CommonErrorCode.WX_LOGIN_BUSY, wxSession.getErrmsg());
            AssertUtil.isFalse(40029 == wxSession.getErrcode(), CommonErrorCode.WX_LOGIN_INVALID_CODE, wxSession.getErrmsg());
            AssertUtil.isFalse(45011 == wxSession.getErrcode(), CommonErrorCode.WX_LOGIN_FREQUENCY_REFUSED, wxSession.getErrmsg());
            AssertUtil.isTrue(wxSession.getErrcode() == 0, CommonErrorCode.WX_LOGIN_UNKNOWN_ERROR,wxSession.getErrmsg());
        }
    }



}
