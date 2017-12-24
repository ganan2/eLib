package com.elib.api.service;

import java.util.List;

public interface MessageService {

    void setMemberId(Long memberId);

    Long getMemberId();

    List<String> getAllMessages();

    boolean postmessage();
}
